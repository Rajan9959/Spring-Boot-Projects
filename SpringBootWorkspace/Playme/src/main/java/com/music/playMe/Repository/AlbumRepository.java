package com.music.playMe.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.music.playMe.Model.Album;

public interface AlbumRepository extends JpaRepository<Album, Integer>
{

}
