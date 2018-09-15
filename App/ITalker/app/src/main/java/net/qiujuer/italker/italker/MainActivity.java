package net.qiujuer.italker.italker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import net.qiujuer.italker.common.Common;
import net.qiujuer.italker.common.app.Activity;

import butterknife.BindView;

public class MainActivity extends Activity {

    @BindView(R.id.tv_text)
    TextView mTextText;

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initWidget() {
        super.initWidget();
        mTextText.setText("Hello World!!!");
    }
}
