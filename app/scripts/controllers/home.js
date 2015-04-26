'use strict';

/**
 * @ngdoc function
 * @name yoApp.controller:HomeCtrl
 * @description
 * # HomeCtrl
 * Controller of the yoApp
 */
angular.module('yoApp')
    //Factory home to use $resource instead $http for the rest request
    .factory('Home', function($resource) {
        return $resource('http://localhost\:8080/homes/:id', {id:'@id'});
    })
    //Controller to get all homes
    .controller('HomeController',function ($scope, Home) {
        $scope.homes = Home.query();
    })
    //Controller to get one home by this id
    .controller('HomeDetailController',function ($scope, $routeParams,Home) {
        $scope.home = Home.get({ id:$routeParams.homeId });
    })
    //Controller to delete a home by this id
    .controller('HomeDeleteController',function ($scope, $routeParams, $location, Home) {
        $scope.device = Home.get({ id:$routeParams.homeId }, function() {
            $scope.home.$delete();
        });
        $scope.$apply(function() {
            $location.path('/home');
        });
    })
    //Controller to add a home
    .controller('HomeAddController',function($scope, Home) {
        $scope.add = function(home) {
            var newHome = new Home;
            newHome.adress = home.adress;
            newHome.area = home.area;
            newHome.ipAdress = home.ipAdress;
            newHome.$save();
        };

        $scope.reset = function() {
            $scope.person = angular.copy({});
        };
    });
