'use strict';
angular.module('theApp').factory(
		'AdminService',
		[
				'$http',
				'$rootScope',
				'AdminServiceAPI',
				function($http, $rootScope, AdminServiceAPI) 
				{
					var service = {};
					service.signUpForStudent=signUpForStudent;
					service.getStudentInfoById = getStudentInfoById;
					service.getStudentList = getStudentList;
					service.getStaffList=getStaffList;
					service.getTransportList=getTransportList;
					service.GetstudentdetailsbyadminId=GetstudentdetailsbyadminId;
					service.getTransportListByVehicleId=getTransportListByVehicleId;
					service.createNewVehicle=createNewVehicle;
					service.signUpForStudent=signUpForStudent;
					service.getCurrentTransportDetails = getCurrentTransportDetails;
					service.getCurrentClassDetails = getCurrentClassDetails;
					service.GetCampusList=GetCampusList;
					service.getStaffInfoById=getStaffInfoById;
				    service.getAllOrgs = getAllOrgs;
				    service.getAllCampusByOrganizationId=getAllCampusByOrganizationId;
					return service;
					
					// getStaffInfoById
					
					
					function signUpForStudent(studentobj,callback) 
					{
						AdminServiceAPI.signUpForStudent(studentobj).then(
								function(response)
								{
									console.log('signUpForStudent Called succesfully ');
									callback(response1);
								});
						
						
					}
					
					
					
					
					//get all list of organization 
					function getAllOrgs()
					{											
						AdminServiceAPI.getAllOrgs().then(function(response,callback){
							var response3 = response.data;
							callback(response3);
							console.log('Admin service API called';)
						});
					}
					
					function getAllCampusByOrganizationId()
					{
						var = campuslistbyorgid= [
						                          {
						                            "id": 1,
						                            "campus_name": "Faraan High School",
						                            "campusAddress": "Dargah Road Bada Roza Gulbarga",
						                            "campusLocation": "Karnataka",
						                            "organization_id": 1
						                          },
						                          {
						                            "id": 2,
						                            "campus_name": "Syed Akbar Hussaini School",
						                            "campusAddress": "Dargah Road Bada Roza Gulbarga",
						                            "campusLocation": "Karnataka",
						                            "organization_id": 1
						                          },
						                         {
						                            "id": 3,
						                            "campus_name": "Noble School",
						                            "campusAddress": "Bus stand road Gulbarga",
						                            "campusLocation": "Karnataka",
						                            "organization_id": 1
						                          },
						                         {
						                            "id": 4,
						                            "campus_name": "Innovative High School",
						                            "campusAddress": "Islamabad colony Gulbarga",
						                            "campusLocation": "Karnataka",
						                            "organization_id": 1
						                          },
						                          {
						                            "id": 1,
						                            "campus_name": "Shahabaz School",
						                            "campusAddress": "Dargah Road Bada Roza Gulbarga",
						                            "campusLocation": "Karnataka",
						                            "organization_id": 2
						                          },
						                          {
						                            "id": 2,
						                            "campus_name": "Kids Zee School",
						                            "campusAddress": "Dargah Road Bada Roza Gulbarga",
						                            "campusLocation": "Karnataka",
						                            "organization_id": 2
						                          },
						                         {
						                            "id": 3,
						                            "campus_name": "Golden Birds",
						                            "campusAddress": "Bus stand road Gulbarga",
						                            "campusLocation": "Karnataka",
						                            "organization_id": 2
						                          },
						                         {
						                            "id": 4,
						                            "campus_name": "Indain Islamic ",
						                            "campusAddress": "Islamabad colony Gulbarga",
						                            "campusLocation": "Karnataka",
						                            "organization_id": 2
						                          }
						                         ];
						return campuslistbyorgid;
						/* AdminServiceAPI.getAllCampusByOrganizationId(OrganizationId,callback).then(function(response){
							var response3 = response.data;
							callback(response3);*/
						
					}
					
					
					
					function getStaffInfoById(staffId,callback)
					{
						AdminServiceAPI.getStaffInfoById(staffId).then(
								function(response)
								{
									
									console.log('q email ---- '+response.data.email);
									console.log('q firstName ---- '+response.data.firstName);
									
									console.log('q address1 ---- '+response.data.address1);
									var response1 = response.data;
									console.log('Response =  '+response1.lastName);
									console.log('Response =  '+response1.email);
									//return JSON.stringify(response1);
								//return	JSON.parse(response1);
									callback(response1);
								});
						
					}
					function getStudentInfoById(studentId,callback)
					{
						AdminServiceAPI.GetStudentInfoById(studentId).then(
								function(response)
								{
									console.log(' 1 id---- '+response.data.id);
									console.log('q email ---- '+response.data.email);
									console.log('q firstName ---- '+response.data.firstName);
									console.log('q lastName ---- '+response.data.lastName);
									console.log('q address1 ---- '+response.data.address1);
									var response1 = response.data;
									console.log('Response =  '+response1.lastName);
									console.log('Response =  '+response1.email);
									//return JSON.stringify(response1);
								//return	JSON.parse(response1);
									callback(response1);
								});
						
					}
					
					function getStudentList(callback){
						var campusId=1;
						AdminServiceAPI.GetStudentList().then(function(response) {
							
							console.log(' id---- '+response.data[0].id);
							console.log('email ---- '+response.data[0].email);
							console.log('firstName ---- '+response.data[0].firstName);
							callback(response.data);
							});
						
							}
					
					function getStaffList(){
						//AdminServiceAPI.GetStaffList().then(function(response){
							//var response2 = response.data;
							//callback(response.data);
						//});*/
						
						var Staffs = [
						              { StaffName: 'tabrez',  StaffId: 2,email:'tabrezhere@gmail.com',address1:'Keonics IT Park Gulbarga',phoneNumber:'9738482325'},
						              { StaffName: 'Shrikanth', StaffId: 4,email:'Shrikanth@gmail.com',address1:'Keonics IT Park Gulbarga',phoneNumber:'9738420325' },
						              { StaffName: 'Ahmed Shareef', StaffId: 7,email:'Ahmed@gmail.com',address1:'Keonics IT Park Gulbarga',phoneNumber:'9715282325'},
						              { StaffName: 'Mukthanjali',  StaffId: 6,email:'Mukthanjali@gmail.com',address1:'Keonics IT Park Gulbarga',phoneNumber:'9428482325' }
						            ];
						return Staffs;
					}
					
					function getTransportList(callback){
						/*AdminServiceAPI.getTransportList(VehicleID).then(function(response){
							var response3 = response.data;
							callback(response3);
						});*/
						console.log('transport list');
						var Transports = [
						                  {
						                      "id": 19,
						                      "Vehicle_no": "KA-32 A1",
						                      "Vehicle_code": "Cab56",
						                      "No_of_Seat": 60,
						                      "Maximum_capacity": 54,
						                      "insurance": "Required",
						                      "tax_remitted": "Required",
						                      "permit": "Required",
						                      "status": "Required",
						                      "Vehicle_type_id": 1,
						                      "Route_Name": "MSK Mill",
						                      "No_of_Stops": 4
						                    /*  "Stop_Name": "Stop 1",
						                      "fare": "200",
						                      "Arival_Mrng": "8:10 AM",
						                      "Departure_Mrng": "8:20 AM",
						                      "Arival_Evng": "5:20 PM",
						                      "Departure_Evng": "5:30 PM"*/
						                  },
						                  {
						                      "id": 20,
						                      "Vehicle_no": "KA-32 A1",
						                      "Vehicle_code": "Cab56",
						                      "No_of_Seat": 60,
						                      "Maximum_capacity": 54,
						                      "insurance": "Required",
						                      "tax_remitted": "Required",
						                      "permit": "Required",
						                      "status": "Required",
						                      "Vehicle_type_id": 1,
						                      "Route_Name": "MSK Mill",
						                     "No_of_Stops": 4
						                     /* "Stop_Name": "Stop 2",
						                      "fare": "150",
						                      "Arival_Mrng": "8:20 AM",
						                      "Departure_Mrng": "8:25 AM",
						                      "Arival_Evng": "5:30 PM",
						                      "Departure_Evng": "5:35 PM"*/
						                  },
						                  {
						                      "id": 21,
						                      "Vehicle_no": "KA-32 A1",
						                      "Vehicle_code": "Cab56",
						                      "No_of_Seat": 60,
						                      "Maximum_capacity": 54,
						                      "insurance": "Required",
						                      "tax_remitted": "Required",
						                      "permit": "Required",
						                      "status": "Required",
						                      "Vehicle_type_id": 1,
						                      "Route_Name": "MSK Mill",
						                      "No_of_Stops": 4
						                      /*"Stop_Name": "Stop 3",
						                      "fare": "100",
						                      "Arival_Mrng": "8:25 AM",
						                      "Departure_Mrng": "8:26 AM",
						                      "Arival_Evng": "5:20 PM",
						                      "Departure_Evng": "5:30 PM"*/
						                  },
						                  {
						                      "id": 22,
						                      "Vehicle_no": "KA-32 A1",
						                      "Vehicle_code": "Cab56",
						                      "No_of_Seat": 60,
						                      "Maximum_capacity": 54,
						                      "insurance": "Required",
						                      "tax_remitted": "Required",
						                      "permit": "Required",
						                      "status": "Required",
						                      "Vehicle_type_id": 1,
						                      "Route_Name": "MSK Mill",
						                      "No_of_Stops": 4
						                      /*"Stop_Name": "Stop 4",
						                      "fare": "50",
						                      "Arival_Mrng": "8:30 AM",
						                      "Departure_Mrng": "8:31 AM",
						                      "Arival_Evng": "5:20 PM",
						                      "Departure_Evng": "5:30 PM"*/
						                  }
						              ];
						return Transports;
					}
					
					function getTransportListByVehicleId(VehicleID,callback){
						
						AdminServiceAPI.getTransportListById(VehicleID).then(function(response){
							var response3 = response.data;
							callback(response3);
						});
										
					}
					
					
					// Create new Vehicle Details
					
					function createNewVehicle(vehiclecreatedata,callback){
						
						AdminServiceAPI.createNewVehicle(vehiclecreatedata).then(function(response){
							var response3 = response.data;
							callback(response3);
						});
										
					}
					
					
					
					
					function getCurrentTransportDetails(vehicleId){
						
						var  BUS={ transportName: 'BUS',  transportId: '1' };
						var Auto = { transportName: 'Auto', transportId: '2' };
						var CAB =  { transportName: 'CAB', transportId: '3' };
						var Van = { transportName: 'Van',  transportId: '4'};
						
						
						switch (vehicleId) { 
											    case "1": 
											        return BUS;
											        break;
											    case "2": 
											    	 return Auto;
											        break;
											    case "3": 
											    	 return CAB;
											        break;      
											    case "4": 
											    	 return Van;
											        break;
											    default:
											        '';
						
										}
					}
					
					
                   function getCurrentClassDetails(ClassId){
	 				
						var  First=  { className: 'First',  ClassId: '1' };
						var Second = { className: 'Second', ClassId: '2' };
						var Third =  { className: 'Third',  ClassId: '3' };
						var Fourth = { className: 'Fourth',  ClassId: '4'};
						
						
						switch (ClassId) { 
										    case "1": 
										        return First;
										        break;
										    case "2": 
										    	 return Second;
										        break;
										    case "3": 
										    	 return Third;
										        break;      
										    case "4": 
										    	 return Fourth;
										        break;
										    default:
										        '';
						
										}
					}
					
					function GetCampusList(callback)
					{
						var campusId=1;
						AdminServiceAPI.GetCampusList().then(function(response1) {
							console.log(' id---- '+response1.data[0].id);
							console.log('email ---- '+response1.data[0].campus_name);
							console.log('firstName ---- '+response1.data[0].organization_id);
							callback(response1.data);
							});
	
											
						/*var Campuses = [
						              { TransportName: 'Saleem',  TransportId: 2 },
						              { TransportName: 'Shrikanth', TransportId: 4 },
						              { TransportName: 'Ahmed Shareef', TransportId: 7 },
						              { TransportName: 'Mukthanjali',  TransportId: 6 }
						            ];
						return Campuses;*/
					}
					
				}]);
