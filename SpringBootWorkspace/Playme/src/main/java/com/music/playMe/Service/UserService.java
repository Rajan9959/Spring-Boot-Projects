package com.music.playMe.Service;

import com.music.playMe.Model.User;

public interface UserService 
{
	public String addNewUser(User data);

	public boolean checkEmail(String mail);

	public boolean checkMobile(String mobile);

	public User checkLogByMail(String email, String password);

	public User checkLogByMobile(String mobile, String password);
}
