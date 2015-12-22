//StaffController
(function() {
	'use strict';

	angular
			.module('theApp')
			.controller(
					'AdminNewsController',
					[
						'$location',
						'$rootScope',
						'$scope',
						'$http',
						'$stateParams','AdminPostService',
						function($location, $rootScope, $scope, $http,$stateParams,AdminPostService) {
									
							
							 $scope.news=  AdminPostService.getAllOrgs(function(response){
						       	  	        $scope.org = response;
						       	  	       return response;
						       	  	        });				
								 
							
							
							
							} ]);
})();
