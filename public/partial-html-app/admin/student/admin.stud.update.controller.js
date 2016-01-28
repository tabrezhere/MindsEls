//StaffController
(function() {
	'use strict';




	angular
			.module('theApp')
			.controller(
					'AdminStudentUpdateController',
					[
						'$location',
						'$rootScope',
						'$scope',
						'$http',
						'$stateParams','AdminPostService',
						function($location, $rootScope, $scope, $http, $stateParams, AdminPostService) {
									
						//	 $scope.campusId=$stateParams.campusID;
						$scope.studentDetails;
							 //$scope.staffId=$stateParams.staffID;
							 $scope.studentId=$stateParams.studentID;
							 console.log("$stateParams.studentId   "+$stateParams.studentID);
							 console.log("inside AdminStudentEditController calling AdminPostService.getStudentByStudentId");

								  AdminPostService.getStudentByStudentId($scope.studentId,function(response){
						       	  	        $scope.studentProfileDetails = response;
						       	  	       return response;
						       	  	        });				
								 
							console.log("student"+$scope.studentProfileDetails);
							$scope.studentProfileDetails ={
								id : '',
								firstName : '',
								middleName : '',
								lastName : '',
								address1 : ' ',
								address2 : '',
								email : '',
								phoneNumber : '',
								city : '',
								state : '',
								class_id : '',
								orgName : ''
								
						  };
						  $scope.studentUpdate = function(){
						  	$scope.studentDetails = $scope.studentProfileDetails;
						  	$scope.message = "";
						  	console.log("studentId: "+ $scope.studentDetails.id + "  firstName: "+ $scope.studentDetails.firstName + " middleName: "+ $scope.studentDetails.middleName + "  lastName: "+ $scope.studentDetails.lastName + 
						  		"  address1"+ $scope.studentDetails.address1 + " updatestaff address2 "+ $scope.studentDetails.address2 + "  email "+ $scope.studentDetails.email + "  phoneNumber "+ $scope.studentDetails.phoneNumber +
						  		"  city"+ $scope.studentDetails.city + "  state"+ $scope.studentDetails.state);
						  	$scope.message = "Student Updated Successfully";
						  	/*AdminPostService.updateStaffByAdmin($scope.staffDetails,function(response){
						  			$scope.message = response.data.message;
						  	});*/
						  }
   						
							
							} ]);
})();

