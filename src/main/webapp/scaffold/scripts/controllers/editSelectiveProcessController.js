

angular.module('openjobs').controller('EditSelectiveProcessController', function($scope, $routeParams, $location, flash, SelectiveProcessResource , JobResource, CandidateResource) {
    var self = this;
    $scope.disabled = false;
    $scope.$location = $location;
    
    $scope.get = function() {
        var successCallback = function(data){
            self.original = data;
            $scope.selectiveProcess = new SelectiveProcessResource(self.original);
            JobResource.queryAll(function(items) {
                $scope.jobSelectionList = $.map(items, function(item) {
                    var wrappedObject = {
                        id : item.id
                    };
                    var labelObject = {
                        value : item.id,
                        text : item.id
                    };
                    if($scope.selectiveProcess.job && item.id == $scope.selectiveProcess.job.id) {
                        $scope.jobSelection = labelObject;
                        $scope.selectiveProcess.job = wrappedObject;
                        self.original.job = $scope.selectiveProcess.job;
                    }
                    return labelObject;
                });
            });
            CandidateResource.queryAll(function(items) {
                $scope.candidatesSelectionList = $.map(items, function(item) {
                    var wrappedObject = {
                        id : item.id
                    };
                    var labelObject = {
                        value : item.id,
                        text : item.id
                    };
                    if($scope.selectiveProcess.candidates){
                        $.each($scope.selectiveProcess.candidates, function(idx, element) {
                            if(item.id == element.id) {
                                $scope.candidatesSelection.push(labelObject);
                                $scope.selectiveProcess.candidates.push(wrappedObject);
                            }
                        });
                        self.original.candidates = $scope.selectiveProcess.candidates;
                    }
                    return labelObject;
                });
            });
        };
        var errorCallback = function() {
            flash.setMessage({'type': 'error', 'text': 'The selectiveProcess could not be found.'});
            $location.path("/SelectiveProcesses");
        };
        SelectiveProcessResource.get({SelectiveProcessId:$routeParams.SelectiveProcessId}, successCallback, errorCallback);
    };

    $scope.isClean = function() {
        return angular.equals(self.original, $scope.selectiveProcess);
    };

    $scope.save = function() {
        var successCallback = function(){
            flash.setMessage({'type':'success','text':'The selectiveProcess was updated successfully.'}, true);
            $scope.get();
        };
        var errorCallback = function(response) {
            if(response && response.data && response.data.message) {
                flash.setMessage({'type': 'error', 'text': response.data.message}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        $scope.selectiveProcess.$update(successCallback, errorCallback);
    };

    $scope.cancel = function() {
        $location.path("/SelectiveProcesses");
    };

    $scope.remove = function() {
        var successCallback = function() {
            flash.setMessage({'type': 'error', 'text': 'The selectiveProcess was deleted.'});
            $location.path("/SelectiveProcesses");
        };
        var errorCallback = function(response) {
            if(response && response.data && response.data.message) {
                flash.setMessage({'type': 'error', 'text': response.data.message}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        }; 
        $scope.selectiveProcess.$remove(successCallback, errorCallback);
    };
    
    $scope.$watch("jobSelection", function(selection) {
        if (typeof selection != 'undefined') {
            $scope.selectiveProcess.job = {};
            $scope.selectiveProcess.job.id = selection.value;
        }
    });
    $scope.candidatesSelection = $scope.candidatesSelection || [];
    $scope.$watch("candidatesSelection", function(selection) {
        if (typeof selection != 'undefined' && $scope.selectiveProcess) {
            $scope.selectiveProcess.candidates = [];
            $.each(selection, function(idx,selectedItem) {
                var collectionItem = {};
                collectionItem.id = selectedItem.value;
                $scope.selectiveProcess.candidates.push(collectionItem);
            });
        }
    });
    $scope.activeList = [
        "true",
        "false"
    ];
    
    $scope.get();
});