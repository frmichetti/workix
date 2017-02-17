

angular.module('workix').controller('EditCommentController', function($scope, $routeParams, $location, flash, CommentResource , BlogResource) {
    var self = this;
    $scope.disabled = false;
    $scope.$location = $location;
    
    $scope.get = function() {
        var successCallback = function(data){
            self.original = data;
            $scope.comment = new CommentResource(self.original);
            BlogResource.queryAll(function(items) {
                $scope.blogSelectionList = $.map(items, function(item) {
                    var wrappedObject = {
                        id : item.id
                    };
                    var labelObject = {
                        value : item.id,
                        text : item.blogCategory
                    };
                    if($scope.comment.blog && item.id == $scope.comment.blog.id) {
                        $scope.blogSelection = labelObject;
                        $scope.comment.blog = wrappedObject;
                        self.original.blog = $scope.comment.blog;
                    }
                    return labelObject;
                });
            });
        };
        var errorCallback = function() {
            flash.setMessage({'type': 'error', 'text': 'The comment could not be found.'});
            $location.path("/Comments");
        };
        CommentResource.get({CommentId:$routeParams.CommentId}, successCallback, errorCallback);
    };

    $scope.isClean = function() {
        return angular.equals(self.original, $scope.comment);
    };

    $scope.save = function() {
        var successCallback = function(){
            flash.setMessage({'type':'success','text':'The comment was updated successfully.'}, true);
            $scope.get();
        };
        var errorCallback = function(response) {
            if(response && response.data && response.data.message) {
                flash.setMessage({'type': 'error', 'text': response.data.message}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        $scope.comment.$update(successCallback, errorCallback);
    };

    $scope.cancel = function() {
        $location.path("/Comments");
    };

    $scope.remove = function() {
        var successCallback = function() {
            flash.setMessage({'type': 'error', 'text': 'The comment was deleted.'});
            $location.path("/Comments");
        };
        var errorCallback = function(response) {
            if(response && response.data && response.data.message) {
                flash.setMessage({'type': 'error', 'text': response.data.message}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        }; 
        $scope.comment.$remove(successCallback, errorCallback);
    };
    
    $scope.$watch("blogSelection", function(selection) {
        if (typeof selection != 'undefined') {
            $scope.comment.blog = {};
            $scope.comment.blog.id = selection.value;
        }
    });
    
    $scope.get();
});