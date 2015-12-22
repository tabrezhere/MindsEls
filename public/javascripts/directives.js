'use strict';

/* Directives */
var appDirectives = angular.module('appDirectives', []);

appDirectives.directive('bsModal', function() {
    return {
        restrict: 'A',
        link: function(scope, element, attrs) {
            scope.$watch(attrs.bsModal, function(value) {
                if (value) element.modal('show');
                else element.modal('hide');
            });
        }
    };
});
