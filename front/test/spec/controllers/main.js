'use strict';

describe('Controller: MainCtrl', function () {


  // modules
  beforeEach(module('demoApp'));

  var $httpBackend, $rootScope, createController;

  beforeEach(inject(function($injector){
    $httpBackend = $injector.get('$httpBackend');
    $rootScope = $injector.get('$rootScope');
    var $controller = $injector.get('$controller');

    createController = function() {
     return $controller('MainCtrl', {'$scope' : $rootScope });
   };
 }))

  afterEach(function() {
    //flush req
    $httpBackend.verifyNoOutstandingExpectation();
    $httpBackend.verifyNoOutstandingRequest();
  });

  beforeEach(function() {
    var controller = createController();
    $httpBackend.when('GET', 'http://localhost:8080/ddds')
    .respond({ _embedded: {ddds: '011'}});
    $httpBackend.when('GET', 'http://localhost:8080/planos')
    .respond({_embedded: {
      planos: [{
        nome: 'Fale Mais 30',
        minutos: 30,
        minutoAdicional: 1.1
      }, {
        nome: 'Fale Mais 60',
        minutos: 60,
        minutoAdicional: 1.1
      }, {
        nome: 'Fale Mais 120',
        minutos: 120,
        minutoAdicional: 1.1
      }]
    }});
  });

  it('Tarifa 10 minutos de 011 para 016 deve retornar 19 e com plano 0', function() {
    $rootScope.origem = '011';
    $rootScope.destino = '016';
    $rootScope.minutos = 10;
    $rootScope.calculaTarifa();
    $httpBackend.expectGET('http://localhost:8080/tarifas/search/findByOrigemAndDestino')
    .respond([1.9]);
    $httpBackend.flush();
    expect($rootScope.valor).toBe(19);
    expect($rootScope.valorComPlano).toBe(0);
  });

  it('Tarifa 15 minutos de 016 para 011 deve retornar 43.50e com plano 0', function() {
    $rootScope.origem = '016';
    $rootScope.destino = '011';
    $rootScope.minutos = 15;
    $rootScope.calculaTarifa();
    $httpBackend.expectGET('http://localhost:8080/tarifas/search/findByOrigemAndDestino')
    .respond([2.9]);
    $httpBackend.flush();
    expect($rootScope.valor).toBe(43.50);
    expect($rootScope.valorComPlano).toBe(0);
  });

  it('Tarifa 17 minutos de 011 para 017 deve retornar 28.90 e com plano 0', function() {
    $rootScope.origem = '011';
    $rootScope.destino = '017';
    $rootScope.minutos = 17;
    $rootScope.calculaTarifa();
    $httpBackend.expectGET('http://localhost:8080/tarifas/search/findByOrigemAndDestino')
    .respond([1.7]);
    $httpBackend.flush();
    expect($rootScope.valor).toBe(28.90);
    expect($rootScope.valorComPlano).toBe(0);
  });

  it('Tarifa 25 minutos de 017 para 011 deve retornar 67.50 e com plano 0', function() {
    $rootScope.origem = '017';
    $rootScope.destino = '011';
    $rootScope.minutos = 25;
    $rootScope.calculaTarifa();
    $httpBackend.expectGET('http://localhost:8080/tarifas/search/findByOrigemAndDestino')
    .respond([2.7]);
    $httpBackend.flush();
    expect($rootScope.valor).toBe(67.50);
    expect($rootScope.valorComPlano).toBe(0);
  });

  it('Tarifa 28 minutos de 011 para 018 deve retornar 25.20 e com plano 0', function() {
    $rootScope.origem = '011';
    $rootScope.destino = '018';
    $rootScope.minutos = 28;
    $rootScope.calculaTarifa();
    $httpBackend.expectGET('http://localhost:8080/tarifas/search/findByOrigemAndDestino')
    .respond([0.9]);
    $httpBackend.flush();
    expect($rootScope.valor).toBe(25.20);
    expect($rootScope.valorComPlano).toBe(0);
  });

  it('Tarifa 122 minutos de 018 para 011 deve retornar 231.80 e com plano 192.28', function() {
    $rootScope.origem = '018';
    $rootScope.destino = '011';
    $rootScope.minutos = 122;
    $rootScope.calculaTarifa();
    $httpBackend.expectGET('http://localhost:8080/tarifas/search/findByOrigemAndDestino')
    .respond([1.9]);
    $httpBackend.flush();
    expect($rootScope.valor).toBe(231.80);
    expect($rootScope.valorComPlano).toBe(192.28);
  });
})