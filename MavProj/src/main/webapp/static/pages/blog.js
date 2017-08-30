/**
 * Blog Module. Retrieves blog posts depending on needs, and their respective comments.
 */

angular.module("blog", ["ngRoute"] );


//configuration to map front controller URL with AngularJS controllers
angular.module("blog").config(function($routeProvider, $locationProvider) {

	$locationProvider.hashPrefix("");
	$routeProvider
		.when("/about", { 
			
			templateUrl: "about.html",
		
		
		})
		.when("/addBlogPost", { 
				
			templateUrl: "blogpost_form.html",
			controller: "createBlogPostCtrl"
		
		
		})
		.when("/viewRecentBlogPosts", { 
				
			templateUrl: "blogposts_recent.html",
			controller: "viewRecentBlogPostsCtrl"
		
		})
		.when("/viewAllBlogPosts", { 
				
			templateUrl: "blogposts_all.html",
			controller:	"viewAllBlogPostsCtrl"
		
		})
		.when("/viewYourBlogPosts", { 
				
			templateUrl: "blogposts_user.html",
			controller: "viewYourBlogPostsCtrl"
		
		})
		.when("/viewBlogPost", {
			
			templateUrl: "blogpost.html",
			controller: "getBlogPostCtrl"
			
		});
		
		
});


angular.module("blog").controller("createBlogPostCtrl", function($scope, $http) {
	
	

	
});

angular.module("blog").controller("viewRecentBlogPostsCtrl", function($scope, $http) {

	
	
});

angular.module("blog").controller("viewAllBlogPostsCtrl", function($scope, $http) {

	

});

angular.module("blog").controller("viewYourBlogPostsCtrl", function($scope, $http) {
	
	
	
});







