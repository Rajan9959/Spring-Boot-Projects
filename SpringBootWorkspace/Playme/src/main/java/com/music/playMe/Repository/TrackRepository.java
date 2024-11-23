package com.music.playMe.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.music.playMe.Model.Track;

public interface TrackRepository extends JpaRepository<Track, Integer> 
{

}
