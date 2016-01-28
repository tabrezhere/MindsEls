(function () {
    'use strict';

    
    angular
	.module('theApp')
	.controller(
			'AdminCampusController',
			[
					'$location',
					'$rootScope',
					'$scope',
					'$http','$routeParams',
					function($location, $rootScope, $scope, $http, $routeParams) {
       		
						//$scope.reset=reset;
						
						

						$scope.adminstaffobj = {
								 username: 'Tabrez',
								 password: 2,
								 firstName: 'Shrikanth', 
								 middleName: 'reddy' ,	
								 lastName: 'Ahmed Shareef',
								 address: 'Keonics IT Park',
								 address1: 'Keonics IT Park', 
								 city: 'gulbarga',  
								 state: 'karnataka',
								 subject:'english',
								 hobby:'sports',
								 interest:'books',
								 exp:5
								};
						
						$scope.guardianList= [ {
						    "id": 20,
						    "email": "parent3@gmail.com",
						    "firstName": "parent3",
						    "lastName": "parent3",
						    "middleName": "parent3",
						    "address1": "Brooklyn",
						    "address2": "Jollyville Road",
						    "city": "Austin",
						    "state": "texas",
						    "Deleted": 1,
						    "context": "Parent/Guardian",
						    "user_id": 19,
						    "relationship": "Mother",
						    "phoneNumber": 9630125478,
						    "income": "Fifty Thousand",
						    "education": "UnderGraduate",
						    "studentdetails": [{"FirstName":"Ali","MiddleName":"Mohd","Lastname":"pasha","Studentadminno":"adm1"},{"FirstName":"Shafi","MiddleName":"Khan","Lastname":"Mohd","Studentadminno":"adm2"}],
						    "campusId": 1,
						    "campusName": "Al-Ameen",
						    "orgId": 1,
						    "orgName": "Minds"
						  },{
							    "id": 10,
							    "email": "parent2@gmail.com",
							    "firstName": "parent2",
							    "lastName": "parent2",
							    "middleName": "parent2",
							    "address1": "glb",
							    "address2": "karnataka Road",
							    "city": "glb",
							    "state": "kar",
							    "Deleted": 1,
							    "context": "Parent/Guardian",
							    "user_id": 19,
							    "relationship": "father",
							    "phoneNumber": 9630145478,
							    "income": "Fifty Thousand",
							    "education": "UnderGraduate",
							    "studentdetails": [{"FirstName":"zishan","MiddleName":"ahmed","Lastname":"ahmed","Studentadminno":"adm6"}],
							    "campusId": 1,
							    "campusName": "Al-Ameen",
							    "orgId": 1,
							    "orgName": "Minds"
							  }
							  ];
					
						$scope.campusid=$routeParams.campusid;
										
								
				      	$scope.CampusFormDisplay = false;
				      
				      	$scope.Campus = {
				       				CampusName : '',
				       				CampusId : '',
				       				OrgId:''
				       		};
				       	$scope.showJson = "test obj";
             
       	  	           
       	         
       	  		 
       	  	$scope.showAddCampusForm = function(){
		       	  	$scope.Campus = {
		       				CampusName : '',
		       				CampusId : '',
		       				OrgId:''
		       		};
       			    $scope.CampusFormDisplay = true;
       	  	};
       	  	
       	  	$scope.addCampus = function(){
       	  		$scope.CampusList.push($scope.Campus);
       	  		$scope.CampusFormDisplay = false;
       	  	};
       	  	
       	  	$scope.closeAddCampusForm = function(){
    	  		$scope.CampusFormDisplay = false;
    	  	};
       	  	
        }]);
    
})();
