//StaffController
(function() {
	'use strict';

	angular.module('theApp').controller('Librarycntrl',
			
			
			[				'$location',
							'$rootScope',
							'$scope',
							'$http','AdminPostService',
							
							function($location, $rootScope, $scope, $http,AdminPostService) 
							{

			
				
				AdminPostService.GetbookListbyCampusID($scope.campusid,function(response){
		       	  	$scope.bookList = response;
		       	  	});	
				
				
  			} ])

})();
