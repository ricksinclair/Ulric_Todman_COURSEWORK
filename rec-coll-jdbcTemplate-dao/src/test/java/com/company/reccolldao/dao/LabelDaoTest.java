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

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class LabelDaoTest {

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
    public void addGetDeleteLabel() {

        Label label = new Label();
        label.setName("Intesrcope");
        label.setWebsite("www.intersope.com");
        labelDao.addLabel(label);

        Label label1 = labelDao.getLabel(label.getId());

        assertEquals(label1, label);

        labelDao.deleteLabel(label.getId());

        label1 = labelDao.getLabel(label.getId());

        assertNull(label1);

    }

    @Test
    public void getAllLabels() {

        Label label = new Label();
        label.setName("Intesrcope");
        label.setWebsite("www.intersope.com");
        labelDao.addLabel(label);

        label = new Label();
        label.setName("Island");
        label.setWebsite("www.island.com");
        labelDao.addLabel(label);

        List<Label> lList = labelDao.getAllLabels();

        assertEquals(lList.size(), 2);

    }

    @Test
    public void updateLabel() {

        Label label = new Label();
        label.setName("Intesrcope");
        label.setWebsite("www.intersope.com");
        labelDao.addLabel(label);

        label.setName("NEW NAME");
        label.setWebsite("NEW WEBSITE");
        labelDao.updateLabel(label);

        Label label1 = labelDao.getLabel(label.getId());

        assertEquals(label1, label);
    }
}