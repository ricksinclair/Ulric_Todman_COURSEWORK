package com.company.reccolljdbcTemplatedao.model;

import java.util.Objects;

public class Track {
    private int trackId;
    private int albumId;
    private String title;
    private int runtime;

    public int getTrackId() {
        return trackId;
    }

    public void setTrackId(int trackId) {
        this.trackId = trackId;
    }

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Track track = (Track) o;
        return getTrackId() == track.getTrackId() &&
                getAlbumId() == track.getAlbumId() &&
                getRuntime() == track.getRuntime() &&
                getTitle().equals(track.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTrackId(), getAlbumId(), getTitle(), getRuntime());
    }
}
