var app = angular.module('app', [ 'ui.router', 'ngAnimate', 'appServices',
		'appController',  'appDirective' ]);

/*
 * app.config(function($routeProvider) { $routeProvider.when('/hello', {
 * templateUrl: 'app/view/hello.html', controller: 'HelloCtrl' }).when('/list',{
 * templateUrl:'app/view/bookList.html', controller:'BookListCtrl'
 * }).otherwise({ redirectTo: '/hello' }) });
 */
app.controller('CurTimeController', function($scope) {
    $scope.getCurrentSecond = function() {
        $scope.x = new Date().getSeconds();
    };
})  
app.config(function($stateProvider, $urlRouterProvider) {
	//
	// For any unmatched url, redirect to /state1
	$urlRouterProvider.otherwise("/index/index");
	//
	// Now set up the states
	$stateProvider.state('index', {
		url : "/index",
		templateUrl : "app/view/navigation/navigation.html",
		controller : 'Navigation',
	}).state('index.index', {
		url : "/index",
		templateUrl : "app/view/index/index.html",
	}).state('index.readcontent', {
		url : "/readcontent",
		views : {
			'' : {
				templateUrl : "app/view/content/content.html",
				controller : 'Content',
			}
		}
	}).state('index.classification', {
		url : "/classification",
		views : {
			'' : {
				controller : 'Classification',
				templateUrl : '/app/view/classification/classification.html',
			}
		}
			
	})
});
