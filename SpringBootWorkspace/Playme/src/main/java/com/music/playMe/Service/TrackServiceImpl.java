package com.music.playMe.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.music.playMe.Model.Track;
import com.music.playMe.Repository.TrackRepository;

@Service
public class TrackServiceImpl implements TrackService
{
	@Autowired
	private TrackRepository tRepo;
	
	@Override
	public Track addTrack(Track tck) 
	{
		try
		{
			Track track = tRepo.save(tck);
			if(track != null)
			{
				return tck;
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
			
			//e.printStackTrace();
		}
	}

	@Override
	public List<Track> displayTracks()
	{	
		return tRepo.findAll();
	}
}
