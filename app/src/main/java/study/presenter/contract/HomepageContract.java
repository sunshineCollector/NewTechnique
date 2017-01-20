package artframe.study.sunshine.artframe.presenter.contract;

import artframe.study.sunshine.artframe.base.BasePresenter;
import artframe.study.sunshine.artframe.base.BaseView;
import artframe.study.sunshine.artframe.ui.home.adapter.HomepageAdapter;

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
