'use strict';

angular.module('theApp').factory(
		'NewAuthService',
		[
				'$http',
				'$rootScope',
				'NewUserService','AdminServiceAPI',
				function($http, $rootScope, NewUserService,AdminServiceAPI) {
					var service = {};
					service.verifyLogin = verifyLogin;
					service.getAllOrgs = getAllOrgs;
					service.getadminstaff=getadminstaff;
					service.getAllCampuses = getAllCampuses;
					service.getCampusDetails = getCampusDetails;
					/*service.organizations = organizations;
					service.campuses = campuses;*/
					return service;

					function verifyLogin(credentials, callback) {
						console.log('0 in NewAuthService callback JS verify login');
						console.log('0 Identifier --- ' + credentials.identifier);
						console.log('0 Password --- ' + credentials.password);
						NewUserService.VerifyUser(credentials).then(
								function(response) {
									console.log("0 NewAuthService testing response");
									console.log("0 1NewAuthService message --- " + response.data.message);
									console.log("0 NewAuthService staus --- " + response.data.staus.success);
									//console.log("0 NewAuthService staffuser.context --- " + response.data.data.staffuser.context);
									callback(response.data);
								});
					}
					
					function getadminstaff()
					{
						var staff = [
						              {   orgName: 'HKES', orgType: 'VTU', orgId: 2 ,
						            	  staffdetails:[ {fisrtName:'Rekha',MiddleName:'Patil',lastName:'kumari'}],
						            	  staffclassassociation:[{classname:'Second',classId:12}],
						            	  staffadditionaldetails:[{experience:10,hobby:'Movies'  }]
						              
						              
						              }];
						return staff;
					}
					
					function getAllOrgs(callback){
					var orgList;
				    AdminServiceAPI.getAllOrgs().then(function(response){
					orgList = response.data;
					callback(orgList);
				    });
				    
					}
					
					function getAllCampuses(orgId,callback){
						console.log("inside getAllCampuses --- "+orgId);							
					    var campusListbyorgid;
					   AdminServiceAPI.getAllCampusByOrganizationId(orgId).then(function(response){
						campusListbyorgid = response.data;
						console.log('after orglist'+campusListbyorgid);
						callback(campusListbyorgid);
					   });								
					}
					
					function getCampusDetails(campusId){
						var campusCollection ={ 
								campusDetails : [
			{ campusName: 'MRMC', campusType: 'Medical', orgId: 2, campusId: 'cHKES01'},
			{ campusName: 'PDA', campusType: 'VTU', orgId: 2, campusId: 'cHKES02'},
			{ campusName: 'HKE WPT', campusType: 'Diploma', orgId: 2, campusId: 'cHKES03'},
			{ campusName: 'HKE BPT', campusType: 'Diploma', orgId: 2, campusId: 'cHKES04'},
			{ campusName: 'MSI PUC', campusType: 'PUC', orgId: 2, campusId: 'cHKES05'},
			{ campusName: 'Bibi Raza', campusType: 'School', orgId: 4, campusId: 'cKES01'},
			{ campusName: 'Farhaan', campusType: 'PUC', orgId: 4, campusId: 'cKES02'},
			{ campusName: 'KBN Medical', campusType: 'Medical', orgId: 4, campusId: 'cKES03'},
			{ campusName: 'Little Hearts', campusType: 'Kindergarten', orgId: 4, campusId: 'cKES04'},
			{ campusName: 'Mother Therasa', campusType: 'PUC', orgId:4, campusId: 'cKES05'},
			{ campusName: 'National College', campusType: 'PUC', orgId: 6, campusId: 'cKCT01'},
			{ campusName: 'KCT EC', campusType: 'Engineering', orgId: 6, campusId: 'cKCT02'},
			{ campusName: 'KCT DIP', campusType: 'Diploma', orgId: 6, campusId: 'cKCT03'},
	        { campusName: 'Nobel', campusType: 'PUC', orgId: 6, campusId: 'cKCT04'},
	        { campusName: 'KCT BBM', campusType: 'BBM', orgId:6, campusId: 'cKCT05'},
	
	          { campusName: 'SBR', campusType: 'PUC', orgId: 7, campusId: 'cAppa01'},
	          { campusName: 'Godutai Engg', campusType: 'Engineering', orgId: 7, campusId: 'cAppa02'},
	          { campusName: 'Ling Engg', campusType: 'Engineering', orgId:7, campusId: 'cAppa03'},
	          { campusName: 'SBC', campusType: 'PUC', orgId: 7, campusId: 'cAppa04'},
	          { campusName: 'SB MBA', campusType: 'MBA', orgId:7, campusId: 'cAppa05'}
								                 ]		            
																
														
													
										 };
						var campuses ="";
						angular.forEach(campusCollection.campusDetails, function(campusList) {
							if(campusList.campusId == campusId){
								 campuses = campusList;
								
							}
						});
						
					
					
						return campuses;
									}
					
					
						} ]);

/*
	<!--  
name
dean
city
campus.id
campus.affiliation
campus.email
campus.phone
campus.address
campus.about

-->
*/
