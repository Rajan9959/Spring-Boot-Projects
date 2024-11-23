package com.music.playMe.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.music.playMe.Model.Artist;

public interface ArtistRepository extends JpaRepository<Artist, Integer>
{

}
