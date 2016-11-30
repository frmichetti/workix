
angular.module('workix').controller('NewJobController', function ($scope, $location, locationParser, flash, JobResource , CompanyResource) {
    $scope.disabled = false;
    $scope.$location = $location;
    $scope.job = $scope.job || {};
    
    $scope.categoryList = [
        "MANAGEMENT",
        "OPERATOR"
    ];
    
    $scope.employeerList = CompanyResource.queryAll(function(items){
        $scope.employeerSelectionList = $.map(items, function(item) {
            return ( {
                value : item.id,
                text : item.cnpj
            });
        });
    });
    $scope.$watch("employeerSelection", function(selection) {
        if ( typeof selection != 'undefined') {
            $scope.job.employeer = {};
            $scope.job.employeer.id = selection.value;
        }
    });
    
    $scope.typeList = [
        "FULLTIME",
        "PARTTIME",
        "FREELANCE",
        "TEMPORARY",
        "INTERNSHIP"
    ];
    
    $scope.activeList = [
        "true",
        "false"
    ];


    $scope.save = function() {
        var successCallback = function(data,responseHeaders){
            var id = locationParser(responseHeaders);
            flash.setMessage({'type':'success','text':'The job was created successfully.'});
            $location.path('/Jobs');
        };
        var errorCallback = function(response) {
            if(response && response.data) {
                flash.setMessage({'type': 'error', 'text': response.data.message || response.data}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        JobResource.save($scope.job, successCallback, errorCallback);
    };
    
    $scope.cancel = function() {
        $location.path("/Jobs");
    };
});