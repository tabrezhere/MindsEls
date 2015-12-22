'use strict';

/* App Module */

var theApp = angular.module('theApp', [ 'ngRoute', 'appControllers',
		'appDirectives', 'appServices', 'appConstants', 'ui.router','angularUtils.directives.dirPagination' ]);

/*
 * theApp.config([
 * '$routeProvider','$stateProvider','$stickyStateProvider','$urlRouterProvider',
 * function($routeProvider,$stateProvider,$stickyStateProvider,$urlRouterProvider) {
 */
theApp
		.config([
				'$routeProvider',
				'$stateProvider',
				function($routeProvider, $stateProvider) {

					$routeProvider

							.when(
									'/admindashboard',
									{
										templateUrl : '/assets/partial-html-app/newTemplate/admin/adminAccount.html'
									})
         
                            .when(
				                	'/getreddash',
								{
									templateUrl : '/assets/partial-html-app/angulartemplate/home.html'
								})

							.when(
									'/new_login',
									{
										templateUrl : '/assets/partial-html-app/newTemplate/admin/newlogin.html',
										controller : 'NewLoginController'
									})
							.when(
									'/new_orgList',
									{
										templateUrl : '/assets/partial-html-app/newTemplate/admin/organizations.html',
										controller : 'orgcontroller'
									})
							.when(
									'/new_showCampusList/:orgId',
									{
										templateUrl : '/assets/partial-html-app/newTemplate/admin/campuses.html',
										controller : 'CampusController'
									})
							.when(
									'/admindashboard/:campusid',
									{
										templateUrl : '/assets/partial-html-app/admin/admindashboard.html',
										controller : 'AdminCampusController'
									})

							.when(
									'/index',
									{
										templateUrl : '/assets/partial-html-app/index.html'
									// controller: 'IndexCtrl'

									})
							
							.when(
									'/staffdashboard/:staffid',
									{
										templateUrl : '/assets/partial-html-app/admin/staff/staffdashboard.html'
									// controller: 'SignupCtrl'
									})
											
							.when(
									'/staffdashboard',
									{
										templateUrl : '/assets/partial-html-app/staff/staffdashboard.html'
									// controller: 'SignupCtrl'
									})
													
					 
							.when(
									'/Guardiandashboard',
									{
										templateUrl : '/assets/partial-html-app/admin/guardian/guardiandashboard.html'
									// controller: 'SignupCtrl'
									})
							.when(
									'/studentByClass/:classId',
									{
										templateUrl : "/assets/partial-html-app/Staff/staffclasslist.html",
										controller : 'StaffController'
									// controller: 'SignupCtrl'
									})
							.when(
									'/NewStudent123',
									{
										templateUrl : '/assets/partial-html-app/admin/student/addstudenttest.html',
										controller : 'AdminController',
										controllerAs : 'vm'

									})

							.otherwise({
								redirectTo : '/index'
							});

					$stateProvider
					
								.state(
										'home',
										{
											templateUrl : '/assets/partial-html-app/admin/guardian/home.html',
											controller : 'DropdownCtrl'
										})
										
								.state(
										'assigmentdetails',
										{
											templateUrl : '/assets/partial-html-app/admin/guardian/assignmentdetails.html',
											controller : 'DropdownCtrl'
										})
										
										
					// School Info Start
										
						/*.state('schoolnews',
										{
							               url:'campus/:campusID',
							               views: {'campus@',{
											templateUrl : '/assets/partial-html-app/admin/Campus/SchoolNews.html',
											controller : 'AdminNewsController'
							               }
							               }
										})*/
										
										
					   .state('schoolnews', {
                                       
                                        templateUrl: '/assets/partial-html-app/admin/Campus/SchoolNews.html',
                                        params : { campusID: null, },
                                        controller: 'AdminNewsController',
                             })					
					// School Inof End	
										
										
						//staff Details
										
										.state(
												'staffclass',
												{
													templateUrl : '/assets/partial-html-app/admin/staff/staffclass.html',
													controller : 'AdminStaffController'
												})
												
										.state(
												'getclassstudent',
												{
													templateUrl : '/assets/partial-html-app/admin/staff/staffclassstudentdetails.html',
									
													controller : 'AdminStaffController'
												})
												
										.state(
												'staffmedical',
												{
													templateUrl : '/assets/partial-html-app/admin/staff/staffmedical.html',
									
													controller : 'AdminStaffController'
												})
												
										.state(
												'staffvehicle',
												{
													templateUrl : '/assets/partial-html-app/admin/staff/staffvehicle.html',
									
													controller : 'AdminStaffController'
												})
																					
												
							// staff End					
					
								.state(
										'studentProfile',
										{
											templateUrl : '/assets/partial-html-app/admin/guardian/studentProfile.html',
											controller : 'DropdownCtrl'
										})
						    	.state(
										'students',
										{
											
											templateUrl : '/assets/partial-html-app/admin/guardian/studentdetails.html',
							     			controller : 'DropdownCtrl'
									
										})
														
					             .state(
										'studentdetails',
										{
											url: '/studentdetails?adminno',
											templateUrl : '/assets/partial-html-app/admin/guardian/studentdetails.html',
											controller : 'DropdownCtrl'
											
										})
										
								 .state(
										'Healthstatus',
										{
											
											templateUrl : '/assets/partial-html-app/admin/guardian/medicaldetails.html',
											controller : 'DropdownCtrl'
											
										})
										
								 .state(
										'docotordetails',
										{
											
											templateUrl : '/assets/partial-html-app/admin/guardian/familydoctor.html',
											controller : 'DropdownCtrl'
											
										})
									.state(
										'national',
										{
											
											templateUrl : '/assets/partial-html-app/admin/guardian/holidaysdetails.html',
											controller : 'DropdownCtrl'
											
										})	
										
								.state(
										'religion',
										{
											
											templateUrl : '/assets/partial-html-app/admin/guardian/holidaysdetails.html',
											controller : 'DropdownCtrl'
											
										})	
										
								.state(
										'ActiveNews',
										{
											
											templateUrl : '/assets/partial-html-app/admin/guardian/newsdetails.html',
											controller : 'DropdownCtrl'
											
										})	
								
								.state(
										'PastNews',
										{
											
											templateUrl : '/assets/partial-html-app/admin/guardian/newsdetails.html',
											controller : 'DropdownCtrl'
											
										})	
								 
									
							     .state(
										'familyprofile',
										{
											templateUrl : '/assets/partial-html-app/admin/guardian/familyProfile.html',
											controller : 'DropdownCtrl'
										})
										
										
								 .state(
										'familydetails',
										{
											templateUrl : '/assets/partial-html-app/admin/guardian/familydetails.html',
											controller : 'DropdownCtrl'
										})
										
								.state(
										'vehiclebyadminid',
										{
											templateUrl : '/assets/partial-html-app/admin/guardian/vehicledetails.html',
											controller : 'DropdownCtrl'
										})
										
								.state(
										'vehicleroutebyvid',
										{
											//url: '/vehicleroutebyadminid?adminno',
											templateUrl : '/assets/partial-html-app/admin/guardian/vehicleroutedetails.html',
											controller : 'DropdownCtrl'
										})
										
								.state(
										'classtimetable',
										{
											
											templateUrl : '/assets/partial-html-app/admin/guardian/classtimetable.html',
											controller : 'DropdownCtrl'
										})
										
								.state(
										'examtimetable',
										{
											
											templateUrl : '/assets/partial-html-app/admin/guardian/examtimetable.html',
											controller : 'DropdownCtrl'
										})
								
							.state(
									'addStaff',
									{
										templateUrl : '/assets/partial-html-app/admin/staff/addstaff.html',
										controller : 'RegisterController'
									})
									
							.state(
									'signupguardian',
									{
										templateUrl : '/assets/partial-html-app/admin/guardian/addParents.html',
										controller : 'RegisterController'
									
									})
							.state(
									'addnewbook',
									{
										templateUrl : '/assets/partial-html-app/admin/library/Addbook.html',
										controller : 'RegisterController'
									
									})
									
									

							.state(
									'viewStudentList',
									{
										templateUrl : '/assets/partial-html-app/admin/student/students.html',
										controller : 'AdminStudController',
										controllerAs : 'vm'
									})
						   .state(
									'viewguardianList',
									{
										templateUrl : '/assets/partial-html-app/admin/guardian/guradianlist.html',
										controller : 'AdminCampusController'
										
									})
									
									

							.state(
									'viewList',
									{
										templateUrl : '/assets/partial-html-app/admin/staff/viewList.html',
										controller : 'AdminStaffController'
									})

							.state(
									'StaffClassList',
									{
										templateUrl : '/assets/partial-html-app/Staff/staffclasslist.html',
										controller : 'StaffController'
									//url: "/StaffClassList/:id"

									/*views :{
										'StaffClass': {templateUrls:'/assets/partial-html-app/Staff/staffclass.html',
											           controller : 'NewLoginController'},
										'StaffClass/10': {
											templateUrl : '/assets/partial-html-app/Staff/staffclasslist.html',
											controller : 'StaffController'							
										                                    }										 
									        }*/
									})

								.state(
									'Staffdetails',
									{
										templateUrl : '/assets/partial-html-app/admin/staff/staffprofile.html',
										controller : 'AdminStaffController'
									})
	
									
							.state(
									'StaffProfile',
									{
										templateUrl : '/assets/partial-html-app/admin/staff/staffprofile.html',
										controller : 'NewLoginController'
									})

							.state(
									'StaffClass',
									{
										templateUrl : '/assets/partial-html-app/Staff/staffclass.html',
										controller : 'NewLoginController'
									})

							.state(
									'StaffExp',
									{
										templateUrl : '/assets/partial-html-app/Staff/StaffExp.html',
										controller : 'NewLoginController'
									})

							.state(
									'studentId',
									{
										templateUrl : '/assets/partial-html-app/admin/student/student.html',
										controller : 'AdminStudController'
									})

							.state(
									'TransportviewList',
									{
										templateUrl : '/assets/partial-html-app/admin/transportation/TransportviewList.html',
										controller : 'AdminTransportController'
									})

							.state(
									'viewCampusList',
									{
										templateUrl : '/assets/partial-html-app/admin/Campus/viewCampusList.html',
										controller : 'AdminCampusController'
									})

							.state(
									'viewStaff',
									{
										templateUrl : '/assets/partial-html-app/admin/staff/viewStaff.html',
										controller : 'StaffController'
									})
							.state(
									'adminHome',
									{
										templateUrl : '/assets/partial-html-app/admin/adminHome.html'
									// controller : 'StaffController'
									})
							.state(
									'addVehicle',
									{
										templateUrl : '/assets/partial-html-app/admin/transportation/addVehicle.html',
									 controller : 'RegisterController'
									})
							.state(
									'adddriver',
									{
										templateUrl : '/assets/partial-html-app/admin/transportation/addnewdriver.html',
									 controller : 'RegisterController'
									})
																	
							.state(
									'NewStudent',
									{
										templateUrl : '/assets/partial-html-app/admin/student/addstudenttest.html',
										controller : 'AdminController',
										controllerAs : 'vm'

									})
							.state(
									'signupstudent',
									{
										templateUrl : '/assets/partial-html-app/admin/student/addstudent.html',
										controller : 'RegisterController'

									})
							.state(
									'addnewMedical',
									{
										templateUrl : '/assets/partial-html-app/admin/student/addstudentmedical.html',
										controller : 'RegisterController'

									})
									
									
							.state(
									'getStudentInfo',
									{
										templateUrl : '/assets/partial-html-app/admin/student/addstudenttest.html',
										controller : 'AdminController',
										controllerAs : 'vm'
									})
							.state(
									'getStudentInfo.detail',
									{
										url : '/{studentId:[0-9]{1,4}}',
										views : {
											templateUrl : '/assets/partial-html-app/admin/student/showStudentInfo.html',
											controller : 'AdminController',
											controllerAs : 'vm'
										}
									})
									
									
							.state(
									'listbooks',
									{
										templateUrl : '/assets/partial-html-app/admin/library/books.html',
										controller : 'Librarycntrl'
										
									})		

							.state("studentByClass", {
								url : "/studentByClass/:classId",
								//    templateUrl: "/assets/partial-html-app/Staff/staffclasslist.html",

								//  ":id"  is a path parameter.

								/* controller: function($scope, $stateParams) {
								 	console.log("Hurray! you have got the classId - "+$stateParams.classId);
								     //$scope.portfolioId = $stateParams.portfolioId;
								  }*/
								controller : 'StaffController'
							})

					;

				} ]);

