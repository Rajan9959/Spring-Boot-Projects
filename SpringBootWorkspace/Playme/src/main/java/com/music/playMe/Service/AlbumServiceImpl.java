package com.music.playMe.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.music.playMe.Model.Album;
import com.music.playMe.Repository.AlbumRepository;

@Service
public class AlbumServiceImpl implements AlbumService 
{
	@Autowired
	private AlbumRepository aRepo;
	
	@Override
	public Album addAlbum(Album alb) 
	{
		try
		{
			Album album = aRepo.save(alb);
			if(album != null)
			{
				return album;
			}
			else
			{
				return null;
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			//e.printStackTrace();
			return null;
		}
		
	}
}
