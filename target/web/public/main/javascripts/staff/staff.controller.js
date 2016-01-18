//StaffController
(function () {
    'use strict';

    angular
        .module('theApp')
        .controller('StaffController', ['$location', '$rootScope','$scope','$http','StaffService','$stateParams','$routeParams',
                                        function($location,$rootScope,$scope,$http,StaffService,$stateParams,$routeParams){
        	var vm = this;
            $scope.staffUserId = $routeParams.staffId;
            console.log("Inside StaffController   "+ $scope.staffUserId);
            $scope.staffUser =  StaffService.getstaffDetails($scope.staffUserId).then(function(response){
                                console.log("Inside StaffController");
                                //return response.data;
                                });       
                   


            $scope.title = 'iam from ui router staff Controller';
            $scope.addStaff =addStaff;
            $scope.getstaff=getstaff;
            $scope.getstudentList=getstudentList;
            $scope.staffUser = {
            	email : 'demo@email.com',
            	firstName : 'Mohammed Safi ',
            	lastName : 'Siddiqui',
            	phone : 'xxx-abc-asdqwe',
            	dob : '12-12-2012',
            	address : 'place a call to get my place',
            	zipcode : '11909'
            };
            var students;
            
          
            
            $http.get('http://api.randomuser.me/?results=20').success(function(data) {
    		    $scope.users = data.results;
    		    $('#loader').hide();
    		    $('#userList').show();
    		  }).error(function(data, status) {
    		    alert('get data error!');
    		  });
            
            
   		 $scope.showUserModal = function(idx){
   		    var user = $scope.users[idx].user;
   		    $scope.currUser = user;
   		    $('#myModalLabel').text(user.name.first
   		         + ' ' + user.name.last);
   		    $('#myModal').modal('show');
   		  }
   		 
   		 function addStaff(){
   			 console.log('Staff Email = '+$scope.staffUser.email);
        	 StaffService.addStaff($scope.staffUser,function(response){
        		console.log("After Rest Api call for AddStaff"); 
        	 });		 
   		 }
   		
   		 function getstaff(){
   			 console.log('Staff List ');
        	 StaffService.getstaff(function(response){
        		console.log("After Rest Api call for AddStaff"); 
        	 });		 
   		 }
   		 
   		 function getstudentList(staffid,orgid,campusid,classid){
   			 console.log('getstudentList From Staff Controller');
   			students =StaffService.getstudentList(); 
        	 console.log(students);
          			 
   		 }
   		 console.log("stateParams ---- "+$stateParams.classId);
   		 $scope.studentList = StaffService.getstudentList($stateParams.classId); 
            /* $http.get("/api/sprocket/" + $stateParams.id)
                 .then(function(res){ return res.data; });*/
   		 
        }]);
  
})();
