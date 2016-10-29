angular.module('workix').factory('UserResource', function($resource){
    var resource = $resource('../services/forge/users/:UserId',{UserId:'@id'},{'queryAll':{method:'GET',isArray:true},'query':{method:'GET',isArray:false},'update':{method:'PUT'}});
    return resource;
});