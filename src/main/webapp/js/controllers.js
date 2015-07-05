"use strict";

angularComparatorApp.controller("homeController" ,function ($scope) {

    $scope.user = 'Anas REKIK';

});

angularComparatorApp.controller("productController" ,function ($scope, Product) {

    Product.fetch().success(function(resp){
        $scope.products = resp;
    });

    $scope.deleteProduct = function(product){
		var index = $scope.products.indexOf(product);

        Product.remove(product.id)
            .success(function(){
                $scope.products.splice(index, 1);
            }
        );
    };

});

angularComparatorApp.controller("productFormController" ,function ($scope, Product, Provider) {

    Provider.fetch().success(function(resp){
        $scope.providersList = resp;
    });

    $scope.addProduct = function(product){
        Product.create(product)
            .success(function(resp){
                $scope.products.push(resp);
                $scope.product = {};
            })
            .error(function(resp){
                console.log(resp);
            });
    };
});



angularComparatorApp.controller("providerController" ,function ($scope, Provider) {

    Provider.fetch().success(function(resp){
        $scope.providers = resp;
    });

    $scope.deleteProvider = function(provider){
        var index = $scope.providers.indexOf(provider);

        Provider.remove(provider.id)
            .success(function(){
                $scope.providers.splice(index, 1);
            }
        );
    };

});

angularComparatorApp.controller("providerFormController" ,function ($scope, Provider) {

    $scope.addProvider = function(provider){
        Provider.create(provider)
            .success(function(resp){
                $scope.providers.push(resp);
                $scope.provider = {};
            })
            .error(function(resp){
                console.log(resp);
            });

    };
});
