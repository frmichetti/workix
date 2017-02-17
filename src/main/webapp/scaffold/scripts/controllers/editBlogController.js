

angular.module('workix').controller('EditBlogController', function($scope, $routeParams, $location, flash, BlogResource , AuthorResource) {
    var self = this;
    $scope.disabled = false;
    $scope.$location = $location;
    
    $scope.get = function() {
        var successCallback = function(data){
            self.original = data;
            $scope.blog = new BlogResource(self.original);
            AuthorResource.queryAll(function(items) {
                $scope.authorsSelectionList = $.map(items, function(item) {
                    var wrappedObject = {
                        id : item.id
                    };
                    var labelObject = {
                        value : item.id,
                        text : item.aboutText
                    };
                    if($scope.blog.authors){
                        $.each($scope.blog.authors, function(idx, element) {
                            if(item.id == element.id) {
                                $scope.authorsSelection.push(labelObject);
                                $scope.blog.authors.push(wrappedObject);
                            }
                        });
                        self.original.authors = $scope.blog.authors;
                    }
                    return labelObject;
                });
            });
        };
        var errorCallback = function() {
            flash.setMessage({'type': 'error', 'text': 'The blog could not be found.'});
            $location.path("/Blogs");
        };
        BlogResource.get({BlogId:$routeParams.BlogId}, successCallback, errorCallback);
    };

    $scope.isClean = function() {
        return angular.equals(self.original, $scope.blog);
    };

    $scope.save = function() {
        var successCallback = function(){
            flash.setMessage({'type':'success','text':'The blog was updated successfully.'}, true);
            $scope.get();
        };
        var errorCallback = function(response) {
            if(response && response.data && response.data.message) {
                flash.setMessage({'type': 'error', 'text': response.data.message}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        $scope.blog.$update(successCallback, errorCallback);
    };

    $scope.cancel = function() {
        $location.path("/Blogs");
    };

    $scope.remove = function() {
        var successCallback = function() {
            flash.setMessage({'type': 'error', 'text': 'The blog was deleted.'});
            $location.path("/Blogs");
        };
        var errorCallback = function(response) {
            if(response && response.data && response.data.message) {
                flash.setMessage({'type': 'error', 'text': response.data.message}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        }; 
        $scope.blog.$remove(successCallback, errorCallback);
    };
    
    $scope.authorsSelection = $scope.authorsSelection || [];
    $scope.$watch("authorsSelection", function(selection) {
        if (typeof selection != 'undefined' && $scope.blog) {
            $scope.blog.authors = [];
            $.each(selection, function(idx,selectedItem) {
                var collectionItem = {};
                collectionItem.id = selectedItem.value;
                $scope.blog.authors.push(collectionItem);
            });
        }
    });
    $scope.blogCategoryList = [
        "COMPANIES",  
        "JOBS",  
        "RESUMES",  
        "MARKET"  
    ];
    
    $scope.get();
});