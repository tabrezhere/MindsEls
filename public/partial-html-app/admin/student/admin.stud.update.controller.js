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
						//	 $scope.staffId=$stateParams.staffID;
							 $scope.studentId=$stateParams.studentID;
							 console.log("$stateParams.studentId   "+$stateParams.studentID);
							 console.log("inside AdminStudentUpdateController calling AdminPostService.getStudentByStudentId");
							 
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
								Studentadminno : '',
								class_id :'',
								className : '',
								campusId : '',
								campusName : '',
								orgId : '',
								orgName : '',
								vehicleId : ''

								
						  };
   						
							
							} ]);
})();

