angular.module('workix').factory('ResumeResource', function($resource){
    var resource = $resource('../services/forge/resumes/:ResumeId',{ResumeId:'@id'},{'queryAll':{method:'GET',isArray:true},'query':{method:'GET',isArray:false},'update':{method:'PUT'}});
    return resource;
});