app.controller("indexController",function($scope,loginService){
	$scope.getloginName=function(){
		loginService.loginName().success(
			function(response){
				$scope.loginName=response.loginName;
			}
		);
	}
	
});