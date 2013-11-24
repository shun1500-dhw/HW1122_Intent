package com.imai.hw1122_intent;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {
	Button telButton;
	Button mailButton;
	Button mapButton;
	MyReceiver receiver;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		telButton = (Button) findViewById(R.id.telButton);
		mailButton = (Button) findViewById(R.id.mailButton);
		mapButton = (Button) findViewById(R.id.mapButton);

		telButton.setOnClickListener(this);
		mailButton.setOnClickListener(this);
		mapButton.setOnClickListener(this);

		receiver = new MyReceiver();
		IntentFilter filter = new IntentFilter(Intent.ACTION_SCREEN_ON);
		registerReceiver(receiver, filter);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	protected void onDestroy() {
		// TODO 自動生成されたメソッド・スタブ
		super.onDestroy();
		//なんか終了時にエラーが出るので
		unregisterReceiver(receiver);
	}

	@Override
	public void onClick(View v) {
		// TODO 自動生成されたメソッド・スタブ

		if (v == telButton) {
			//117ボタンが押された時
			Intent intent = new Intent();
			intent.setAction(Intent.ACTION_CALL);
			Uri data = Uri.parse("tel:117");
			intent.setData(data);
			startActivity(intent);

		} else if (v == mailButton) {
			//Mailボタンが押された時
			Intent intent = new Intent();
			intent.setAction(Intent.ACTION_SENDTO);
			Uri data = Uri.parse("mailto:");
			intent.setData(data);
			intent.putExtra(Intent.EXTRA_SUBJECT, "タイトルだよ");
			intent.putExtra(Intent.EXTRA_TEXT, "本文だよ");
			startActivity(intent);

		} else if (v == mapButton) {
			//Mapボタンが押された時
			Intent intent = new Intent();
			intent.setAction(Intent.ACTION_VIEW);
			Uri data = Uri.parse("geo:0,0?q=博多駅");
			intent.setData(data);
			startActivity(intent);

		}
	}
}
