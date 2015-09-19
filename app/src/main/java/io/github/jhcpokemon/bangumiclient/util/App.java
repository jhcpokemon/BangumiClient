package io.github.jhcpokemon.bangumiclient.util;

import android.app.Application;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;


public class App extends Application {
    public static Context context;
    public static String TAG;
    public static int height;
    public static int width;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        TAG = App.class.getSimpleName();
        DisplayMetrics dm = new DisplayMetrics();
        WindowManager windowManager = (WindowManager)getSystemService(WINDOW_SERVICE);
        windowManager.getDefaultDisplay().getMetrics(dm);
        height = dm.heightPixels;
        width = dm.widthPixels;
    }
}
