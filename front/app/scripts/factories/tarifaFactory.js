'use strict';

angular.module('demoApp')
	.factory('tarifaFactory', ['$http', function($http){
    var url = 'http://localhost:8080/tarifas/search/findByOrigemAndDestino';

    var tarifaFactory = {
      getTarifa: function(origem, destino){
        return $http.get(url, {params: {origem:origem, destino:destino}})
        .then(function(result) {
          return result;
        })
      }
    };

    return tarifaFactory;
  }])