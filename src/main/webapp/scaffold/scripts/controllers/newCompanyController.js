
angular.module('akijob').controller('NewCompanyController', function ($scope, $location, locationParser, flash, CompanyResource ) {
    $scope.disabled = false;
    $scope.$location = $location;
    $scope.company = $scope.company || {};
    

    $scope.save = function() {
        var successCallback = function(data,responseHeaders){
            var id = locationParser(responseHeaders);
            flash.setMessage({'type':'success','text':'The company was created successfully.'});
            $location.path('/Companies');
        };
        var errorCallback = function(response) {
            if(response && response.data) {
                flash.setMessage({'type': 'error', 'text': response.data.message || response.data}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        CompanyResource.save($scope.company, successCallback, errorCallback);
    };
    
    $scope.cancel = function() {
        $location.path("/Companies");
    };
});