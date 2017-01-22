package study.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import study.app.App;
import study.utils.NetUtils;

/**
 * Created by xiaofeng on 2016/12/20.
 * base activity
 */

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity implements BaseView {
    @Inject
    protected T mPresenter;
    protected Activity mActivity;
    private Unbinder mUnBinder;
    private boolean mNeedInitCacheData;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((getLayout()));
        mUnBinder = ButterKnife.bind(this);
        mActivity = this;
        mPresenter=getPresenter();
        if (mPresenter != null)
            mPresenter.attachView(this);
        App.getInstance().addActivity(this);
        initConfig();
        initEvent();
        mNeedInitCacheData = isNeedLoadCacheData();
        if (mNeedInitCacheData) {
            mPresenter.initCacheData();
        }
        if (NetUtils.isNetWorkConnected(this)) {
            mPresenter.initServerData();
        } else {
            if (!mNeedInitCacheData)
                mPresenter.initCacheData();
        }
    }

    protected abstract int getLayout();

    protected abstract void initConfig();

    protected abstract void initEvent();

    protected abstract T  getPresenter();

    protected abstract boolean isNeedLoadCacheData();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null)
            mPresenter.detachView();
        mUnBinder.unbind();
        App.getInstance().removeActivity(this);
    }
}
