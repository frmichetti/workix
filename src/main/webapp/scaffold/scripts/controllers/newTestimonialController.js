
angular.module('workix').controller('NewTestimonialController', function ($scope, $location, locationParser, flash, TestimonialResource ) {
    $scope.disabled = false;
    $scope.$location = $location;
    $scope.testimonial = $scope.testimonial || {};
    

    $scope.save = function() {
        var successCallback = function(data,responseHeaders){
            var id = locationParser(responseHeaders);
            flash.setMessage({'type':'success','text':'The testimonial was created successfully.'});
            $location.path('/Testimonials');
        };
        var errorCallback = function(response) {
            if(response && response.data) {
                flash.setMessage({'type': 'error', 'text': response.data.message || response.data}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        TestimonialResource.save($scope.testimonial, successCallback, errorCallback);
    };
    
    $scope.cancel = function() {
        $location.path("/Testimonials");
    };
});