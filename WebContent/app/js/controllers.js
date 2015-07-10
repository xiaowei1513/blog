var appController = angular.module('appController', []);

appController.controller('Navigation', [ '$scope','$http','dataService', function($scope,$http,dataService) {
			$scope.greeting = {
				index : '网站首页',
				dataBase : 'DataBase',
				html : 'Html',
				css : 'Css',
				extJs : 'ExtJs',
				angularJS : 'AngularJS',
				websiteDesign : '网站设计',
				seo:'SEO',
				chongQing : 'ChongQing',
				aboutWebSite : '关于本站',
				subTitle : {
					news : '最新日志',
					hot : '热门日志',
				},
				personalProfile : {
					personalProfile : '个人简介',
					connection : '联系方式'
				}
			};
			$scope.action = function(target) {
				dataService.key = target.name;
				dataService.value = target.text;
				dataService.defaultData.loaction = target.text;
			};
} ]);

appController.controller('SideBox', [ '$scope', function($scope) {
	$scope.greeting = {
		contact : '联系我',
		cooperation : '广告投放及合作：',
		qqTalk : '  QQ交谈',
		popularArticle:'热门文章',
		weixin:'小伟的微信',
		randomArticle:'随机文章'
	};
} ]);

appController.controller('RollPage', [ '$scope','$http', function($scope) {
	
} ]);
appController.controller('HomePage', [ '$scope','$http', 'dataService',function($scope,$http,dataService) {
	$scope.readMostContent =function(target){
		dataService.key = target.name;
		dataService.value = target.textContent;
		dataService.content.id = target.dataset.id;
	};
	$scope.content={
		readmore:"阅读全文",
		author:"作者:",
		classification:"分类:",
		read:"阅读次数:"
	};
	$http({
		method:'POST',
		url:'home.summary.action'
	}).success(function(data,status,headers,config){
		$scope.datas = data;
	});
} ]);
appController.controller('Classification', [ '$scope','$http','dataService', function($scope,$http,dataService) {
	$scope.target = dataService;
	$scope.content = {
		readmore : "阅读全文",
		author : "作者:",
		classification : "分类:",
		read : "阅读次数:"
	};
	$http({
		method:'POST',
		url:'classification.summary.action'
	}).success(function(data,status,headers,config){
		$scope.datas = data;
	});
	$scope.readMostContent =function(target){
		dataService.key = target.name;
		dataService.value = target.textContent;
		dataService.content.id = target.dataset.id;
	}
} ]);
appController.controller('Content', [ '$scope','$http','dataService', function($scope,$http,dataService) {
	$scope.target = dataService;
	$scope.content = {
			readmore : "阅读全文",
			author : "作者:",
			classification : "分类:",
			read : "阅读次数:"
		};
	$scope.greeting = {
		title : '工作生活',
		cooperation : '广告投放及合作：',
		qqTalk : '  QQ交谈',
		popularArticle:'热门文章',
		weixin:'小伟的微信',
		randomArticle:'随机文章'
	};
	$http({
		method:'POST',
		url:'classification.readById.action',
		params: {id:dataService.content.id}
	}).success(function(data,status,headers,config){
		$scope.data = data;
	});
} ]);
appController.controller('Mainsidebox', [ '$scope','$http','dataService', function($scope,$http,dataService) {
	$scope.target = dataService;
	
} ]);