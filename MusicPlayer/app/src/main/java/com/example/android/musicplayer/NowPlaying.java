package com.example.android.musicplayer;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class NowPlaying extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;
    int songResourceID;
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            // Now that the sound file has finished playing, release the media player resources.
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //get the song ID from the clicked listview
        Intent intent = getIntent();
        songResourceID = intent.getIntExtra("songResourceID", 0);
        //start the media player, and play the song that was clicked in the library activity
        mMediaPlayer = MediaPlayer.create(this, songResourceID);
        mMediaPlayer.start();
        //button to move from 'main activity to library//
        final Button libraryActivity = (Button) findViewById(R.id.librarybutton);
        libraryActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent libraryIntent = new Intent(NowPlaying.this, Library.class);
                releaseMediaPlayer();
                startActivity(libraryIntent);
            }
        });
        //buttons for playing, pausing, stopping music
        Button playButton = (Button) findViewById(R.id.playbutton);
        Button pauseButton = (Button) findViewById(R.id.pausebutton);
        Button stopButton = (Button) findViewById(R.id.stopbutton);
        playButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
               //if mediaplayer is prepared, play. if not, go to library activity and show toast instruction
                if (mMediaPlayer != null) {
                    mMediaPlayer.start();
                } else {
                    Toast toast = Toast.makeText(getApplicationContext(), "Select a song to Play", Toast.LENGTH_SHORT);
                    toast.show();
                    Intent libraryIntent = new Intent(NowPlaying.this, Library.class);
                    startActivity(libraryIntent);
                }
            }
        });
        pauseButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mMediaPlayer.pause();
            }
        });
        stopButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mMediaPlayer.pause();
                mMediaPlayer.reset();
                releaseMediaPlayer();
            }
        });

    }
    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();
            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;
        }
    }
}
