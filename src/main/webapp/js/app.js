"use strict";

var angularComparatorApp = angular.module('angularMovieApp', ['ngRoute']);

angularComparatorApp.config(function($routeProvider) {
    $routeProvider
        .when('/home', {
            templateUrl: 'partials/home.html',
            controller : 'homeController'
        })
        .when('/products', {
            templateUrl: 'partials/products.html',
            controller : 'productController'
        })
        .when('/providers', {
            templateUrl: 'partials/providers.html',
            controller : 'providerController'
        })
        .when('/product/edit/:id', {
            templateUrl: 'partials/edit.html',
            controller: 'editProductController'
        })
        .otherwise({
            redirectTo: '/home'
        });
});
