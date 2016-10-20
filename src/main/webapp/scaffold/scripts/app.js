'use strict';

angular.module('akijob',['ngRoute','ngResource'])
  .config(['$routeProvider', function($routeProvider) {
    $routeProvider
      .when('/',{templateUrl:'views/landing.html',controller:'LandingPageController'})
      .when('/Candidates',{templateUrl:'views/Candidate/search.html',controller:'SearchCandidateController'})
      .when('/Candidates/new',{templateUrl:'views/Candidate/detail.html',controller:'NewCandidateController'})
      .when('/Candidates/edit/:CandidateId',{templateUrl:'views/Candidate/detail.html',controller:'EditCandidateController'})
      .when('/Companies',{templateUrl:'views/Company/search.html',controller:'SearchCompanyController'})
      .when('/Companies/new',{templateUrl:'views/Company/detail.html',controller:'NewCompanyController'})
      .when('/Companies/edit/:CompanyId',{templateUrl:'views/Company/detail.html',controller:'EditCompanyController'})
      .when('/Jobs',{templateUrl:'views/Job/search.html',controller:'SearchJobController'})
      .when('/Jobs/new',{templateUrl:'views/Job/detail.html',controller:'NewJobController'})
      .when('/Jobs/edit/:JobId',{templateUrl:'views/Job/detail.html',controller:'EditJobController'})
      .when('/SelectiveProcesses',{templateUrl:'views/SelectiveProcess/search.html',controller:'SearchSelectiveProcessController'})
      .when('/SelectiveProcesses/new',{templateUrl:'views/SelectiveProcess/detail.html',controller:'NewSelectiveProcessController'})
      .when('/SelectiveProcesses/edit/:SelectiveProcessId',{templateUrl:'views/SelectiveProcess/detail.html',controller:'EditSelectiveProcessController'})
      .otherwise({
        redirectTo: '/'
      });
  }])
  .controller('LandingPageController', function LandingPageController() {
  })
  .controller('NavController', function NavController($scope, $location) {
    $scope.matchesRoute = function(route) {
        var path = $location.path();
        return (path === ("/" + route) || path.indexOf("/" + route + "/") == 0);
    };
  });
