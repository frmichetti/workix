angular.module('workix').factory('CandidateResource', function($resource){
    var resource = $resource('../services/candidates/:CandidateId',{CandidateId:'@id'},{'queryAll':{method:'GET',isArray:true},'query':{method:'GET',isArray:false},'update':{method:'PUT'}});
    return resource;
});