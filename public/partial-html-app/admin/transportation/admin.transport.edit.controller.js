//StaffController
(function() {
	'use strict';




	angular
			.module('theApp')
			.controller(
					'AdminTransportEditController',
					[
						'$location',
						'$rootScope',
						'$scope',
						'$http',
						'$stateParams','AdminPostService',
						function($location, $rootScope, $scope, $http, $stateParams, AdminPostService) {
									
							 $scope.vehicleDetails;
							 $scope.vehicleId=$stateParams.vehicleID;
							 console.log("$stateParams.vehicleId   "+$stateParams.vehicleID);
							 console.log("inside AdminTransportEditController calling AdminPostService.Getvehicleroutebyvid");

								  AdminPostService.Getvehicleroutebyvid($scope.vehicleId,function(response){
						       	  	        $scope.vehicleList = response;
						       	  	       return response;
						       	  	        });				
								 
							console.log("staff"+$scope.vehicleList);
							
						  	$scope.vehicleList ={
											Vehicle_no: '',
						            		Vehicle_code: '',
						            		No_of_Seat: '',
						            		Maximum_capacity: '',
						            		insurance: '',
						            		tax_remitted:'',
						            		permit:'',
						            		status: '',
						            		Vehicle_type_id: 1,
						            		Route_Name: '',
						            		No_of_Stops: 4, 
						            		Stop_Name:'',
						            		fare : '',
						            		Arival_Mrng : '',
						            		Departure_Mrng : '',
						            		Arival_Evng : '',
						            		campusId: '',
						            		Departure_Evng : ''
								
						  };
						  $scope.vehicleUpdate = function(){
						  	$scope.vehicleDetails = $scope.vehicleList;
						  	$scope.message = "";
						  	console.log("vehicleId: "+ $scope.vehicleList.Vehicle_no + "  firstName: "+ $scope.vehicleDetails.firstName + " middleName: "+ $scope.staffDetails.middleName + "  lastName: "+ $scope.staffDetails.lastName + 
						  		" updatestaff address1"+ $scope.staffDetails.address1 + " updatestaff address2 "+ $scope.staffDetails.address2 + " updatestaff email "+ $scope.staffDetails.email + " updatestaff phoneNumber "+ $scope.staffDetails.phoneNumber +
						  		" updatestaff city"+ $scope.staffDetails.city + " updatestaff state"+ $scope.staffDetails.state);
						  	$scope.message = "Vehicle Updated Successfully";
						  	/*AdminPostService.updateStaffByAdmin($scope.staffDetails,function(response){
						  			$scope.message = response.data.message;
						  	});*/
						  }
							
							} ]);
})();

