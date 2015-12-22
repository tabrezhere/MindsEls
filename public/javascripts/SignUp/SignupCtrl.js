
use strict';

/* Controllers */

var appControllers = angular.module('appControllers', []);




appControllers.controller('SignupCtrl', [ '$scope', '$rootScope', '$location', 'AUTH_EVENTS',
		'Auth', 'UIMessage', function($scope, $rootScope, $location, AUTH_EVENTS, Auth, UIMessage) {
			$scope.signupdata = {
				identifier: 'tab',
				password: 'tab',
				firstName: 'Amar',
				middleName: 'Akbar',
				lastName: 'Anthony',
				contextId: 4,
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
