package study.ui.fruit;

import android.support.annotation.IdRes;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import study.base.BaseActivity;
import study.presenter.FruitPresenter;
import study.presenter.contract.FruitContract;
import study.sunshine.newTechnique.R;

/**
 * Created by xiaofeng on 2017/1/10.
 * FruitActivity
 */

public class FruitActivity extends BaseActivity<FruitPresenter> implements FruitContract.View {
    @BindView(R.id.toolbar)
    public Toolbar mToolbar;
    @BindView(R.id.collapsing_toolbar)
    public CollapsingToolbarLayout mCollapsingToolbar;
    @BindView(R.id.imv_fruit_view)
    public ImageView mImvFruitView;
    @BindView(R.id.tv_fruit_content)
    public TextView mTvFruitContent;

    public static final String FRUIT_NAME = "fruit_name";
    public static final String FRUIT_IMAEG_ID = "fruit_image_id";

    @Override
    protected int getLayout() {
        return R.layout.activity_fruit;
    }

    @Override
    protected void initConfig() {
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null)
            actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected FruitPresenter getPresenter() {
        return new FruitPresenter();
    }

    @Override
    protected boolean isNeedLoadCacheData() {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showError(String msg) {

    }

    @Override
    public void showNetWorkDisconnection() {

    }

    @Override
    public void setRefreshing(boolean refreshing) {

    }

    @Override
    public void setToolbarTitle(String title) {
        mCollapsingToolbar.setTitle(title);
    }

    @Override
    public void setFruitContent(String content) {
        mTvFruitContent.setText(content);
    }

    @Override
    public String getFruitTitleByIntentKey(String key) {
        return getIntent().getStringExtra(key);
    }

    @Override
    public int getFruitImgIdByIntentKey(String key,int defValue) {
        return getIntent().getIntExtra(key,defValue);
    }

    @Override
    public void setFruitViewById(@IdRes int id) {
        Glide.with(this).load(id).into(mImvFruitView);
    }
}
