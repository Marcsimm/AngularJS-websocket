'use strict';

/**
 * @ngdoc function
 * @name floggitDigitalWhiteboardApp.controller:TodoCtrl
 * @description
 * # TodoCtrl
 * Controller of the floggitDigitalWhiteboardApp
 */
angular.module('floggitDigitalWhiteboardApp-websocket')
  .controller('TodoCtrl', function ($scope, localStorageService, $interval, $http, websocket) {


    $scope.$on('ws-message', function (event, todoarray) {
      $scope.todos = todoarray;
      $scope.$apply();
    });

    $scope.add = function () {
      websocket.sendtoserver();

    };

    $scope.update = function (todo) {
      websocket.sendtoudpate(todo);

    };

    $scope.delete = function (todo) {
      websocket.deleteobject(todo);

    };



  });