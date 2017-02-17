angular.module('workix').factory('CommentResource', function($resource){
    var resource = $resource('../services/comments/:CommentId',{CommentId:'@id'},{'queryAll':{method:'GET',isArray:true},'query':{method:'GET',isArray:false},'update':{method:'PUT'}});
    return resource;
});