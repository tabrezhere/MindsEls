'use strict';

/* Controllers */

var appControllers = angular.module('appControllers', []);

appControllers.controller('AppCtrl', [ '$scope', '$rootScope', '$location', 'USER_ROLES', 'AUTH_EVENTS', 'Auth', 'UIMessage',
		function($scope, $rootScope, $location, USER_ROLES, AUTH_EVENTS, Auth, UIMessage) {

			$scope.currentUser = null;
			$scope.userRoles = USER_ROLES;
			$scope.isAuthorized = Auth.isAuthorized;
			$scope.isAuthenticated = Auth.isAuthenticated;

			$scope.setCurrentUser = function(user) {
				$scope.currentUser = user;
			};

			$scope.isActiveLocation = function(viewLocation) {
				return viewLocation === $location.path();
			};

			$scope.logout = function() {
				Auth.logout().then(function(r) {
					$rootScope.$broadcast(AUTH_EVENTS.logoutSuccess);
					UIMessage.success(r.data.message);
					$location.path('/index').replace();
				}, function(res) {
					UIMessage.error(res.data.message);
				});
				
				return false;
			};
			
			
			$scope.getuserRoles = function() {
				Auth.getUserRoles().then(function(r) {
					//$rootScope.$broadcast(AUTH_EVENTS);
					UIMessage.success(r.data.message);
					$scope.roles=r.data;
					$location.path('/login').replace();
				}, function(res) {
					UIMessage.error(res.data.message);
				});
				
				return false;
			};
			
			
			$scope.getAllCampus = function() {
				Auth.getAllCampus().then(function(r) {
					//$rootScope.$broadcast(AUTH_EVENTS);
					UIMessage.success(r.data.message);
					$location.path('/login').replace();
				}, function(res) {
					UIMessage.error(res.data.message);
				});
				
				return false;
			};
			
			$scope.getUserById = function() {
				Auth.getUserById().then(function(r) {
					//$rootScope.$broadcast(AUTH_EVENTS);
					UIMessage.success(r.data.message);
					$location.path('/login').replace();
				}, function(res) {
					UIMessage.error(res.data.message);
				});
				
				return false;
			};
			
			$scope.getUserLoginByEmail = function() {
				Auth.getUserLoginByEmail().then(function(r) {
					//$rootScope.$broadcast(AUTH_EVENTS);
					UIMessage.success(r.data.message);
					$location.path('/login').replace();
				}, function(res) {
					UIMessage.error(res.data.message);
				});
				
				return false;
			};
			
			//getUserContextById()
			$scope.getUserContextById = function() {
				Auth.getUserContextById().then(function(r) {
					//$rootScope.$broadcast(AUTH_EVENTS);
					UIMessage.success(r.data.message);
					$location.path('/login').replace();
				}, function(res) {
					UIMessage.error(res.data.message);
				});
				
				return false;
			};
			
			//getContextById()
			$scope.getContextById = function() {
				Auth.getContextById().then(function(r) {
					//$rootScope.$broadcast(AUTH_EVENTS);
					UIMessage.success(r.data.message);
					$location.path('/login').replace();
				}, function(res) {
					UIMessage.error(res.data.message);
				});
				
				return false;
			};
			
			//getStaffDetails()
			$scope.getStaffDetails = function() {
				Auth.getStaffDetails().then(function(r) {
					//$rootScope.$broadcast(AUTH_EVENTS);
					UIMessage.success(r.data.message);
					$location.path('/login').replace();
				}, function(res) {
					UIMessage.error(res.data.message);
				});
				
				return false;
			};
			
			
			//getStaffDetails()
			$scope.getStudentUserList = function() {
				Auth.getStudentUserList().then(function(r) {
					//$rootScope.$broadcast(AUTH_EVENTS);
					UIMessage.success(r.data.message);
					$location.path('/login').replace();
				}, function(res) {
					UIMessage.error(res.data.message);
				});
				
				return false;
			};
			
			//getStudentUserByName
			$scope.getStudentUserByName = function() {
				Auth.getStudentUserByName().then(function(r) {
					//$rootScope.$broadcast(AUTH_EVENTS);
					UIMessage.success(r.data.message);
					$location.path('/login').replace();
				}, function(res) {
					UIMessage.error(res.data.message);
				});
				
				return false;
			};
			
			//getStudentUserByFatherName
			/*$scope.getStudentUserByFatherName = function() {
				Auth.getStudentUserByFatherName().then(function(r) {
					//$rootScope.$broadcast(AUTH_EVENTS);
					UIMessage.success(r.data.message);
					$location.path('/login').replace();
				}, function(res) {
					UIMessage.error(res.data.message);
				});
				
				return false;
			};*/
			
			//getstdFatherName
			$scope.getstdFatherName = function() {
				Auth.getstdFatherName().then(function(r) {
					//$rootScope.$broadcast(AUTH_EVENTS);
					UIMessage.success(r.data.message);
					$location.path('/login').replace();
				}, function(res) {
					UIMessage.error(res.data.message);
				});
				
				return false;
			};
			//getStaffUserListByCampusId
			$scope.getStaffUserListByCampusId = function() {
				Auth.getStaffUserListByCampusId().then(function(r) {
					//$rootScope.$broadcast(AUTH_EVENTS);
					UIMessage.success(r.data.message);
					$location.path('/login').replace();
				}, function(res) {
					UIMessage.error(res.data.message);
				});
				
				return false;
			};
			
			
			//getStudentDetails()
			$scope.getStudentDetails = function() {
				Auth.getStudentDetails().then(function(r) {
					//$rootScope.$broadcast(AUTH_EVENTS);
					UIMessage.success(r.data.message);
					$location.path('/login').replace();
				}, function(res) {
					UIMessage.error(res.data.message);
				});
				
				return false;
			};
			
			
			//getGurdianDetails()
			$scope.getGuardianDetails = function() {
				Auth.getGuardianDetails().then(function(r) {
					//$rootScope.$broadcast(AUTH_EVENTS);
					UIMessage.success(r.data.message);
					$location.path('/login').replace();
				}, function(res) {
					UIMessage.error(res.data.message);
				});
				
				return false;
			};
			
			//updateStaffDetails()
			/*$scope.updateStaffDetails = function() {
				Auth.updateStaffDetails().then(function(r) {
					//$rootScope.$broadcast(AUTH_EVENTS);
					UIMessage.success(r.data.message);
					$location.path('/login').replace();
				}, function(res) {
					UIMessage.error(res.data.message);
				});
				
				return false;
			};
			*/
			//updateStudentDetails()
			$scope.updateStudentDetails = function() {
				Auth.updateStudentDetails().then(function(r) {
					//$rootScope.$broadcast(AUTH_EVENTS);
					UIMessage.success(r.data.message);
					$location.path('/login').replace();
				}, function(res) {
					UIMessage.error(res.data.message);
				});
				
				return false;
			};
			
			//
			/*$scope.updateGuardianDetails = function() {
				Auth.updateGuardianDetails().then(function(r) {
					//$rootScope.$broadcast(AUTH_EVENTS);
					UIMessage.success(r.data.message);
					$location.path('/login').replace();
				}, function(res) {
					UIMessage.error(res.data.message);
				});
				
				return false;
			};*/
			
			//deleteUserDetailsById()
			$scope.deleteUserDetailsById = function() {
				Auth.deleteUserDetailsById().then(function(r) {
					//$rootScope.$broadcast(AUTH_EVENTS);
					UIMessage.success(r.data.message);
					$location.path('/login').replace();
				}, function(res) {
					UIMessage.error(res.data.message);
				});
				
				return false;
			};
			
			//getFullStudentDetails
			$scope.getFullStudentDetails= function() {
				Auth.getFullStudentDetails().then(function(r) {
					//$rootScope.$broadcast(AUTH_EVENTS);
					UIMessage.success(r.data.message);
					$location.path('/login').replace();
				}, function(res) {
					UIMessage.error(res.data.message);
				});
				
				return false;
			};
			
			//getStudentUserById
			$scope.getStudentUserById= function() {
				Auth.getStudentUserById().then(function(r) {
					//$rootScope.$broadcast(AUTH_EVENTS);
					UIMessage.success(r.data.message);
					$location.path('/login').replace();
				}, function(res) {
					UIMessage.error(res.data.message);
				});
				
				return false;
			};
			
			
			//getAllClassesByCompusId()
			$scope.getAllClassesByCompusId= function() {
				Auth.getAllClassesByCompusId().then(function(r) {
					//$rootScope.$broadcast(AUTH_EVENTS);
					UIMessage.success(r.data.message);
					$location.path('/login').replace();
				}, function(res) {
					UIMessage.error(res.data.message);
				});
				
				return false;
			};
			
			//getStudentListById
			
			$scope.getStudentListByClassId= function() {
				Auth.getStudentListByClassId().then(function(r) {
					//$rootScope.$broadcast(AUTH_EVENTS);
					UIMessage.success(r.data.message);
					$location.path('/login').replace();
				}, function(res) {
					UIMessage.error(res.data.message);
				});
				
				return false;
			};
			
			//createStudent
			
			$scope.createAttendance= function() {
				Auth.createAttendance().then(function(r) {
					//$rootScope.$broadcast(AUTH_EVENTS);
					UIMessage.success(r.data.message);
					$location.path('/login').replace();
				}, function(res) {
					UIMessage.error(res.data.message);
				});
				
				return false;
			};
			
			//getVehicledetails()
			$scope.getVehicledetails= function() {
				Auth.getVehicledetails().then(function(r) {
					//$rootScope.$broadcast(AUTH_EVENTS);
					UIMessage.success(r.data.message);
					$location.path('/login').replace();
				}, function(res) {
					UIMessage.error(res.data.message);
				});
				
				return false;
			};
			
			
			//forgetpassword()
			$scope.forgetpassword= function() {
				Auth.forgetpassword().then(function(r) {
					//$rootScope.$broadcast(AUTH_EVENTS);
					UIMessage.success(r.data.message);
					$location.path('/login').replace();
				}, function(res) {
					UIMessage.error(res.data.message);
				});
				
				return false;
			};
			
			//updatePassword
			$scope.updatePassword= function() {
				Auth.updatePassword().then(function(r) {
					//$rootScope.$broadcast(AUTH_EVENTS);
					UIMessage.success(r.data.message);
					$location.path('/login').replace();
				}, function(res) {
					UIMessage.error(res.data.message);
				});
				
				return false;
			};
			
			
			//createAttendanceByClass
			$scope.createAttendanceByClass= function() {
				Auth.createAttendanceByClass().then(function(r) {
					UIMessage.success(r.data.message);
					$location.path('/login').replace();
				}, function(res) {
					UIMessage.error(res.data.message);
				});
				
				return false;
			};
			
			//createVehicleDetailsByVehicleType
			$scope.createVehicleDetailsByVehicleType= function() {
				Auth.createVehicleDetailsByVehicleType().then(function(r) {
					UIMessage.success(r.data.message);
					$location.path('/login').replace();
				}, function(res) {
					UIMessage.error(res.data.message);
				});
				return false;
			};
			
			///auth/getCreateVehicleDetailUserById/
			$scope.getCreateVehicleDetailDlno= function() {
				Auth.getCreateVehicleDetailDlno().then(function(r) {
					//$rootScope.$broadcast(AUTH_EVENTS);
					UIMessage.success(r.data.message);
					$location.path('/login').replace();
				}, function(res) {
					UIMessage.error(res.data.message);
				});
				
				return false;
			};
			
			//sendMailByAWS
			/*$scope.sendMailByAWS= function() {
				Auth.sendMailByAWS().then(function(r) {
					//$rootScope.$broadcast(AUTH_EVENTS);
					UIMessage.success(r.data.message);
					$location.path('/login').replace();
				}, function(res) {
					UIMessage.error(res.data.message);
				});
				
				return false;
			};*/
			
			//createAttendenceStd
			/*$scope.createAttendenceStd= function() {
				Auth.createAttendenceStd().then(function(r) {
					//$rootScope.$broadcast(AUTH_EVENTS);
					UIMessage.success(r.data.message);
					$location.path('/login').replace();
				}, function(res) {
					UIMessage.error(res.data.message);
				});
				
				return false;
			};*/
			
			/*//getAllTermType()
			$scope.getAllTermType= function() {
				Auth.getAllTermType().then(function(r) {
					//$rootScope.$broadcast(AUTH_EVENTS);
					UIMessage.success(r.data.message);
					$location.path('/login').replace();
				}, function(res) {
					UIMessage.error(res.data.message);
				});
				
				return false;
			};*/
			
		} ]);

