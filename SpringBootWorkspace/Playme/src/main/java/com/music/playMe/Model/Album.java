package com.music.playMe.Model;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
@Entity
@Data
public class Album
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true,nullable = false)
	private Integer albumId;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "albumId",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Track> trackId;
	
	@Column(nullable = false)
	private String albumName;
	
	@Column(nullable = false)
	private Date releaseDate;
	
	@Column(nullable = false)
	private String language;
}
