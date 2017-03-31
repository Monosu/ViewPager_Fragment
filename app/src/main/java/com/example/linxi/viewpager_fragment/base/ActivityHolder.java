package com.example.linxi.viewpager_fragment.base;

import android.app.Activity;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by linxi on 2017/3/30.
 */

public class ActivityHolder {
	private final String TAG="ActivityHolder";
	private HashSet<Activity>activities=new HashSet<>();

	public int getActivityCount(){
		if (activities==null){
			return 0;
		}
		return activities.size();
	}

	private static class SingletonHolder{
		private static final ActivityHolder INSTANCE=new ActivityHolder();
	}

	public static final ActivityHolder getInstance(){
		return SingletonHolder.INSTANCE;
	}

	public synchronized void putActivity(Activity activity){
		if (activity!=null){
			activities.add(activity);
		}
	}

	public synchronized void dropActivity(Activity activity){
		if (activity!=null){
			while (activities.contains(activity)){
				activities.remove(activity);
			}
		}
	}

	public synchronized void finishAll(){
		finishAllExceptSelf(null);
	}

	private synchronized void finishAllExceptSelf(Activity self) {
		for (Activity a:activities){
			if (a!=null&&!a.isFinishing()){
				if (self==a){
					continue;
				}
				a.finish();
				a=null;
			}
		}
		activities=new HashSet<>();
		if (self!=null){
			activities.add(self);
		}
	}
}
