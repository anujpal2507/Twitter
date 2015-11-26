// create the module and name it twitterApp
<<<<<<< HEAD
var twitterApp = angular.module('twitterApp',['ngRoute','ngStorage']);
=======
var twitterApp = angular.module('twitterApp',['ngRoute']);
>>>>>>> 567e617b039c7e01e851f8adfcc74ebc41ff0db9

// configure routes
twitterApp.config(function($routeProvider) {
    $routeProvider
    // route for the home page
        .when('/', {
            templateUrl : '../pages/login.html',
            controller  : 'mainController'
        })
        // route for the test page
        .when('/profile',{
            templateUrl : '../pages/profile.html',
            controller : 'profileController'
        })
        //route for the dashboard page
        .when('/dashboard',{
            templateUrl : '../pages/dashboard.html',
            controller : 'tweet'
        })
        .otherwise({
            redirectTo:'/'
        });
});
