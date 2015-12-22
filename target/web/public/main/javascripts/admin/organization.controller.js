//StaffController
(function() {
	'use strict';

	angular
			.module('theApp')
			.controller(
					'orgcontroller',
					[
						'$location',
						'$rootScope',
						'$scope',
						'$http',
						'$stateParams','AdminPostService',
						function($location, $rootScope, $scope, $http,$stateParams,AdminPostService) {
									
							
							 
								
							AdminPostService.getAllOrgs(function(response){
					       	  	$scope.org = response;
					       	  	console.log("data:"+response);
					       	  	});	 
							
							
							
							} ]);
})();



























