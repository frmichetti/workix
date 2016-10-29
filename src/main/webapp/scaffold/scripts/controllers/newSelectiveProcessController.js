
angular.module('workix').controller('NewSelectiveProcessController', function ($scope, $location, locationParser, flash, SelectiveProcessResource , JobResource, CandidateResource) {
    $scope.disabled = false;
    $scope.$location = $location;
    $scope.selectiveProcess = $scope.selectiveProcess || {};
    
    $scope.jobList = JobResource.queryAll(function(items){
        $scope.jobSelectionList = $.map(items, function(item) {
            return ( {
                value : item.id,
                text : item.id
            });
        });
    });
    $scope.$watch("jobSelection", function(selection) {
        if ( typeof selection != 'undefined') {
            $scope.selectiveProcess.job = {};
            $scope.selectiveProcess.job.id = selection.value;
        }
    });
    
    $scope.candidatesList = CandidateResource.queryAll(function(items){
        $scope.candidatesSelectionList = $.map(items, function(item) {
            return ( {
                value : item.id,
                text : item.id
            });
        });
    });
    $scope.$watch("candidatesSelection", function(selection) {
        if (typeof selection != 'undefined') {
            $scope.selectiveProcess.candidates = [];
            $.each(selection, function(idx,selectedItem) {
                var collectionItem = {};
                collectionItem.id = selectedItem.value;
                $scope.selectiveProcess.candidates.push(collectionItem);
            });
        }
    });


    $scope.save = function() {
        var successCallback = function(data,responseHeaders){
            var id = locationParser(responseHeaders);
            flash.setMessage({'type':'success','text':'The selectiveProcess was created successfully.'});
            $location.path('/SelectiveProcesses');
        };
        var errorCallback = function(response) {
            if(response && response.data) {
                flash.setMessage({'type': 'error', 'text': response.data.message || response.data}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        SelectiveProcessResource.save($scope.selectiveProcess, successCallback, errorCallback);
    };
    
    $scope.cancel = function() {
        $location.path("/SelectiveProcesses");
    };
});