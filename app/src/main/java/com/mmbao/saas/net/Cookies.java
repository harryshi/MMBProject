package com.mmbao.saas.net;

import com.mmbao.saas.util.DESUtil;

/**
 * 网络请求令牌
 * Description:com.mmbao.saas.net类
 * Created by Administrator on 2018/1/27.
 * Maxim:There is no smoke without fire
 */

public class Cookies {

    public static String JSESSIONID = null;
    public static String User_Agent = "1fy8LLuCLgc=";
    public static String User_Agent2;
//	public static String User_Agent =  Cookies.getInstance().getUser_Agent();

    public Cookies() {}
    public static Cookies single = new Cookies();
    // 静态工厂方法
    public static Cookies getInstance() {
        if (single == null) {
            single = new Cookies();
        }
        System.out.print(single);
        return single;
    }

    public static String getUser_Agent() {   //获取User_Agent的时候可释放该方法
        try {
            User_Agent2 = DESUtil.encrypt("saas");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return User_Agent2;
    }

    //	public static String token = "";
}
