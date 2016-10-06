package edu.orangecoastcollege.cs273.bnguyen336.alohamusic;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import java.net.URI;

public class MediaActivity extends AppCompatActivity {

    private Button ukuleleButton;
    private Button ipuButton;
    private Button hulaButton;
    private VideoView hulaVideoView;

    private MediaPlayer ukuleleMP;
    private MediaPlayer ipuMP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media);

        ukuleleButton = (Button) findViewById(R.id.ukuleleButton);
        ipuButton = (Button) findViewById(R.id.ipuButton);
        hulaButton = (Button) findViewById(R.id.hulaButton);

        hulaVideoView = (VideoView) findViewById(R.id.hulaVideoView);
        hulaVideoView.setVideoURI(Uri.parse("android.resource://" + getPackageName()
                + "/" + R.raw.hula));
        hulaVideoView.setMediaController(new MediaController(this));

        //Associate MediaPlayers with corresponding raws
        ukuleleMP = MediaPlayer.create(this, R.raw.ukulele);
        ipuMP = MediaPlayer.create(this, R.raw.ipu);
    }

    public void playMedia(View view) {
        //Determine which button is clicked
        switch (view.getId()) {
            case R.id.ukuleleButton:
                if (ukuleleMP.isPlaying()) {
                    ukuleleButton.setText(R.string.ukulele_button_play_text);
                    ukuleleMP.pause();
                    //Hide other buttons
                    ipuButton.setVisibility(View.VISIBLE);
                    hulaButton.setVisibility(View.VISIBLE);
                } else {
                    ukuleleButton.setText(R.string.ukulele_button_pause_text);
                    ukuleleMP.start();
                    ipuButton.setVisibility(View.INVISIBLE);
                    hulaButton.setVisibility(View.INVISIBLE);
                }
                break;
            case R.id.ipuButton:
                if (ipuMP.isPlaying()) {
                    ipuButton.setText(R.string.ipu_button_play_text);
                    ipuMP.pause();
                    ukuleleButton.setVisibility(View.VISIBLE);
                    hulaButton.setVisibility(View.VISIBLE);
                } else {
                    ipuButton.setText(R.string.ipu_button_pause_text);
                    ipuMP.start();
                    ukuleleButton.setVisibility(View.INVISIBLE);
                    hulaButton.setVisibility(View.INVISIBLE);
                }
                break;
            case R.id.hulaButton:
                if (hulaVideoView.isPlaying()) {
                    hulaVideoView.pause();
                    hulaButton.setText(R.string.hula_button_watch_text);
                    ukuleleButton.setVisibility(View.VISIBLE);
                    ipuButton.setVisibility(View.VISIBLE);
                } else {
                    hulaVideoView.start();
                    hulaButton.setText(R.string.hula_button_pause_text);
                    ukuleleButton.setVisibility(View.INVISIBLE);
                    ipuButton.setVisibility(View.INVISIBLE);
                }
                break;
        }
    }
}
