'use strict';

angular.module('demoApp')
	.factory('planoFactory', ['$http', function($http){
    var url = 'http://localhost:8080/planos';
    var planoFactory = {
      getPlano: function(){
        return $http.get(url).then(function(result) {
          return result.data;
        })
      }
    };
    return planoFactory;
  }])