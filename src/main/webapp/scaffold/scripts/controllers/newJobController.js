
angular.module('akijob').controller('NewJobController', function ($scope, $location, locationParser, flash, JobResource , CompanyResource) {
    $scope.disabled = false;
    $scope.$location = $location;
    $scope.job = $scope.job || {};
    
    $scope.jobTypeList = [
        "FULLTIME",
        "PARTTIME",
        "FREELANCE",
        "TEMPORARY",
        "INTERNSHIP"
    ];
    
    $scope.jobCategoryList = [
        "MANAGEMENT",
        "OPERATOR"
    ];
    
    $scope.estateList = [
        "AC",
        "AL",
        "AP",
        "AM",
        "BA",
        "CE",
        "DF",
        "ES",
        "GO",
        "MA",
        "MT",
        "MS",
        "MG",
        "PA",
        "PB",
        "PR",
        "PE",
        "PI",
        "RJ",
        "RN",
        "RS",
        "RO",
        "RR",
        "SC",
        "SP",
        "SE",
        "TO"
    ];
    
    $scope.employeerList = CompanyResource.queryAll(function(items){
        $scope.employeerSelectionList = $.map(items, function(item) {
            return ( {
                value : item.id,
                text : item.companySegment
            });
        });
    });
    $scope.$watch("employeerSelection", function(selection) {
        if ( typeof selection != 'undefined') {
            $scope.job.employeer = {};
            $scope.job.employeer.id = selection.value;
        }
    });
    
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