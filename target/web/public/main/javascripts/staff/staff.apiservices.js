(function () {
    'use strict';

    angular
        .module('theApp')
        .factory('StaffApiService',['$http',function($http){
        	var service = {};

            service.AddStaff = AddStaff;
            service.getstafflist=getstafflist;
            service.getStaffDetails=getStaffDetails;
            return service;

            function AddStaff(staffDetails){
            	
            	return $http.post('/auth/signUpForStaff', staffDetails).then(handleSuccess, handleError('Error creating user'));
            	
            }

            function getStaffDetails(staffId){
                return  $http.get('/auth/getStaffUserById/'+staffId).then(handleSuccess, handleError('Error creating user'));
            }

            function getstafflist(campusid){
                	return $http.get('/auth/getStaffUserListByCampusId/'+campusid).then(handleSuccess, handleError('Get All Staff Deatils'));
            	
            	
            }
            
            
            // private functions

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