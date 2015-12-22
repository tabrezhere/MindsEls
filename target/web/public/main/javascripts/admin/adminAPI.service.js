(function () {
    'use strict';

    angular
        .module('theApp')
        .factory('AdminServiceAPI',['$http',function($http){
        	var service = {};
           
        	//post service
        	service.createNewStudent=createNewStudent;
            service.createNewGuardian=createNewGuardian;
            service.createNewStaff = createNewStaff;
        	service.addnewMedical=addnewMedical;
        	service.createNewVehicle=createNewVehicle;
        	 service.createNewBook=createNewBook;
        	service.registerdriver=registerdriver;
        	
        	 //Get Service 
        	
        		
            
            service.Getvehiclebyadminno=Getvehiclebyadminno;
            service.Getvehicleroutebyvid=Getvehicleroutebyvid;
           
            	
           
            service.GetstudentdetailsbyadminId=GetstudentdetailsbyadminId;
            service.GetguardiandetailsbyadminId=GetguardiandetailsbyadminId;
            service.GetmedicaldetailsbyadminId=GetmedicaldetailsbyadminId;
            service.GetholidaylistbyCampusId=GetholidaylistbyCampusId;
            service.GetnewslistbyCampusId=GetnewslistbyCampusId;
            
           
            service.GetclassTimetablebyClassId=GetclassTimetablebyClassId;	
            service.GetStudentInfoById = GetStudentInfoById;
            service.GetStudentListByCampusId = GetStudentListByCampusId;
            service.GetStaffListbyCampusId = GetStaffListbyCampusId;
            
           
            service.GetCampusList = GetCampusList;
            service.GetVehicleListbyCampusId =GetVehicleListbyCampusId;
            service.getTransportListById=getTransportListById;
            service.getAllClassesByCampusId=getAllClassesByCampusId; 
            service.getschoollnews=getschoollnews;
            service.getAllOrgs = getAllOrgs;
            service.getAllCampusByOrganizationId=getAllCampusByOrganizationId;
            service.GetbookListbyCampusID=GetbookListbyCampusID;
            service.getAllsubjects=getAllsubjects;
            service.Getassigmentdetailsbyclassid=Getassigmentdetailsbyclassid;
            return service;
            
          
            
            //Post Service 
            
            function createNewStudent(user) 
            {           	
           	return $http.post('/auth/signUpForStudent', user).then(handleSuccess, handleError('Error Creating New Student Details'));
            } 
            
            function createNewGuardian(guardian)
            {
            	return $http.post('/auth/signUpForGuardian', guardian).then(handleSuccess, handleError('Error Creating New  Guardian details'));
            }
            
            function createNewStaff(staff)
            {
            	return $http.post('/auth/signUpForStaff',staff).then(handleSuccess, handleError('Error Creating New Staff Details'));
            }
            
            function addnewMedical(user) 
            {           	
           	return $http.post('/auth/medicalCreate', user).then(handleSuccess, handleError('Error Creating New Student Medical Details'));
            } 
            
            function createNewVehicle(vehiclecreatedata){
            	return $http.post('/auth/createVehicleDetail',vehiclecreatedata).then(handleSuccess, handleError('Error Creating New Vehicle'));
            }
            
            function createNewBook(book){
            	return $http.post('/auth/createbook',book).then(handleSuccess, handleError('Error adding new book details'));
            }
            
           
            function registerdriver(driver){
            	return $http.post('/auth/signUpForDriver',driver).then(handleSuccess, handleError('Error adding new driver details'));
            }
            
            
            
            
            // Assignment 
            
            function Getassigmentdetailsbyclassid(classid)
            {
            	return $http.get('/auth/getAssignmentByClassId/'+classid).then(handleSuccess, handleError('Error getting Assigment'));
            }
            
            // student details
           
            
           
            function GetstudentdetailsbyadminId(adminno) {
                return $http.get('/auth/getStudentDetailByStdAdmNum/'+adminno).then(handleSuccess, handleError('Error getting studentInfo'));
            }
            
            function GetStudentInfoById(studentId) {
                return $http.get('/auth/getStudentUserById/'+studentId).then(handleSuccess, handleError('Error getting studentInfo'));
            }
          
            function GetStudentListByCampusId(campusid){
            	return $http.get('/auth/getStudentUserListByCampusId/'+campusid).then(handleSuccess, handleError('Error getting studentInfo'));
            }
            
            function GetclassTimetablebyClassId(classid)
            {
            	return $http.get('/auth/getClassTimeTableByClassId/'+classid).then(handleSuccess, handleError('Error getting class time table'));
            }
            
           
            //vehicle details
            
           
            
            function Getvehiclebyadminno(adminno) {
                return $http.get('/auth/getStudentVehicleDetailsByStudentAdmNum/'+adminno).then(handleSuccess, handleError('Error getting Vehicle Details'));
            }
            
            function Getvehicleroutebyvid(vid) {
                return $http.get('/auth/getVehicleRouteAndStopDetailsByVhId/'+vid).then(handleSuccess, handleError('Error getting Vehicle Route Details'));
            }
            
            
          //  library details
            

          
            
            function GetbookListbyCampusID(campusid)
            {
            	return $http.get('/auth/getBookListByCampusId/'+campusid).then(handleSuccess, handleError('Error getting All Vehicle List'));
            }
            
          
            
            function GetguardiandetailsbyadminId(adminno) {
                return $http.get('/auth/getGuardianUserByStudentAdmissionNumber/'+adminno).then(handleSuccess, handleError('Error getting guardian details'));
            }
            
            function GetmedicaldetailsbyadminId(adminno) {
                return $http.get('/auth/getStudentMedicalDetailsByStudentAdmNum/'+adminno).then(handleSuccess, handleError('Error getting Medical details'));
            }
            
            function GetholidaylistbyCampusId(campusid) {
                return $http.get('/auth/getHolidaysByCampusID/'+campusid).then(handleSuccess, handleError('Error getting Holiday List details'));
            }
            
            function GetnewslistbyCampusId(campusid) {
                return $http.get('/auth/getSchoolNewsListByCampusId/'+campusid).then(handleSuccess, handleError('Error getting News Information List details'));
            }
            
           
            function GetStaffListbyCampusId(campusid){
            	return $http.get('/auth/getStaffUserListByCampusId/'+campusid).then(handleSuccess, handleError('Error getting GetStaffList'));
            }
            
            function GetVehicleListbyCampusId(campusid)
            {
               return $http.get('/auth/getVehicleListByCampusId/'+campusid).then(handleSuccess, handleError('Error getting All Vehicle List'));
            	
            }
            
            function getTransportListById(VehicleID){
            	return $http.get('/auth/getVehicleRouteAndStopDetailsByVhId/'+VehicleID).then(handleSuccess, handleError('Error getting getTransportList'));
            }
            
         //Get Organization list function 
            
            function GetCampusList(){
            	return $http.get('/auth/allCampus').then(handleSuccess, handleError('Error getting GetCampusList'));
            }
          
            function getAllOrgs(){
            	return $http.get('/auth/getAllOganization').then(handleSuccess, handleError('Error getting Oganization List'));
            }
            function getAllCampusByOrganizationId(OrganizationId){
            	return $http.get('/auth/getAllCampusByOrganizationId/'+OrganizationId).then(handleSuccess, handleError('Error getting Oganizations Campus List'));
            }
            
            function getAllsubjects(){
            	return $http.get('/auth/getAllSubjectList').then(handleSuccess, handleError('Error getting all Subject List'));
            }
            
            
            function getschoollnews(CampusId){
            return $http.get('/auth/getSchoolNewsListByCampusId/'+CampusId).then(handleSuccess, handleError('Error getting school News'));
            
            }
            
            function getAllClassesByCampusId(CampusId){
                return $http.get('/auth/getAllClassesByCampusId/'+CampusId).then(handleSuccess, handleError('Error class Details'));
                
                }
            
            function handleSuccess(data) {
                return data;
            }
            function handleError(error) {
                return function () {
                    return { success: false, message: error };
                };
            }

        }]);

    
})();