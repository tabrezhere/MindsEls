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
									
						//	 $scope.campusId=$stateParams.campusID;
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
								state : '',
								subjectName : '',
								campusId : '',
								campusName : '',
								orgId : '',
								OrgName : '',
								Vehicle : ''
								
						  };

						  function deleteStaff(id) {
                			staffProfileDetails.splice(id, 1);
            			}
            			function updateStaff(id, staffProfileDetails) {
                			staffProfileDetails[id] = staffProfileDetails;
                		}

   						
							
							} ]);
})();

