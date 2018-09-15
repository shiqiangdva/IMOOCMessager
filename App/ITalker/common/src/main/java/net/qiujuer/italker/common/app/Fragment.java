package net.qiujuer.italker.common.app;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by shiqiang on 2018/9/15.
 */

public abstract class Fragment extends android.support.v4.app.Fragment {

    protected View mRoot;
    protected Unbinder mRootUnbinder;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        initArgs(getArguments());

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (mRoot == null) {
            int layId = getContentLayout();
            // 初始化当前的跟布局
            View root = inflater.inflate(layId, container, false);
            initWidget(root);

            mRoot = root;
        } else {
            if (mRoot.getParent() != null) {
                // 把当前Root从其父控件中移除
                ((ViewGroup) mRoot.getParent()).removeView(mRoot);
            }
        }

        return mRoot;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // 当View创建完成后, 初始化数据
        initData();
    }

    /**
     * 初始化相关参数
     */
    protected void initArgs(Bundle bundle) {

    }

    /**
     * 得到当前界面资源文件的id
     *
     * @return 资源文件id
     */
    @LayoutRes
    protected abstract int getContentLayout();

    /**
     * 初始化控件
     *
     * @param root
     */
    protected void initWidget(View root) {
        mRootUnbinder = ButterKnife.bind(this, root);
    }

    /**
     * 初始化数据
     */
    protected void initData() {

    }

    /**
     * 返回按键触发时调用
     *
     * @return 返回true代表我已经处理返回逻辑, Activity不用自己finish
     * 返回false代表我没有处理逻辑, Activi自己走自己的逻辑
     */
    public boolean onBackPressed() {
        return false;
    }

}
