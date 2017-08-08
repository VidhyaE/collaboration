/**
 * ForumPostService for Forum module
 */
app.factory('ForumPostService',function($http){
	var forumPostService={}
	
	forumPostService.saveForum=function(forumPost){
		return $http.post("http://localhost:8081/backendproject/saveforumpost",forumPost)
	}
	
	forumPostService.forumsApproved=function(){
		return $http.get("http://localhost:8081/backendproject/listofforums/"+1)
	}
	 
	forumPostService.forumsWaitingForApproval=function() {
		return $http.get("http://localhost:8081/backendproject/listofforums/"+0)
	}
	forumPostService.getForumPost=function(id) {
		return $http.get("http://localhost:8081/backendproject/getforumpost/"+id)
	}
	forumPostService.updateForumPost=function(forumpost) {
		return $http.put("http://localhost:8081/backendproject/updateforumpost",forumpost)
	}
	forumPostService.addComment=function(forumComment) {
		return $http.post("http://localhost:8081/backendproject/addforumcomment",forumComment)
	}
	forumPostService.getForumComments=function(forumId) {
		return $http.get("http://localhost:8081/backendproject/getforumcomments/"+forumId);
	}
	return forumPostService;
})