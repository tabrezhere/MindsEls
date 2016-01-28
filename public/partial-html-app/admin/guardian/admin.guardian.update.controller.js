//StaffController
(function() {
	'use strict';




	angular
			.module('theApp')
			.controller(
					'AdminGuardianUpdateController',
					[
						'$location',
						'$rootScope',
						'$scope',
						'$http',
						'$stateParams','AdminPostService',
						function($location, $rootScope, $scope, $http, $stateParams, AdminPostService) {

							$scope.campusId=1;
							AdminPostService.getAllGuardianListByCampusId($scope.campusId,function(response){
						       	  	        $scope.guardianList = response;
						       	  	       return response;
						       	  	        });	
							$scope.guardianList={
								id:'',
						  		user_id : '',
				  				email: '',
				  				password: '',
				  				firstName: '',
				  				middleName: '',
				  				lastName: '',
				  				DOB:'',
				  				Gender:'',
				  				address1: '',
				  				address2: '',
				  				city:'',
				  				state : '',
				  				
				  				contextId: '',
				  				campusId: '', 
				  				 campusName: '',
				  				 orgId: '',
				  				 orgName: '',
				  				relationship:'',
				  				mobile: '',
				  				income:'',
				  				education:'',
				  				stdadmissionno:'',		
				  			};

				  			$scope.student={
				  				studentdetails: [{"FirstName":"zishan","MiddleName":"ahmed","Lastname":"ahmed","Studentadminno":"adm6"},
				  				{"FirstName":"Ishan","MiddleName":"ahmed","Lastname":"ahmed","Studentadminno":"adm7"}], 
				  			}
									
							 $scope.guardianDetails;
							 $scope.guardianId=$stateParams.guardianID;
							 console.log("$stateParams.guardianId   "+$stateParams.guardianID);
							 console.log("inside AdminGuardianUpdateController calling AdminPostService.getGuardianByGuardianId");
								  AdminPostService.getGuardianByGuardianId($scope.guardianId,function(response){
						       	  	        $scope.guardianProfileDetails = response;
						       	  	       return response;
						       	  	        });				
							console.log("guardian"+$scope.guardianProfileDetails);	
						  $scope.guardianProfileDetails={
						  		id:'',
						  		user_id : '',
				  				email: '',
				  				password: '',
				  				firstName: '',
				  				middleName: '',
				  				lastName: '',
				  				DOB:'',
				  				Gender:'',
				  				address1: '',
				  				address2: '',
				  				city:'',
				  				state : '',
				  				contextId: '',
				  				campusId: '', 
				  				 campusName: '',
				  				 orgId: '',
				  				 orgName: '',
				  				relationship:'',
				  				mobile: '',
				  				income:'',
				  				education:'',
				  				stdadmissionno:''
				  						
				  			};
						  $scope.guardianUpdate = function(){
						  	$scope.guardianDetails = $scope.guardianProfileDetails;
						  	$scope.message = "";
						  	console.log("ParentId: "+ $scope.guardianDetails.user_id + "  firstName: "+ $scope.guardianDetails.firstName + " middleName: "+ $scope.guardianDetails.middleName + "  lastName: "+ $scope.guardianDetails.lastName + 
						  		"  address1"+ $scope.guardianDetails.address1 + "  address2 "+ $scope.guardianDetails.address2 + "  email "+ $scope.guardianDetails.email + "  phoneNumber "+ $scope.guardianDetails.phoneNumber +
						  		"  city"+ $scope.guardianDetails.city + "  state"+ $scope.guardianDetails.state);
						  	$scope.message = "guardian Updated Successfully";
						  	/*AdminPostService.updateStaffByAdmin($scope.staffDetails,function(response){
						  			$scope.message = response.data.message;
						  	});*/
						  }
							
							} ]);
})();

