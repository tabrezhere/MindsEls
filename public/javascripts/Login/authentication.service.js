'use strict';

angular.module('theApp').factory(
		'AuthenticationService',
		[
				'$http',
				'$rootScope',
				'UserService',
				function($http, $rootScope, UserService) {
					var service = {};
					service.verifyLogin = verifyLogin;
					service.organizations = organizations;
					service.campuses = campuses;
					return service;

					function verifyLogin(credentials, callback) {
						console.log('inside verify login');
						console.log('Username --- ' + credentials.username);
						console.log('Password --- ' + credentials.password);
						UserService.VerifyUser(credentials).then(
								function(response) {
									var response = response.data;
									var result;
									result = {
										type : 'admin',
										username : 'siddutab'
									};

									callback(result);
								});
					}
					
					var organizations ={	organizations: [
					           {
					             "id": 0,
					             "name": "HKE",
					             "city": "Kalburagi",
					             "president": "Bhimalli"
					           },
					           {
						             "id": 1,
						             "name": "AIET",
						             "city": "Gulbarga",
						             "president": "Appa"
						           }
					           
					           ]};
				var campuses =	{campuses: [
		                       {
		                         "id": 0,
		                         "dean": "S S Hebbal",
		                         "city": "Kalburagi",
		                         "name": "MSI",
		                         "affiliation": "Autonomous",
		                         "organization": 0,
		                         "email": "ssh@pda.com",
		                         "phone": "+1 (927) 426-2566",
		                         "address": "444 Harkness Avenue, Waterview, South Carolina, 9336",
		                         "about":"50 yrs old org "
		                       },
		                       {
			                         "id": 1,
			                         "dean": "A K Bidve",
			                         "city": "Gulbarga",
			                         "name": "GEC",
			                         "affiliation": "VTU",
			                         "organization": 1,
			                         "email": "akb@vtu.com",
			                         "phone": "+1 (927) 426-2566",
			                         "address": "444 Appa Avenue, Mountainview, South Gulbarga, 585105",
			                         "about":"25 yrs old org "
			                       }
		                      ]};
					
					
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
