package com.company.reccolljdbcTemplatedao.dao;

import com.company.reccolljdbcTemplatedao.model.Artist;

import java.util.List;

public interface ArtistDao {
    public Artist addArtist();
    public Artist getArtist(int id);
    public void deleteArtist(int id);
    public void updateArtist(Artist artist);
    public List<Artist> getAllArtists();
}
