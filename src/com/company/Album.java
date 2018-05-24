package com.company;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Album {
    private ArrayList<Song> songs;

    public Album(ArrayList<Song> songs) {
        this.songs = songs;
    }
    public Album() {
        ArrayList<Song> song = new ArrayList<Song>();
        this.songs = song;
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public void addSongToAlbum(String name, int duration) {
        System.out.println(this.songs);
        Song newSong = new Song(name, duration);

        if(!isSongInAlbum(name)) {
            this.songs.add(newSong);
        }  else {
                System.out.println("Song " + name + " already exists");
            }
    }

    public Song getSong(String name) {
        Song song = new Song();
        if(isSongInAlbum(name)) {
            int position = findSong(name);
            song = this.songs.get(position);
        } else {
            System.out.println("Song not in album.");
        }
        return song;
    }

    public int findSong(String name) {
        int position = -1;
        for (int i = 0; i < this.songs.size(); i++) {
            if (this.songs.get(i).getTitle().equalsIgnoreCase(name)) {
                position = i;
                break;
            }
        }
        return position;
    }
    public boolean isSongInAlbum(String name) {
        int position = -1;
        boolean songFound = false;
        for (int i = 0; i < this.songs.size(); i++) {
            if (this.songs.get(i).getTitle().equalsIgnoreCase(name)) {
                position = i;
                break;
            }
        }
        if(position >= 0){
            songFound = true;
        }
        return songFound;
    }

}
