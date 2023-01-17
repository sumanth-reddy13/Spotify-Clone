import java.util.LinkedList;
import java.util.List;

public class Album { //
    private String name;
    private String artist;
    List<Song> songs;

    // constructor
    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        songs = new LinkedList<>();
    }

    // adding songs to the album
    public void addSongToAlbum(Song song) {
        // check if the song is already present on the album.
        if (findSong(song.getTitle())) {
            System.out.println("song is already present in the album");
        }
        else {
            songs.add(song);
            System.out.println("song added to the album");
        }
    }

    private boolean findSong(String title) {
        for (Song song : songs) {
            if (song.getTitle().equals(title)) return true;
        }
        return false;
    }

    // I am using Method overloading to add songs to my playlist.
    public void addSongToPlayList(String title, LinkedList<Song> myPlayList) {
        // check if the title is already present in the playList.
        for (Song song : myPlayList) {
            if (song.getTitle().equals(title)) {
                System.out.println("song is already in the list");
                return;
            }
        }

        for (Song song : songs) {
            if (song.getTitle().equals(title)) {
                myPlayList.add(song);
                System.out.println("song added to the list");
                return;
            }
        }
    }

    public void addSongToPlayList(int trackNo, LinkedList<Song> myPlayList) {
        // As index in a list starts from 0.
        int index = trackNo - 1;

        if (index < 0 || index > songs.size()) {
            System.out.println("track number is not present in the album");
            return;
        }
        Song s = songs.get(index);
        for (Song song : myPlayList) {
            if (song.getTitle().equals(s.getTitle())) {
                System.out.println("song is already in the list");
                return;
            }
        }
        myPlayList.add(s);
        System.out.println("song added to the playList");
    }

    // getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
}
