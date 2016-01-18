    'use strict';

    angular
        .module('theApp')
        .factory('StaffService', ['$http', '$rootScope',  'StaffApiService',
                                           function($http,  $rootScope, StaffApiService){
        	var service = {};
            service.addStaff = addStaff;
            service.getstaff=getstaff;
            service.getstudentList=getstudentList;
            service.getstaffDetails = getstaffDetails;
            return service;
            
            function addStaff(staffUser,callback)
            {
            	console.log('inside verify login');
            	console.log('Username --- '+staffUser.firstName);
            	StaffApiService.AddStaff(staffUser)
            		.then(function(response){
            		console.log('Response is obtained ---- ');
            			callback(response);
            		});
            }
            
            function getstaffDetails(staffId){
                console.log('Inside Staff Services staffId  '+staffId);
                StaffApiService.getStaffDetails(staffId).then(function(response){
                      console.log('Staff Details Response is obtained form Api in service ---- ');  
                      console.log('response --- '+response.data);
                    //  callback(response);
                });
            }

            function getstaff(callback)
            {
            	//console.log('inside verify login');
            	console.log('students');
            	StaffApiService.getstafflist()
            		.then(function(response){
            			//var response = response.data;
            		//	var result;
            			console.log('Response is obtained form Api in service ---- ');
            			
            			callback(response);
            		});
            }
            
            function getstudentList(classId)
            {
            	console.log('inside getstudentList classId '+classId);
            	console.log('Student List');
            	var students= [
									{
									"userId":"rirani",
									"firstName":"Romin",
									"lastName":"Irani",
									"preferredFullName":"Romin Irani",
									"phoneNumber":"408-1234567",
									"emailAddress":"romin.k.irani@gmail.com"
									},
									{
									"userId":"nirani",
									"firstName":"Neil",
									"lastName":"Irani",
									"preferredFullName":"Neil Irani",
									"phoneNumber":"408-1111111",
									"emailAddress":"neilrirani@gmail.com"
									},
									{
									"userId":"thanks",
									"firstName":"Tom",
									"lastName":"Hanks",
									"preferredFullName":"Tom Hanks",
									"phoneNumber":"408-2222222",
									"emailAddress":"tomhanks@gmail.com"
									}
								]
            	return students;
            	
            }
        }]);
    
    
