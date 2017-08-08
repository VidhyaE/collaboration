package com.backendproject.dao;

import java.util.List;

import com.backendproject.model.Job;

public interface JobDao {
	void saveJob(Job job);
	List<Job> getAllJobs();
	Job getJobById(int id);
}
