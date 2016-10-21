

angular.module('openjobs').controller('EditResumeController', function($scope, $routeParams, $location, flash, ResumeResource , CandidateResource) {
    var self = this;
    $scope.disabled = false;
    $scope.$location = $location;
    
    $scope.get = function() {
        var successCallback = function(data){
            self.original = data;
            $scope.resume = new ResumeResource(self.original);
            CandidateResource.queryAll(function(items) {
                $scope.ownerSelectionList = $.map(items, function(item) {
                    var wrappedObject = {
                        id : item.id
                    };
                    var labelObject = {
                        value : item.id,
                        text : item.id
                    };
                    if($scope.resume.owner && item.id == $scope.resume.owner.id) {
                        $scope.ownerSelection = labelObject;
                        $scope.resume.owner = wrappedObject;
                        self.original.owner = $scope.resume.owner;
                    }
                    return labelObject;
                });
            });
        };
        var errorCallback = function() {
            flash.setMessage({'type': 'error', 'text': 'The resume could not be found.'});
            $location.path("/Resumes");
        };
        ResumeResource.get({ResumeId:$routeParams.ResumeId}, successCallback, errorCallback);
    };

    $scope.isClean = function() {
        return angular.equals(self.original, $scope.resume);
    };

    $scope.save = function() {
        var successCallback = function(){
            flash.setMessage({'type':'success','text':'The resume was updated successfully.'}, true);
            $scope.get();
        };
        var errorCallback = function(response) {
            if(response && response.data && response.data.message) {
                flash.setMessage({'type': 'error', 'text': response.data.message}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        $scope.resume.$update(successCallback, errorCallback);
    };

    $scope.cancel = function() {
        $location.path("/Resumes");
    };

    $scope.remove = function() {
        var successCallback = function() {
            flash.setMessage({'type': 'error', 'text': 'The resume was deleted.'});
            $location.path("/Resumes");
        };
        var errorCallback = function(response) {
            if(response && response.data && response.data.message) {
                flash.setMessage({'type': 'error', 'text': response.data.message}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        }; 
        $scope.resume.$remove(successCallback, errorCallback);
    };
    
    $scope.$watch("ownerSelection", function(selection) {
        if (typeof selection != 'undefined') {
            $scope.resume.owner = {};
            $scope.resume.owner.id = selection.value;
        }
    });
    
    $scope.get();
});