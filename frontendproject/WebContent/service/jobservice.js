/**
 * JobService for Job module
 */
app.factory('JobService',function($http){
	var jobService={}
	jobService.saveJob=function(job){
		return $http.post("http://localhost:8081/backendproject/savejob",job)
	}
	
	jobService.getAllJobs=function(){
		return $http.get("http://localhost:8081/backendproject/getalljobs")
	}
	 
	jobService.getJobById=function(id) {
		return $http.get("http://localhost:8081/backendproject/getjobbyid/"+id)
	}
	return jobService;
})