appControllers.controller('MessageListCtrl', [ '$scope', 'Message', 'UIMessage',
		function($scope, Message, UIMessage) {
			$scope.myId = $scope.currentUser.id;
			$scope.box = 'inbox';

			$scope.messages = Message.query();

			$scope.showNewMessage = false;

			$scope.recipientId = 25;
			$scope.fromId = 12;
			$scope.messageText = "Hi, 25";

			$scope.sendMessage = function() {
				// Message.save
				Message.create({
					fromId: parseInt($scope.fromId),
					toId: parseInt($scope.recipientId),
					text: $scope.messageText
				}, function(response) {
					$scope.showNewMessage = false;
					UIMessage.success(response.message);
					$scope.messages.unshift(response.data.item);
				}, function(response) {
					UIMessage.error(response.statusText)
				});
			};

			$scope.removeMessage = function(id) {
				Message.remove({
					messageId: id
				}, function(response) {
					UIMessage.success(response.message);

					angular.forEach($scope.messages, function(msg, i) {
						if (msg.id === id)
							$scope.messages.splice(i, 1);
					});
				}, function(response) {
					UIMessage.error(response.statusText)
				});
			};

			$scope.markRead = function(id) {
				Message.markRead({
					id: id
				}, function(response) {

					angular.forEach($scope.messages, function(msg, i) {
						if (msg.id === id)
							$scope.messages[i].isRead = true;
					});
				}, function(response) {
					UIMessage.error(response.statusText)
				});
			};
		} ]);

