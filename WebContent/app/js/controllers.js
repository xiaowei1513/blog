var appController = angular.module('appController', []);

appController.controller('Navigation', [ '$scope','$http','dataService', function($scope,$http,dataService) {
	$scope.greeting = {
		search : '搜索',
		homePage : '网站首页',
		safe : {
			safe : '工作生活',
			workingLog : '工作日志',
		},
		study:'读书学习',
		marketing:'市场营销',
		networkMarketing:'网络营销',
		seo : 'SEO',
		sharingTechnology : '技术分享',
		chongqing : '重庆',
		personalProfile :{
			personalProfile:'个人简介',
			resume:'个人简历',
			aboutWebSite:'关于本站',
			contactMe:'联系我'
		}
	};
	$scope.setClassification =function(target){
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