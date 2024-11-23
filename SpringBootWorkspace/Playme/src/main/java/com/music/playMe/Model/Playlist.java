package com.music.playMe.Model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Playlist
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer playlistId;
	
	@Column(nullable = false)
	private String playlistName;
	
	@ManyToOne
	private User userId;
	
	@OneToMany
	private List<Track> trackId;
	
}
