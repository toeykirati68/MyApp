package com.example.toey_kirati.myapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Aboutme extends AppCompatActivity {
    //Explict
    MediaPlayer mediaPlayer;
    int soundID = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutme);
        // Toast onClick
        ImageView clickImageView = (ImageView) findViewById(R.id.imageAbout);
        clickImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Hello!! My name is KIRATI ", Toast.LENGTH_LONG).show();
                //show soundID file Hello when click Image
                soundID = R.raw.hellotoey;
                playSound (soundID);
            }
        });
        // End Toast onLongClick
        ImageView longClickImageView = (ImageView) findViewById(R.id.imageAbout);
        longClickImageView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast.makeText(getApplicationContext(),"Thank ..", Toast.LENGTH_LONG).show();
                // show soundID file Thank when click Image
                soundID = R.raw.thk;
                playSound (soundID);
                return true;
            }
        });

        //Phone click
        TextView phoneTextView = (TextView) findViewById(R.id.txtTell);
        phoneTextView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent phoneIntent = new Intent(Intent.ACTION_DIAL);
                phoneIntent.setData(Uri.parse("tel:0909099361"));
                startActivity(phoneIntent);
            }
        });
    }

    private void playSound(int soundID) {
        mediaPlayer = MediaPlayer.create(getApplicationContext(),soundID);
        mediaPlayer.start();
    }


    public void onClickFacebook(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://www.facebook.com/toey.kirati"));
        startActivity(intent);
    }
    public void clickBackk (View view){
        finish();
    }
}
