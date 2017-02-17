angular.module('workix').factory('BlogResource', function($resource){
    var resource = $resource('../services/blogs/:BlogId',{BlogId:'@id'},{'queryAll':{method:'GET',isArray:true},'query':{method:'GET',isArray:false},'update':{method:'PUT'}});
    return resource;
});