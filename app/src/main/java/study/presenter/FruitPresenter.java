package artframe.study.sunshine.artframe.presenter;


import artframe.study.sunshine.artframe.presenter.contract.FruitContract;

/**
 * Created by xiaofeng on 2017/1/10.
 */

public class FruitPresenter implements FruitContract.Presenter {
    private FruitContract.View mView;

    @Override
    public void attachView(FruitContract.View view) {
        mView = view;
    }

    @Override
    public void detachView() {
        mView = null;
    }

    @Override
    public void initServerData() {

    }

    @Override
    public void initCacheData() {

    }
}
