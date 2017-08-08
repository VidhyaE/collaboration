/**
 * 
 */
app.factory('FriendService',function($http){
	var friendService={}
	
	friendService.suggestedUsers=function(){
		return $http.get("http://localhost:8081/backendproject/suggesteduserslist")
	}
	
	friendService.sendFriendRequest=function(toUsername){
		return $http.get("http://localhost:8081/backendproject/friendrequest/"+toUsername);
	}
	 
	friendService.pendingRequests=function() {
		return $http.get("http://localhost:8081/backendproject/pendingrequests")
	}
	
	friendService.updatePendingRequest=function(fromId,status) {
		return $http.put("http://localhost:8081/backendproject/updatependingrequest/"+fromId+"/"+status);
	}
	
	friendService.listOfFriends=function() {
		return $http.get("http://localhost:8081/backendproject/listoffriends")
	}
	
	return friendService;
})