appControllers.controller('UserListCtrl', [ '$scope', 'User', 'UIMessage',
		function($scope, User, UIMessage) {
			$scope.users = User.query();

			$scope.user = {
				id: null,
				firstName: '',
				lastName: '',
				email: ''
			};

			$scope.dialog = {
				showNewEdit: false,
				show: 'new',
				hideNewEdit: function() {
					$scope.dialog.showNewEdit = false;
				},
				showNewDialog: function() {
					$scope.user = {
						id: null,
						firstName: '',
						lastName: '',
						email: ''
					};
					$scope.dialog.showNewEdit = true;
					$scope.dialog.show = 'new';
				},
				showEditDialog: function(user) {
					$scope.user = angular.copy(user);
					$scope.dialog.showNewEdit = true;
					$scope.dialog.show = 'edit';
				},
				dialogAction: function() {
					if ($scope.dialog.show == 'new')
						$scope.createUser()
					else
						$scope.updateUser()
				}
			};

			$scope.createUser = function() {
				User.create($scope.user, function(response) {
					$scope.dialog.hideNewEdit();
					UIMessage.success(response.message);
					$scope.users.unshift(response.item);
				}, function(response) {
					UIMessage.error(response.statusText)
				})
			};

			$scope.updateUser = function() {
				User.update($scope.user, function(response) {
					$scope.dialog.hideNewEdit();
					UIMessage.success(response.message);
					angular.forEach($scope.users, function(u, i) {
						if (u.id === $scope.user.id) {
							$scope.users[i] = angular.copy($scope.user);
						}
					})
				}, function(response) {
					UIMessage.error(response.statusText)
				})
			};

			$scope.deleteUser = function(id) {
				User.remove({
					userId: id
				}, function(response) {
					UIMessage.success(response.message);

					angular.forEach($scope.users, function(u, i) {
						if (u.id === id)
							$scope.users.splice(i, 1);
					});
				}, function(response) {
					UIMessage.error(response.statusText)
				});
			};
		} ]);

