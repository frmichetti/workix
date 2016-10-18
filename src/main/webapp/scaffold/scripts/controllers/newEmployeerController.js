
angular.module('jobseeker').controller('NewEmployeerController', function ($scope, $location, locationParser, flash, EmployeerResource ) {
    $scope.disabled = false;
    $scope.$location = $location;
    $scope.employeer = $scope.employeer || {};
    

    $scope.save = function() {
        var successCallback = function(data,responseHeaders){
            var id = locationParser(responseHeaders);
            flash.setMessage({'type':'success','text':'The employeer was created successfully.'});
            $location.path('/Employeers');
        };
        var errorCallback = function(response) {
            if(response && response.data) {
                flash.setMessage({'type': 'error', 'text': response.data.message || response.data}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        EmployeerResource.save($scope.employeer, successCallback, errorCallback);
    };
    
    $scope.cancel = function() {
        $location.path("/Employeers");
    };
});