'use strict';

angular.module('workix',['ngRoute','ngResource'])
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
      .when('/Resumes',{templateUrl:'views/Resume/search.html',controller:'SearchResumeController'})
      .when('/Resumes/new',{templateUrl:'views/Resume/detail.html',controller:'NewResumeController'})
      .when('/Resumes/edit/:ResumeId',{templateUrl:'views/Resume/detail.html',controller:'EditResumeController'})
      .when('/SelectiveProcesses',{templateUrl:'views/SelectiveProcess/search.html',controller:'SearchSelectiveProcessController'})
      .when('/SelectiveProcesses/new',{templateUrl:'views/SelectiveProcess/detail.html',controller:'NewSelectiveProcessController'})
      .when('/SelectiveProcesses/edit/:SelectiveProcessId',{templateUrl:'views/SelectiveProcess/detail.html',controller:'EditSelectiveProcessController'})
      .when('/Subscribers',{templateUrl:'views/Subscriber/search.html',controller:'SearchSubscriberController'})
      .when('/Subscribers/new',{templateUrl:'views/Subscriber/detail.html',controller:'NewSubscriberController'})
      .when('/Subscribers/edit/:SubscriberId',{templateUrl:'views/Subscriber/detail.html',controller:'EditSubscriberController'})
      .when('/Testimonials',{templateUrl:'views/Testimonial/search.html',controller:'SearchTestimonialController'})
      .when('/Testimonials/new',{templateUrl:'views/Testimonial/detail.html',controller:'NewTestimonialController'})
      .when('/Testimonials/edit/:TestimonialId',{templateUrl:'views/Testimonial/detail.html',controller:'EditTestimonialController'})
      .when('/Users',{templateUrl:'views/User/search.html',controller:'SearchUserController'})
      .when('/Users/new',{templateUrl:'views/User/detail.html',controller:'NewUserController'})
      .when('/Users/edit/:UserId',{templateUrl:'views/User/detail.html',controller:'EditUserController'})
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