appControllers.controller('LoginCtrl', [ '$scope', '$rootScope', '$location', 'AUTH_EVENTS',
		'Auth', 'UIMessage', function($scope, $rootScope, $location, AUTH_EVENTS, Auth, UIMessage) {
			$scope.credentials = {
					identifier: 'tab',
					password: 'tab'
			};

			$scope.isProcessing = false;
			$scope.isReady = false;

			$scope.isDisabled = function() {
				return $scope.isProcessing || $scope.isReady;
			};

			$scope.login = function(credentials) {
				$scope.isProcessing = true;

				Auth.login(credentials).then(function(r) {
					/*$rootScope.$broadcast(AUTH_EVENTS.loginSuccess);
					$scope.setCurrentUser(r.data.user);*/
					location.href="#/admindashboard"
					
					//$location.path('/messages').replace();
				}, function(res) {
					$rootScope.$broadcast(AUTH_EVENTS.loginFailed);
					$scope.isProcessing = false;
					UIMessage.error(res.data.message);
				});
			};
			
				$scope.getuserRoles = function() {
					Auth.getUserRoles().then(function(r) {
						
						//$rootScope.$broadcast(AUTH_EVENTS);
						UIMessage.success(r.data.message);
						$scope.roles=r.data;
						$location.path('/login').replace();
					}, function(res) {
						UIMessage.error(res.data.message);
					});
					
					return false;
				};
				

			
			
			
			
		} ]);

