package com.example.linxi.viewpager_fragment.util;

import android.app.Application;
import android.content.Context;
import android.os.Environment;


import java.io.File;

import dalvik.system.PathClassLoader;

//import com.squareup.leakcanary.LeakCanary;

/**
 * MadaoApplication
 *
 * @author Angel<br/>
 *         执行初始化<br/>
 *         create: 2014年10月28日 下午2:28:07<br/>
 */
public class LeqiApplication  extends Application{
    private final String TAG = "LeqiApplication";

    /**
     * true : debug模式，不会捕获异常 <br>
     * false: 发包模式，捕获异常并且上传友盟的后台
     */

    public boolean bDeveloperFlag = true;

    private static LeqiApplication mInstance;
    //public static DefaultHXSDKHelper hxSDKHelper = new DefaultHXSDKHelper();
    public static Context applicationContext;

    public static LeqiApplication getInstance() {
        return mInstance;
    }



    @Override
    public void onCreate() {
        super.onCreate();

       // Realm.init(this);

        int pid = android.os.Process.myPid();
       // String processAppName = AppUtil.getAppName(pid, this);
        // 如果app启用了远程的service，此application:onCreate会被调用2次
        // 为了防止环信SDK被初始化2次，加此判断会保证SDK被初始化1次
        // 默认的app会在以包名为默认的process name下运行，如果查到的process name不是app的process
        // name就立即返回
//        if (processAppName == null || !processAppName.equalsIgnoreCase(AppUtil.getAppPackageName(this))) {
//            Log.e(TAG, "onCreate：enter the service process!");
//            // 则此application::onCreate 是被service 调用的，直接返回
//            return;
//        }

       // new PluginsManagerUtil(this).installPlugins();

        applicationContext = this;
        mInstance = this;
//        Logs.e(TAG, "************************onCreate**************************************************");
//        initImageLoader(applicationContext);
//        hxSDKHelper.onInit(applicationContext);

//      SDKInitializer.initialize(applicationContext);
       // MapFacadeImp.createIntance(this);
//      initRealmDB();
//        LeakCanary.install(this);
//      initBugTags();

        PathClassLoader loader = null;
    }

    /**
     * 初始化Realm数据库
     */
//    private void initRealmDB() {
//
//        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder(this)
//                .deleteRealmIfMigrationNeeded() // 测试的时候，不用考虑数据库升级，直接删除即可
////                .schemaVersion(0) // 当前的数据库版本
////                .migration(new LeqiMigration()) // 数据库进行版本升级的处理
//                .build();
//        Realm.setDefaultConfiguration(realmConfiguration);
//    }

//    private void initBugTags() {
//        //在这里初始化
//        Bugtags.start("4d0c4dc1ddc2cdef26b216055b7ea14e", this, Bugtags.BTGInvocationEventBubble);
//    }


    @Override
    public void onTerminate() {
        super.onTerminate();
       // Logs.d(TAG, "onTerminate");

        System.exit(0);
    }

//    public static void initImageLoader(Context context) {
//
//        ImageLoaderConfiguration.Builder config = new ImageLoaderConfiguration.Builder(context);
//        config.threadPriority(Thread.NORM_PRIORITY - 2);
//        config.denyCacheImageMultipleSizesInMemory();
//        config.diskCacheFileNameGenerator(new Md5FileNameGenerator());
//        config.memoryCache(new UsingFreqLimitedMemoryCache(4 * 1024 * 1024));
//        // config.memoryCache(new LruMemoryCache(4*1024 *1024));
//        // config.memoryCache(new WeakMemoryCache());
//        // config.memoryCacheSize(4 * 1024 * 1024);
//        config.diskCache(new UnlimitedDiskCache(getDiskCacheDir(context, "image-cache")));// 自定义缓存路径
//        config.diskCacheSize(100 * 1024 * 1024); // 100 MiB
//        // config.diskCacheFileCount(500)
//        config.tasksProcessingOrder(QueueProcessingType.LIFO);
//        config.imageDownloader(new BaseImageDownloader(context, 5 * 1000, 30 * 1000)); // connectTimeout
        // (5
        // s),
        // readTimeout
        // (30
        // s)超时时间
        // config.writeDebugLogs(); // Remove for release app
        // Initialize ImageLoader with configuration.
//        ImageLoader.getInstance().init(config.build());
//    }

    private static File getDiskCacheDir(Context context, String uniqueName) {
        boolean sdCardExist = Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED);
        String baseDir = "/sdcard/madao";
        if (sdCardExist) {
            baseDir = Environment.getExternalStorageDirectory().getPath();
            baseDir += File.separatorChar + context.getPackageName();
        } else {
            baseDir = context.getCacheDir().getPath();
        }
        // 创建文件夹
        File dir = new File(baseDir);
        if (dir != null && !dir.exists()) {
            dir.mkdirs();
        }

        return new File(baseDir + File.separator + uniqueName);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();

//        startService(new Intent(this, BackSportStaticService.class));
    }

//    @Override
//    public void onTrimMemory(int level) {
//        super.onTrimMemory(level);
//
//        Logs.e(TAG, "trimMemory Level" + level);
//
//        switch (level) {
//            case TRIM_MEMORY_UI_HIDDEN: // 内存不足，并且该进程的UI已经不可见了。
//                onReleaseBmp();
//                break;
//            case TRIM_MEMORY_BACKGROUND: // 内存不足，并且该进程是后台进程。
//                onReleaseBmp();
//                break;
//            case TRIM_MEMORY_MODERATE: // 内存不足，并且该进程在后台进程列表的中部。
//                break;
//            case TRIM_MEMORY_COMPLETE: // 内存不足，并且该进程在后台进程列表最后一个，马上就要被清理
//                break;
//            case TRIM_MEMORY_RUNNING_CRITICAL: // 内存不足(后台进程不足3个)，并且该进程优先级比较高，需要清理内存
//                break;
//            case TRIM_MEMORY_RUNNING_MODERATE: // 内存不足(后台进程超过5个)，并且该进程优先级比较高，需要清理内存
//                break;
//            case TRIM_MEMORY_RUNNING_LOW: // 内存不足(后台进程不足5个)，并且该进程优先级比较高，需要清理内存
//                break;
//        }
//    }


//    private void onReleaseBmp() {
//
//        Logs.e(TAG, "release Bitmap");
//
//        if (null != ImageLoader.getInstance()) {
//            if (ImageLoader.getInstance().isInited())
//                ImageLoader.getInstance().clearMemoryCache();
//        }
//    }

    //public String getServerUrl() {
       // return getString(R.string.server_url);
    //}

}
