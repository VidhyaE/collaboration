package com.backendproject.dao;

import java.util.List;

import com.backendproject.model.BlogPost;
import com.backendproject.model.BlogComment;

public interface BlogPostDao {

	void saveBlogPost(BlogPost blogPost);
	List<BlogPost> getAllBlogs(int approved);
	BlogPost getBlogById(int id);
	void updateBlogPost(BlogPost blogPost);
	void addComment(BlogComment blogComment);
	List<BlogComment> getBlogComments(int blogId);
}
