use strict';

/* Controllers */

var appControllers = angular.module('appControllers', []);

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