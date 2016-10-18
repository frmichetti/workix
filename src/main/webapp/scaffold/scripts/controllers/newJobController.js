
angular.module('jobseeker').controller('NewJobController', function ($scope, $location, locationParser, flash, JobResource ) {
    $scope.disabled = false;
    $scope.$location = $location;
    $scope.job = $scope.job || {};
    

    $scope.save = function() {
        var successCallback = function(data,responseHeaders){
            var id = locationParser(responseHeaders);
            flash.setMessage({'type':'success','text':'The job was created successfully.'});
            $location.path('/Jobs');
        };
        var errorCallback = function(response) {
            if(response && response.data) {
                flash.setMessage({'type': 'error', 'text': response.data.message || response.data}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        JobResource.save($scope.job, successCallback, errorCallback);
    };
    
    $scope.cancel = function() {
        $location.path("/Jobs");
    };
});