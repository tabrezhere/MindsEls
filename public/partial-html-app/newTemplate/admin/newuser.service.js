(function () {
    'use strict';

    angular
        .module('theApp')
        .factory('NewUserService',['$http',function($http){
            var service = {};

            service.VerifyUser = VerifyUser;
            return service;

            function VerifyUser(credentials){
                //'/auth/signin/credentials', credentials
                console.log('Credentials---Indentifier --- ' + credentials.identifier);
                return $http.post('/auth/signin/credentials', credentials).then(handleSuccess, handleError('Error creating user'));
            //  return $http.get('/auth/getUserById').then(handleSuccess, handleError('Error creating user'));
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