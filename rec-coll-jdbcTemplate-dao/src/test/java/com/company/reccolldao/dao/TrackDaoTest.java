package com.company.reccolldao.dao;

import com.company.reccolldao.model.Album;
import com.company.reccolldao.model.Artist;
import com.company.reccolldao.model.Label;
import com.company.reccolldao.model.Track;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TrackDaoTest {

    @Autowired
    TrackDao trackDao;
    @Autowired
    AlbumDao albumDao;
    @Autowired
    ArtistDao artistDao;
    @Autowired
    LabelDao labelDao;

    @Before
    public void setUp() throws Exception {
        // Clean up the test db
        List<Track> tList = trackDao.getAllTracks();
        for (Track t : tList) {
            trackDao.deleteTrack(t.getId());
        }

        List<Album> aList = albumDao.getAllAlbums();

        for (Album a : aList) {
            albumDao.deleteAlbum(a.getId());
        }

        List<Artist> artistList = artistDao.getAllArtists();

        for (Artist a : artistList) {
            artistDao.deleteArtist(a.getId());
        }

        List<Label> lList = labelDao.getAllLabels();

        for (Label l : lList) {
            labelDao.deleteLabel(l.getId());
        }

    }

    @Test
    public void addGetDeleteTrack() {

        // Need to create a Label, Artist, and Album first
        Label label = new Label();
        label.setName("A&M");
        label.setWebsite("www.aandm.com");
        label = labelDao.addLabel(label);

        Artist artist = new Artist();
        artist.setName("Rock Start");
        artist.setInstagram("@RockStart");
        artist.setTwitter("@TheRockStar");
        artist = artistDao.addArtist(artist);

        Album album = new Album();
        album.setTitle("Greatest Hits");
        album.setArtistId(artist.getId());
        album.setLabelId(label.getId());
        album.setReleaseDate(LocalDate.of(2010, 1, 5));
        album.setListPrice(new BigDecimal("21.95"));

        album = albumDao.addAlbum(album);

        Track track = new Track();
        track.setTitle("The Big Hit");
        track.setRunTime(180);
        track.setAlbumId(album.getId());
        track = trackDao.addTrack(track);

        Track track1 = trackDao.getTrack(track.getId());

        assertEquals(track1, track);

        trackDao.deleteTrack(track.getId());

        track1 = trackDao.getTrack(track.getId());

        assertNull(track1);
    }

    @Test
    public void updateTrack() {

        // Need to create a Label, Artist, and Album first
        Label label = new Label();
        label.setName("A&M");
        label.setWebsite("www.aandm.com");
        label = labelDao.addLabel(label);

        Artist artist = new Artist();
        artist.setName("Rock Start");
        artist.setInstagram("@RockStart");
        artist.setTwitter("@TheRockStar");
        artist = artistDao.addArtist(artist);

        Album album = new Album();
        album.setTitle("Greatest Hits");
        album.setArtistId(artist.getId());
        album.setLabelId(label.getId());
        album.setReleaseDate(LocalDate.of(2010, 1, 5));
        album.setListPrice(new BigDecimal("21.95"));

        album = albumDao.addAlbum(album);

        Track track = new Track();
        track.setTitle("The Big Hit");
        track.setRunTime(180);
        track.setAlbumId(album.getId());
        track = trackDao.addTrack(track);

        track.setTitle("NEW TITLE");
        track.setRunTime(12);

        trackDao.updateTrack(track);

        Track track1 = trackDao.getTrack(track.getId());

        assertEquals(track1, track);

    }

    @Test
    public void getAllTracks() {

        // Need to create a Label, Artist, and Album first
        Label label = new Label();
        label.setName("A&M");
        label.setWebsite("www.aandm.com");
        label = labelDao.addLabel(label);

        Artist artist = new Artist();
        artist.setName("Rock Start");
        artist.setInstagram("@RockStart");
        artist.setTwitter("@TheRockStar");
        artist = artistDao.addArtist(artist);

        Album album = new Album();
        album.setTitle("Greatest Hits");
        album.setArtistId(artist.getId());
        album.setLabelId(label.getId());
        album.setReleaseDate(LocalDate.of(2010, 1, 5));
        album.setListPrice(new BigDecimal("21.95"));

        album = albumDao.addAlbum(album);

        Album album1 = new Album();
        album1.setTitle("Lesser Hits");
        album1.setArtistId(artist.getId());
        album1.setLabelId(label.getId());
        album1.setReleaseDate(LocalDate.of(2012, 6, 25));
        album1.setListPrice(new BigDecimal("9.95"));

        album1 = albumDao.addAlbum(album1);


        Track track = new Track();
        track.setTitle("The Big Hit");
        track.setRunTime(180);
        track.setAlbumId(album.getId());
        track = trackDao.addTrack(track);

        track = new Track();
        track.setTitle("Just A Song");
        track.setRunTime(120);
        track.setAlbumId(album1.getId());
        track = trackDao.addTrack(track);

        List<Track> tList = trackDao.getAllTracks();

        assertEquals(tList.size(), 2);

    }

    @Test
    public void getTracksByAlbum() {

        // Need to create a Label, Artist, and Album first
        Label label = new Label();
        label.setName("A&M");
        label.setWebsite("www.aandm.com");
        label = labelDao.addLabel(label);

        Artist artist = new Artist();
        artist.setName("Rock Start");
        artist.setInstagram("@RockStart");
        artist.setTwitter("@TheRockStar");
        artist = artistDao.addArtist(artist);

        Album album = new Album();
        album.setTitle("Greatest Hits");
        album.setArtistId(artist.getId());
        album.setLabelId(label.getId());
        album.setReleaseDate(LocalDate.of(2010, 1, 5));
        album.setListPrice(new BigDecimal("21.95"));

        album = albumDao.addAlbum(album);

        Album album1 = new Album();
        album1.setTitle("Lesser Hits");
        album1.setArtistId(artist.getId());
        album1.setLabelId(label.getId());
        album1.setReleaseDate(LocalDate.of(2012, 6, 25));
        album1.setListPrice(new BigDecimal("9.95"));

        album1 = albumDao.addAlbum(album1);


        Track track = new Track();
        track.setTitle("The Big Hit");
        track.setRunTime(180);
        track.setAlbumId(album.getId());
        track = trackDao.addTrack(track);

        track = new Track();
        track.setTitle("Just A Song");
        track.setRunTime(120);
        track.setAlbumId(album1.getId());
        track = trackDao.addTrack(track);

        track = new Track();
        track.setTitle("A Little Tune");
        track.setRunTime(100);
        track.setAlbumId(album1.getId());
        track = trackDao.addTrack(track);

        List<Track> tList = trackDao.getTracksByAlbum(album.getId());
        assertEquals(tList.size(), 1);

        tList = trackDao.getTracksByAlbum(album1.getId());
        assertEquals(tList.size(), 2);

    }
}