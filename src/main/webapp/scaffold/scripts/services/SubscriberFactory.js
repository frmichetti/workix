angular.module('workix').factory('SubscriberResource', function($resource){
    var resource = $resource('../services/subscribers/:SubscriberId',{SubscriberId:'@id'},{'queryAll':{method:'GET',isArray:true},'query':{method:'GET',isArray:false},'update':{method:'PUT'}});
    return resource;
});