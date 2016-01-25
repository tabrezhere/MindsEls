 'use strict';

    angular
        .module('theApp')
        .factory('AdminPostService', ['$http', '$rootScope',  'AdminServiceAPI',
                                           function($http,  $rootScope, AdminServiceAPI){
        	var service = {};
        	
        	
            service.getAllOrgs=getAllOrgs;
            service.getschoollnews=getschoollnews;
            service.getAllsubjects=getAllsubjects;
            service.getAllCampusByOrganizationId=getAllCampusByOrganizationId;
            service.getTransportList=getTransportList;
            service.GetStudentListByCampusId=GetStudentListByCampusId;
            service.GetStaffListbyCampusId=GetStaffListbyCampusId;
            service.GetbookListbyCampusID=GetbookListbyCampusID;
            service.GetstudentdetailsbyadminId=GetstudentdetailsbyadminId;
            service.GetguardiandetailsbyadminId=GetguardiandetailsbyadminId;
            service.Getvehiclebyadminno=Getvehiclebyadminno;
            service.Getvehicleroutebyvid=Getvehicleroutebyvid;
            service.Getassigmentdetailsbyclassid=Getassigmentdetailsbyclassid;
            service.GetmedicaldetailsbyadminId=GetmedicaldetailsbyadminId;
            service.GetholidaylistbyCampusId=GetholidaylistbyCampusId;
            service.GetnewslistbyCampusId=GetnewslistbyCampusId;
            service.GetclassTimetablebyClassId=GetclassTimetablebyClassId;
            service.getAllClassesByCampusId=getAllClassesByCampusId;
            service.getStaffByStaffId=getStaffByStaffId;
            service.getStudentByStudentId=getStudentByStudentId;
            service.getGuardianByGuardianId=getGuardianByGuardianId;
           service.getAllGuardianListByCampusId=getAllGuardianListByCampusId;
            
            return service;
            
           
            function getAllOrgs(callback){
				AdminServiceAPI.getAllOrgs().then(function(response){
				var response1 = response.data;
				console.log("data in post:"+response1);
				callback(response1);
					
				});
				
			   }
            
            function getschoollnews(campusId,callback){
				AdminServiceAPI.getschoollnews(campusId).then(function(response){
				var response1 = response.data;
				console.log("School News:"+response1);
				callback(response1);
					
				});
				
			   }
            
            
            
            function getAllsubjects(callback){
				AdminServiceAPI.getAllsubjects().then(function(response){
					var response1 = response.data;
					callback(response1);
				
				});
				
			   }


         function getStaffByStaffId(staffId,callback){
              AdminServiceAPI.getStaffUserById(staffId).then(function(response){
                
                 console.log("Staff Details yet to be displayed");
                  var response1 = response.data;
                  console.log("Staff Details :"+response1);
                  callback(response1);
                    
                  });
            }

            function getGuardianByGuardianId(guardianId,callback){
              AdminServiceAPI.getGuardianUserById(guardianId).then(function(response){
                
                 console.log("guardian Details yet to be displayed");
                  var response1 = response.data;
                  console.log("guardian Details :"+response1);
                  callback(response1);
                    
                  });
            }


            function getStudentByStudentId(studentId,callback){
              AdminServiceAPI.GetStudentInfoById(studentId).then(function(response){
                
                 console.log("Student Details yet to be displayed");
                  var response1 = response.data;
                  console.log("Student Details :"+response1);
                  callback(response1);
                    
                  });
            }
            
            
            
            function getAllCampusByOrganizationId(OrganizationId,callback){
				AdminServiceAPI.getAllCampusByOrganizationId(OrganizationId).then(function(response){
				var response1 = response.data;
				
				callback(response1);
					
				});
				
			   }
           
            function getAllClassesByCampusId(campusid,callback){
				AdminServiceAPI.getAllClassesByCampusId(campusid).then(function(response){
				var response1 = response.data;
				callback(response1);
					
				});
				
			   }
           
            
            
            function getTransportList(campusid,callback){
				AdminServiceAPI.GetVehicleListbyCampusId(campusid).then(function(response){
				var response1 = response.data;			
				callback(response1);
					
				});
				
			   }
            
            
            
            function GetStudentListByCampusId(campusid,callback)
            {
            	AdminServiceAPI.GetStudentListByCampusId(campusid).then(function(response){
				var response1 = response.data;
				callback(response1);
					
				});        		
            }

            function getAllGuardianListByCampusId(campusid,callback)
            {
              AdminServiceAPI.getAllGuardianListByCampusId(campusid).then(function(response){
        var response1 = response.data;
        callback(response1);
          
        });
              
              
            }


            
            function GetStaffListbyCampusId(campusid,callback)
            {
            	AdminServiceAPI.GetStaffListbyCampusId(campusid).then(function(response){
    				var response1 = response.data;
    				callback(response1);
    					
    				});
            	
            }
            
            function GetbookListbyCampusID(campusid,callback){
            	
            	AdminServiceAPI.GetbookListbyCampusID(campusid).then(function(response){
    				var response1 = response.data;
    				callback(response1);
    					
    				});
            }
            
            function GetstudentdetailsbyadminId(adminno,callback){
            	
            	AdminServiceAPI.GetstudentdetailsbyadminId(adminno).then(function(response){
    				var response1 = response.data;
    				callback(response1);
    					
    				});
            }
            
             function GetguardiandetailsbyadminId(adminno,callback){
            	
            	AdminServiceAPI.GetguardiandetailsbyadminId(adminno).then(function(response){
    				var response1 = response.data;
    				callback(response1);
    					
    				});
            }
            
             function Getvehiclebyadminno(adminno,callback){
             	
             	AdminServiceAPI.Getvehiclebyadminno(adminno).then(function(response){
     				var response1 = response.data;
     				callback(response1);
     					
     				});
             }
             
             function Getvehicleroutebyvid(vehicleId,callback){
              	
              	AdminServiceAPI.Getvehicleroutebyvid(vehicleId).then(function(response){
      				var response1 = response.data;
      				callback(response1);
      					
      				});
              }
             
             function Getassigmentdetailsbyclassid(classid,callback){
               	
               	AdminServiceAPI.Getassigmentdetailsbyclassid(classid).then(function(response){
       				var response1 = response.data;
       				callback(response1);
       					
       				});
               }
             
             function GetmedicaldetailsbyadminId(adminno,callback){
                	
                	AdminServiceAPI.GetmedicaldetailsbyadminId(adminno).then(function(response){
        				var response1 = response.data;
        				callback(response1);
        					
        				});
                }
             
             function GetholidaylistbyCampusId(campusid,callback){
             	
             	AdminServiceAPI.GetholidaylistbyCampusId(campusid).then(function(response){
     				var response1 = response.data;
     				callback(response1);
     					
     				});
             }
             
             function GetnewslistbyCampusId(campusid,callback){
              	
              	AdminServiceAPI.GetnewslistbyCampusId(campusid).then(function(response){
      				var response1 = response.data;
      				callback(response1);
      					
      				});
              }
          
             function GetclassTimetablebyClassId(classid,callback){
               	
               	AdminServiceAPI.GetclassTimetablebyClassId(classid).then(function(response){
       				var response1 = response.data;
       				callback(response1);
       					
       				});
               }
             
             
             
            
        }]);
    