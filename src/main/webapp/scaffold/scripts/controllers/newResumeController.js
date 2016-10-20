
angular.module('openjobs').controller('NewResumeController', function ($scope, $location, locationParser, flash, ResumeResource , CandidateResource) {
    $scope.disabled = false;
    $scope.$location = $location;
    $scope.resume = $scope.resume || {};
    
    $scope.candidateList = CandidateResource.queryAll(function(items){
        $scope.candidateSelectionList = $.map(items, function(item) {
            return ( {
                value : item.id,
                text : item.id
            });
        });
    });
    $scope.$watch("candidateSelection", function(selection) {
        if ( typeof selection != 'undefined') {
            $scope.resume.candidate = {};
            $scope.resume.candidate.id = selection.value;
        }
    });
    

    $scope.save = function() {
        var successCallback = function(data,responseHeaders){
            var id = locationParser(responseHeaders);
            flash.setMessage({'type':'success','text':'The resume was created successfully.'});
            $location.path('/Resumes');
        };
        var errorCallback = function(response) {
            if(response && response.data) {
                flash.setMessage({'type': 'error', 'text': response.data.message || response.data}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        ResumeResource.save($scope.resume, successCallback, errorCallback);
    };
    
    $scope.cancel = function() {
        $location.path("/Resumes");
    };
});