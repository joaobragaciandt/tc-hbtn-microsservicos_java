package com.song.demo;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class SongRepository {

    private List<Song> list = new ArrayList<Song>();

    public List<Song> getAllSongs() {
        return list;
    }

    public Song getSongById(Integer id) {
        return list.stream().filter(s -> Objects.equals(s.getId(), id))
                .findFirst()
                .orElse(null);
    }

    public void addSong(Song s) {
        list.add(s);
    }

    public void updateSong(Song s) {
        Song antigoSong = getSongById(s.getId());
        if(antigoSong!=null) {
            int pos = list.indexOf(antigoSong);
            list.set(pos,s);
        }
    }

    public void removeSong(Song s) {
        list.remove(s);
    }

}
