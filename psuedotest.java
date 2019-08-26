//psuedocode

//avm fields below

private int id
private String title
private Artist artist
private LocalDate releaseDate;
private Label label;

private BigDecimal listPrice

private List<Track> tracks = new ArrayList<>();



public Album saveAlbum(AlbumViewModel avm){
    Album newAlbum = new Album();

    newAlbum.setTitle( avm.getTitle());
    newAlbum.setArtistId(avm.artist.getArtistId());
    newAlbum.setReleaseDate(avm.getReleaseDate()); 
    newAlbum.setLabelId(avm.label.getLabelId());
    newALbum.setListPrice(avm.getListPrice());

    return  albumDao.addAlbum(newAlbum);
}