

angular.module('workix').controller('EditTestimonialController', function($scope, $routeParams, $location, flash, TestimonialResource , AuthorResource) {
    var self = this;
    $scope.disabled = false;
    $scope.$location = $location;
    
    $scope.get = function() {
        var successCallback = function(data){
            self.original = data;
            $scope.testimonial = new TestimonialResource(self.original);
            AuthorResource.queryAll(function(items) {
                $scope.authorSelectionList = $.map(items, function(item) {
                    var wrappedObject = {
                        id : item.id
                    };
                    var labelObject = {
                        value : item.id,
                        text : item.aboutText
                    };
                    if($scope.testimonial.author && item.id == $scope.testimonial.author.id) {
                        $scope.authorSelection = labelObject;
                        $scope.testimonial.author = wrappedObject;
                        self.original.author = $scope.testimonial.author;
                    }
                    return labelObject;
                });
            });
        };
        var errorCallback = function() {
            flash.setMessage({'type': 'error', 'text': 'The testimonial could not be found.'});
            $location.path("/Testimonials");
        };
        TestimonialResource.get({TestimonialId:$routeParams.TestimonialId}, successCallback, errorCallback);
    };

    $scope.isClean = function() {
        return angular.equals(self.original, $scope.testimonial);
    };

    $scope.save = function() {
        var successCallback = function(){
            flash.setMessage({'type':'success','text':'The testimonial was updated successfully.'}, true);
            $scope.get();
        };
        var errorCallback = function(response) {
            if(response && response.data && response.data.message) {
                flash.setMessage({'type': 'error', 'text': response.data.message}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        $scope.testimonial.$update(successCallback, errorCallback);
    };

    $scope.cancel = function() {
        $location.path("/Testimonials");
    };

    $scope.remove = function() {
        var successCallback = function() {
            flash.setMessage({'type': 'error', 'text': 'The testimonial was deleted.'});
            $location.path("/Testimonials");
        };
        var errorCallback = function(response) {
            if(response && response.data && response.data.message) {
                flash.setMessage({'type': 'error', 'text': response.data.message}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        }; 
        $scope.testimonial.$remove(successCallback, errorCallback);
    };
    
    $scope.$watch("authorSelection", function(selection) {
        if (typeof selection != 'undefined') {
            $scope.testimonial.author = {};
            $scope.testimonial.author.id = selection.value;
        }
    });
    
    $scope.get();
});