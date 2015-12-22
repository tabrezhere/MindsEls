'use strict';

/* Controllers */

var appControllers = angular.module('appControllers', []);



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
