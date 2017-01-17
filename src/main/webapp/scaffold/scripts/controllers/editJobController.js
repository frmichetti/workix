

angular.module('workix').controller('EditJobController', function($scope, $routeParams, $location, flash, JobResource , CompanyResource) {
    var self = this;
    $scope.disabled = false;
    $scope.$location = $location;
    
    $scope.get = function() {
        var successCallback = function(data){
            self.original = data;
            $scope.job = new JobResource(self.original);
            CompanyResource.queryAll(function(items) {
                $scope.companySelectionList = $.map(items, function(item) {
                    var wrappedObject = {
                        id : item.id
                    };
                    var labelObject = {
                        value : item.id,
                        text : item.cnpj
                    };
                    if($scope.job.company && item.id == $scope.job.company.id) {
                        $scope.companySelection = labelObject;
                        $scope.job.company = wrappedObject;
                        self.original.company = $scope.job.company;
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
    
    $scope.$watch("companySelection", function(selection) {
        if (typeof selection != 'undefined') {
            $scope.job.company = {};
            $scope.job.company.id = selection.value;
        }
    });
    $scope.jobCategoryList = [
        "MANAGEMENT",  
        "OPERATOR"  
    ];
    $scope.jobTypeList = [
        "FULLTIME",  
        "PARTTIME",  
        "FREELANCE",  
        "TEMPORARY",  
        "INTERNSHIP"  
    ];
    $scope.activeList = [
        "true",
        "false"
    ];
    
    $scope.get();
});