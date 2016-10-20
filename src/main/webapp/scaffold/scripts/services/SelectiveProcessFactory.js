angular.module('akijob').factory('SelectiveProcessResource', function($resource){
    var resource = $resource('../services/selectiveprocesses/:SelectiveProcessId',{SelectiveProcessId:'@id'},{'queryAll':{method:'GET',isArray:true},'query':{method:'GET',isArray:false},'update':{method:'PUT'}});
    return resource;
});