package com.music.playMe.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.music.playMe.Model.User;
import com.music.playMe.Service.UserService;

@Controller
@RequestMapping("/playMe")
public class HomeController
{
	@Autowired
	private UserService uServ;
	
	@CrossOrigin(origins = "http://127.0.0.1:5500")
	@PostMapping("/user")
	public ResponseEntity<String> displayUser(@RequestBody User user)
	{
		System.out.println(user);
		String message = uServ.addNewUser(user);
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://127.0.0.1:5500")
	@GetMapping("/checkMail")
	public ResponseEntity<String> checkEmail(@RequestParam String mail)
	{
		System.out.println(mail);
		if(uServ.checkEmail(mail))
		{
			return new ResponseEntity<String>(HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
	}
	
	@CrossOrigin(origins = "http://127.0.0.1:5500")
	@GetMapping("/checkMobile")
	public ResponseEntity<String> checkMobile(@RequestParam String mobile)
	{
		System.out.println(mobile);
		if(uServ.checkMobile(mobile))
		{
			return new ResponseEntity<String>(HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
	}
	
	@CrossOrigin(origins = "http://127.0.0.1:5500")
	@GetMapping("/logByMail")
	public ResponseEntity<User> logByMail(@RequestParam String email,@RequestParam String password)
	{
		User usr = uServ.checkLogByMail(email,password);
		
		if(usr!=null)
		{
			return new ResponseEntity<User>(usr,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
	}
	
	@CrossOrigin(origins = "http://127.0.0.1:5500")
	@GetMapping("/logByMobile")
	public ResponseEntity<User> logByMobile(@RequestParam String mobile,@RequestParam String password)
	{
		User usr = uServ.checkLogByMobile(mobile,password);
		
		if(usr!=null)
		{
			return new ResponseEntity<User>(usr,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
