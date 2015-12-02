'use strict';

angular.module('demoApp')
	.factory('dddFactory', ['$http', function($http){
    var url = 'http://localhost:8080/ddds';
    var dddFactory = {
      getDdd: function(){
        return $http.get(url).then(function(result) {
          return result.data;
        })
      }
    };
    return dddFactory;
  }])