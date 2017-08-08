package com.backendproject.dao;

import com.backendproject.model.ProfilePicture;
public interface ProfilePictureDao {

    void saveProfilePicture(ProfilePicture profilePicture);
	ProfilePicture getProfilePicture(String username);
}
