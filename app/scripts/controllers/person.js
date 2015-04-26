'use strict';

/**
 * @ngdoc function
 * @name yoApp.controller:PersonCtrl
 * @description
 * # PersonCtrl
 * Controller of the yoApp
 */
angular.module('yoApp')
    //Factory person to use $resource instead $http for the rest request
    .factory('Person', function($resource) {
        return $resource('http://localhost\:8080/persons/:id', {id:'@id'});
    })
    //Controller to get all persons
    .controller('PersonController', function ($scope, Person) {
        $scope.persons = Person.query();
    })
    //Controller to get one person by this id
    .controller('PersonDetailController', function($scope, $routeParams, Person) {
        $scope.person = Person.get({ id:$routeParams.personId });
    })
    //Controller to delete a person by this id
    .controller('PersonDeleteController', function($scope, $routeParams, $location, Person) {
        $scope.person = Person.get({ id:$routeParams.personId }, function() {
            $scope.person.$delete();
        });
        $scope.$apply(function() {
            $location.path('/person');
        });
    })
    //Controller to add one person and this home is the checkbox is check
    .controller('PersonAddController',function($scope, Person) {
        $scope.person = {
            birthday: new Date()
        };

        $scope.add = function(person) {
            var newPerson = new Person;
            newPerson.firstName = person.firstName;
            newPerson.lastName = person.lastName;
            newPerson.email = person.email;
            newPerson.facebook = person.facebook;
            newPerson.birthday =  Date.parse(person.birthday);
            newPerson.sex = person.sex;
            //Add house if checkbox is check
            if (person.home.create != null && person.home.create) {
                newPerson.homeAdress = person.home.adress;
                newPerson.homeArea = person.home.area;
                newPerson.homeIpAdress = person.home.ipAdress;
            }
            //Send the boolean to verify if the checkbox is check or not
            newPerson.homeCreate = person.home.create;
            newPerson.$save();
        };

        $scope.reset = function() {
            $scope.person = angular.copy({});
        };
    });
