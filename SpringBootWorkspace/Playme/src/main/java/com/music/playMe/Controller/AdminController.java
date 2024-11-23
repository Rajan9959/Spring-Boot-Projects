package com.music.playMe.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.music.playMe.Model.Admin;
import com.music.playMe.Model.Track;
import com.music.playMe.Service.AdminService;
import com.music.playMe.Service.TrackService;

@Controller
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequestMapping("/playMe/admin")
public class AdminController
{
	@Autowired
	private AdminService aServ;
	@Autowired
	private TrackService tServ;
	
	@GetMapping("/login")
	public ResponseEntity<Admin> login(@RequestParam String email, @RequestParam String password)
	{
		System.out.println(email);
		if(aServ.checkAdminLogin(email,password)!=null)
		{
			return new ResponseEntity<Admin>(HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<Admin>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping(value = "/storeData", consumes = ("multipart/form-data"))
	public ResponseEntity<String> StoreData(
							@RequestPart Map<String, Object> album,
							@RequestPart Map<String, Object> track,
							@RequestPart Map<String, Object> artist,
							@RequestPart MultipartFile trackImage,
							@RequestPart MultipartFile audio,
							@RequestPart MultipartFile artistImage )
	{
		if(aServ.storeAll(album, track, artist,trackImage, audio, artistImage))
		{
			return new ResponseEntity<String> (HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String> (HttpStatus.NOT_FOUND);
		}
		
	}
	
	@GetMapping(value = "/track", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Track>> getAllTrack()
	{
		List<Track> tracks = tServ.displayTracks();
		if(!tracks.isEmpty())
		{
			return ResponseEntity.ok(tracks);
		}
		else
		{
			return new ResponseEntity<List<Track>>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
