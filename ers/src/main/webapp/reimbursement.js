/**
 * Modules and Controllers for adding, viewing, approving, denying, and filtering reimbursements

 */
//creates module for reimbursements, stores it in variable
angular.module("reimbursements", ["ngRoute"] );

//----------------------------------------------------------------------------------------------/
//Directives.

angular.module("reimbursements").directive('onReadFile', function ($parse) {
	  return {
	    restrict: 'A',
	    scope: false,
	    link: function(scope, element, attrs) {
	      var fn = $parse(attrs.onReadFile);

	      element.on('change', function(onChangeEvent) {
	        var reader = new FileReader();

	        reader.onload = function(onLoadEvent) {
	          var buffer = onLoadEvent.target.result;
	          var uint8 = new Uint8Array(buffer); // Assuming the binary format should be read in unsigned 8-byte chunks
	          // If you're on ES6 or polyfilling
	          // var result = Array.from(uint8);
	          // Otherwise, good old loop
	          var result = [];
	          for (var i = 0; i < uint8.length; i++) {
	            result.push(uint8[i]);
	          }

	          scope.$apply(function() {
	            fn(scope, {
	              $fileContent: result
	            });
	          });
	        };

	        reader.readAsArrayBuffer((onChangeEvent.srcElement || onChangeEvent.target).files[0]);
	      });
	    }
	  };
	});

//configuration to map front controller URL with AngularJS controllers
angular.module("reimbursements").config(function($routeProvider, $locationProvider) {
		$locationProvider.hashPrefix("");
		$routeProvider
			.when("/addReimbursement", {
				
				templateUrl: "reimbursement_form.html",
				controller: "addReimbursementCtrl"
				
			})
			.when("/approveReimbursement", {
			
				templateUrl: "reimbursement_allusers.html",
				controller: "approveReimbursementCtrl"
				
			})
			.when("/denyReimbursement", {
				
				templateUrl: "reimbursement_allusers.html",
				controller: "denyReimbursementCtrl"
				
			})
			.when("/viewPendingReimbursements", {
				
				templateUrl: "reimbursement_user_pending.html",
				controller: "viewPendingReimbursementsCtrl"
				
			})
			.when("/viewReimbursements", {
				
				templateUrl: "reimbursement_allusers.html",
				controller: "viewReimbursementsCtrl"
				
			})
			.when("/filterByStatus", {
				
				templateUrl: "reimbursement_allusers.html",
				controller: "filterByStatusCtrl"
				
			})
		
			.when("/viewPastReimbursements", {
				
				templateUrl: "reimbursement_user_past.html",
				controller: "viewPastReimbursementsCtrl"
				
			});

});


//add reimbursement into database
angular.module("reimbursements").controller("addReimbursementCtrl", function($scope, $http) {
	
	
	$scope.addRemibursement = function() {
		
		
		var pendingStatus = 2;
		var resolver = 8000;
		
		$scope.reimbursement = {
			
			reimb_author : 9000,
			reimb_amount : $scope.newReimbursement.reimb_amount,
			reimb_description : $scope.newReimbursement.reimb_description,
			reimb_status_id : pendingStatus,
			reimb_receipt : $scope.newReimbursement.reimb_receipt,
			reimb_type_id : parseInt($scope.newReimbursement.type_id),
			reimb_resolver : resolver
			
				
				
		}
		
		$scope.newReimbursement.reimb_amount = " ";
		$scope.newReimbursement.reimb_description = " ";
		$scope.newReimbursement.reimb_receipt = " ";
		$scope.newReimbursement.type_id = " ";
		
		
		console.log($scope.reimbursement);
		
		$http({
			
				method: "POST", url: "addReimbursement.do", data: $scope.reimbursement
				
				
			}).then(function(response) {
				
				if (response.status === 200) {
					
					$scope.reimbursements = response.data;
					console.log("Reimbursement added.");
					console.log($scope.reimbursements);
					
				} else {
					
					console.log("Response not added.");
					console.log($scope.reimbursements);
				}
				
			});
			
	}
	
});

//--------------------------------------------------------------------------------------------/

//approve reimbursement
angular.module("reimbursements").controller("approveReimbursementCtrl", function($scope, $http, $route) {
		
	$scope.approveReimbursement = function(){
		
		var approvedStatus = 0;
		var resolver = 8000;
		
		$scope.approved = {
				
				reimb_status_id : approvedStatus,
				reimb_resolver : resolver,
				reimb_id : $scope.reimb_id			
					
			}
		
		
		console.log($scope.approved);
		

		$http({
		
			method: "POST", url: "approveReimbursement.do", data: $scope.approved
			
		}).then(function(response) {
			
			console.log(response.status);
			
		});
		
		$route.reload();
		
	}


});

//--------------------------------------------------------------------------------------------/

//deny reimbursement
angular.module("reimbursements").controller("denyReimbursementCtrl", function($scope, $http, $route) {
		
	$scope.denyReimbursement = function(){
		
		var deniedStatus = 1;
		var resolver = 8000;
		
		$scope.denied = {
				
				reimb_status_id : deniedStatus,
				reimb_resolver : resolver,
				reimb_id : $scope.reimb_id			
					
			}
		
		
		console.log($scope.denied);
		
		$http({
		
			method: "POST", url: "denyReimbursement.do", data: $scope.denied
			
		}).then(function(response) {
			
			console.log(response.status);
			
		});
		
		$route.reload();
		
	}

});

//--------------------------------------------------------------------------------------------/

//gets all reimbursement requests with a pending status
angular.module("reimbursements").controller("viewPendingReimbursementsCtrl", function($scope, $http) {
		
		$http({
		
			method: "GET", url: "viewPendingReimbursement.do"
			
		}).then(function(response) {
			
			$scope.reimbursements = response.data;
			
		});

});

//--------------------------------------------------------------------------------------------/

//gets all reimbursements made by users, regardless of status
angular.module("reimbursements").controller("viewReimbursementsCtrl", function($scope, $http) {
		
	$http({
		
		method: "GET", url: "viewReimbursements.do"
		
	}).then(function(response) {
		
		$scope.reimbursements = response.data;
		
	});

});

//--------------------------------------------------------------------------------------------/

angular.module("reimbursements").controller("MainCtrl", function ($scope) {
	  $scope.showContent = function($fileContent) {
	    $scope.content = $fileContent;
	  };
	});

//--------------------------------------------------------------------------------------------/

//filters all reimbursements by status: approved, denied, or pending
angular.module("reimbursements").controller("filterByStatusCtrl", function($scope, $http) {
		
	$scope.filterReimbursementByStatus = function(){
		
		console.log($scope.newReimbursement);
		
		
		$http({
		
			method: "GET", url: "filterByStatus.do"
			
		}).then(function(response) {
			
			$scope.reimbursements = reimbursement;
			
		});
		
	}


});

//----------------------------------------------------------------------------------------------/

//view past reimbursement requests, that have either been approved or denied
angular.module("reimbursements").controller("viewPastReimbursementsCtrl", function($scope, $http) {
	
	$http({
	
		method: "GET", url: "viewPastReimbursements.do"
		
	}).then(function(response) {
		
		$scope.reimbursements = response.data;
		
	});

});

