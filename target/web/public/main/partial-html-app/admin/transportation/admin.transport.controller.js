//Admin - StudentController
(function() {
	'use strict';

	angular.module('theApp').controller(
			'AdminTransportController',
			[
					'$location',
					'$rootScope',
					'$scope',
					'$http',
					'$stateParams',
					'AdminPostService',
					function($location, $rootScope, $scope, $http, $stateParams,AdminPostService) {
						//var vm = this;
						//$scope.newStudentAdmission = newStudentAdmission;
                        $scope.campusId=1;
						$scope.TransportFormDisplay = false;
						$scope.editVehicleFlag = false;
						$scope.viewVehicleFlag = true;
						$scope.Transport = {
							TransportName : '',
							TransportId : ''
													
						};
						
						
						
						 
										
										
						AdminPostService.getTransportList($scope.campusid,function(response){
				       	  	$scope.TransportList = response;
				       	  	
				       	  	});
					
						
						 
						
						
						 $scope.showUserModal = function(vehicleId){
					   		    var vehicle = AdminService.getTransportListByVehicleId(vehicleId);
					   		    console.log('model');
					   		    $scope.currVehicle = vehicle;
					   		    $('#myModalLabel').text(vehicle.Vehicle_code);
					   		    $('#myVehicleModal').modal('show');
					   		  };
						$scope.editVehicleInfo = function(){
							$scope.viewVehicleFlag = false;
							$scope.editVehicleFlag = true;
							
						};
						$scope.updateVehicleInfo = function(){
							console.log('Need to call service method to update vehicle info');
							console.log('new Vehicle name --- '+$scope.Transport.TransportName);
							console.log('new Vehicle id --- '+$scope.Transport.TransportId);
							$scope.messageInfo = "Vehicle Info Successfully Updated!";
							$scope.viewVehicleFlag = true;
							$scope.editVehicleFlag = false;
							
						};


						

					

					} ]);

})();
