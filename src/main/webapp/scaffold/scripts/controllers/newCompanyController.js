
angular.module('workix').controller('NewCompanyController', function ($scope, $location, locationParser, flash, CompanyResource , UserResource) {
    $scope.disabled = false;
    $scope.$location = $location;
    $scope.company = $scope.company || {};
    
    $scope.userList = UserResource.queryAll(function(items){
        $scope.userSelectionList = $.map(items, function(item) {
            return ( {
                value : item.id,
                text : item.email
            });
        });
    });
    $scope.$watch("userSelection", function(selection) {
        if ( typeof selection != 'undefined') {
            $scope.company.user = {};
            $scope.company.user.id = selection.value;
        }
    });
    
    $scope.localeestateList = [
        "AC",
        "AL",
        "AP",
        "AM",
        "BA",
        "CE",
        "DF",
        "ES",
        "GO",
        "MA",
        "MT",
        "MS",
        "MG",
        "PA",
        "PB",
        "PR",
        "PE",
        "PI",
        "RJ",
        "RN",
        "RS",
        "RO",
        "RR",
        "SC",
        "SP",
        "SE",
        "TO"
    ];
    

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