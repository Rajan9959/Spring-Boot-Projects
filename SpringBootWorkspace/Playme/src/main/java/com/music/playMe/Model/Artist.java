package com.music.playMe.Model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import lombok.Data;
@Entity
@Data
public class Artist
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Integer artistId;
	
	@Column(nullable = false)
	private String artistName;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "track_artist",
				joinColumns = @JoinColumn(name = "artistId"),
				inverseJoinColumns = @JoinColumn(name = "trackId"))
	@JsonBackReference
	private List<Track> trackId;
	
	@Column(nullable = false, columnDefinition = "LONGBLOB")
	@Lob
	private byte[] artistImage;
}
