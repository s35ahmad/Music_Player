package com.example.android.musicplayer;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.musicplayer.R;
import com.example.android.musicplayer.Song;

import java.util.ArrayList;
public class SongAdapter extends ArrayAdapter<Song> {

    public SongAdapter(Context context, ArrayList<Song> songs) {
        super(context, 0, songs);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Word} object located at this position in the list
        Song currentSong = getItem(position);


        // Find the TextView in the list_item.xml layout with the ID miwok_text_view.
        TextView songNameTextView = (TextView) listItemView.findViewById(R.id.song_name_text_view);
        TextView durationTextView = (TextView) listItemView.findViewById(R.id.duration_text_view);
        TextView genreTextView = (TextView) listItemView.findViewById(R.id.genre_text_view);

        songNameTextView.setText(currentSong.getSongName());
        durationTextView.setText(currentSong.getSongDuration());
        genreTextView.setText(currentSong.getSongGenre());

        // Find the TextView in the list_item.xml layout with the ID default_text_view.
        // Get the default translation from the currentWord object and set this text on
        // the default TextView.

        // Return the whole list item layout (containing 2 TextViews) so that it can be shown in
        // the ListView.
        return listItemView;
    }



}
