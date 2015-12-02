'use strict';

/**
 * @ngdoc function
 * @name demoApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the frontApp
 */
 angular.module('demoApp')
 .controller('MainCtrl', ['$scope', 'tarifaFactory', 'planoFactory', 'dddFactory', 
  function ($scope, tarifaFactory, planoFactory, dddFactory) {
    $scope.minutos;
    var barOptions = {
      legend: true,
      scaleLabel:
      function(label){return  ' R$ ' + label.value.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ".");}
    }

    dddFactory.getDdd().then(function(result){
      $scope.ddds = result["_embedded"]["ddds"];
      $scope.origem = $scope.ddds[0];
      $scope.destino = $scope.ddds[1];
    })
    planoFactory.getPlano().then(function(result){
      $scope.planos = result["_embedded"]["planos"];
      $scope.plano = $scope.planos[0];
    });

    $scope.calculaTarifa = function() {
      tarifaFactory.getTarifa($scope.origem.codigo, $scope.destino.codigo).then(function(result){
        $scope.tarifa = result.data;
        $scope.valor = +($scope.tarifa * $scope.minutos).toFixed(2);
        if ($scope.plano.minutos - $scope.minutos >= 0) {
          $scope.valorComPlano = 0;
        } else{
          $scope.valorComPlano = +(($scope.minutos - $scope.plano.minutos) * ($scope.tarifa * $scope.plano.minutoAdicional)).toFixed(2);
        };
        $scope.bar = {
          labels: ['Valor com Plano', 'Valor sem plano'],
          data: [[$scope.valorComPlano, $scope.valor]],
          options: barOptions
        };
      })
      setTimeout(function(){scroll('#economia')}, 800);
    } 

    function scroll(selector, callback){
      var animation = {scrollTop: $(selector).offset().top};
      $('html,body').animate(animation, 'slow', 'swing', function() {
        if (typeof callback == 'function') {
          callback();
        }
        callback = null;
      });
    }

  }]);
