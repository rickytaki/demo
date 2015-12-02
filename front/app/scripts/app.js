'use strict';

/**
 * @ngdoc overview
 * @name demoApp
 * @description
 * # demoApp
 *
 * Main module of the application.
 */
angular
  .module('demoApp', [
    'oc.lazyLoad',
    'ui.router',
    'ui.bootstrap',
  ])
  .config(['$stateProvider', '$urlRouterProvider', '$ocLazyLoadProvider',function ($stateProvider, $urlRouterProvider, $ocLazyLoadProvider) {
    
    $ocLazyLoadProvider.config({
      debug:false,
      events:true,
    });

    $urlRouterProvider.otherwise('/main');

    $stateProvider
      .state('main', {
        url:'/main',
        templateUrl: '/views/main.html',
        resolve: {
          loadMyFiles: function($ocLazyLoad){
            return $ocLazyLoad.load({
              files:[
              'scripts/factories/tarifaFactory.js',
              'scripts/controllers/main.js',
              'scripts/factories/planoFactory.js',
              'scripts/factories/dddFactory.js'
              ]
            })
          }
        }
      })
      .state('comparativo', {
        urL: '/comparativo',
        templateUrl: '/views/comparativo.html',
        controller: 'MainCtrl',
        resolve: {
          loadMyFiles: function($ocLazyLoad){
            return $ocLazyLoad.load({
              files:[
                'bower_components/angular-chart.js/dist/angular-chart.min.js'
              ]
            })
          }
        }
      })
  }]);
