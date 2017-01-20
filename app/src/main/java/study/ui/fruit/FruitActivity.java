package artframe.study.sunshine.artframe.ui.fruit;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import artframe.study.sunshine.artframe.R;
import artframe.study.sunshine.artframe.base.BaseActivity;
import artframe.study.sunshine.artframe.presenter.FruitPresenter;
import artframe.study.sunshine.artframe.presenter.contract.FruitContract;
import butterknife.BindView;

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

    }

    @Override
    protected void initEvent() {
        Intent intent = getIntent();
        String fruitName = intent.getStringExtra(FRUIT_NAME);
        int fruitImageId = intent.getIntExtra(FRUIT_IMAEG_ID, 0);
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null)
            actionBar.setDisplayHomeAsUpEnabled(true);
        mCollapsingToolbar.setTitle(fruitName);
        Glide.with(this).load(fruitImageId).into(mImvFruitView);
        mTvFruitContent.setText(generateFruitContent(fruitName));
    }

    @Override
    protected FruitPresenter getPresenter() {
        return new FruitPresenter();
    }

    @Override
    protected boolean isNeedLoadCacheData() {
        return false;
    }

    private String generateFruitContent(String fruitName) {
        StringBuilder fruitContent = new StringBuilder();
        for (int i = 0; i < 500; i++) {
            fruitContent.append(fruitName);
        }
        return fruitContent.toString();
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
}
