/*
 * 指令
 * 
 * */
var appDirective = angular.module('appDirective', []);

//注射器加载完所有模块时，此方法执行一次
appDirective.run(function($templateCache){
	$('#google').carousel();
});


appDirective.directive("roll", function($templateCache) {
    return {
        restrict: 'AECM',
        //template: $templateCache.get("hello.html"),
        template:'<ol class="carousel-indicators">'+
        '<li data-target="#ad-carousel" data-slide-to="0" class="active" ng-click="load()"></li>'+
        '<li data-target="#ad-carousel" data-slide-to="1"></li>'+
        '<li data-target="#ad-carousel" data-slide-to="2"></li>'+
        '<li data-target="#ad-carousel" data-slide-to="2"></li>'+
        '<li data-target="#ad-carousel" data-slide-to="2"></li>'+
        '<li data-target="#ad-carousel" data-slide-to="2"></li>'+
        '<li data-target="#ad-carousel" data-slide-to="2"></li>'+
        '<li data-target="#ad-carousel" data-slide-to="2"></li>'+
        '<li data-target="#ad-carousel" data-slide-to="2"></li>'+
        '<li data-target="#ad-carousel" data-slide-to="2"></li>'+
        '<li data-target="#ad-carousel" data-slide-to="3"></li>'+'</ol>',
        replace: true,
        link:function(scope,element,attrs){},
        controller:function($scope){
        	function load(){
        		alert();
        	}
        }
    }
});
appDirective.directive("homemaincontent", function($templateCache) {
    return {
        restrict: 'AECM',
        templateUrl: $templateCache.get("hello.html"),
        replace: true,
        link:function(){
        	
        }
    }
});