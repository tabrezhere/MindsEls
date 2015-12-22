 angular
        .module('theApp')
        .service('UserDetails', UserDetails);

        UserDetails.$inject = ['$http', '$cookieStore', '$rootScope'];
    function UserDetails($http, $cookieStore, $rootScope) {

    	 this.create = function(userId, userRoles) {
			        this.userId = userId;
			        this.userRoles = userRoles;
			    };

			    this.getUserId = function() {
			      return this.userId;
			    };

			    this.getUserRoles = function() {
			      return this.userRoles;
			    };

			    return this;

    	/*var usertype = '';


    	var setData = function (userType){
    		console.log('in userDetails service setting userType as '+userType);
    		this.usertype = userType;
    	} 

    	var getData = function () {
        	return usertype;
    	}

    	return {
    		setData : setData,
        	getData : getData,
        	usertype : usertype
    	};*/

    }