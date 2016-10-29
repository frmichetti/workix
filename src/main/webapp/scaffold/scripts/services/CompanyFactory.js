angular.module('workix').factory('CompanyResource', function($resource){
    var resource = $resource('../services/companies/:CompanyId',{CompanyId:'@id'},{'queryAll':{method:'GET',isArray:true},'query':{method:'GET',isArray:false},'update':{method:'PUT'}});
    return resource;
});