/*
 * $urlRouterProvider
 *  // The `when` method says if the url is ever the 1st param, then redirect to
 * the 2nd param // Here we are just setting up some convenience urls.
 * .when('/getStudentInfo?id', '/getStudentInfo/:id')
 * .when('/getStudentInfo/:id', '/getStudentInfo/:id')
 *  // If the url is ever invalid, e.g. '/asdf', then redirect to '/' aka the
 * home state .otherwise('/');
 * 
 * 
 * $stateProvider .state('addStaff', { templateUrl:
 * '/assets/partial-html-app/register/register.view.html', controller:
 * 'RegisterController' }) .state('viewStaff', { templateUrl:
 * '/assets/partial-html-app/admin/staff/viewStaff.html', controller :
 * 'StaffController' }) .state('adminHome', { templateUrl:
 * '/assets/partial-html-app/admin/adminHome.html' //controller :
 * 'StaffController' }) .state('addVehicle', { templateUrl:
 * '/assets/partial-html-app/admin/transportation/addVehicle.html' //controller :
 * 'StaffController' }) .state('getStudentInfo', { templateUrl:
 * '/assets/partial-html-app/admin/student/addstudenttest.html', controller:
 * 'AdminController', controllerAs: 'vm' }) .state('getStudentInfo.detail', {
 * url: '/{studentId:[0-9]{1,4}}', views: { templateUrl:
 * '/assets/partial-html-app/admin/student/showStudentInfo.html', controller:
 * 'AdminController', controllerAs: 'vm' } })
 *  ;
 */
/*
 * showStudentInfo .state('addstudent', { templateUrl:
 * '/assets/partial-html-app/admin/student/newadmission.html', controller :
 * 'AdminStudController', controllerAs: 'vm' })
 */

/*
 * $stateProvider.state('tabs', { url: '/', templateUrl: 'tab-viewport.html',
 * });
 * 
 * $stateProvider.state('tabs.account', { url: '/account', sticky: true, dsr:
 * true, views: { 'account': { templateUrl: 'account.html' } }, });
 * 
 * $stateProvider.state('tabs.account.stuff', { url: '/stuff', template: "<h3>Here's
 * my stuff:</h3><ul><li>stuff 1</li><li>stuff 2</li><li>stuff 3</li></ul>"
 * });
 * 
 * $stateProvider.state('tabs.account.things', { url: '/things', template: "<h3>Here
 * are my things:</h3><ul><li>thing a</li><li>thing b</li><li>thing c</li></ul>"
 * });
 * 
 * 
 * 
 * $stateProvider.state('tabs.survey', { url: '/survey', sticky: true, views: {
 * 'survey': { templateUrl: 'survey.html' } } });
 * 
 * 
 * $stickyStateProvider.enableDebug(true);
 */

