/**
 *  UserService for User module
 */
app.factory('UserService',function($http){
	var userService={}
	
	userService.registerUser=function(user){
		return $http.post("http://localhost:8081/backendproject/registration",user)
	}
	
	userService.login=function(user){
		return $http.post("http://localhost:8081/backendproject/login",user)
	}
	 
	userService.logout=function(){
		return $http.get("http://localhost:8081/backendproject/logout")
	}
	
	userService.getUserByUsername=function(){
		return $http.get("http://localhost:8081/backendproject/getuserdetails")
	}
	
	userService.updateUserProfile=function(user){
		return $http.put("http://localhost:8081/backendproject/updateprofile",user)
	}
	return userService;
	})