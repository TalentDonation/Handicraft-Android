package kr.co.landvibe.handicraft;


import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;

import kr.co.landvibe.handicraft.utils.LogUtil;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class GlobalApp extends Application {

    public static boolean DEBUG;

    private static GlobalApp mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        this.DEBUG = isDebuggable(this);

        FontInit();

        LogUtil.d("onCreate");
        mInstance = this;

    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        LogUtil.d("attachBaseContext");
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        mInstance = null;
    }

    public static GlobalApp getGlobalApplicationContext() {
        if (mInstance == null) {
            throw new IllegalStateException("this application does not inherit GlobalApplication");
        }
        return mInstance;
    }

    /**
     * 기본 폰트 설정
     */
    public void FontInit() {
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/BMDOHYEON_ttf.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }

    /**
     * 현재 디버그 모드 여부를 리턴
     *
     * @param context
     * @return
     */
    private boolean isDebuggable(Context context) {
        boolean debuggable = false;

        PackageManager pm = context.getPackageManager();
        try {
            ApplicationInfo appinfo = pm.getApplicationInfo(context.getPackageName(), 0);
            debuggable = (0 != (appinfo.flags & ApplicationInfo.FLAG_DEBUGGABLE));
        } catch (PackageManager.NameNotFoundException e) {
            /* debuggable variable will remain false */
        }

        return debuggable;
    }


}
