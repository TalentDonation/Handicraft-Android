package kr.co.landvibe.handicraft;


import android.app.Application;
import android.content.Context;
import android.util.Log;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class GlobalApp extends Application  {

    private final static String TAG = "GlobalApp";

    private static GlobalApp mInstance;

    @Override
    public void onCreate() {
        super.onCreate();

        FontInit();

        Log.d(TAG, "onCreate");
        mInstance=this;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        Log.d(TAG, "attachBaseContext");
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        mInstance = null;
    }

    public static GlobalApp getGlobalApplicationContext(){
        if(mInstance==null){
            throw new IllegalStateException("this application does not inherit GlobalApplication");
        }
        return mInstance;
    }

    public void FontInit(){
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/BMDOHYEON_ttf.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }

}
