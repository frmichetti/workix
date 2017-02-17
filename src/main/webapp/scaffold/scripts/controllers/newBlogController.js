
angular.module('workix').controller('NewBlogController', function ($scope, $location, locationParser, flash, BlogResource , AuthorResource, CommentResource) {
    $scope.disabled = false;
    $scope.$location = $location;
    $scope.blog = $scope.blog || {};
    
    $scope.authorsList = AuthorResource.queryAll(function(items){
        $scope.authorsSelectionList = $.map(items, function(item) {
            return ( {
                value : item.id,
                text : item.aboutText
            });
        });
    });
    $scope.$watch("authorsSelection", function(selection) {
        if (typeof selection != 'undefined') {
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
    
    $scope.commentsList = CommentResource.queryAll(function(items){
        $scope.commentsSelectionList = $.map(items, function(item) {
            return ( {
                value : item.id,
                text : item.email
            });
        });
    });
    $scope.$watch("commentsSelection", function(selection) {
        if (typeof selection != 'undefined') {
            $scope.blog.comments = [];
            $.each(selection, function(idx,selectedItem) {
                var collectionItem = {};
                collectionItem.id = selectedItem.value;
                $scope.blog.comments.push(collectionItem);
            });
        }
    });


    $scope.save = function() {
        var successCallback = function(data,responseHeaders){
            var id = locationParser(responseHeaders);
            flash.setMessage({'type':'success','text':'The blog was created successfully.'});
            $location.path('/Blogs');
        };
        var errorCallback = function(response) {
            if(response && response.data) {
                flash.setMessage({'type': 'error', 'text': response.data.message || response.data}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        BlogResource.save($scope.blog, successCallback, errorCallback);
    };
    
    $scope.cancel = function() {
        $location.path("/Blogs");
    };
});