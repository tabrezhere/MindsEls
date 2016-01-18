'use strict';

//LoginController.$inject = ['$location', 'AuthenticationService', ,'$rootScope','$scope'];

angular.module('theApp').controller(
		'NewLoginController',
		[
				'$location',
				'NewAuthService',
				'$rootScope',
				'$scope',
				function($location, NewAuthService, $rootScope, $scope) {
					//var vm = this;
					//$scope.UserDetails = UserDetails; 
					$scope.login = login;
					$scope.identifier = "tabrez";
					$scope.adminstaff = [ {
						orgName : "HKES",
						orgType : "Autonomous",
						orgId : 2,
						staffdetails : [ {
							firstName : 'Rekha',
							middleName : 'Patil',
							lastName : 'kumari'
						} ],
						staffclassassociation : [ {
							classname : 'Second',
							classId : 12
						}, {
							classname : 'third',
							classId : 2
						}, {
							classname : 'seventh',
							classId : 3
						}, {
							classname : 'inter-A',
							classId : 1
						}

						],
						staffadditionaldetails : [ {
							experience : 10,
							hobby : 'Movies'
						} ]

					} ];
					/* function classlist($scope.ID)
					 {
					  var students = [{
					        "id": 1,
					        "name": "saleem",
					        "address": ."GUL",
					        "classname":'Second',
					        "classId":12
					       
					    }, {
					    	"id": 2,
					        "name": "sameer",
					        "address": ."GUL",
					        "classname":'Second',
					        "classId":12
					    }, {
					    	"id": 3,
					        "name": "guru",
					        "address": ."GUL",
					        "classname":'third',
					        "classId":13
					    }, {
					    	"id": 4,
					        "name": "suresh",
					        "address": ."GUL",
					        "classname":'fourth',
					        "classId":14
					    }];
					   return students;
					 }*/

					$scope.password = "hi";
					$scope.dataLoading = false;

					var staffdt;

					function login() {
						console.log("inside login --- vm.username "
								+ $scope.identifier + "  vm.password ---- "
								+ $scope.password);
						$scope.dataLoading = true;
						var credentials = {
								identifier : $scope.identifier,
							password : $scope.password
						}

						NewAuthService.verifyLogin(credentials, function(
								response) {
							console.log('user context id = ' + response.data.context);
							console.log('username = ' + response.data.staffuser.email);
							
						//	$scope.adminstaff = NewAuthService.getadminstaff();
						//	staffdt = NewAuthService.getadminstaff();
					//		console.log('Organization name')
					//		console.log($scope.adminstaff);
				//			console.log(staffdt);
			//				console.log(response.data);

							if (response.data.context === 3) {
								console.log('now going to staff page');
								location.href = "#/new_admindashboard";
							} else if (response.data.context  === 5) {
								console.log('now going to staff page');
								location.href = "#/staffUserDashboard/"+response.data.staffuser.user_id;
							} else if (response.data.context  === 6) {
								location.href = "#/Guardiandashboard";
							}
						});
					}

					//$scope.getdata = staffdt;
				} ])
				
				
.controller('OrgController',[ '$scope', 'NewAuthService', function($scope, NewAuthService)
{
				$scope.sortType = 'orgName'; // set the default sort type
				$scope.sortReverse = false; // set the default sort order
				$scope.searchOrg = '';
				$scope.comp = {
					orgName : 'test',
					orgType : 'test',
					orgId : 'test'
				};
				$scope.orgtable = true;
				$scope.addOrgForm = false;
				$scope.org = '';
			
				AdminPostService.getAllOrgs(function(response){
		       	  	$scope.org = response;
		       	  	console.log("data:"+response);
		       	  	});	 
				
				
	
				$scope.showAddOrgForm = function() {
					$scope.comp = {
						orgName : '',
						orgType : '',
						orgId : ''
					};
					$scope.orgtable = false;
					$scope.addOrgForm = true;
	
				};
	
				$scope.addorg = function() {
					$scope.org.push($scope.comp);
					console.log('fuction addorg called');
					$scope.orgtable = true;
					$scope.addOrgForm = false;
	
				};
	
				

		} ])
		
		//CampusController
.controller(
		'CampusController',
		[
				'$scope',
				'$routeParams',
				'NewAuthService',
				function($scope, $routeParams, NewAuthService) {
					$scope.sortType = 'campusName'; // set the default sort type
					$scope.sortReverse = false; // set the default sort order
					$scope.searchCampus = '';
					$scope.camp = {
						campusName : 'test',
						campusType : 'test',
						orgId : 'test',
						campusId : 'test'
					};// set the default search/filter term
					$scope.cmptable = true;
					$scope.addCmpForm = false;
					
					
					
					$scope.campuslist ='';
					NewAuthService.getAllCampuses($routeParams.orgId,function(response1){
						$scope.campuslist =  response1;
							
						});
					
					
				//	$scope.campus = NewAuthService.getAllCampuses($routeParams.orgId);
					$scope.showAddCmpForm = function() {
						$scope.comp = {
							orgName : '',
							orgType : '',
							orgId : ''
						};
						$scope.orgtable = false;
						$scope.addOrgForm = true;

					};

				} ])
				
				.controller('AdminCampusActionsController',[
				'$scope',
				'$routeParams',
				'NewAuthService',
				function($scope, $routeParams, NewAuthService) {
					$scope.campusId =$routeParams.campusId;
					console.log('Campus id'+campusId);

				} ]);
