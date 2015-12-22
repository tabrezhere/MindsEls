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
             
             function Getvehicleroutebyvid(vid,callback){
              	
              	AdminServiceAPI.Getvehicleroutebyvid(vid).then(function(response){
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
    