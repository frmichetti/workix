
angular.module('workix').controller('NewSubscriberController', function ($scope, $location, locationParser, flash, SubscriberResource ) {
    $scope.disabled = false;
    $scope.$location = $location;
    $scope.subscriber = $scope.subscriber || {};
    

    $scope.save = function() {
        var successCallback = function(data,responseHeaders){
            var id = locationParser(responseHeaders);
            flash.setMessage({'type':'success','text':'The subscriber was created successfully.'});
            $location.path('/Subscribers');
        };
        var errorCallback = function(response) {
            if(response && response.data) {
                flash.setMessage({'type': 'error', 'text': response.data.message || response.data}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        SubscriberResource.save($scope.subscriber, successCallback, errorCallback);
    };
    
    $scope.cancel = function() {
        $location.path("/Subscribers");
    };
});