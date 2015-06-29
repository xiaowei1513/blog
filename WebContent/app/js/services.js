var appServices = angular.module('appServices', []);

appServices.factory('dataService', [function(){
    var serviceInstance = {
    		defaultData:{
    			maskLoc:"当前位置 :",
    			readmore : "阅读全文",
    			loaction:""
    		},
    		key :"",
    		value:'',
    		home:"首页",
    		content:{
    			id:''
    		}
    		
    };
    // 我们的第一个服务
    return serviceInstance;
}]);

appServices.service('loadContentService', ['$scope',
    function($scope) {}
]);
