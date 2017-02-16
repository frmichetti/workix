

angular.module('workix').controller('EditCompanyController', function($scope, $routeParams, $location, flash, CompanyResource , UserResource) {
    var self = this;
    $scope.disabled = false;
    $scope.$location = $location;
    
    $scope.get = function() {
        var successCallback = function(data){
            self.original = data;
            $scope.company = new CompanyResource(self.original);
            UserResource.queryAll(function(items) {
                $scope.userSelectionList = $.map(items, function(item) {
                    var wrappedObject = {
                        id : item.id
                    };
                    var labelObject = {
                        value : item.id,
                        text : item.email
                    };
                    if($scope.company.user && item.id == $scope.company.user.id) {
                        $scope.userSelection = labelObject;
                        $scope.company.user = wrappedObject;
                        self.original.user = $scope.company.user;
                    }
                    return labelObject;
                });
            });
        };
        var errorCallback = function() {
            flash.setMessage({'type': 'error', 'text': 'The company could not be found.'});
            $location.path("/Companies");
        };
        CompanyResource.get({CompanyId:$routeParams.CompanyId}, successCallback, errorCallback);
    };

    $scope.isClean = function() {
        return angular.equals(self.original, $scope.company);
    };

    $scope.save = function() {
        var successCallback = function(){
            flash.setMessage({'type':'success','text':'The company was updated successfully.'}, true);
            $scope.get();
        };
        var errorCallback = function(response) {
            if(response && response.data && response.data.message) {
                flash.setMessage({'type': 'error', 'text': response.data.message}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        $scope.company.$update(successCallback, errorCallback);
    };

    $scope.cancel = function() {
        $location.path("/Companies");
    };

    $scope.remove = function() {
        var successCallback = function() {
            flash.setMessage({'type': 'error', 'text': 'The company was deleted.'});
            $location.path("/Companies");
        };
        var errorCallback = function(response) {
            if(response && response.data && response.data.message) {
                flash.setMessage({'type': 'error', 'text': response.data.message}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        }; 
        $scope.company.$remove(successCallback, errorCallback);
    };
    
    $scope.$watch("userSelection", function(selection) {
        if (typeof selection != 'undefined') {
            $scope.company.user = {};
            $scope.company.user.id = selection.value;
        }
    });
    $scope.localeestateList = [
        "AC",  
        "AL",  
        "AM",  
        "AP",  
        "BA",  
        "CE",  
        "DF",  
        "ES",  
        "GO",  
        "MA",  
        "MG",  
        "MS",  
        "MT",  
        "PA",  
        "PB",  
        "PE",  
        "PI",  
        "PR",  
        "RJ",  
        "RN",  
        "RO",  
        "RR",  
        "RS",  
        "SC",  
        "SE",  
        "SP",  
        "TO"  
    ];
    
    $scope.get();
});