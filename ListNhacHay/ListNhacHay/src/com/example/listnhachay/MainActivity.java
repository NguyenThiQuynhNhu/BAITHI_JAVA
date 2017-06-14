package com.example.listnhachay;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
//import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {
	MediaPlayer song;
	RelativeLayout mh;
	ImageView play;
	public void Anhxa(){
		mh=(RelativeLayout)findViewById(R.id.manHinh);
		play=(ImageView)findViewById(R.id.imagePlay);
	}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();
        //
        mh.setBackgroundResource(R.drawable.anhnen);
        //nhac nen
        song=MediaPlayer.create(getApplicationContext(),R.raw.ttecbd);
        song.start();
        //
        play.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				song.stop();
				Intent mhMusic=new Intent(getApplicationContext(),MusicActivity.class);
				startActivity(mhMusic);
			}
		});
   }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
