package ua.riks;


import android.os.Bundle;
import android.util.Log;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
//import com.google.android.gms.ads.AdView;




public class AndroidLauncher extends AndroidApplication  {

	private static final String TAG = " AndroidLauncher";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		config.useAccelerometer = false;
		config.useCompass = false;
		config.useWakelock = true;
		Log.i(TAG, "On Create");
		//config.useGLSurfaceView20API18 = true;
		initialize(new MyGame(), config);
	}

}