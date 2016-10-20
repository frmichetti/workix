

angular.module('openjobs').controller('EditJobController', function($scope, $routeParams, $location, flash, JobResource , CompanyResource) {
    var self = this;
    $scope.disabled = false;
    $scope.$location = $location;
    
    $scope.get = function() {
        var successCallback = function(data){
            self.original = data;
            $scope.job = new JobResource(self.original);
            CompanyResource.queryAll(function(items) {
                $scope.employeerSelectionList = $.map(items, function(item) {
                    var wrappedObject = {
                        id : item.id
                    };
                    var labelObject = {
                        value : item.id,
                        text : item.companySegment
                    };
                    if($scope.job.employeer && item.id == $scope.job.employeer.id) {
                        $scope.employeerSelection = labelObject;
                        $scope.job.employeer = wrappedObject;
                        self.original.employeer = $scope.job.employeer;
                    }
                    return labelObject;
                });
            });
        };
        var errorCallback = function() {
            flash.setMessage({'type': 'error', 'text': 'The job could not be found.'});
            $location.path("/Jobs");
        };
        JobResource.get({JobId:$routeParams.JobId}, successCallback, errorCallback);
    };

    $scope.isClean = function() {
        return angular.equals(self.original, $scope.job);
    };

    $scope.save = function() {
        var successCallback = function(){
            flash.setMessage({'type':'success','text':'The job was updated successfully.'}, true);
            $scope.get();
        };
        var errorCallback = function(response) {
            if(response && response.data && response.data.message) {
                flash.setMessage({'type': 'error', 'text': response.data.message}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        $scope.job.$update(successCallback, errorCallback);
    };

    $scope.cancel = function() {
        $location.path("/Jobs");
    };

    $scope.remove = function() {
        var successCallback = function() {
            flash.setMessage({'type': 'error', 'text': 'The job was deleted.'});
            $location.path("/Jobs");
        };
        var errorCallback = function(response) {
            if(response && response.data && response.data.message) {
                flash.setMessage({'type': 'error', 'text': response.data.message}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        }; 
        $scope.job.$remove(successCallback, errorCallback);
    };
    
    $scope.jobTypeList = [
        "FULLTIME",  
        "PARTTIME",  
        "FREELANCE",  
        "TEMPORARY",  
        "INTERNSHIP"  
    ];
    $scope.jobCategoryList = [
        "MANAGEMENT",  
        "OPERATOR"  
    ];
    $scope.estateList = [
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
    $scope.$watch("employeerSelection", function(selection) {
        if (typeof selection != 'undefined') {
            $scope.job.employeer = {};
            $scope.job.employeer.id = selection.value;
        }
    });
    $scope.activeList = [
        "true",
        "false"
    ];
    
    $scope.get();
});