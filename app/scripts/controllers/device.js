'use strict';

/**
 * @ngdoc function
 * @name yoApp.controller:DeviceCtrl
 * @description
 * # DeviceCtrl
 * Controller of the yoApp
 */
angular.module('yoApp')
    //Factory device to use $resource instead $http for the rest request
    .factory('Device', function($resource) {
        return $resource('http://localhost\:8080/devices/:id', {id:'@id'});
    })
    //Controller to get all devices
    .controller('DeviceController',function ($scope, Device) {
        $scope.devices = Device.query();
    })
    //Controller to get one device by this id
    .controller('DeviceDetailController',function ($scope, $routeParams, Device) {
        $scope.device = Device.get({ id:$routeParams.deviceId });
    })
    //Controller to delete a device by this id
    .controller('DeviceDeleteController',function ($scope, $routeParams, $location, Device) {
        $scope.device = Device.get({ id:$routeParams.deviceId }, function() {
            $scope.device.$delete();
        });
        $scope.$apply(function() {
            $location.path('/device');
        });
    })
    //Controller to add a device
    .controller('DeviceAddController',function($scope, $routeParams, Device) {
        $scope.add = function(device) {
            var newDevice = new Device;
            newDevice.name = device.name;
            newDevice.avgcons = device.avgcons;
            newDevice.homeid = $routeParams.homeId;
            newDevice.deviceType = device.deviceType;
            if (device.deviceType == 'electronic') {
                newDevice.type = device.type;
            } else {
                newDevice.temperatureMin = device.temperatureMin;
                newDevice.temperatureMax = device.temperatureMax;
                newDevice.power = device.power;
            }
            newDevice.$save();
        };

        $scope.reset = function() {
            $scope.device = angular.copy({});
        };
    });
