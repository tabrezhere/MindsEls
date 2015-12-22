'use strict';

/* Controllers */

var appConstants = angular.module('appConstants', []);

appConstants.constant('AUTH_EVENTS', {
	loginSuccess: 'auth-login-success',
	loginFailed: 'auth-login-failed',
	logoutSuccess: 'auth-logout-success',
	sessionTimeout: 'auth-session-timeout',
	notAuthenticated: 'auth-not-authenticated',
	notAuthorized: 'auth-not-authorized'
});

appConstants.constant('USER_ROLES', {
	any: '*',
	admin: 'admin',
	user: 'user',
	guest: 'guest'
});
