package com.example.android.musicplayer;


public class Song {

    private String mSongName;
    private String mSongDuration;
    private String mSongGenre;
    private int mSongResourceId;

    public Song(String songName, String songDuration, String songGenre, int songResourceId) {
        mSongName = songName;
        mSongDuration = songDuration;
        mSongGenre = songGenre;
        mSongResourceId = songResourceId;
    }
    /**
     * Get the default translation of the word.
     */
    public String getSongName() {
        return mSongName;
    }
    public String getSongDuration() {
        return mSongDuration;
    }
    public String getSongGenre() { return mSongGenre;    }
    public int getSongResourceId(){
        return mSongResourceId;
    }



}
