package study.ui.home.activity;

import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

import java.util.List;
import butterknife.BindView;
import butterknife.OnClick;
import study.base.BaseActivity;
import study.model.bean.BookBean;
import study.presenter.HomepagePresenter;
import study.presenter.contract.HomepageContract;
import study.sunshine.newTechnique.R;
import study.ui.home.adapter.HomepageAdapter;

public class HomepageActivity extends BaseActivity<HomepagePresenter> implements HomepageContract.View {
    private static final String TAG = "LoginActivity";


    @BindView(R.id.toolbar)
    public Toolbar mToolbar;

    @BindView(R.id.drawer_layout)
    public DrawerLayout mDrawerLayout;

    @BindView(R.id.nav_view)
    public NavigationView mNavView;

    @BindView(R.id.recycler_view)
    public RecyclerView mRecyclerView;

    @BindView(R.id.swipe_refresh)
    public SwipeRefreshLayout mSwipeRefresh;

    @OnClick(R.id.btn_create_db)
    public void createDB(View v) {
        Connector.getDatabase();
    }

    @OnClick(R.id.btn_add_data)
    public void addData(View v) {
        BookBean bookBean = new BookBean();
        bookBean.name = "三国";
        bookBean.author = "吴承恩";
        bookBean.pages = 454;
        bookBean.priice = 16.96;
        bookBean.press = "unKnow";
        bookBean.save();
    }

    @OnClick(R.id.btn_add_update)
    public void updateData(View v) {
        BookBean bookBean = new BookBean();
        bookBean.name = "sanguo";
        bookBean.author = "wuchengen";
        bookBean.updateAll("name=? and author=?", "三国", "吴承恩");
    }

    @OnClick(R.id.btn_add_delete)
    public void deleteData(View v) {
        DataSupport.deleteAll(BookBean.class, "pages <?", "500");
    }

    @OnClick(R.id.btn_add_query)
    public void queryData(View v) {
        List<BookBean> books = DataSupport.findAll(BookBean.class);
        Log.d(TAG, "queryData: " + books.get(0));
    }

    @OnClick(R.id.fab)
    public void fabClick(View v) {
        Snackbar.make(v, "FAB Click delete data", Snackbar.LENGTH_LONG).setAction("Undo", (view) ->
                Toast.makeText(getApplicationContext(), "Data restored", Toast.LENGTH_SHORT).show()
        ).show();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void initConfig() {
        setSupportActionBar(mToolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
            supportActionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        }
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        mSwipeRefresh.setColorSchemeResources(R.color.colorPrimary);
        mSwipeRefresh.setOnRefreshListener(() -> mPresenter.refreshFruits());
    }

    @Override
    protected void initEvent() {
        mNavView.setCheckedItem(R.id.nav_call);
        mNavView.setNavigationItemSelectedListener(item -> {
            mDrawerLayout.closeDrawer(GravityCompat.START);
            return true;
        });
    }

    @Override
    protected HomepagePresenter getPresenter() {
        return new HomepagePresenter();
    }

    @Override
    protected boolean isNeedLoadCacheData() {
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.backup:
                Toast.makeText(getApplicationContext(), "backup", Toast.LENGTH_SHORT).show();
                break;
            case R.id.delete:
                Toast.makeText(getApplicationContext(), "delete", Toast.LENGTH_SHORT).show();
                break;
            case R.id.settings:
                Toast.makeText(getApplicationContext(), "settings", Toast.LENGTH_SHORT).show();
                break;
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;
        }
        return true;
    }

    @Override
    public void setRefreshing(boolean refreshing) {
        mSwipeRefresh.setRefreshing(refreshing);
    }

    @Override
    public void setFruitAdapter(HomepageAdapter adapter) {
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    public void refreshFruitAdapter(HomepageAdapter adapter) {
        adapter.notifyDataSetChanged();
        mSwipeRefresh.setRefreshing(false);
    }

    @Override
    public void showError(String msg) {

    }

    @Override
    public void showNetWorkDisconnection() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
