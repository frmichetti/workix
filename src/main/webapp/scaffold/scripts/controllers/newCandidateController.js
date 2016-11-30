
angular.module('workix').controller('NewCandidateController', function ($scope, $location, locationParser, flash, CandidateResource , UserResource) {
    $scope.disabled = false;
    $scope.$location = $location;
    $scope.candidate = $scope.candidate || {};
    
    $scope.userList = UserResource.queryAll(function(items){
        $scope.userSelectionList = $.map(items, function(item) {
            return ( {
                value : item.id,
                text : item.email
            });
        });
    });
    $scope.$watch("userSelection", function(selection) {
        if ( typeof selection != 'undefined') {
            $scope.candidate.user = {};
            $scope.candidate.user.id = selection.value;
        }
    });
    
    $scope.localeestateList = [
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
    

    $scope.save = function() {
        var successCallback = function(data,responseHeaders){
            var id = locationParser(responseHeaders);
            flash.setMessage({'type':'success','text':'The candidate was created successfully.'});
            $location.path('/Candidates');
        };
        var errorCallback = function(response) {
            if(response && response.data) {
                flash.setMessage({'type': 'error', 'text': response.data.message || response.data}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        CandidateResource.save($scope.candidate, successCallback, errorCallback);
    };
    
    $scope.cancel = function() {
        $location.path("/Candidates");
    };
});