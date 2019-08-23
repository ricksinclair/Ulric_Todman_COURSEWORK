package com.company.reccolljdbcTemplatedao.dao;

import com.company.reccolljdbcTemplatedao.model.Album;

import java.util.List;

public interface AlbumDao {
    public Album addAlbum(Album album);

    public Album getAlbum(int id);

    public List<Album> getAllAlbums();

    public void updateAlbum(Album album);

    public void deleteAlbum(int id);
}