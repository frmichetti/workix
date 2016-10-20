angular.module('akijob').factory('JobResource', function($resource){
    var resource = $resource('../services/jobs/:JobId',{JobId:'@id'},{'queryAll':{method:'GET',isArray:true},'query':{method:'GET',isArray:false},'update':{method:'PUT'}});
    return resource;
});