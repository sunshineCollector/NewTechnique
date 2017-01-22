package study.presenter;

import android.os.SystemClock;

import java.util.ArrayList;
import java.util.Random;

import study.model.bean.FruitBean;
import study.presenter.contract.HomepageContract;
import study.sunshine.newTechnique.R;
import study.ui.home.activity.HomepageActivity;
import study.ui.home.adapter.HomepageAdapter;

/**
 * Created by xiaofeng on 2016/12/20.
 */

public class HomepagePresenter implements HomepageContract.Presenter {
    private HomepageContract.View mView;

    private FruitBean[] fruits = {new FruitBean("Apple", R.drawable.apple),
            new FruitBean("Banana", R.drawable.banana), new FruitBean("Pear", R.drawable.pear),
            new FruitBean("Grape", R.drawable.pear), new FruitBean("pineapple", R.drawable.pineapple),
            new FruitBean("strawberry", R.drawable.strawberry), new FruitBean("mango", R.drawable.mango)};
    private ArrayList<FruitBean> fruitList = new ArrayList<>();
    private HomepageAdapter mHomepageAdapter;

    @Override
    public void refreshFruits() {
        new Thread(() -> {
            SystemClock.sleep(1500);
            ((HomepageActivity) mView).runOnUiThread(() -> {
                        initFruitData();
                        mView.refreshFruitAdapter(mHomepageAdapter);
                        mView.setRefreshing(false);
                    }
            );
        }).start();
    }

    @Override
    public void initFruitData() {
        fruitList.clear();
        for (int i = 0; i < 50; i++) {
            fruitList.add(fruits[new Random().nextInt(fruits.length)]);
        }
    }

    @Override
    public void attachView(HomepageContract.View view) {
        mView = view;
    }

    @Override
    public void detachView() {
        this.mView = null;
    }

    @Override
    public void initServerData() {

    }

    @Override
    public void initCacheData() {
        initFruitData();
        mHomepageAdapter = new HomepageAdapter(fruitList);
        mView.setFruitAdapter(mHomepageAdapter);
    }
}
