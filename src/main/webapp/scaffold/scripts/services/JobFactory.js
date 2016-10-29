angular.module('workix').factory('JobResource', function($resource){
    var resource = $resource('../services/forge/jobs/:JobId',{JobId:'@id'},{'queryAll':{method:'GET',isArray:true},'query':{method:'GET',isArray:false},'update':{method:'PUT'}});
    return resource;
});