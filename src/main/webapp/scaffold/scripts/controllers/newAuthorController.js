
angular.module('workix').controller('NewAuthorController', function ($scope, $location, locationParser, flash, AuthorResource ) {
    $scope.disabled = false;
    $scope.$location = $location;
    $scope.author = $scope.author || {};
    

    $scope.save = function() {
        var successCallback = function(data,responseHeaders){
            var id = locationParser(responseHeaders);
            flash.setMessage({'type':'success','text':'The author was created successfully.'});
            $location.path('/Authors');
        };
        var errorCallback = function(response) {
            if(response && response.data) {
                flash.setMessage({'type': 'error', 'text': response.data.message || response.data}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        AuthorResource.save($scope.author, successCallback, errorCallback);
    };
    
    $scope.cancel = function() {
        $location.path("/Authors");
    };
});