package com.company;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Album {
    private Tracks tracks;

    public Album() {
        this.tracks = new Tracks();
    }

    public void addSongToAlbum(String name, int duration) {
        this.tracks.addTrackToAlbum(name, duration);
    }

    public Song getSong(String name) {
        return this.tracks.getTrack(name);
    }

    public int findSong(String name) {
        return this.tracks.findTrack(name);
    }
    public boolean isSongInAlbum(String name) {
        return this.tracks.isTrackInAlbum(name);
    }

    private class Tracks {
        private ArrayList<Song> tracks;

        public Tracks() {
            this.tracks = new ArrayList<Song>();
        }

        public void addTrackToAlbum(String name, int duration) {
            System.out.println(this.tracks);
            Song newTrack = new Song(name, duration);

            if(!isSongInAlbum(name)) {
                this.tracks.add(newTrack);
            }  else {
                System.out.println("Song " + name + " already exists");
            }
        }

        public Song getTrack(String name) {
            Song song = new Song();
            if(isSongInAlbum(name)) {
                int position = findSong(name);
                song = this.tracks.get(position);
            } else {
                System.out.println("Song not in album.");
            }
            return song;
        }

        public int findTrack(String name) {
            int position = -1;
            for (int i = 0; i < this.tracks.size(); i++) {
                if (this.tracks.get(i).getTitle().equalsIgnoreCase(name)) {
                    position = i;
                    break;
                }
            }
            return position;
        }

        public boolean isTrackInAlbum(String name) {
            int position = -1;
            boolean songFound = false;
            for (int i = 0; i < this.tracks.size(); i++) {
                if (this.tracks.get(i).getTitle().equalsIgnoreCase(name)) {
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
}
