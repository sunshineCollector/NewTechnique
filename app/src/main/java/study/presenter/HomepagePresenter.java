package artframe.study.sunshine.artframe.presenter;

import android.os.SystemClock;

import java.util.ArrayList;
import java.util.Random;

import artframe.study.sunshine.artframe.R;
import artframe.study.sunshine.artframe.model.bean.FruitBean;
import artframe.study.sunshine.artframe.presenter.contract.HomepageContract;
import artframe.study.sunshine.artframe.ui.home.adapter.HomepageAdapter;
import artframe.study.sunshine.artframe.ui.home.activity.HomepageActivity;

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
