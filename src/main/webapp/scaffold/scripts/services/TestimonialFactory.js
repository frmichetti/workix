angular.module('workix').factory('TestimonialResource', function($resource){
    var resource = $resource('../services/testimonials/:TestimonialId',{TestimonialId:'@id'},{'queryAll':{method:'GET',isArray:true},'query':{method:'GET',isArray:false},'update':{method:'PUT'}});
    return resource;
});