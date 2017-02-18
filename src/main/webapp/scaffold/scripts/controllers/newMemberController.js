
angular.module('workix').controller('NewMemberController', function ($scope, $location, locationParser, flash, MemberResource ) {
    $scope.disabled = false;
    $scope.$location = $location;
    $scope.member = $scope.member || {};
    

    $scope.save = function() {
        var successCallback = function(data,responseHeaders){
            var id = locationParser(responseHeaders);
            flash.setMessage({'type':'success','text':'The member was created successfully.'});
            $location.path('/Members');
        };
        var errorCallback = function(response) {
            if(response && response.data) {
                flash.setMessage({'type': 'error', 'text': response.data.message || response.data}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        MemberResource.save($scope.member, successCallback, errorCallback);
    };
    
    $scope.cancel = function() {
        $location.path("/Members");
    };
});