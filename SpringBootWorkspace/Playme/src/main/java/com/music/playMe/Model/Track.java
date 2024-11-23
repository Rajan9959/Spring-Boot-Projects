package com.music.playMe.Model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;
@Entity
@Data
public class Track
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Integer trackId;
	
	@Column(nullable = false)
	private String trackName;
	
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "albumId")
	private Album albumId;
	
	//@Column(nullable = false)
	private Double duration;
	
	@Column(nullable = false, columnDefinition = "LONGBLOB")
	@Lob
	private byte[] audio;
	
	@Column(nullable = true)
	private Integer likes;
	
	@Column(nullable = false, columnDefinition = "LONGBLOB")
	@Lob
	private byte[] trackImage;
	
	@ManyToMany(mappedBy = "trackId")
	private List<Artist> artist;
	
	@Column(nullable = false)
	private String type;
	
	@Column(nullable = false)
	private String language;
}