appControllers.controller('SignupCtrl', [ '$scope', '$rootScope', '$location', 'AUTH_EVENTS',
		'Auth', 'UIMessage', function($scope, $rootScope, $location, AUTH_EVENTS, Auth, UIMessage) {
			$scope.signupdata = {
				identifier: 'tab',
				password: 'tab',
				firstName: 'Amar',
				middleName: 'Akbar',
				lastName: 'Anthony',
				DOB:'1999-05-12',
				Gender:'Male/Female',
				contextId: 6,
				campusId: 1,
				address1: 'Brooklyn',
				address2: 'Jollyville Road',
				city:'Austin',
				state : 'texas'
			};

			$scope.isProcessing = false;
			$scope.isReady = false;

			$scope.isDisabled = function() {
				return $scope.isProcessing || $scope.isReady;
			};

			$scope.signup = function(signupdata) {
				$scope.isProcessing = true;

				Auth.signup(signupdata).then(function(res) {
					$rootScope.$broadcast(AUTH_EVENTS.loginSuccess);
					$scope.setCurrentUser(res.data.user);

					/*$scope.isReady = true;
					$scope.isProcessing = false;

					UIMessage.success(res.message);
					$location.path('/messages').replace();*/
				}, function(res) {
					$rootScope.$broadcast(AUTH_EVENTS.loginFailed);
					$scope.isProcessing = false;
					UIMessage.error(res.data.message)
				});

			};
		} ]);

appControllers.controller('IndexCtrl', [ '$scope', '$rootScope', function($scope, $rootScope) {
	$scope.hello = 'hi';
} ]);

appControllers.controller('StudentSignupCtrl', [ '$scope', '$rootScope', '$location', 'AUTH_EVENTS',
  		'Auth', 'UIMessage', function($scope, $rootScope, $location, AUTH_EVENTS, Auth, UIMessage) {
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

  			$scope.isProcessing = false;
  			$scope.isReady = false;

  			$scope.isDisabled = function() {
  				return $scope.isProcessing || $scope.isReady;
  			};
  			
  			$scope.studentsignup = function(studentsignupdata) {
  				$scope.isProcessing = true;

  				Auth.studentsignup(studentsignupdata).then(function(res) {
  					$rootScope.$broadcast(AUTH_EVENTS.loginSuccess);
  					$scope.setCurrentUser(res.data.user);

  					
  				}, function(res) {
  					$rootScope.$broadcast(AUTH_EVENTS.loginFailed);
  					$scope.isProcessing = false;
  					UIMessage.error(res.data.message)
  				});

  			};
  		} ]);



appControllers.controller('StaffSignupCtrl', [ '$scope', '$rootScope', '$location', 'AUTH_EVENTS',
   		'Auth', 'UIMessage', function($scope, $rootScope, $location, AUTH_EVENTS, Auth, UIMessage) {
   			$scope.staffsignupdata = {
   				identifier: 'tab',
   				password: 'tab',
   				firstName: 'Amar',
   				middleName: 'Akbar',
   				lastName: 'Anthony',
   				DOB:'1999-05-12',
   				Gender:'Male/Female',
   				address1: 'Brooklyn',
   				address2: 'Jollyville Road',
   				contextId: 5,
   				campusId: 1,  				
   				city:'Austin',
   				state : 'texas'
   				
   			};

   			$scope.isProcessing = false;
   			$scope.isReady = false;

   			$scope.isDisabled = function() {
   				return $scope.isProcessing || $scope.isReady;
   			};

   			$scope.staffsignup = function(staffsignupdata) {
   				$scope.isProcessing = true;

   				Auth.staffsignup(staffsignupdata).then(function(res) {
   					$rootScope.$broadcast(AUTH_EVENTS.loginSuccess);
   					$scope.setCurrentUser(res.data.user);

   					/*$scope.isReady = true;
   					$scope.isProcessing = false;

   					UIMessage.success(res.message);
   					$location.path('/messages').replace();*/
   				}, function(res) {
   					$rootScope.$broadcast(AUTH_EVENTS.loginFailed);
   					$scope.isProcessing = false;
   					UIMessage.error(res.data.message)
   				});

   			};
   		} ]);



