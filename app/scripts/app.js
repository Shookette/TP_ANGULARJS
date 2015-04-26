'use strict';

/**
 * @ngdoc overview
 * @name yoApp
 * @description
 * # yoApp
 *
 * Main module of the application.
 */
angular
  .module('yoApp', [
    'ngAnimate',
    'ngAria',
    'ngCookies',
    'ngMessages',
    'ngResource',
    'ngRoute',
    'ngSanitize',
    'ngTouch'
  ])
  //Here you define all the routes you need with their template (view) and their controller
  .config(function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'views/main.html',
        controller: 'MainController'
      })
      .when('/device', {
        templateUrl: 'views/device.html',
        controller: 'DeviceController'
      })
      .when('/device/get/:deviceId', {
        templateUrl: 'views/deviceDetail.html',
        controller: 'DeviceDetailController'
      })
      .when('/device/add/:homeId', {
        templateUrl: 'views/addDevice.html',
        controller: 'DeviceAddController'
      })
      .when('/device/delete/:deviceId', {
        templateUrl: 'views/device.html',
        controller: 'DeviceDeleteController'
      })
      .when('/person', {
        templateUrl: 'views/person.html',
        controller: 'PersonController'
      })
      .when('/person/add', {
        templateUrl: 'views/addPerson.html',
        controller: 'PersonAddController'
      })
      .when('/person/get/:personId', {
        templateUrl: 'views/personDetail.html',
        controller: 'PersonDetailController'
      })
      .when('/person/delete/:personId', {
        templateUrl: 'views/person.html',
        controller: 'PersonDeleteController'
      })
      .when('/home', {
        templateUrl: 'views/home.html',
        controller: 'HomeController'
      })
      .when('/home/add', {
        templateUrl: 'views/addHome.html',
        controller: 'HomeAddController'
      })
      .when('/home/get/:homeId', {
        templateUrl: 'views/homeDetail.html',
        controller: 'HomeDetailController'
      })
      .when('/home/delete/:homeId', {
        templateUrl: 'views/home.html',
        controller: 'HomeDeleteController'
      })
      .otherwise({
        redirectTo: '/'
      });
  });
