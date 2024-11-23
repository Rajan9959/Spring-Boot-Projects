package com.music.playMe.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.music.playMe.Model.User;
import com.music.playMe.Repository.UserRepository;

@Service
public class UserServiceImpl implements UserService
{
	@Autowired
	private UserRepository uRepo;
	
	@Override
	public String addNewUser(User data) 
	{
			User save = uRepo.save(data);
			if(save != null)
			{
				return "Account Created..!!!";
			}
			else
			{
				return "Account not Created...!!!";
			}
		
		
	}
	
	@Override
	public boolean checkEmail(String mail)
	{
		try
		{
			User user = uRepo.findByuserEmail(mail);
			if(user != null)
			{
				return true;
			}
			else
				return false;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public boolean checkMobile(String mobile)
	{
		try
		{
			User user = uRepo.findByuserMobile(mobile);
			if(user != null)
			{
				return true;
			}
			else
				return false;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public User checkLogByMail(String email, String password) 
	{
		try
		{
			User user = uRepo.findByUserEmailAndUserPassword(email,password);
			if(user != null)
			{
				return user;
			}
			else
				return null;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public User checkLogByMobile(String mobile, String password)
	{
		try
		{
			User user = uRepo.findByUserMobileAndUserPassword(mobile, password);
			if(user != null)
			{
				return user;
			}
			else
				return null;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
