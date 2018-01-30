package com.mmbao.saas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.Toast;

import com.mmbao.saas.base.BaseMainActivity;
import com.mmbao.saas.custom.MyRadioGroup;
import com.mmbao.saas.view.LoginActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseMainActivity {


    @BindView(R.id.fragmentContent)
    FrameLayout fragmentContent;
    @BindView(R.id.rbHome)
    RadioButton rbHome;
    @BindView(R.id.rbBuy)
    RadioButton rbBuy;
    @BindView(R.id.rbCategory)
    RadioButton rbCategory;
    @BindView(R.id.rbCart)
    RadioButton rbCart;
    @BindView(R.id.btn_msg)
    Button btnMsg;
    @BindView(R.id.rbUserCenter)
    RadioButton rbUserCenter;
    @BindView(R.id.rg_tab_bar)
    MyRadioGroup rgTabBar;
    private int count = 99;

    @Override
    public void setContentView() {
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void init() {
        setCartMsg(btnMsg);
    }

    /**
     * 显示购物车上的数量
     */
    private void setCartMsg(Button btnMsg) {

        if (TextUtils.isEmpty(count + "") || count == 0) {
            btnMsg.setVisibility(View.GONE);
        } else {
            btnMsg.setVisibility(View.VISIBLE);
            if (count > 99) {
                count = 99;
                btnMsg.setText("" + count);
            } else {
                btnMsg.setText("" + count);
            }
        }
    }

    @OnClick({R.id.rbHome, R.id.rbBuy, R.id.rbCategory, R.id.rbCart, R.id.rbUserCenter})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rbHome:
                break;
            case R.id.rbBuy:
                break;
            case R.id.rbCategory:
                break;
            case R.id.rbCart:
                break;
            case R.id.rbUserCenter:
                Toast.makeText(this, "agaehygaet a a", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
                break;
        }
    }
}
