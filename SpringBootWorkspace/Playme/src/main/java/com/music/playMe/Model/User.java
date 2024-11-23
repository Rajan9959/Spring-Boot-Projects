package com.music.playMe.Model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class User
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	
	@Column(nullable = false)
	private String firstName;
																																															
	@Column(nullable = false)
	private String userName;
	
	@Column(nullable = false,unique = true)
	private String userEmail;
	
	@Column(nullable = false)
	private String userPassword;
	
	@Column(nullable = true)
	private String confirmPassword;
	
	@Column(nullable = false,unique = true)
	private String userMobile;
	
	@Column(nullable = false)
	private String userGender;
	
	@OneToMany
	private List<Artist> artistId;
	
	@Column(nullable = true)
	private List<String> language;
	
	@OneToMany
	private List<Playlist> playlistId;
	
	@OneToMany
	private List<Track> favourites;
}
