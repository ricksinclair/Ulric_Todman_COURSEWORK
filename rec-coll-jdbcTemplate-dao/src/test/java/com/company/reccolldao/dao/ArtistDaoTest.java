package com.company.reccolldao.dao;

import com.company.reccolldao.model.Album;
import com.company.reccolldao.model.Artist;
import com.company.reccolldao.model.Label;
import com.company.reccolldao.model.Track;
import com.company.reccolljdbcTemplatedao.dao.AlbumDao;
import com.company.reccolljdbcTemplatedao.dao.ArtistDao;
import com.company.reccolljdbcTemplatedao.dao.LabelDao;
import com.company.reccolljdbcTemplatedao.dao.TrackDao;
import com.company.reccolljdbcTemplatedao.model.Artist;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ArtistDaoTest {

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
    public void addGetDeleteArtist() {

        Artist artist = new Artist();
        artist.setName("Rock Star");
        artist.setInstagram("@RockStart");
        artist.setTwitter(("@TheRockStar"));

        artist = artistDao.addArtist(artist);

        Artist artist1 = artistDao.getArtist(artist.getId());

        assertEquals(artist1, artist);

        artistDao.deleteArtist(artist.getId());

        artist1 = artistDao.getArtist(artist.getId());

        assertNull(artist1);
    }

    @Test
    public void updateArtist() {

        Artist artist = new Artist();
        artist.setName("Rock Star");
        artist.setInstagram("@RockStart");
        artist.setTwitter(("@TheRockStar"));

        artist = artistDao.addArtist(artist);

        artist.setName("Pop Star");
        artist.setInstagram("@PopStar");
        artist.setTwitter("@ThePopstar");

        artistDao.updateArtist(artist);

        Artist artist1 = artistDao.getArtist(artist.getId());

        assertEquals(artist1, artist);
    }

    @Test
    public void getAllArtists() {

        Artist artist = new Artist();
        artist.setName("Rock Star");
        artist.setInstagram("@RockStart");
        artist.setTwitter(("@TheRockStar"));

        artist = artistDao.addArtist(artist);

        artist = new Artist();
        artist.setName("Super Star");
        artist.setInstagram("@SuperStart");
        artist.setTwitter(("@TheSuperStar"));

        artist = artistDao.addArtist(artist);

        List<Artist> aList = artistDao.getAllArtists();
        assertEquals(aList.size(), 2);

    }

}