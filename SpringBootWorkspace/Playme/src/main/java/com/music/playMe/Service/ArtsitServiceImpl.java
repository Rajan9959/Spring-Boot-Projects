package com.music.playMe.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.music.playMe.Model.Artist;
import com.music.playMe.Repository.ArtistRepository;

@Service
public class ArtsitServiceImpl implements ArtistService
{
	@Autowired
	private ArtistRepository atRepo;
	
	@Override
	public Artist addArtist(Artist ars) 
	{
		try
		{
			Artist artist = atRepo.save(ars);
			if(artist != null)
			{
				return ars;
			}
			else
			{
				return null;
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
			return null;
		}
		
	}
}
