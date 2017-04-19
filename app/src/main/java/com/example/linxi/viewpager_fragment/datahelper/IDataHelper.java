package com.example.linxi.viewpager_fragment.datahelper;

import com.example.linxi.viewpager_fragment.metadata.Logout;
import com.example.linxi.viewpager_fragment.metadata.RqstMsg;
import com.example.linxi.viewpager_fragment.metadata.UserLogin;

import java.util.Map;

/**
 * Created by linxi on 2017/4/19.
 */

public interface IDataHelper {
    int register(RqstMsg rqstMsg, Map info);
    int login(RqstMsg rqstMsg, UserLogin info );
    int logout(RqstMsg rqstMsg, Logout info);
    int setSink(IDataHelperSink sink);

}
