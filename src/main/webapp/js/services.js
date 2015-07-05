"use strict";

angularComparatorApp.factory("Product", function ($http) {
    var API_URI = '/Comparateur/service/product';

    return {

        fetch : function() {
            return $http.get(API_URI + '/');
        },

        create : function(movie) {
            return  $http.post(API_URI + '/', movie);
        },

        remove : function(id) {
            return $http.delete(API_URI + '/' + id);
        },

        fetchOne : function(id) {
            return $http.get(API_URI + '/' + id);
        },

        update : function(product) {
             return $http.put(API_URI + '/', product);
        }

    };

});

angularComparatorApp.factory("Provider", function ($http) {
    var API_URI = '/Comparateur/service/provider';

    return {

        fetch : function() {
            return $http.get(API_URI + '/');
        },

        create : function(provider) {
            return  $http.post(API_URI + '/', provider);
        },

        remove : function(id) {
            return $http.delete(API_URI + '/' + id);
        },

        fetchOne : function(id) {
            return $http.get(API_URI + '/' + id);
        },

        update : function(provider) {
             return $http.put(API_URI + '/', provider);
        }

    };

});
