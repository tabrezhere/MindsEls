//StaffController
(function() {
	'use strict';

	angular
			.module('theApp')
			.controller(
					'DropdownCtrl',
					[
						'$location',
						'$rootScope',
						'$scope',
						'$http',
						'$stateParams','AdminPostService',
						function($location, $rootScope, $scope, $http,$stateParams,AdminPostService) {
									
							
							  /*  $scope.adminno=""+$stateParams.adminno;*/
							  $scope.adminno="adm1";
							  $scope.vid=1;
							  $scope.classid=1;
							  $scope.campusId=1;
							    console.log("Adminno :"+$stateParams.adminno);
							$scope.items = [ {
					            	 adminno: 'adm2',
					                name: 'Salman',
					                active:'active' 
					            }, {
					                adminno: 'adm1',
					                name: 'Ahmed',
					                active:'' 
					            }, {
					                adminno: 'adm3',
					                name: 'kareem',
					                active:'' 
					            }];				
								
							AdminPostService.getAllOrgs(function(response){
					       	  	$scope.org = response;
					       	  	console.log("data:"+response);
					       	  	});	 
							
							AdminPostService.GetstudentdetailsbyadminId($scope.adminno,function(response){
					       	  	$scope.studentprofile = response;
					       	  	});	
							
							AdminPostService.GetguardiandetailsbyadminId($scope.adminno,function(response){
					       	  	$scope.familyprofile = response;
					       	  	});		
							
							AdminPostService.Getvehiclebyadminno($scope.adminno,function(response){
					       	  	$scope.vehicledetails = response;
					       	  	});		
							
							AdminPostService.Getvehicleroutebyvid($scope.vid,function(response){
					       	  	$scope.routedetails = response;
					       	  	});	
							
							AdminPostService.Getassigmentdetailsbyclassid($scope.classid,function(response){
								$scope.assigmentdetails = response;
								console.log($scope.assigmentdetails);
								
					       	  	});	
							
							AdminPostService.GetmedicaldetailsbyadminId($scope.adminno,function(response){
					       	  	$scope.medicaldetails = response;
					       	  	});	
							
							AdminPostService.GetholidaylistbyCampusId($scope.campusId,function(response){
					       	  	$scope.holidaydetails = response;
					       	  	});	
							
							AdminPostService.GetnewslistbyCampusId($scope.campusId,function(response){
					       	  	$scope.newsdetails = response;
					       	  	});	
							
							AdminPostService.GetclassTimetablebyClassId($scope.classid,function(response){
					       	  	$scope.classtimetable = response;
				       	  	});	
							
							} ]);
})();



























