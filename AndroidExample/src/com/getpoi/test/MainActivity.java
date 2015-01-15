package com.getpoi.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.getpoi.beacon.PoiService;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final View startServiceBtn = findViewById(R.id.startService);
		final View sendUserInfo = findViewById(R.id.sendUserInfo);
		final View sendNotificationToken = findViewById(R.id.sendNotificationToken);
		final View stopServiceBtn = findViewById(R.id.stopService);

		startServiceBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent service = new Intent(MainActivity.this, PoiService.class);
				service.putExtra(PoiService.ACTION_KEY, PoiService.START_SERVICE);
				service.putExtra(PoiService.SECRET_KEY, "YourCompanySecretKey");
				service.putExtra(PoiService.UNIQUE_ID_KEY, "userUniqueId");
				startService(service);
			}
		});

		sendUserInfo.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				final Intent service = new Intent(MainActivity.this, PoiService.class);
				service.putExtra(PoiService.ACTION_KEY, PoiService.SEND_USER_DATA);
				service.putExtra(PoiService.SECRET_KEY, "YourCompanySecretKey");
				service.putExtra(PoiService.UNIQUE_ID_KEY, "userUniqueId");
				service.putExtra(PoiService.NAME, "Name");
				service.putExtra(PoiService.SURNAME, "Surname");
				service.putExtra(PoiService.EMAIL, "Email");
				service.putExtra(PoiService.TELNUMBER, "TelNo");
				startService(service);
			}
		});

		sendNotificationToken.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent service = new Intent(MainActivity.this, PoiService.class);
				service.putExtra(PoiService.ACTION_KEY, PoiService.SEND_NOTIFICATION_TOKEN);
				service.putExtra(PoiService.UNIQUE_ID_KEY, "userUniqueId");
				service.putExtra(PoiService.SECRET_KEY, "YourCompanySecretKey");
				service.putExtra(PoiService.NOTIFICATION_TOKEN_KEY, "UserRemoteNotificationToken");
				startService(service);

			}
		});

		stopServiceBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				stopService(new Intent(MainActivity.this, PoiService.class));
			}
		});

		
	}

}
