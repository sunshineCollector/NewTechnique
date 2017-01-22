package study.presenter.contract;

import study.base.BasePresenter;
import study.base.BaseView;
import study.ui.home.adapter.HomepageAdapter;

/**
 * Created by xiaofeng on 2016/12/20.
 */

public interface HomepageContract {

    interface View extends BaseView {
        void setFruitAdapter(HomepageAdapter adapter);

        void refreshFruitAdapter(HomepageAdapter adapter);
    }


    interface Presenter extends BasePresenter<View> {

        void refreshFruits();

        void initFruitData();

    }
}
