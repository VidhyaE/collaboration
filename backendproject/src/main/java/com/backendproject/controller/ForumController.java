package com.backendproject.controller;


import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import com.backendproject.dao.ForumPostDao;
import com.backendproject.model.ForumPost;
import com.backendproject.model.ForumComment;
import com.backendproject.model.Users;
import com.backendproject.model.Error;

@RestController("forumcontroller")
public class ForumController {
	@Autowired
	private ForumPostDao forumPostDao;   
	@RequestMapping(value="/saveforumpost",method=RequestMethod.POST) 
	public ResponseEntity<?> saveForumPost(@RequestBody ForumPost forumPost,HttpSession session) {
		 Users users=(Users)session.getAttribute("user");
		  if(users==null) {
			  Error error=new Error(3,"UnAuthorized user");
			  return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
		  } 
	      try {
	    	  forumPost.setPostedOn(new Date());
			  forumPost.setCreatedBy(users);
	    	  forumPostDao.saveForumPost(forumPost);
			  return new ResponseEntity<Void>(HttpStatus.OK);
	    	  
	      }catch(Exception e) {
	    	  Error error=new Error(2,"Cannot insert blog post details");
	    	  return new ResponseEntity<Error>(error,HttpStatus.INTERNAL_SERVER_ERROR);
	      }
		  
	}
	/*
	 * @param approved
	 * @param session
	 * @return
	 * approved=0,list of blogs waiting for approval
	 * approved=1,list of blogs which are approved
	 * http://localhost:8081/backendproject/listofblogs/0
	 * http://localhost:8081/backendproject/listofblogs/1
	 */
	@RequestMapping(value="/listofforums/{approved}",method=RequestMethod.GET)
	  public ResponseEntity<?> getAllForums(@PathVariable int approved,HttpSession session) {
		  Users users=(Users)session.getAttribute("user");
		   if(users==null) {
			   Error error=new Error(3,"UnAuthorized user");
			   return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
		   }
		       List<ForumPost> forumPosts=forumPostDao.getAllForums(approved);
			   return new ResponseEntity<List<ForumPost>>(forumPosts,HttpStatus.OK);
			   
		   }
    
	 @RequestMapping(value="/getforumpost/{id}",method=RequestMethod.GET)
     public ResponseEntity<?> getForumPost(@PathVariable int id,HttpSession session) {
	  Users users=(Users)session.getAttribute("user");
	  if(users==null) {
		  Error error=new Error(3,"UnAuthorized user");
		  return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
		 }
	    ForumPost forumPost=forumPostDao.getForumById(id);
	    return new ResponseEntity<ForumPost>(forumPost,HttpStatus.OK);
	  }
	 
	 @RequestMapping(value="/updateforumpost",method=RequestMethod.PUT)
	  public ResponseEntity<?> updateForumPost(@RequestBody ForumPost forumPost,HttpSession session) {
		  Users users=(Users)session.getAttribute("user");
		  if(users==null) {
			  Error error=new Error(3,"UnAuthorized user");
			  return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
			 }
		  forumPostDao.updateForumPost(forumPost);
		  return new ResponseEntity<Void>(HttpStatus.OK);
		  }
	
	 @RequestMapping(value="/addforumcomment",method=RequestMethod.POST)
	  public ResponseEntity<?> addForumComment(@RequestBody ForumComment forumComment,HttpSession session) {
		  Users users=(Users)session.getAttribute("user");
		  if(users==null) {
			  Error error=new Error(3,"UnAuthorized user");
			  return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
			 }
		  try {
			 forumComment.setCommentedBy(users);
			 forumComment.setCommentedOn(new Date());
			 forumPostDao.addComment(forumComment);
			 return new ResponseEntity<Void>(HttpStatus.OK);
		  }
		  catch(Exception e) {
			  Error error=new Error(4,"Unable to add comment"+ e.getMessage());
			  return new ResponseEntity<Error>(error,HttpStatus.INTERNAL_SERVER_ERROR);
		  }
	  }
	    @RequestMapping(value="/getforumcomments/{forumId}",method=RequestMethod.GET)
	    public ResponseEntity<?> getForumComments(@PathVariable int forumId,HttpSession session) {
	    	System.out.println("ENTERING GETFORUMCOMMENTS");
	    	 Users users=(Users)session.getAttribute("user");
			  if(users==null) {
				  Error error=new Error(3,"UnAuthorized user");
				  return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
			}
			try {
				List<ForumComment> forumComments=forumPostDao.getForumComments(forumId);
				System.out.println(forumComments.size());
				return new ResponseEntity<List<ForumComment>>(forumComments,HttpStatus.OK);
			  }catch(Exception e) {
				  System.out.println(e.getMessage());
				  return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
			  }
				
	         }
	 
	 
	}

		  
	
 