appControllers.controller('GuardianSignupCtrl', [ '$scope', '$rootScope', '$location', 'AUTH_EVENTS',
      		'Auth', 'UIMessage', function($scope, $rootScope, $location, AUTH_EVENTS, Auth, UIMessage) {
      			$scope.guardiansignupdata = {
      				identifier: 'tab',
      				password: 'tab',
      				firstName: 'Amar',
      				middleName: 'Akbar',
      				lastName: 'Anthony',
      				DOB:'1999-05-12',
      				Gender:'Male/Female',
      				address1: 'Brooklyn',
      				address2: 'Jollyville Road',
      				contextId: 5,
      				campusId: 1,  				
      				city:'Austin',
      				state : 'texas',
      				//phoneNumber : '',
      				relation : 'Father/Mother/Guardian',
      				mobile : '',
      				income : 'Fifty Thousand',
      				education : 'UnderGraduate',
      				campusId:1
      			};

      			$scope.isProcessing = false;
      			$scope.isReady = false;

      			$scope.isDisabled = function() {
      				return $scope.isProcessing || $scope.isReady;
      			};

      			$scope.guardiansignup = function(guardiansignupdata) {
      				$scope.isProcessing = true;

      				Auth.guardiansignup(guardiansignupdata).then(function(res) {
      					$rootScope.$broadcast(AUTH_EVENTS.loginSuccess);
      					$scope.setCurrentUser(res.data.user);

      				}, function(res) {
      					$rootScope.$broadcast(AUTH_EVENTS.loginFailed);
      					$scope.isProcessing = false;
      					UIMessage.error(res.data.message)
      				});

      			};
      		} ]);

appControllers.controller('DriverSignupCtrl', [ '$scope', '$rootScope', '$location', 'AUTH_EVENTS',
          'Auth', 'UIMessage', function($scope, $rootScope, $location, AUTH_EVENTS, Auth, UIMessage) {
          $scope.driversignupdata = {
       				identifier: 'tab',
					password: 'tab',
					firstName: 'Amar',
					middleName: 'Akbar',
					lastName: 'Anthony',
					DOB:'1999-05-12',
					Gender:'Male/Female',
					address1: 'Brooklyn',
					address2: 'Jollyville Road',
					contextId: 9,
					campusId: 1,  				
					city:'Austin',
					state : 'texas',
					DLno : 'Required',
					vehicleid : 0
					
				};
		
				$scope.isProcessing = false;
				$scope.isReady = false;
		
				$scope.isDisabled = function() {
					return $scope.isProcessing || $scope.isReady;
				};

				$scope.driversignup = function(driversignupdata) {
					$scope.isProcessing = true;
		
					Auth.driversignup(driversignupdata).then(function(res) {
						$rootScope.$broadcast(AUTH_EVENTS.loginSuccess);
						$scope.setCurrentUser(res.data.user);
		
						
					}, function(res) {
						$rootScope.$broadcast(AUTH_EVENTS.loginFailed);
						$scope.isProcessing = false;
						UIMessage.error(res.data.message)
					});
		
				};
			} ]);


