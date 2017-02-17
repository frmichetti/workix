angular.module('workix').factory('AuthorResource', function($resource){
    var resource = $resource('../services/authors/:AuthorId',{AuthorId:'@id'},{'queryAll':{method:'GET',isArray:true},'query':{method:'GET',isArray:false},'update':{method:'PUT'}});
    return resource;
});