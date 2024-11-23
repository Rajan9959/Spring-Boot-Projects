package com.music.playMe.Service;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.music.playMe.Model.Admin;

public interface AdminService
{

	Admin checkAdminLogin(String email, String password);

	boolean storeAll(Map<String, Object> album, Map<String, Object> track, Map<String, Object> artist,
			MultipartFile trackImage, MultipartFile audio, MultipartFile artistImage);

}
