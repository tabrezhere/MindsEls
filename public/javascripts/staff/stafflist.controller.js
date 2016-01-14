(function () {
    'use strict';

    angular
        .module('theApp')
        .controller('StaffListController', ['$location', 'StaffService','$rootScope','$scope','$http',
                                        function($location,StaffService,$rootScope,$scope,$http)
          {
        	  var vm = this;
            $scope.title = 'iam from ui router states list Controller';
            $scope.getstaff=getstaff;
            function getstaff(){
      			  console.log('Staff List ');
           	  StaffService.getstaff(function(response){
           		console.log("After Rest Api call for AddStaff"); 
           	 });		 
      		 }
           }]);
  
})();
