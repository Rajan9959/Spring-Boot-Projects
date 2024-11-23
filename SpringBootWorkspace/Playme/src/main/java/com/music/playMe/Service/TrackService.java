package com.music.playMe.Service;

import java.util.List;

import com.music.playMe.Model.Track;

public interface TrackService {

	Track addTrack(Track tck1);

	List<Track> displayTracks();

}
