
angular.module('openjobs').controller('NewCandidateController', function ($scope, $location, locationParser, flash, CandidateResource , UserResource, ResumeResource) {
    $scope.disabled = false;
    $scope.$location = $location;
    $scope.candidate = $scope.candidate || {};
    
    $scope.userList = UserResource.queryAll(function(items){
        $scope.userSelectionList = $.map(items, function(item) {
            return ( {
                value : item.id,
                text : item.id
            });
        });
    });
    $scope.$watch("userSelection", function(selection) {
        if ( typeof selection != 'undefined') {
            $scope.candidate.user = {};
            $scope.candidate.user.id = selection.value;
        }
    });
    
    $scope.resumeList = ResumeResource.queryAll(function(items){
        $scope.resumeSelectionList = $.map(items, function(item) {
            return ( {
                value : item.id,
                text : item.id
            });
        });
    });
    $scope.$watch("resumeSelection", function(selection) {
        if ( typeof selection != 'undefined') {
            $scope.candidate.resume = {};
            $scope.candidate.resume.id = selection.value;
        }
    });
    

    $scope.save = function() {
        var successCallback = function(data,responseHeaders){
            var id = locationParser(responseHeaders);
            flash.setMessage({'type':'success','text':'The candidate was created successfully.'});
            $location.path('/Candidates');
        };
        var errorCallback = function(response) {
            if(response && response.data) {
                flash.setMessage({'type': 'error', 'text': response.data.message || response.data}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        CandidateResource.save($scope.candidate, successCallback, errorCallback);
    };
    
    $scope.cancel = function() {
        $location.path("/Candidates");
    };
});