package com.backendproject.dao;


import java.util.List;

import com.backendproject.model.ForumPost;
import com.backendproject.model.ForumComment;

public interface ForumPostDao {

	void saveForumPost(ForumPost forumPost);
	List<ForumPost> getAllForums(int approved);
	ForumPost getForumById(int id);
	void updateForumPost(ForumPost forumPost);
	void addComment(ForumComment forumComment);
	List<ForumComment> getForumComments(int forumId);
}

