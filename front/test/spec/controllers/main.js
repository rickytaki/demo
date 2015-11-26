'use strict';

describe('Controller: MainCtrl', function () {

  // load the controller's module
  beforeEach(module('demoApp'));

  var $controller;

  beforeEach(inject(function(_$controller_) {
    $controller = _$controller_;
  }));

  describe('$scope.tarifa', function() {

    var $scope, controller;
    beforeEach(function() {
      $scope = {};
      controller = $controller('PasswordController', { $scope: $scope });
    });

    it('Tarifa 10 minutos de 011 para 016 deve retornar 19', function() {
      $scope.origem = '011';
      $scope.destino = '016';
      $scope.minutos = 10;
      $scope.calculaTarifa();
      expect($scope.tarifa).toBe(19);
    });

    it('Tarifa 15 minutos de 016 para 011 deve retornar 43.50', function() {
      $scope.origem = '016';
      $scope.destino = '011';
      $scope.minutos = 15;
      $scope.calculaTarifa();
      expect($scope.tarifa).toBe(43.50);
    });

    it('Tarifa 17 minutos de 011 para 017 deve retornar 28.90', function() {
      $scope.origem = '011';
      $scope.destino = '017';
      $scope.minutos = 17;
      $scope.calculaTarifa();
      expect($scope.tarifa).toBe(28.90);
    });

    it('Tarifa 25 minutos de 017 para 011 deve retornar 67.50', function() {
      $scope.origem = '017';
      $scope.destino = '011';
      $scope.minutos = 25;
      $scope.calculaTarifa();
      expect($scope.tarifa).toBe(67.50);
    });

    it('Tarifa 28 minutos de 011 para 018 deve retornar 25.20', function() {
      $scope.origem = '011';
      $scope.destino = '018';
      $scope.minutos = 28;
      $scope.calculaTarifa();
      expect($scope.tarifa).toBe(25.20);
    });

    it('Tarifa 122 minutos de 018 para 011 deve retornar 231.80', function() {
      $scope.origem = '018';
      $scope.destino = '011';
      $scope.minutos = 122;
      $scope.calculaTarifa();
      expect($scope.tarifa).toBe(231.80);
    });


  });