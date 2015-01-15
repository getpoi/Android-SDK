# Poi Android SDK
Poi Android SDK and Example Android Application that shows usage of the SDK

Installation
-------
1. Add getPoi_vXXX.jar file to your project.
2. Add following permissions and definitions to your AndroidManifest.xml file:

```xml
 <uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION" />
 <uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
 <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>
 <uses-permission android:name="android.permission.INTERNET"/>
 <uses-permission android:name="android.permission.BLUETOOTH" />
 <uses-permission android:name="android.permission.BLUETOOTH_ADMIN" />
```
```xml
 <service android:name="com.getpoi.beacon.PoiService" />
 <receiver
   android:name="com.getpoi.beacon.PoiBroadcastReceiver"
   android:exported="false" >
   <intent-filter>
    <action android:name="com.getpoi.beacon.RECEIVE" />
   </intent-filter>
 </receiver>
```

Integration
-------
* Add the following code block where you want to start service.
```java
   final Intent service = new Intent(MainActivity.this, PoiService.class);
   service.putExtra(PoiService.ACTION_KEY, PoiService.START_SERVICE);
   service.putExtra(PoiService.SECRET_KEY, " YourCompanySecretKey ");
   service.putExtra(PoiService.UNIQUE_ID_KEY, "userUniqueId");
   startService(service);
```
* Add the following code block where you want to stop service.
```java
    stopService(new Intent(MainActivity.this, PoiService.class));
```

* Add the following code block to send the mobile app user info.
```java
    Intent service = new Intent(MainActivity.this, PoiService.class);
    service.putExtra(PoiService.ACTION_KEY, PoiService.SEND_USER_DATA);
    service.putExtra(PoiService.SECRET_KEY, "YourCompanySecretKey");
    service.putExtra(PoiService.UNIQUE_ID_KEY, "UserUniqueId");
    service.putExtra(PoiService.NAME, "UserName");
    service.putExtra(PoiService.SURNAME, "UserSurname");
    service.putExtra(PoiService.EMAIL, "UserEmail");
    service.putExtra(PoiService.ADDRESS, "UserAddress");
    service.putExtra(PoiService.TELNUMBER, "UserTelNumber");
    service.putExtra(PoiService.TCKN, "UserTckn");
    service.putExtra(PoiService.TWITTER, "UserTwitterId");
    service.putExtra(PoiService.FACEBOOK, "UserFacebookId");
    startService(service);
```

* Add the following code block to send the remote notification token.
```java
    Intent service = new Intent(MainActivity.this, PoiService.class);
    service.putExtra(PoiService.ACTION_KEY, PoiService.SEND_NOTIFICATION_TOKEN);
    service.putExtra(PoiService.SECRET_KEY, "YourCompanySecretKey");
    service.putExtra(PoiService.NOTIFICATION_TOKEN_KEY, "UserRemoteNotificationToken");
    startService(service);
```

* If you add the PoiBroadcastReceiver definition to your AndroidManifest.xml file, automatically the campaign data will be shown as a notification. This notification launches the launcher activity. 

```xml
 <receiver
   android:name="com.getpoi.beacon.PoiBroadcastReceiver"
   android:exported="false" >
   <intent-filter>
    <action android:name="com.getpoi.beacon.RECEIVE" />
   </intent-filter>
 </receiver>
```

However if you want to create some special notification in your application with the incoming campaign data you can create your own BroadcastReceiver and change the PoiBroadcastReceiver definition with it. You can get the campaign data in your custom Broadcastreceiver as follows

```java
	@Override
	public void onReceive(Context context, Intent intent) {
		BeaconResponse data = intent.getParcelableExtra("CAMPAIGN_DATA");
	}
```




