var app = angular.module('app', [ 'ui.router', 'ngAnimate', 'appServices',
		'appController',  'appDirective' ]);

/*
 * app.config(function($routeProvider) { $routeProvider.when('/hello', {
 * templateUrl: 'app/view/hello.html', controller: 'HelloCtrl' }).when('/list',{
 * templateUrl:'app/view/bookList.html', controller:'BookListCtrl'
 * }).otherwise({ redirectTo: '/hello' }) });
 */

app.config(function($stateProvider, $urlRouterProvider) {
	//
	// For any unmatched url, redirect to /state1
	$urlRouterProvider.otherwise("/index/home");
	//
	// Now set up the states
	$stateProvider.state('index', {
		url : "/index",
		views : {
			'' : {
				templateUrl : "app/view/navigation/navigation.html",
				controller : 'Navigation',
			},
			'side@index':{
				templateUrl : "app/view/side/side.html",
				controller : 'SideBox',
			}
		}
	}).state('index.home', {
		url : "/home",
		views : {
			'' : {
				templateUrl : "app/view/home/home.html",
			},
			'side@index.home':{
				templateUrl : "app/view/side/side.html",
			},
			'homemaincontent@index.home':{
				templateUrl : "app/view/home/maincontent.html"
			}
		}
	}).state('index.classification', {
		url : "/classification",
		templateUrl : '/app/view/classification/classification.html',
		controller : 'Classification',
	}).state('state2.list', {
	}).state('index.resume', {
		url : "/resume",
		templateUrl : 'app/view/resume.html',
	}).state('state2.list', {
		url : "/list",
		templateUrl : "partials/state2.list.html",
		controller : function($scope) {
			$scope.things = [ "A", "Set", "Of", "Things" ];
		}
	});
});
