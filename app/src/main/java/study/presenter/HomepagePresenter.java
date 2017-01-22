package study.presenter;

import android.os.SystemClock;
import android.util.Log;

import java.util.ArrayList;
import java.util.Random;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import study.model.bean.FruitBean;
import study.presenter.contract.HomepageContract;
import study.sunshine.newTechnique.R;
import study.ui.home.adapter.HomepageAdapter;

/**
 * Created by xiaofeng on 2016/12/20.
 */

public class HomepagePresenter implements HomepageContract.Presenter {
    private static final String TAG = "HomepagePresenter";
    private HomepageContract.View mView;

    private FruitBean[] fruits = {new FruitBean("Apple", R.drawable.apple),
            new FruitBean("Banana", R.drawable.banana), new FruitBean("Pear", R.drawable.pear),
            new FruitBean("Grape", R.drawable.pear), new FruitBean("pineapple", R.drawable.pineapple),
            new FruitBean("strawberry", R.drawable.strawberry), new FruitBean("mango", R.drawable.mango)};
    private ArrayList<FruitBean> fruitList = new ArrayList<>();
    private HomepageAdapter mHomepageAdapter;

    @Override
    public void refreshFruits() {
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                Log.d(TAG, "subscribe: "+Thread.currentThread().getName());
                SystemClock.sleep(1500);
                initFruitData();
                e.onNext("success");
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                mView.refreshFruitAdapter(mHomepageAdapter);
                mView.setRefreshing(false);
            }
        });
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
