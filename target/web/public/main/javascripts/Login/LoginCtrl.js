use strict';

/* Controllers */

var appControllers = angular.module('appControllers', []);

appControllers.controller('LoginCtrl', [ '$scope', '$rootScope', '$location','USER_ROLES', 'AUTH_EVENTS',
		'Auth', 'UIMessage', function($scope, $rootScope, $location, AUTH_EVENTS, Auth, UIMessage) {
			$scope.credentials = {
					identifier: 'tab',
					password: 'tab'
			};

			$scope.isProcessing = false;
			$scope.isReady = false;
			$scope.userRoles = USER_ROLES;

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