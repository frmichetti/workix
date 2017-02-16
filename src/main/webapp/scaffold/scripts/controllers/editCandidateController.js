

angular.module('workix').controller('EditCandidateController', function($scope, $routeParams, $location, flash, CandidateResource , UserResource) {
    var self = this;
    $scope.disabled = false;
    $scope.$location = $location;
    
    $scope.get = function() {
        var successCallback = function(data){
            self.original = data;
            $scope.candidate = new CandidateResource(self.original);
            UserResource.queryAll(function(items) {
                $scope.userSelectionList = $.map(items, function(item) {
                    var wrappedObject = {
                        id : item.id
                    };
                    var labelObject = {
                        value : item.id,
                        text : item.email
                    };
                    if($scope.candidate.user && item.id == $scope.candidate.user.id) {
                        $scope.userSelection = labelObject;
                        $scope.candidate.user = wrappedObject;
                        self.original.user = $scope.candidate.user;
                    }
                    return labelObject;
                });
            });
        };
        var errorCallback = function() {
            flash.setMessage({'type': 'error', 'text': 'The candidate could not be found.'});
            $location.path("/Candidates");
        };
        CandidateResource.get({CandidateId:$routeParams.CandidateId}, successCallback, errorCallback);
    };

    $scope.isClean = function() {
        return angular.equals(self.original, $scope.candidate);
    };

    $scope.save = function() {
        var successCallback = function(){
            flash.setMessage({'type':'success','text':'The candidate was updated successfully.'}, true);
            $scope.get();
        };
        var errorCallback = function(response) {
            if(response && response.data && response.data.message) {
                flash.setMessage({'type': 'error', 'text': response.data.message}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        $scope.candidate.$update(successCallback, errorCallback);
    };

    $scope.cancel = function() {
        $location.path("/Candidates");
    };

    $scope.remove = function() {
        var successCallback = function() {
            flash.setMessage({'type': 'error', 'text': 'The candidate was deleted.'});
            $location.path("/Candidates");
        };
        var errorCallback = function(response) {
            if(response && response.data && response.data.message) {
                flash.setMessage({'type': 'error', 'text': response.data.message}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        }; 
        $scope.candidate.$remove(successCallback, errorCallback);
    };
    
    $scope.$watch("userSelection", function(selection) {
        if (typeof selection != 'undefined') {
            $scope.candidate.user = {};
            $scope.candidate.user.id = selection.value;
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