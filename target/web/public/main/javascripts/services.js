'use strict';

/* Services */

var appServices = angular.module('appServices', [ 'ngResource' ]);

appServices.service('UIMessage', function() {
	toastr.options.closeButton = true;

	this.success = function(message) {
		toastr.success(message);
	};

	this.error = function(message) {
		toastr.error(message);
	};

	this.message = function(message, status) {
		if (status.success) {
			this.success(message)
		} else {
			this.error(message)
		}
	}

	return this;
});

appServices.factory('Message', [ '$resource', function($resource) {
	return $resource('/message/:messageId', {
		messageId: '@id'
	}, {
		query: {
			method: 'GET',
			params: {
				messageId: 'messages'
			},
			isArray: true
		},
		create: {
			method: 'POST',
			params: {
				messageId: 'create'
			}
		},
		markRead: {
			method: 'POST',
			url: '/message/:messageId/mark-read'
		}
	})
} ]);

appServices.factory('User', [ '$resource', function($resource) {
	return $resource('/user/:userId', {
		userId: '@id'
	}, {
		query: {
			method: 'GET',
			params: {
				userId: 'users'
			},
			isArray: true
		},
		create: {
			method: 'POST',
			params: {
				userId: 'create'
			}
		},
		update: {
			method: 'POST'
		}
	})
} ]);

