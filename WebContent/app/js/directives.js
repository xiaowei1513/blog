/*
 * 指令
 * 
 * */
var appDirective = angular.module('appDirective', []);

//注射器加载完所有模块时，此方法执行一次
appDirective.run(["$templateCache", function($templateCache) {
	  $templateCache.put("app/view/navigation/test.html",
	    '<div class="col-xs-6 col-md-3" style="width:auto; " ng-repeat="item in baneItems ">'+
	    '    <div class="thumbnail" style="cursor:pointer;position:relative;">'+
	    '       <img ng-src="{{item[smSrc]}}" ng-style="smSize" ng-click="showBigBox($index)" src="" style="display: none;"><img alt="加载中..." title="图片加载中..." src="http://www.2cto.com/statics/images/s_nopic.gif"> '+
	    '       <div style=" position:absolute; bottom:4px;background: rgba(225,225,225,0.5); right: 4px;left: 4px; text-align:right;">'+
	    '           <span style="float:left;" ng-show="radioShow"><input type="radio" ng-model="selectItem.cover" value="{{item[radioValue]}}"><label>{{radioText}}</label></span>'+
	    '            <i class="glyphicon glyphicon-search" ng-click="showBigBox($index)" style="margin: 2px 5px;"></i>'+
	    '            <i class="glyphicon glyphicon-trash" ng-click="deleteItem($index)" style="margin: 2px 5px;" ng-show="deleteShow"></i>'+
	    '        </div>'+
	    '    </div>'+
	    '    <div class="modal fade bs-example-modal-lg in" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="false" style=" padding-right: 15px; display:block" ng-show="item.baneBigImageShow">'+
	    '       <div class="modal-backdrop fade in"></div>'+
	    '           <div class="modal-dialog modal-lg" style="z-index:1100;">'+
	    '               <div class="modal-content">'+
	    '                   <div class="modal-header">'+
	    '                       <button type="button" class="close" data-dismiss="modal" ng-click="closeBox($index)"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>'+
	    '                   </div>'+
	    '               <div class="modal-body" style="text-align:center;">'+
	    '                       <img ng-src="{{item[orgSrc]?item[orgSrc]:item[smSrc]}}" style="max-width: 100%; display: none;" src=""><img alt="加载中..." title="图片加载中..." src="http://www.2cto.com/statics/images/s_nopic.gif">'+
	    '               </div>'+
	    '           </div>'+
	    '       </div>'+
	    '   </div>'+
	    '</div>'
	    );
	}]);
//首页图片加载
appDirective.directive("mainsidebox", function($templateCache,$timeout) {
	var mainsidebox ={
			restrict: 'AECM',	//匹配模式
			controller: function($scope,$http,$timeout ) {
				$scope.sourse = {
						'new':'最新日志',
						'hot':'热门日志',
						'comm':'联系方式',
						'color':'#c1e735',
				};
				$http({
					method:'POST',
					url:'classification.readById.action',
					params: {id:1}
				}).success(function(data,status,headers,config){
					$scope.data = data;
				});
			},
			templateUrl:'app/view/sidebox/mainsidebox.html',
			link:function(scope, element, attrs ){
/*				$(document).on('mouseenter.bs.carousel.data-api', '[data-slide], [data-slide-to]', function (e) {
					var $this   = $(this), href
					var $target = $($this.attr('data-target') || (href = $this.attr('href')) && href.replace(/.*(?=#[^\s]+$)/, '')) //strip for ie7
					var options = $.extend({}, $target.data(), $this.data())
					var slideIndex = $this.attr('data-slide-to')
					if (slideIndex) options.interval = false
					$target.carousel(options)
					if (slideIndex = $this.attr('data-slide-to')) {
					  $target.data('bs.carousel').to(slideIndex)
					}
					e.preventDefault()
				});*/
				$timeout(function() {
					//首页图片自动轮播间隔5秒。
					//startMove(30000);
					//$('.carousel').carousel({interval: 3000 });
                }, 1000);
	            element.bind("mouseenter", function() {
	            });
	            element.on('click', function(e) {
		        });
	            var timer = null;//时间对象
	            var alpha = 3000;//透明度初始值
	            var color =0;
	            function startMove(iTarget){
	               clearInterval(timer);//清空时间对象
	               timer = setInterval(function(){
	                  if(color>=defaultColor.length){
	                	  color=0;  
	                  }
	                  var speed = 0;
	                  if(alpha < iTarget){
	                     speed =5;
	                  }else{
	                     speed = -5;
	                  }
	                  if(alpha == iTarget){
	                     clearInterval(timer);
	                  }else{
	                     //alpha +=speed; //透明度值增加效果
	                    // oDiv.style.filter = 'alpha(opacity:'+alpha+')'; //设置IE透明度
	                     //oDiv.style.opacity = alpha / 100; //设置其他浏览器
	                     oDiv.style.background =  defaultColor[color]; //设置其他浏览器
	                     color++;
	                  }
	               },3000);
	            }
			}

	};
	return mainsidebox;
});

appDirective.directive("homemaincontent", function($templateCache,$http) {
 return {
        restrict: 'EA',
        transclude: true,
        controller:
        function ($scope, $element,$attrs,$transclude) {
            $transclude(function (clone) {              
                var a = angular.element('<a>');
                a.attr('href', $attrs.value);
                a.text(clone.text());
                $element.append(a);
            });
        }
    };
});
appDirective.directive("baneImggrid",function(){
    return {
            restrict:'EA',
            transclude: true,
            replace: false,
            //templateUrl: "template/image(1).html",
            templateUrl:"app/view/navigation/test.html",
            scope:{
                    baneItems:'=',
                    smSrc:'@',
                    orgSrc:'@',
                    radioText:'@',
                    radioValue:'@',
                    radioShow:'=',
                    deleteShow:'=',
                    selectItem:'=',
                    itemDelete:'=',
                    //beforeDelete:'&'
                },
            link:function(scope, element, attrs,contr){
                    scope.selectItem={"cover":""};
                    scope.orgSrc=(scope.orgSrc?scope.orgSrc:scope.smSrc);
                    scope.smSize={};
                    if(attrs.smWidth){
                        scope.smSize.width=attrs.smWidth;
                        }
                    if(attrs.smHeight){
                            scope.smSize.height=attrs.smHeight;
                        }   
                    scope.showBigBox=function(index){
                            scope.baneItems[index].baneBigImageShow=true;                           
                        }
                    scope.closeBox=function(index){
                            scope.baneItems[index].baneBigImageShow=false;  
                        }
                    scope.deleteItem=function(index){
                            scope.itemDelete=scope.baneItems[index];
                            //scope.beforeDelete();
                            scope.baneItems.splice(index, 1);
                        }                               
                }
        }
    });