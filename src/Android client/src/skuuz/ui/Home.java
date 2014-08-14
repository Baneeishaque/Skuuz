package skuuz.ui;

import android.os.Bundle;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.view.Menu;

public class Home extends Activity {
	
	/** Identifier for the notification. */
	private static int NOTIF_ID = 'S' << 24 + 'd' << 16 + 'k' << 8 + 'C' << 0;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);
		
		 NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

			String text = "Skuuz! is Active";

			// Note: Notification is marked as deprecated -- in API 11+ there's a
			// new Builder class
			// but we need to have API 7 compatibility so we ignore that warning.

			@SuppressWarnings("deprecation")
			Notification n = new Notification(R.drawable.ic_launcher, text,
					System.currentTimeMillis());
			n.flags |= Notification.FLAG_ONGOING_EVENT | Notification.FLAG_NO_CLEAR;
			Intent intent = new Intent(this, FriendList.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
			PendingIntent pi = PendingIntent.getActivity(this, // context
					0, // requestCode
					intent, // intent
					0 // pending intent flags
					);
			n.setLatestEventInfo(this, text, text, pi);

			nm.notify(NOTIF_ID, n);

	}

	
}
