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
									
							 $scope.campusId=$stateParams.campusID;
							 
							 $scope.news;/*[
							              {
							            	    "id": 1,
							            	    "schoolId": 1,
							            	    "headLines": "Vist",
							            	    "newsDesc": "Digital Library",
							            	    "newsDate": "2015-09-10",
							            	    "status": 1
							            	  },
							            	  {
								            	    "id": 1,
								            	    "schoolId": 1,
								            	    "headLines": "Vist",
								            	    "newsDesc": "National Events",
								            	    "newsDate": "2015-09-10",
								            	    "status": 1
								            	  },
								            	  {
									            	    "id": 1,
									            	    "schoolId": 1,
									            	    "headLines": "Vist",
									            	    "newsDesc": "Inaugaration ceremony",
									            	    "newsDate": "2015-09-10",
									            	    "status": 1
									           	  }
							            	] ;
								 */
								  AdminPostService.getschoollnews($scope.campusId,function(response){
						       	  	        $scope.news = response;
						       	  	       return response;
						       	  	        });				
								 
							console.log($scope.news);
   						
							
							} ]);
})();
