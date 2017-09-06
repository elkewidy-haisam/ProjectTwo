/**
 * 
 */

//center content module
     angular.module("centerContent", ["ngRoute"]);

     
//create profile
	angular.module("centerContent").controller("moderatoraddprofilecontroller", function($scope, $http) {
	
	
		$scope.adduser = function() {
			
			$scope.user = {
					
				username : $scope.newUser.username,
				password : $scope.newUser.password,
				firstname :  $scope.newUser.firstname,
				lastname : $scope.newUser.lastname
					
					
			}
			
			$scope.newUser.username = " ";
			$scope.newUser.password = " ";
			$scope.newUser.firstname = " ";
			$scope.newUser.lastname = " ";
			
			console.log($scope.user);
			
			$http({
				
					method: "POST", url: "http://localhost:8080/MavProj/user/create", data: $scope.user
					
					
				}).then(function(response) {
					
					if (response.status === 200) {
						
						$scope.users = response.data;
						console.log("User created.");
						console.log($scope.users);
						
					} else {
						
						console.log("User not created.");
						console.log($scope.users);
					}
					
			});
				
		}
	
	});

//update profile
	angular.module("centerContent")
		.controller("moderatorupdateprofilecontroller",function($http,$scope){
			$scope.updateProfile = function(){
				
				$scope.user = {
						
						username : $scope.oldUser.username,
						password : $scope.oldUser.password,
						firstname :  $scope.oldUser.firstname,
						lastname : $scope.oldUser.lastname
							
							
					}
					
					$scope.oldUser.username = " ";
					$scope.oldUser.password = " ";
					$scope.oldUser.firstname = " ";
					$scope.oldUser.lastname = " ";
					
					console.log($scope.user);
				
				
				
				$http.put("http://localhost:8080/MavProj/user/update",
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
					
				$scope.blogpost = {
						
						content : $scope.blog.content,
						id: 1,
						blogpost_user_id : 1300
						
				}
				
				$scope.blog.content = " ";
				console.log($scope.blogpost);
					
					
				$http.post("http://localhost:8080/MavProj/blogpost/create", 
						$scope.blogpost).then(function(value){
							
							window.alert("Blog Post Created");
							
					});
				
				
			}
	});



//delete blogpost
	angular.module("centerContent")
	.controller("moderatordeleteblogcontroller",
			function($http,$scope){
				$scope.deleteBlog = function(){
					
					$scope.deleted = {
							
						id : 1,
						content : $scope.blog.content,
						user_id : 1300
							
					}
					
					
				$http.delete("http://localhost:8080/MavProj/blogpost/delete", 
						$scope.deleted).then(function(value){
							
							window.alert("Blog Post Deleted");
							
						});
				}
	});
	
// view blogposts
	angular.module("centerContent").controller("moderatorgetallblogscontroller", function($scope, $http) {
		
		$http({
		
			method: "GET", url: "http://localhost:8080/MavProj/blogpost/getall"
			
		}).then(function(response) {
			
			$scope.allBlogs = response.data;
			
		});

	});
	

