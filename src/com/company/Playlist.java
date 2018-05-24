package com.company;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Playlist {
    private LinkedList<Song> playlist;

    public Playlist() {
        LinkedList<Song> newPlaylist = new LinkedList<Song>();
        this.playlist = newPlaylist;
    }

    public LinkedList<Song> getPlaylist() {
        return playlist;
    }

    public void addSong(Song song) {
        if(!isSongInPlaylist(song)) {
            this.playlist.add(song);
        } else {
            System.out.println("Song is already in your playlist");
        }
    }

    public void printList() {
        Iterator<Song> n = playlist.iterator();
        System.out.println("-----Start of List-----");
        while (n.hasNext()) {
            Song song = n.next();
            System.out.println(song.getTitle() + " : legnth: " + song.getDuration());
        }
        System.out.println("-----end-----");
    }

    private  boolean isSongInPlaylist(Song song) {
        boolean songFound = false;
            if (this.playlist.contains(song))
                songFound = true;
        return songFound;
    }
}
