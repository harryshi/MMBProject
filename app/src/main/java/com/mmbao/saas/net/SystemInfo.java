package com.mmbao.saas.net;

import android.content.Context;

import com.mmbao.saas.constant.ApplicationGlobal;
import com.mmbao.saas.constant.Constants;
import com.mmbao.saas.util.SharedPrenfenceUtil;


public class SystemInfo {
	private SharedPrenfenceUtil sp;
	private static SystemInfo instance;
	public SystemInfo(Context ctx) {
		this.sp = SharedPrenfenceUtil.getInstance();
	}
	/**
	 * 单例模式
	 * 
	 * @return 唯一退出应用对象
	 */
	public static SystemInfo getInstance(Context ctx) {
		if (null == instance) {
			synchronized (SystemInfo.class) {
				if (null == instance) {
					instance = new SystemInfo(ctx);
				}
			}
		}
		return instance;
	}

	public String getToken(){
		return sp.getStringValue(Constants.SHARED_PRENFENCE_TOKEN,"");
	}
	public void setToken(String token){
		sp.putStringValue(Constants.SHARED_PRENFENCE_TOKEN, token);
		sp.commit();
	}
	
	public String getMemberid() {
		return sp.getStringValue(Constants.SHARED_PRENFENCE_MEMBERID, "");
	}
	public void setMemberid(String memberid) {
		sp.putStringValue(Constants.SHARED_PRENFENCE_MEMBERID, memberid);
		sp.commit();
	}
	public String getLoginid() {
		return sp.getStringValue(Constants.SHARED_PRENFENCE_LOGINID, "");
	}
	public void setLoginid(String loginid) {
		sp.putStringValue(Constants.SHARED_PRENFENCE_LOGINID, loginid);
		sp.commit();
	}
	public String getAccount() {
		return sp.getStringValue(Constants.SHARED_PRENFENCE_ACCOUNT, "");
	}
	public void setAccount(String account) {
		sp.putStringValue(Constants.SHARED_PRENFENCE_ACCOUNT, account);
		sp.commit();
	}
	public String getPassword() {
		return sp.getStringValue(Constants.SHARED_PRENFENCE_PASSWORD, "");
	}
	public void setPassword(String password) {
		sp.putStringValue(Constants.SHARED_PRENFENCE_PASSWORD, password);
		sp.commit();
	}
	public String getEmail() {
		return sp.getStringValue(Constants.SHARED_PRENFENCE_EMAIL, "");
	}
	public void setEmail(String email) {
		sp.putStringValue(Constants.SHARED_PRENFENCE_EMAIL, email);
		sp.commit();
	}
	public String getPhone() {
		return sp.getStringValue(Constants.SHARED_PRENFENCE_PHONE, "");
	}
	public void setPhone(String phone) {
		sp.putStringValue(Constants.SHARED_PRENFENCE_PHONE, phone);
		sp.commit();
	}
	public String getUserName() {
		return sp.getStringValue(Constants.SHARED_PRENFENCE_USERNAME, "");
	}
	public void setUserName(String userName) {
		sp.putStringValue(Constants.SHARED_PRENFENCE_USERNAME, userName);
		sp.commit();
	}
	public String getPoints() {
		return sp.getStringValue(Constants.SHARED_PRENFENCE_POINTS, "");
	}
	public void setPoints(String points) {
		sp.putStringValue(Constants.SHARED_PRENFENCE_POINTS, points);
		sp.commit();
	}

	//红包
	public String getWallet() {
		return sp.getStringValue(Constants.SHARED_PRENFENCE_WALLET, "");
	}
	public void setWallet(String wallet) {
		sp.putStringValue(Constants.SHARED_PRENFENCE_POINTS, wallet);
		sp.commit();
	}

	//优惠券
	public String getCoupon() {
		return sp.getStringValue(Constants.SHARED_PRENFENCE_COUPON, "");
	}
	public void setCoupon(String coupon) {
		sp.putStringValue(Constants.SHARED_PRENFENCE_POINTS, coupon);
		sp.commit();
	}

	public boolean isLogin(){
		String memberid = sp.getStringValue(Constants.SHARED_PRENFENCE_MEMBERID, "");
		if(memberid==null || memberid.equals("")){
			return false;
		}
		return true;
	}
}
