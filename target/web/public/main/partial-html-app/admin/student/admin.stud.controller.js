//Admin - StudentController
(function () {
    'use strict';

    
    angular
	.module('theApp')
	.controller(
			'AdminStudController',
			[
					'$location',
					'$rootScope',
					'$scope',
					'$http',
					 
					'AdminPostService',
					function($location, $rootScope, $scope, $http,
							AdminPostService) {
       		 //var vm = this;
       		//$scope.newStudentAdmission = newStudentAdmission;
       
       		$scope.studentFormDisplay = false;
       		$scope.student = {
       				studentName : '',
       				studentId : ''
       		};
       		
       		
       		
       	//newStudentAdmission
       	  /*function newStudentAdmission() {
       	  		console.log('inside AdminStudController  -- '+vm.firstName+'  '+vm.middleName);
       	  		 var studentDetails = {
                firstName : vm.firstName,
                middleName : vm.middleName,
                lastName : vm.lastName,
                dob : vm.dob,
                postalAddress1 : vm.postalAddress1,
                postalAddress2 : vm.postalAddress2,
                phoneNumber : vm.phoneNumber,
                inputEmail : vm.inputEmail,
                city : vm.city,
                state : vm.state,
                role : vm.role
                     
       		 };*/
       	  		 
       		AdminPostService.GetStudentListByCampusId($scope.campusid,function(response){
       	  	$scope.studentList = response;
       	  	});	
       	  	
       
       	  	

       	  	$scope.showStudentModal = function(id){       	  		
       	  	AdminService.getStudentInfoById(id,function(response){
       	  	$scope.currStdobj = response;
       	  		$('#studentName').text($scope.currStdobj.firstName);
       	  		$('#myStudentModal').modal('show');
    	  	});	};
       	  	/*$scope.showStudentModal = function(id)
			 {
					 $scope.currStdobj  = 	AdminService.getStudentInfoById(id);
					 console.log('$scope.currStdobj.firstName  = '+$scope.currStdobj.firstName);
			   		    $('#studentName').text($scope.currStdobj);
			   		 console.log('before opening model');
			   		    $('#myStudentModal').modal('show');
			   		 console.log('After opening model');  
			 };
			 */
			
       	  //	console.log("$scope.studentList ---- "+$scope.studentList.data[0].firstName);
       	  	$scope.showAddStudentForm = function(){
	   	  	$scope.student = {
	       				studentName : '',
	       				studentId : ''
	       		};
       			$scope.studentFormDisplay = true;
       	  	};
       	  	
       	  	$scope.addStudent = function(){
       	  		$scope.studentList.push($scope.student);
       	  		$scope.studentFormDisplay = false;
       	  	};
       	  	
       	  	
           	  	$scope.closeAddStudentForm = function(){
    	  		$scope.studentFormDisplay = false;
    	  	};
       	  	
        }]);
    
})();
