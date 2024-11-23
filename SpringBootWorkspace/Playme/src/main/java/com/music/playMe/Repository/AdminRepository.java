package com.music.playMe.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.music.playMe.Model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> 
{
	public Admin findByAdminEmailAndAdminPassword(String email,String password);
}
