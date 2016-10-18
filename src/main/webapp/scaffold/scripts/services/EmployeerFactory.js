angular.module('jobseeker').factory('EmployeerResource', function($resource){
    var resource = $resource('../services/employeers/:EmployeerId',{EmployeerId:'@id'},{'queryAll':{method:'GET',isArray:true},'query':{method:'GET',isArray:false},'update':{method:'PUT'}});
    return resource;
});