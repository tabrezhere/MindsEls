    'use strict';
    
//LoginController.$inject = ['$location', 'AuthenticationService', ,'$rootScope','$scope'];
    
    angular
    .module('theApp')
    .controller('LoginController',['$location','AuthenticationService','$rootScope','$scope',
                                   function($location, AuthenticationService,$rootScope,$scope) {
		    	//var vm = this;
		        //$scope.UserDetails = UserDetails; 
		        $scope.login = login;
		        $scope.username = "";
		        $scope.password = "";
		        $scope.dataLoading = false;
		        
		        function login() {
    	        	console.log("inside login --- vm.username "+$scope.username+"  vm.password ---- "+$scope.password);
    	        	$scope.dataLoading = true;
    	            var credentials = {
    	            		identifier : $scope.username,
    	            		password : $scope.password
    	            }
    	            AuthenticationService.verifyLogin(credentials,function(response){
    	            	console.log('usertype = '+response.type);
    	            	console.log('username = '+response.username);
    	            	
    	            	if(response.type === 'admin')
    	            		{
    	            			console.log('now going to admin page');
    	            			location.href="#/admindashboard"
    	            		}
    	            	else if(response.type === 'staff')
    	            		{
    	            			location.href="#/Staff/staffdashboard"
    	            		}
    	            		else{
    	            			
    	            			location.href="#/Guardiandashboard"
    	            		}
    	            });
    	        }
    }]);
    			
    	       