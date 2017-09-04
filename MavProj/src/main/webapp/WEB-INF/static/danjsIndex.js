
//reference router
	angular.module("centerContent",["ng-route"]);
	
	angular.module("centerContent")
	.config(function($locationProvider, $routeProvider){
		$locationProvider.hashPrefix("");
		$routeProvider.when("/moderatorUpdateProfile",{
			templateUrl: "moderatorUpdateProfile.html",
			controller: "moderatorupdateprofilecontroller"
		}).when("/createBlog",{
			templateUrl: "moderatoraddblog.html",
			controller: "moderatoraddblogcontroller"
		});
	});
  