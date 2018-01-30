package com.mmbao.saas.constant;

import android.os.Environment;

import java.io.File;

/**
 * Description:com.mmbao.saas.constant类
 * Created by Administrator on 2018/1/27.
 * Maxim:There is no smoke without fire
 */

public class ApplicationGlobal {
    public static String basePath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/";

    public static String SAVE_IMAGE_PATH = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separatorChar;//文件分隔符

    //服务端接口版本号
    public static String serviceVersion = "v1";

    public static String _appUrl,payUrl,IMUrl,imgUrl;

    static {
        //测试库
        _appUrl = "http://beta.mmbao.com:8096/";
        payUrl = "http://beta.mmbao.com:8096/";
        IMUrl = "http://trade.mmbao.com/";
        imgUrl = "http://beta.mmbao.com:8096";

        //正式库
//        _appUrl = "http://saas.mmbao.com/";
//        payUrl = "http://saas.mmbao.com/";
//        IMUrl = "http://trade.mmbao.com/";
//        imgUrl = "http://www.mmbao.com/";
    }


}
