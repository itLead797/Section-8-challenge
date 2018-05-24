package com.company;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        /** create a program that implements a playlist for songs
         *  create a Song class having Title and Duration
         *  the program will have an Album class containing a list of songs
         *  albums will be stored in an ArrayList
         *  Songs from different albums can be added to a playlsit and will appear in
         *  the list in order they are added
         *  once the songs have been added to the playlsit, create a menu of options to:
         *      Quit, Skip Forward to next song,
         *      Skip backwards to previous song,
         *      Replay the current song
         *  A song must exist in an album before it can be added to the playlist
         *  Hint: to replay a song, consider what was done in the linkedList class example
         *  an optional extra: Remove the current song from the list.
         */
        Playlist playlist = new Playlist();
       operatePlaylist(playlist);

    }

    public static void addSongToPlaylist(Playlist playlist, Album album, String name) {
        if(album.isSongInAlbum(name)) {
            playlist.addSong(album.getSong(name));
        } else {
            System.out.println(name + " not found in album");
        }
    }

    private static void printMenu() {
        System.out.println("Available actions\nPress");
        System.out.println("0 - to quit\n" +
                "1 - to go to next song\n" +
                "2 - to go to previous song\n" +
                "3 - replay current song\n" +
                "4 - print the playlist\n" +
                "5 - remove current song from the list\n" +
                "6 - to print this menu\n");

    }

    public static void operatePlaylist(Playlist playlist) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean goingForward = true;
        String currentSong;

        Album beetles = new Album();
        beetles.addSongToAlbum("Hey Jude", 2);
        beetles.addSongToAlbum("Abbey Road", 3);
        beetles.addSongToAlbum("Yesterday", 3);
        beetles.addSongToAlbum("Lucy In The Sky With Diamonds", 4);
        Album styx = new Album();
        styx.addSongToAlbum("Mr. Roboto", 3);
        styx.addSongToAlbum("The Best Of Times", 2);
        styx.addSongToAlbum("Renegade", 3);
        styx.addSongToAlbum("Lorelei", 2);
        Album eagles = new Album();
        eagles.addSongToAlbum("Hotel California", 3);
        eagles.addSongToAlbum("Desperado", 4);
        eagles.addSongToAlbum("Take It Easy", 2);
        eagles.addSongToAlbum("Peaceful Easy Feeling", 2);

        addSongToPlaylist(playlist, beetles, "Hey Jude");
       // addSongToPlaylist(playlist, beetles, "Hey Jude");
        addSongToPlaylist(playlist, beetles, "Yesterday");
        addSongToPlaylist(playlist, styx, "Renegade");
        addSongToPlaylist(playlist, styx, "The Best Of Times");
        addSongToPlaylist(playlist, eagles, "Desperado");
       // addSongToPlaylist(playlist, eagles, "noName");
        addSongToPlaylist(playlist, eagles, "Peaceful Easy Feeling");
         playlist.printList();

        LinkedList<Song> list = playlist.getPlaylist();
        ListIterator<Song> listIterator = list.listIterator();
        if(list.isEmpty()) {
            System.out.println("No songs in the list");
        } else {
            printMenu();
        }
        while(!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();
            switch(action) {
                case 0:
                    System.out.println("Stopping playlist");
                    quit = true;
                    break;
                case 1:
                    if(!goingForward) {
                        if(listIterator.hasNext()) {
                            listIterator.next();
                        }
                        goingForward = true;
                    }
                    if(listIterator.hasNext()) {
                        System.out.println("Now playing " + listIterator.next().getTitle());
                    } else {
                        System.out.println("Reached the end of the playlist");
                        goingForward = false;
                    }
                    break;
                case 2:
                    if(goingForward) {
                        if(listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        goingForward = false;
                    }
                    if(listIterator.hasPrevious()) {
                        System.out.println("Now playing " + listIterator.previous().getTitle());
                    } else {
                        System.out.println("Reached the beginning of the playlist");
                        goingForward = true;

                    }
                    break;
                case 3:
                    if(goingForward) {
                        if(listIterator.hasPrevious()) {
                            listIterator.previous();
                            System.out.println("Now playing " + listIterator.next().getTitle());

                        }
                    }
                    if (!goingForward) {
                        if(listIterator.hasNext()) {
                            listIterator.next();
                            System.out.println("Now playing " + listIterator.previous().getTitle());

                        }
                    }
                    break;
                case 4:
                    playlist.printList();
                    break;
                case 5:
                    if(goingForward) {
                        if(listIterator.hasPrevious()) {
                            listIterator.previous();
                            System.out.println("Removing song " + listIterator.next().getTitle());
                            listIterator.remove();
                        }
                    }
                    if (!goingForward) {
                        if(listIterator.hasNext()) {
                            listIterator.next();
                            System.out.println("Removing song " + listIterator.previous().getTitle());
                            listIterator.remove();
                        }
                    }
                    break;
                case 6:
                    printMenu();
                    break;
            }
        }
    }
}

// element - element - element