(function() {
	'use strict';

	angular.module('theApp').controller(
			'RegisterController',
			[ 'AdminServiceAPI', '$location', '$rootScope', '$scope','AdminPostService','UIMessage',
					function(AdminServiceAPI, $location, $rootScope, $scope,AdminPostService, UIMessage) {

						$scope.register = register;
						$scope.registerdriver=registerdriver;
						$scope.registerguardian=registerguardian;
						$scope.registerstaff=registerstaff;
						$scope.createNewVehicle=createNewVehicle;
						$scope.createNewBook=createNewBook;
						$scope.createMedical=createMedical;
						$scope.dataLoading = false;
						$scope.OrganizationId=1;
						$scope.campusId=1;
						$scope.subjects;
						$scope.vehicles;
						$scope.state=["Karnataka","Tilangana","Maharastra","Goa","Uttar Pradesh"];
						$scope.gender=['Male','Female'];
						$scope.stdclass;
						$scope.adminclass;
						
						
						AdminPostService.getAllCampusByOrganizationId($scope.OrganizationId,function(response){
				       	  	$scope.campusList = response;
				       	  
				       	  	});	 
						AdminPostService.getAllsubjects(function(response){
		       	  	        $scope.subjects = response;
		       	  	      
		       	  	        });
						AdminPostService.getTransportList($scope.campusId,function(response){
		       	  	        $scope.vehicles = response;
		       	  	      
		       	  	        });
						
						AdminPostService.getAllClassesByCampusId($scope.campusId,function(response){
		       	  	        $scope.stdclass = response;
		       	  	      
		       	  	        });
						// Driver Details start
						$scope.driveruser ={
								identifier : '',
								password : '',
								firstName : '',
								middleName : '',
								lastName : '',
								contextId : 4,
								campusId : 1,
								address1 : ' ',
								phoneNumber : 5465,
								address2 : '',
								city : '',
								state : '',
								Gender : '',
								DOB : '',
								DLno:'',
								vehicleid:1
						  };
						
						// Driver details End
						
						$scope.user ={
								identifier : '',
								password : '',
								firstName : '',
								middleName : '',
								lastName : '',
								contextId : 4,
								campusId : 1,
								address1 : ' ',
								phoneNumber : 5465,
								address2 : '',
								city : '',
								state : '',
								Gender : '',
								DOB : '',
								Studentadminno:'',
								classId:1
						  };
						
						$scope.guardian={
				  				identifier: 'tab',
				  				password: 'tab',
				  				firstName: 'Amar',
				  				middleName: 'Akbar',
				  				lastName: 'Anthony',
				  				DOB:'1999-05-12',
				  				Gender:'Male/Female',
				  				address1: 'Brooklyn',
				  				address2: 'Jollyville Road',
				  				city:'Austin',
				  				state : 'texas',
				  				phoneNumber:9865321040,
				  				contextId: 4,
				  				campusId: 1,  
				  				relationship:'father',
				  				mobile:9865320140,
				  				income:'test',
				  				education:'School',
				  				stdadmissionno:'Admin123'
				  						
				  			};
				
			// Staff Sign Up Details Start 			
						
						$scope.staffuser={
				  				identifier: 'tab',
				  				password: 'tab',
				  				firstName: 'Amar',
				  				middleName: 'Akbar',
				  				lastName: 'Anthony',
				  				DOB:'1999-05-12',
				  				Gender:'Male',
				  				phoneNumber:9865321040,
				  				address1: 'Brooklyn',
				  				address2: 'Jollyville Road',
				  				city:'Austin',
				  				state : 'texas',
				  				campusId: 2,  
				  				contextId: 4,
				  				subjectName:'Select Subject',
				  				vehicleId:1,
				  				role_name:'father'
				  				
				  			    };	
						
						 $scope.selectedItem='Select Sub';
						 $scope.selectedstate="Select State";
						 $scope.dropboxitemselected = function (item) {
					     $scope.selectedItem = item;
			              };
						    
						 // DropBox For Subject Selection   
						 $scope.selectedsubject='---- Select Subject ----';
						 $scope.dropboxsubjectselected = function (item) {
							
						        $scope.staffuser.subjectName = item.subjectName;
						        $scope.selectedsubject=item.subjectName;
						  };
						  
						  // DropBox For State Selection 
						  
						  $scope.dropboxstateselected=function(item)
						  {    $scope.guardian.state=item;
							  $scope.staffuser.state = item;
							  $scope.selectedstate=item;
							  $scope.driveruser.state=item;
						  };
						  
						 // DropBox for Vehicle select 
						     $scope.selectedvehicle ='---- Select Vehicle ----';
							 $scope.dropboxvehicleselected = function (item) {
							 $scope.selectedvehicle=item.Vehicle_no;
							 $scope.staffuser.vehicleId=item.id;
							 $scope.driveruser.vehicleId=item.id;
							 };
							 
							
						  
						  //Dropbox for Gender Select
							  
					     $scope.selectedgender ='---- Select Gender ----';
								 $scope.dropboxgenderselected = function (item) {
								 $scope.selectedgender=item;
								 $scope.staffuser.Gender=item;
								 $scope.guardian.Gender=item;
								 $scope.driveruser.Gender=item;
								
								};
							  
						  
					// Staff Sign Up Details End   
								
								
			       // Create Vehicle details
								 $scope.vehiclecreatedata = {
										    Vehicle_no: 'KA-32',
						            		Vehicle_code: 'Cab56',
						            		No_of_Seat: 60,
						            		Maximum_capacity: 54,
						            		insurance: 'Required',
						            		tax_remitted:'Required',
						            		permit:'Required',
						            		status: 'Required',
						            		Vehicle_type_id: 1,
						            		Route_Name: 'MSK Mill',
						            		No_of_Stops: 4, 
						            		Stop_Name:'Stop 1,Stop 2,Stop 3 Stop 4',
						            		fare : '200,200,200,200',
						            		Arival_Mrng : '8:10 AM',
						            		Departure_Mrng : '8:20 AM',
						            		Arival_Evng : '5:20 PM',
						            		campusId:1,
						            		Departure_Evng : '5:30 PM'
						            		
						  		         };
					$scope.vehicletype=[  {
					                        "id": 1,
					                        "name": "Bus"					                        
					                      },
					                      {
					                    	  "id": 2,
						                        "name": "Cab"
					                      },
					                      {
					                    	  "id": 3,
						                        "name": "Auto"
					                      }
					                    ];	
					
					$scope.selectedvehicletype ='---- Select Vehicle type ----';
					$scope.dropboxvehicletypeselected = function (item) {
			        $scope.selectedvehicletype=item.name;
			        $scope.vehiclecreatedata.Vehicle_type_id=item.id;
						
						 };		 
								
				  // end vehicle details 				
						  $scope.selectedclass="--- Select Class ---";
						/* $scope.stdclass = [
								                    {
								                        "id": 1,
								                        "campus_id": 1,
								                        "term_id": 1,
								                        "class_name": "1st Standard",
								                        "deleted": 0
								                      },
								                      {
								                        "id": 2,
								                        "campus_id": 1,
								                        "term_id": 1,
								                        "class_name": "2nd Standard",
								                        "deleted": 0
								                      }
								                    ];
						    */
						  
						    $scope.dropboxclassselected=function(item)
						    {
						    	$scope.adminclass=item.id; 	 
						    	$scope.selectedclass=item.class_name;
				     	    };
					
					
						$scope.createnewbook={
							    id : 1,
							    ISBN: 'ISD1150',
							    Book_title: 'Computer Network',
							    date_of_publication: '1990-02-02',
							    bookCount: 10,
							    First_Name: 'B P Kottur',
							    Book_Categories_id:1,
							    Last_Name:'Krishan'
							    
						 };
						
						$scope.addnewMedical={
								userId : 1,
								Bloodgroup: 'B+',
								height: 5,
								weight: 52,
								ailment: 'Nill',
								Doctorname: 'Ramesh',
								Doctor_address:'Kalaburagi makka colony',
								Mobile:9620352041
							    
						 };
						
						

											
						function register() {
							$scope.dataLoading = true;
							AdminServiceAPI.createNewStudent($scope.user).then(function(response) {
								if (response.success) {
									console.log("Student Inserted success");
									
								} 
							});
							
						}
						
						function registerguardian() {
							$scope.dataLoading = true;
							AdminServiceAPI.createNewGuardian($scope.guardian).then(function(response) {
								if (response.success) {
									console.log("Guardian Inserted success");
									
								} 
							});
							
						}
						
						
						function registerstaff() {
							$scope.staffuser.campusId=$scope.campusId;
							$scope.dataLoading = true;
							AdminServiceAPI.createNewStaff($scope.staffuser).then(function(response) {
								UIMessage.success(response.message);

								if (response.success) {
									console.log("Guardian Inserted success");
									
								} 
								UIMessage.error(response.message);
							});
							
						}
						
						function createNewVehicle() {
							$scope.dataLoading = true;
							AdminServiceAPI.createNewVehicle($scope.vehiclecreatedata).then(function(response) {
								if (response.success) {
									console.log("Vehicle Details Inserted success");
									
								} 
							});
							
						}
						
						function createNewBook() {
							$scope.dataLoading = true;
							AdminServiceAPI.createNewBook($scope.createNewBook).then(function(response) {
								if (response.success) {
									console.log("New Book Details Inserted success");
									
								} 
							});
							
						}
						
						function registerdriver() {
							$scope.dataLoading = true;
							AdminServiceAPI.registerdriver($scope.driveruser).then(function(response) {
								if (response.success) {
									console.log("Driver Details Inserted success");
									
								} 
							});
							
						}
						
					
						function createMedical() {
							
							console.log("New Medical called success");
							$scope.dataLoading = true;
							
							AdminServiceAPI.addnewMedical($scope.addnewMedical).then(function(response) {
								if (response.success) {
									console.log("New Medical Inserted success");
									
								} 
							});
							
						}
						
						
						
						
						
					
						
					} ]);

})();
