package com.example.listnhachay;

import java.util.ArrayList;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
//import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MusicActivity extends Activity {
	TextView loinhan;
	ListView baihat;
	RelativeLayout hn;
	MediaPlayer song;
	ArrayList<String> mangteBH,mangLoinhan;
	ArrayList<Integer> mangmp3;
	Button back,stop,phat,pause;
	public void Anhxa(){
		loinhan=(TextView)findViewById(R.id.textChuc);
		baihat=(ListView)findViewById(R.id.listViewNhac);
		hn=(RelativeLayout)findViewById(R.id.hinhNen);
		back=(Button)findViewById(R.id.buttonBack);
		pause=(Button)findViewById(R.id.buttonPause);
		phat=(Button)findViewById(R.id.buttonPlay);
	}
		 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_music);
		Anhxa();
		//
		hn.setBackgroundResource(R.drawable.hn);
		//
		song=MediaPlayer.create(getApplicationContext(),R.raw.ttecbd);
        song.start();
        //
		loinhan.setText("Chúc mày sinh nhật vui vẻ");
		//
		Taomang();
		//
		ArrayAdapter adapter =new 
				ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1,mangteBH);
		baihat.setAdapter(adapter);
		//
		baihat.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				song.stop();
				song=MediaPlayer.create(getApplicationContext(), mangmp3.get(arg2));
				song.start();
			
			}
			
		});
		back.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				song.stop();
				Intent mhChinh=new Intent(getApplicationContext(),MainActivity.class);
				startActivity(mhChinh);
				
			}
		});
		
		pause.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				song.pause();
				
			}
		});
		phat.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				song.start();
				
			}
		});
	
	}
	public void Taomang(){
		mangteBH= new ArrayList<String>();
		mangmp3= new ArrayList<Integer>();
		
		mangmp3.add(R.raw.anhsetotma);
		mangteBH.add("Anh sẽ tốt mà-Phạm Hồng Phước");
		
		mangmp3.add(R.raw.coemcho);
		mangteBH.add("Có em chờ-Min");
		
		mangmp3.add(R.raw.dnvnga);
		mangteBH.add("Đừng nói về người ấy-Hồ Quỳnh Hương");
		
		mangmp3.add(R.raw.lactroi);
		mangteBH.add("Lạc trôi-Sơn Tùng");
		
		mangmp3.add(R.raw.psmcg);
		mangteBH.add("Phía sau một cô gái-Soobin Hoàng Sơn");
		
		mangmp3.add(R.raw.tamsuvoingla);
		mangteBH.add("Tâm sự với người lạ-Tiên Cookie");

		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.demo, menu);
		return true;
	}

}