appControllers.controller('VehicleCreateCtrl', [ '$scope', '$rootScope', '$location', 'AUTH_EVENTS',
            'Auth', 'UIMessage', function($scope, $rootScope, $location, AUTH_EVENTS, Auth, UIMessage) {
            $scope.vehiclecreatedata = {
            		id : 0,
            		Vehicle_no: 'KA-32',
            		Vehicle_code: 'Cab56',
            		No_of_Seat: 60,
            		Maximum_capacity: 54,
            		insurance: 'Required',
            		tax_remitted:'Required',
            		permit:'Required',
            		status: 'Required',
            		Vehicle_type_id: 1,
            		Route_Name: 'MSK Mill',
            		No_of_Stops: 4, 
            		Stop_Name:'Stop 1,Stop 2,Stop 3 Stop 4',
            		fare : '200,200,200,200',
            		Arival_Mrng : '8:10 AM',
            		Departure_Mrng : '8:20 AM',
            		Arival_Evng : '5:20 PM',
            		Departure_Evng : '5:30 PM'
  				};
  		
  				$scope.isProcessing = false;
  				$scope.isReady = false;
  		
  				$scope.isDisabled = function() {
  					return $scope.isProcessing || $scope.isReady;
  				};

  				$scope.vehiclecreate = function(vehiclecreatedata) {
  					$scope.isProcessing = true;
  		
  					Auth.vehiclecreate(vehiclecreatedata).then(function(res) {
  						$rootScope.$broadcast(AUTH_EVENTS.loginSuccess);
  						$scope.setCurrentUser(res.data.user);
  		
  						
  					}, function(res) {
  						$rootScope.$broadcast(AUTH_EVENTS.loginFailed);
  						$scope.isProcessing = false;
  						UIMessage.error(res.data.message)
  					});
  		
  				};
  			} ]);


appControllers.controller('ForgetCtrl', [ '$scope', '$rootScope', '$location', 'AUTH_EVENTS',
    'Auth', 'UIMessage', function($scope, $rootScope, $location, AUTH_EVENTS, Auth, UIMessage) {
	$scope.email = '';
	$scope.isProcessing = false;
		$scope.isReady = false;

		$scope.isDisabled = function() {
			return $scope.isProcessing || $scope.isReady;
		};
		
		$scope.send = function(email) {
				$scope.isProcessing = true;
		}
		Auth.send(email).then(function(res) {
				$rootScope.$broadcast(AUTH_EVENTS.loginSuccess);
				$scope.setCurrentUser(res.data.user);
			}, function(res) {
				$rootScope.$broadcast(AUTH_EVENTS.loginFailed);
				$scope.isProcessing = false;
				UIMessage.error(res.data.message)
			});

		}
		]);
appControllers.controller('ResetPasswordCtrl', [ '$scope', '$rootScope', '$location', 'AUTH_EVENTS',
            'Auth', 'UIMessage', function($scope, $rootScope, $location, AUTH_EVENTS, Auth, UIMessage) {
                 $scope.password = '';
                 $scope.confirmPassword = '';
                 $scope.isProcessing = false;
                 $scope.isReady = false;

             $scope.isDisabled = function() {
             return $scope.isProcessing || $scope.isReady;
             };
                                      		
           $scope.updatePassword = function(password,confirmPassword) {
                                      				$scope.isProcessing = true;
                                      		}
                                      		Auth.updatePassword(password,confirmPassword).then(function(res) {
                                      				$rootScope.$broadcast(AUTH_EVENTS.loginSuccess);
                                      				$scope.setCurrentUser(res.data.user);
                                      			}, function(res) {
                                      				$rootScope.$broadcast(AUTH_EVENTS.loginFailed);
                                      				$scope.isProcessing = false;
                                      				UIMessage.error(res.data.message)
                                      			});

                                      		}
                                      		]);
/*appControllers.controller('ResetPasswordCtrl', [ '$scope', '$routeParams', '$rootScope', '$resource', 'UIMessage', function($scope, $routeParams, $rootScope, $resource, UIMessage) {
	$scope.isUpdating = false;
	$scope.password = '';
	$scope.confirmPassword = '';

	$scope.isProcessing = function() {
		return $scope.isUpdating;
	};
	
	$scope.updatePassword = function(password, confirmPassword) {
		if(password.length < 6) {
			alert("Passwords is too short. Please, choose another password.");
			return false;
		}

		if(password !== confirmPassword) {
			alert("Passwords missmatch. Please, enter again.");
			return false;
		}
		
		$scope.isUpdating = true;
		
		PS.resetPassword({key: $routeParams.key, password: password}, function(resp) {
			$scope.isUpdating = false;
			UIMessage.success(resp.message);
		}, function(err){
			$scope.isUpdating = false;
			UIMessage.error(err.message);
		});
	};
	
	var PS = $resource('/reset-password/:key', {key: '@key'}, {
		resetPassword: {
			method: 'POST'
		}
	});
	
	}
	]);
*/




