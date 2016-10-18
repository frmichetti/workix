
angular.module('jobseeker').controller('NewCandidateController', function ($scope, $location, locationParser, flash, CandidateResource ) {
    $scope.disabled = false;
    $scope.$location = $location;
    $scope.candidate = $scope.candidate || {};
    

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