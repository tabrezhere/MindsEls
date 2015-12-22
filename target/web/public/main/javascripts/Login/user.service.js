(function () {
    'use strict';

    angular
        .module('theApp')
        .factory('UserService',['$http',function($http){
        	var service = {};

            service.GetAll = GetAll;
            service.GetById = GetById;
            service.GetByUsername = GetByUsername;
            service.Create = Create;
            service.Update = Update;
            service.Delete = Delete;

            service.VerifyUser = VerifyUser;
            return service;

            function VerifyUser(credentials){
            	//'/auth/signin/credentials', credentials
            	return $http.post('/auth/signin/credentials', credentials).then(handleSuccess, handleError('Error creating user'));
            //	return $http.get('/auth/getUserById').then(handleSuccess, handleError('Error creating user'));
            }
            
            function GetAll() {
                return $http.get('/api/users').then(handleSuccess, handleError('Error getting all users'));
            }

            function GetById(id) {
                return $http.get('/api/users/' + id).then(handleSuccess, handleError('Error getting user by id'));
            }

            function GetByUsername(username) {
                return $http.get('/api/users/' + username).then(handleSuccess, handleError('Error getting user by username'));
            }

            function Create(user) {
            	console.log('user identifier -- '+user.identifier);
            	console.log('user contextId -- '+user.contextId);
            	return $http.post('/auth/signUpForStudent', user).then(handleSuccess, handleError('Error creating user'));
               // return $http.post('/auth/signup', user).then(handleSuccess, handleError('Error creating user'));
            	//'/auth/signUpForStudent'
            }

            function Update(user) {
                return $http.put('/api/users/' + user.id, user).then(handleSuccess, handleError('Error updating user'));
            }

            function Delete(id) {
                return $http.delete('/api/users/' + user.id).then(handleSuccess, handleError('Error deleting user'));
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