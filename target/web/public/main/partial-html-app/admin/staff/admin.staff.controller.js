//Admin - StudentController
(function() {
	'use strict';

	angular
			.module('theApp')
			.controller(
					'AdminStaffController',
					[
							'$location',
							'$rootScope',
							'$scope',
							'$http',
							'AdminPostService',
							'AdminServiceAPI',
							function($location, $rootScope, $scope, $http,
									AdminPostService, AdminServiceAPI) {

								$scope.StaffFormDisplay = false;

								AdminPostService.GetStaffListbyCampusId(
										$scope.campusid, function(response) {
											$scope.staffList = response;

										});
								
						//staff details start 	
								
						$scope.staffprofile= {
								  "id": 4,
								  "email": "test@gmail.com",
								  "firstName": "student1",
								  "lastName": "student1",
								  "middleName": "student1",
								  "address1": "MSK Mill",
								  "address2": "GLB",
								  "city": "GLB",
								  "state": "KARNATAKA",
								  "Deleted": 1,
								  "context": "Student",
								  "user_id": 4,
								  "StaffId": "adm1",
								  "phoneNumber": 9685741230,
								  "class_id": 1,
								  "className": "1st Standard",
								  "campusId": 1,
								  "campusName": "Al-Ameen",
								  "orgId": 1,
								  "orgName": "Minds",
								  "vehicleId": 1
								};		
							$scope.staffvehicle={
									  "id": 1,
									  "Vehicle_no": "KA-32",
									  "Vehicle_code": "Cab56",
									  "No_of_Seat": 60,
									  "Maximum_capacity": 54,
									  "insurance": "Ins-562",
									  "tax_remitted": "tax-6985",
									  "permit": "per-454",
									  "status": "Excellent",
									  "Vehicle_type_id": 1,
									  "RouteId": 1,
									  "No_of_Stops": 4,
									  "Route_Name": "MSK Mill",
									  "StopDetailsList": [
									    {
									      "id": 1,
									      "Stop_Name": "Stop 1",
									      "fare": "200",
									      "Arival_Mrng": "8:10 AM",
									      "Departure_Mrng": "8:20 AM",
									      "Arival_Evng": "5:20 PM",
									      "Departure_Evng": "5:30 PM",
									      "Route_details_id": 1
									    },
									    {
									      "id": 2,
									      "Stop_Name": "Stop 2",
									      "fare": "200",
									      "Arival_Mrng": "8:10 AM",
									      "Departure_Mrng": "8:20 AM",
									      "Arival_Evng": "5:20 PM",
									      "Departure_Evng": "5:30 PM",
									      "Route_details_id": 1
									    },
									    {
									      "id": 3,
									      "Stop_Name": "Stop 3",
									      "fare": "200",
									      "Arival_Mrng": "8:10 AM",
									      "Departure_Mrng": "8:20 AM",
									      "Arival_Evng": "5:20 PM",
									      "Departure_Evng": "5:30 PM",
									      "Route_details_id": 1
									    },
									    {
									      "id": 4,
									      "Stop_Name": "Stop 4",
									      "fare": "200",
									      "Arival_Mrng": "8:10 AM",
									      "Departure_Mrng": "8:20 AM",
									      "Arival_Evng": "5:20 PM",
									      "Departure_Evng": "5:30 PM",
									      "Route_details_id": 1
									    }
									  ]};
									
							
							$scope.staffmedical={
									  "id": 1,
									  "user_id": 4,
									  "Bloodgroup": "A+",
									  "height": 5.199999809265137,
									  "weight": 55,
									  "ailment": "Nil",
									  "Doctorname": "Andrey",
									  "Doctor_address": "USA",
									  "Mobile": 9685741230
									};
							
							$scope.staffclass=[{"id":1,"classname":"second standard"},{"id":2,"classname":"third standard"},{"id":3,"classname":"fourth standard"}];
							
							$scope.staffclassstudentdetails=[
							                                 {
							                                	    "id": 1,
							                                	    "email": "test@gmail.com",
							                                	    "firstName": "student1",
							                                	    "lastName": "student1",
							                                	    "middleName": "student1",
							                                	    "address1": "MSK Mill",
							                                	    "address2": "GLB",
							                                	    "city": "GLB",
							                                	    "state": "KARNATAKA",
							                                	    "Deleted": 1,
							                                	    "context": "Student",
							                                	    "user_id": 4,
							                                	    "Studentadminno": "adm1",
							                                	    "phoneNumber": 9685741230,
							                                	    "class_id": 1,
							                                	    "className": "1st Standard",
							                                	    "campusId": 1,
							                                	    "campusName": "Al-Ameen",
							                                	    "orgId": 1,
							                                	    "orgName": "Minds",
							                                	    "vehicleId": 1
							                                	  },

							                                	  {
							                                		"id": 2,
							                                	    "email": "abc@gmail.com",
							                                	    "firstName": "student2",
							                                	    "lastName": "student2",
							                                	    "middleName": "student2",
							                                	    "address1": "MSK Mill",
							                                	    "address2": "GLB",
							                                	    "city": "GLB",
							                                	    "state": "KARNATAKA",
							                                	    "Deleted": 1,
							                                	    "context": "Student",
							                                	    "user_id": 4,
							                                	    "Studentadminno": "adm1",
							                                	    "phoneNumber": 9685741230,
							                                	    "class_id": 1,
							                                	    "className": "1st Standard",
							                                	    "campusId": 1,
							                                	    "campusName": "Al-Ameen",
							                                	    "orgId": 1,
							                                	    "orgName": "Minds",
							                                	    "vehicleId": 1
							                                	  },

							                                	  {
							                                		"id": 5,
							                                	    "email": "xyz@gmail.com",
							                                	    "firstName": "student3",
							                                	    "lastName": "student3",
							                                	    "middleName": "student3",
							                                	    "address1": "MSK Mill",
							                                	    "address2": "GLB",
							                                	    "city": "GLB",
							                                	    "state": "KARNATAKA",
							                                	    "Deleted": 1,
							                                	    "context": "Student",
							                                	    "user_id": 4,
							                                	    "Studentadminno": "adm1",
							                                	    "phoneNumber": 9685741230,
							                                	    "class_id": 1,
							                                	    "className": "1st Standard",
							                                	    "campusId": 1,
							                                	    "campusName": "Al-Ameen",
							                                	    "orgId": 1,
							                                	    "orgName": "Minds",
							                                	    "vehicleId": 1
							                                	  }
							                                	];
								
						// staff details ends		

								console.log($scope.StaffList);

								$scope.showAddStaffForm = function() {
									$scope.Staff = {
										StaffName : '',
										StaffId : '',
										email : '',
										address1 : '',
										phoneNumber : ''
									};
									$scope.StaffFormDisplay = true;
								};

								$scope.addStaff = function() {
									$scope.StaffList.push($scope.Staff);
									$scope.StaffFormDisplay = false;
								};

								$scope.showStaffModal = function(id) {
									AdminService
											.getStaffInfoById(
													id,
													function(response) {
														$scope.currStdobj = response;
														$('#stafftName')
																.text(
																		$scope.currStaffdobj.firstName);
														$('#myStaffModal')
																.modal('show');
													});
								};

								$scope.closeAddStaffForm = function() {
									$scope.StaffFormDisplay = false;
								};

							} ]);

})();
