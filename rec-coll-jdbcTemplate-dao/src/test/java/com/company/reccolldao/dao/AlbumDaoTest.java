package com.company.reccolldao.dao;

import com.company.reccolldao.model.Album;
import com.company.reccolldao.model.Artist;
import com.company.reccolldao.model.Label;
import com.company.reccolldao.model.Track;
import com.company.reccolljdbcTemplatedao.model.Album;
import com.company.reccolljdbcTemplatedao.model.Artist;
import com.company.reccolljdbcTemplatedao.model.Label;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AlbumDaoTest {

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
    public void addGetDeleteAlbum() {

        // Need to create a Label and an Artist first
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

        Album album1 = albumDao.getAlbum(album.getId());

        assertEquals(album1, album);

        albumDao.deleteAlbum(album.getId());

        album1 = albumDao.getAlbum(album.getId());

        assertNull(album1);

    }

    @Test(expected  = DataIntegrityViolationException.class)
    public void addWithRefIntegrityException() {

        Album album = new Album();
        album.setTitle("Greatest Hits");
        album.setArtistId(54);
        album.setLabelId(91);
        album.setReleaseDate(LocalDate.of(2010, 1, 5));
        album.setListPrice(new BigDecimal("21.95"));

        album = albumDao.addAlbum(album);

    }

    @Test
    public void getAllAlbums() {

        // Need to create a Label and an Artist first
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

        album = new Album();
        album.setTitle("Leftovers");
        album.setArtistId(artist.getId());
        album.setLabelId(label.getId());
        album.setReleaseDate(LocalDate.of(2012, 4, 5));
        album.setListPrice(new BigDecimal("18.95"));

        album = albumDao.addAlbum(album);

        List<Album> aList = albumDao.getAllAlbums();

        assertEquals(aList.size(), 2);

    }

    @Test
    public void updateAlbum() {

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
        album.setReleaseDate(LocalDate.of(2010, 1, 1));
        album.setListPrice(new BigDecimal("21.95"));

        album = albumDao.addAlbum(album);

        album.setTitle("NEW TITLE");
        album.setReleaseDate(LocalDate.of(2000, 7, 7));
        album.setListPrice(new BigDecimal("15.68"));

        albumDao.updateAlbum(album);

        Album album1 = albumDao.getAlbum(album.getId());
        assertEquals(album1, album);

    }

}