appServices.factory('Auth', [ '$http', 'Session', 'USER_ROLES',
      function($http, Session, USER_ROLES) {
      var authService = {};
      authService.signup = function(signupdata) {
	      if(signupdata.contextId === 5){
		      return $http.post(' /auth/signUpForStaff', signupdata).then(function(res) {
		      var d = res.data;
		      Session.create(d.data.session.token, d.data.user.id, d.data.user.roles);
		      return d;
		      });
	      }
	      if(signupdata.contextId === 4){
		      return $http.post('/auth/signUpForStudent', signupdata).then(function(res) {
		      var d = res.data;
		      Session.create(d.data.session.token, d.data.user.id, d.data.user.roles);
		      return d;
		      });
	      }
	      if(signupdata.contextId === 6){
		      return $http.post('/auth/signUpForGuardian', signupdata).then(function(res) {
		      var d = res.data;
		      Session.create(d.data.session.token, d.data.user.id, d.data.user.roles);
		      return d;
		      });
	      }
	      if(signupdata.contextId === 9){
		      return $http.post('/auth/signUpForDriver', signupdata).then(function(res) {
		      var d = res.data;
		      Session.create(d.data.session.token, d.data.user.id, d.data.user.roles);
		      return d;
		      });
	      }

      };
      
      
      authService.studentsignup = function(studentsignupdata) {
	      
		      return $http.post('/auth/signUpForStudent', studentsignupdata).then(function(res) {
			      var d = res.data;
			      Session.create(d.data.session.token, d.data.user.id, d.data.user.roles);
			      return d;
		      });
	      
      };
      
      
      authService.driversignup = function(driversignupdata) {
	      
	      return $http.post('/auth/signUpForDriver', driversignupdata).then(function(res) {
		      var d = res.data;
		      Session.create(d.data.session.token, d.data.user.id, d.data.user.roles);
		      return d;
	      });
      
  };
  
  authService.vehiclecreate = function(vehiclecreatedata) {
      
      return $http.post('/auth/createVehicleDetail', vehiclecreatedata).then(function(res) {
	      var d = res.data;
	      //Session.create(d.data.session.token, d.data.user.id, d.data.user.roles);
	      return d;
      });
  
};
      
      authService.staffsignup = function(staffsignupdata) {
	      
	      return $http.post('/auth/signUpForStaff', staffsignupdata).then(function(res) {
		      var d = res.data;
		      Session.create(d.data.session.token, d.data.user.id, d.data.user.roles);
		      return d;
	      });
	      
      };
	      
	      authService.guardiansignup = function(guardiansignupdata) {
		      
		      return $http.post('/auth/signUpForGuardian', guardiansignupdata).then(function(res) {
			      var d = res.data;
			      Session.create(d.data.session.token, d.data.user.id, d.data.user.roles);
			      return d;
		      });
      
	      };
      
      
authService.login = function(credentials) {
				return $http.post('/auth/signin/credentials', credentials).then(function(res) {
					var d = res.data
					Session.create(d.data.session.token, d.data.user.id, d.data.user.roles);
					return res;
				});
			};
			
			authService.logout = function() {
				return $http.post('/auth/signout').then(function(r){
					Session.destroy();
					
					return r;
				});
			};
			
			
			authService.getUserRoles = function() {
				return $http.get(' /auth/userRoles').then(function(r){
					return r;
				});
			};
			
			
			authService.getAllCampus = function() {
				return $http.get(' /auth/allCampus').then(function(r){					
					return r;
				});
			};
			
			authService.getUserById = function() {
				return $http.get('/auth/getUserById/').then(function(r){					
					return r;
				});
			};
			
			authService.getUserLoginByEmail = function() {
				return $http.get('/auth/getUserLoginByEmail/').then(function(r){					
					return r;
				});
			};
			
			//getUserContextById
			authService.getUserContextById = function() {
				return $http.get('/auth/getUserContextById/').then(function(r){					
					return r;
				});
			};
			
			//getContextById
			authService.getContextById = function() {
				return $http.get('/auth/getContextById/').then(function(r){					
					return r;
				});
			};
			
			//getStaffDetails
			authService.getStaffDetails = function() {
				return $http.get('/auth/getStaffDetails/').then(function(r){					
					return r;
				});
			};
			
			authService.getStudentUserList = function() {
				return $http.get('/auth/getStudentUserListByCampusId/').then(function(r){					
					return r;
				});
			};
			
			
			//getStaffUserListByCampusId
			authService.getStaffUserListByCampusId = function() {
				return $http.get('/auth/getStaffUserListByCampusId/').then(function(r){					
					return r;
				});
			};
			
			authService.getStudentUserByName = function() {
				return $http.get('/auth/getStudentUserByName/').then(function(r){					
					return r;
				});
			};
			
			//getStudentUserByFatherName
			/*authService.getStudentUserByFatherName = function() {
				return $http.get('/auth/getStudentUserByFatherName').then(function(r){					
					return r;
				});
			};*/
			
			
			//getstdFatherName
			authService.getstdFatherName = function() {
				return $http.get('/auth/getstdFatherName/').then(function(r){					
					return r;
				});
			};
			
			//getStudentDetails
			authService.getStudentDetails = function() {
				return $http.get('/auth/getStudentDetails/').then(function(r){					
					return r;
				});
			};
			
			//Auth.getGurdianDetails
			/*authService.getGuardianDetails = function() {
				return $http.get('/auth/getGuardianDetails/').then(function(r){					
					return r;
				});
			};*/
			
			
			//Auth.getGurdianDetails
			authService.getGuardianDetails = function() {
				return $http.get('/auth/getGuardianDetails/').then(function(r){					
					return r;
				});
			};
			
			//Auth.updateStaffDetails
			/*authService.updateStaffDetails = function() {
				return $http.get('/auth/updateStaffDetails').then(function(r){					
					return r;
				});
			};
			
			//Auth.updateGuardianDetails
			authService.updateGuardianDetails = function() {
				return $http.get('/auth/updateGuardianDetails').then(function(r){					
					return r;
				});
			};
			
			*/
			//Auth.updateStudentDetails
			authService.updateStudentDetails = function() {
				return $http.get('/auth/updateStudentDetails/').then(function(r){					
					return r;
				});
			};
			
			/*//Auth.updateGuardianDetails
			authService.updateGuardianDetails = function() {
				return $http.get('/auth/updateGuardianDetails').then(function(r){					
					return r;
				});
			};*/
			//deleteUserDetailsById
			authService.deleteUserDetailsById = function() {
				return $http.get('/auth/deleteUserDetailsById/').then(function(r){					
					return r;
				});
				
			};
			//getFullStudentDetails
			authService.getFullStudentDetails = function() {
				return $http.get('/auth/getFullStudentDetails').then(function(r){					
					return r;
				});
				
			};
			
			///auth/getStudentUserById
			authService.getStudentUserById = function() {
				return $http.get('/auth/getStudentUserById/').then(function(r){					
					return r;
				});
			};
			
			//getAllClassesByCompusId
			authService.getAllClassesByCompusId = function() {
				return $http.get('/auth/getAllClassesByCompusId/').then(function(r){					
					return r;
				});
			};
			
			//getStudentListById
			authService.getStudentListByClassId = function() {
				return $http.get('/auth/getStudentListByClassId/').then(function(r){					
					return r;
				});
			};
			
			//createStudent
			authService.createAttendance  = function() {
				return $http.get('/auth/createAttendance').then(function(r){					
					return r;
				});
			};
			
			//getVehicledetails
			/*authService.getVehicledetails = function() {
				return $http.get('/auth/getVehicledetails').then(function(r){					
					return r;
				});
			};*/
			
			authService.getVehicledetails = function() {
				return $http.get('/auth/getVehicledetails/').then(function(r){					
					return r;
				});
			};
			
			//forgetpassword
			authService.forgetpassword = function() {
				return $http.get('/auth/forgetpassword/').then(function(r){					
					return r;
				});
			};
			
			//updatePassword
			authService.updatePassword = function() {
				return $http.get('/auth/updatePassword').then(function(r){					
					return r;
				});
			};
			
			//createAttendanceByClass
			authService.createAttendanceByClass = function() {
				return $http.get('/auth/createAttendanceByClass/').then(function(r){					
					return r;
				});
			};
			
			//auth/createVehicleDetailsByVehicleType
			authService.createVehicleDetailsByVehicleType = function() {
				return $http.post('/auth/createVehicleDetailsByVehicleType').then(function(r){					
					return r;
				});
			};
			
			//auth/getCreateVehicleDetailUserById/:userId
			authService.getCreateVehicleDetailDlno = function() {
				return $http.get('/auth/getCreateVehicleDetailDlno/').then(function(r){					
					return r;
				});
			};
			
			///auth/sendMailByAWS
			/*authService.sendMailByAWS = function() {
				return $http.get('/auth/sendMailByAWS').then(function(r){					
					return r;
				});
			};*/
			
			//createAttendenceStd
			/*authService.createAttendenceStd = function() {
				return $http.get('/auth/createAttendenceStd').then(function(r){					
					return r;
				});
			};*/
			
			//getAllTermType
			/*authService.getAllTermType = function() {
				return $http.get('/auth/getAllTermType').then(function(r){					
					return r;
				});
			};*/
			
			
			authService.isAuthenticated = function() {
				return !!Session.userId;
			};

			authService.isAuthorized = function(authorizedRoles) {
				if (!angular.isArray(authorizedRoles)) {
					authorizedRoles = [ authorizedRoles ];
				}

				// checking authorized for roles 'any' and 'guest' before checking
				// authentication
				var isA = false;
				var anyguest = [ USER_ROLES.any, USER_ROLES.guest ];

				angular.forEach(Session.userRoles.filter(function(role) {
					return anyguest.indexOf(role) !== -1;
				}), function(role, i) {
					isA = isA || (authorizedRoles.indexOf(role) !== -1);
				});

				if (isA)
					return true;

				if (!authService.isAuthenticated()) {
					return false;
				}

				isA = false;
				angular.forEach(Session.userRoles, function(role, i) {
					isA = isA || (authorizedRoles.indexOf(role) !== -1);
				});

				return isA;
			};

			return authService;
		} ]);

appServices.service('Session', [ 'USER_ROLES', function(USER_ROLES) {
	this.create = function(token, userId, userRoles) {
		this.token = token;
		this.userId = userId;
		this.userRoles = userRoles;
		this.userRoles.unshift(USER_ROLES.any);
	};

	this.destroy = function() {
		this.token = null;
		this.userId = 0;
		this.userRoles = [ USER_ROLES.any, USER_ROLES.guest ];
	};

	this.destroy();

	return this;
} ])
