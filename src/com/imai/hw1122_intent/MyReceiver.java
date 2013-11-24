package com.imai.hw1122_intent;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO 自動生成されたメソッド・スタブ
		Log.i("MyReceiver", "onReceive");

		if (intent.getAction().equals(Intent.ACTION_AIRPLANE_MODE_CHANGED)) {
			Log.i("MyReceiver", "機内モード変更されました");
		}
		else if (intent.getAction().equals(Intent.ACTION_NEW_OUTGOING_CALL)) {
			Log.i("MyReceiver", "電話をかけました");
		}
		else if (intent.getAction().equals(Intent.ACTION_SCREEN_ON)) {
			Log.i("MyReceiver", "画面がonになりました");
		}
	}

}
