package com.getpoi.test;

import com.getpoi.beacon.PoiBroadcastReceiver;
import com.getpoi.beacon.PoiService;
import com.getpoi.beacon.objects.BeaconResponse;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

/*
 Bu broadcastreceiver örnek olup uygulama içerisinde kullanılmamaktadır. Notification
  oluşturmak için kullanılacak datanın nasıl elde edileceğini göstermek amaçlıdır. 
  Burada olduğu gibi kendiniz datayı elde etmek istediğiniz durumda manifest 
  dosyasındaki broadcastreceiver tanımını bu class ile değiştiriniz.
 */
public class MyBroadcastReceiver extends PoiBroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		BeaconResponse data = intent.getParcelableExtra(PoiService.CAMPAIGN_DATA);
		Log.i("My Push data", data.getBody() + " " + data.getTitle());

	}

}
