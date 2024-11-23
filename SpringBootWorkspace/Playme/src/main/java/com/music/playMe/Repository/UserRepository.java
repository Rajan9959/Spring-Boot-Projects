package com.music.playMe.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.music.playMe.Model.User;

public interface UserRepository extends JpaRepository<User, Integer>
{
	public User findByuserEmail(String email);

	public User findByuserMobile(String mobile);

	public User findByUserEmailAndUserPassword(String email, String password);
	
	public User findByUserMobileAndUserPassword(String mobile, String password);
	
	
}
