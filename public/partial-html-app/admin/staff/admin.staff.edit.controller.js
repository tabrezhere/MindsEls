//StaffController
(function() {
	'use strict';




	angular
			.module('theApp')
			.controller(
					'AdminStaffEditController',
					[
						'$location',
						'$rootScope',
						'$scope',
						'$http',
						'$stateParams','AdminPostService',
						function($location, $rootScope, $scope, $http, $stateParams, AdminPostService) {
									
							 $scope.staffDetails;
							 $scope.staffId=$stateParams.staffID;
							 console.log("$stateParams.staffId   "+$stateParams.staffID);
							 console.log("inside AdminStaffEditController calling AdminPostService.getStaffByStaffId");
							 
							 	
								  AdminPostService.getStaffByStaffId($scope.staffId,function(response){
						       	  	        $scope.staffProfileDetails = response;
						       	  	       return response;
						       	  	        });				
								 
							console.log("staff"+$scope.staffProfileDetails);
							
						  	$scope.staffProfileDetails ={
								id : '',
								firstName : '',
								middleName : '',
								lastName : '',
								address1 : ' ',
								address2 : '',
								email : '',
								phoneNumber : '',
								city : '',
								state : ''
								
						  };
						  $scope.staffUpdate = function(){
						  	$scope.staffDetails = $scope.staffProfileDetails;
						  	$scope.message = "";
						  	console.log("staffId: "+ $scope.staffDetails.id + "  firstName: "+ $scope.staffDetails.firstName + " middleName: "+ $scope.staffDetails.middleName + "  lastName: "+ $scope.staffDetails.lastName + 
						  		" updatestaff address1"+ $scope.staffDetails.address1 + " updatestaff address2 "+ $scope.staffDetails.address2 + " updatestaff email "+ $scope.staffDetails.email + " updatestaff phoneNumber "+ $scope.staffDetails.phoneNumber +
						  		" updatestaff city"+ $scope.staffDetails.city + " updatestaff state"+ $scope.staffDetails.state);
						  	$scope.message = "Staff Updated Successfully";
						  	/*AdminPostService.updateStaffByAdmin($scope.staffDetails,function(response){
						  			$scope.message = response.data.message;
						  	});*/
						  }
							
							} ]);
})();

