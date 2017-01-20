package artframe.study.sunshine.artframe.presenter.contract;

import artframe.study.sunshine.artframe.base.BasePresenter;
import artframe.study.sunshine.artframe.base.BaseView;

/**
 * Created by xiaofeng on 2017/1/10.
 */

public interface FruitContract {

    interface View extends BaseView {
    }


    interface Presenter extends BasePresenter<View> {
    }
}
