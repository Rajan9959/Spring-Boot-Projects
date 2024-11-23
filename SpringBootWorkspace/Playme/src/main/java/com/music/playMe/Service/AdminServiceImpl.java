package com.music.playMe.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.music.playMe.Model.Admin;
import com.music.playMe.Model.Album;
import com.music.playMe.Model.Artist;
import com.music.playMe.Model.Track;
import com.music.playMe.Repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminRepository aRepo;

	@Autowired
	private AlbumService aServ;

	@Autowired
	private ArtistService atServ;

	@Autowired
	private TrackService tServ;

	@Override
	public Admin checkAdminLogin(String email, String password) {
		try {
			Admin admin = aRepo.findByAdminEmailAndAdminPassword(email, password);
			if (admin != null) {
				return admin;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean storeAll(Map<String, Object> album, Map<String, Object> track, Map<String, Object> artist,
			MultipartFile trackImage, MultipartFile audio, MultipartFile artistImage) {
		// Convert Album
		Album alb = new Album();
		alb.setAlbumName((String) album.get("albumName"));
		alb.setReleaseDate(Date.valueOf((String) album.get("releaseDate")));
		alb.setLanguage((String) album.get("language"));
//		if(aServ.addAlbum(alb))
//		{
//			System.out.println("Album Created...!!!");
//		}
//		else
//		{
//			System.out.println("Album Not Created...!!!");
//		}

		// Convert Track
		Track tck = new Track();
		tck.setTrackName((String) track.get("trackName"));
		tck.setType((String) track.get("type"));
		tck.setLanguage((String) track.get("language"));
		Object durationObject = track.get("trackDuration");
		if(durationObject != null)
		{
			tck.setDuration((double) durationObject);
		}
		else
		{
			tck.setDuration(0.0);
		}
		//tck.setDuration((double) track.get("trackDuration"));
		try {
			tck.setTrackImage(trackImage.getBytes());
			tck.setAudio(audio.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Convert Artist
		Artist ars = new Artist();
		ars.setArtistName((String) artist.get("artistName"));
		try {
			ars.setArtistImage(artistImage.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}

		Album alb1 = aServ.addAlbum(alb);
		if (alb1 != null) {
			System.out.println("Album Created..!!!");
			Track tck1 = tServ.addTrack(tck);
			if (tck1 != null) {
				System.out.println("Track created...!!!");
				List<Track> tList = new ArrayList<>();
				tList.add(tck1);
				alb1.setTrackId(tList);
				Album alb2 = aServ.addAlbum(alb1);

				ars.setTrackId(tList);
				Artist ars1 = atServ.addArtist(ars);
				if (alb2 != null && ars1 != null) {
					System.out.println("DONE");
					System.out.println("Album Updated...!!!");
					System.out.println("Artist Updated..!!!");
					ArrayList<Artist> aList = new ArrayList<Artist>();
					aList.add(ars1);
					tck1.setAlbumId(alb2);
					tck1.setArtist(aList);
					Track track2 = tServ.addTrack(tck1);
					if (track2 != null) {
						System.out.println("Track Updated...!!!");
						return true;
					}
				}

			} else {
				System.out.println("Album not Created...!!!");
			}
		}

		return false;
	}

}
