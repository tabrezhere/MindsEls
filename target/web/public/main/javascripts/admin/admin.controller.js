//StaffController
(function() {
	'use strict';

	angular
			.module('theApp')
			.controller(
					'AdminController',
					[
							'$location',
							'$rootScope',
							'$scope',
							'$http',
							 
							'AdminService','AdminPostService',
							function($location, $rootScope, $scope, $http,
									AdminService,AdminPostService) {
							
								$scope.guardiansignup = guardiansignup;
								
								var adminstaff = [
									              { 
									              username: 'Tabrez',  password: 2, firstName:'Shrikanth', middleName:'reddy',					              { studentName: 'Ahmed Shareef', studentId: 7 },
									              lastName: 'Mukthanjali',  address1: '' ,address1:'',city:'',state:''
									              }
									            ];
								
								$scope.studentsignupdata = {
						  				identifier: 'tab',
						  				password: 'tab',
						  				firstName: 'Amar',
						  				middleName: 'Akbar',
						  				lastName: 'Anthony',
						  				DOB:'1999-05-12',
						  				Gender:'Male/Female',
						  				address1: 'Brooklyn',
						  				address2: 'Jollyville Road',
						  				contextId: 4,
						  				campusId: 1,  				
						  				city:'Austin',
						  				state : 'texas',
						  				//phoneNumber : '',
						  				Studentadminno : 'None',
						  				classId : ''
						  				
						  			};
								
								
										
								AdminPostService.getAllOrgs(function(response){
						       	  	$scope.org = response;
						       	  	console.log("admin:"+org);
						       	  	});	
								
								
								$scope.studentsignup = function(studentsignupdata) {
					  				$scope.isProcessing = true;

					  				AdminService.signUpForStudent(studentsignupdata).then(function(res) {
					  					$rootScope.$broadcast(AUTH_EVENTS.loginSuccess);
					  					$scope.setCurrentUser(res.data.user);

					  					
					  				}, function(res) {
					  					$rootScope.$broadcast(AUTH_EVENTS.loginFailed);
					  					$scope.isProcessing = false;
					  					UIMessage.error(res.data.message)
					  				});

					  			};
					  			
					  			
						            
						            
								
								$scope.Uid = 2;
								$scope.studentInfo = "";
								// getStudentUserById
								$scope.getStudentUserById = function() {
									console.log("test");
									AdminService
											.getStudentInfoById($scope.Uid ,
													function(response) {
														$scope.studentInfo = response;
														
														/*$location.path('/showStudentInfo').replace();*/
														 $state.go('getStudentInfo.detail', { studentId: $scope.Uid  });
													});

									return false;
								};

							} ]);
})();
