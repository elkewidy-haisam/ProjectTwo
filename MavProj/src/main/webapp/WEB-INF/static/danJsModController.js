

//update profile
	
	angular.module("centerContent")
		.controller("moderatorupdateprofilecontroller",function($http,$scope){
			$scope.updateProfile = function(){
				$http.post("http://localhost:8080/MavProj/user/update",
						$scope.user).then(function(value){
					window.alert("Profile Updated.");
				});
			}
			
		});

//create blogpost
	
	angular.module("centerContent")
	.controller("moderatoraddblogcontroller",
			function($http,$scope){
				$scope.createBlog = function(){
				$http.post("http://localhost:8080/MavProj/blogpost/create", 
						$scope.blogpost).then(function(value){
							window.alert("Blog Post Created");
						});
				}
	});
	