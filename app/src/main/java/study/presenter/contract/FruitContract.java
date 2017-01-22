package study.presenter.contract;

import study.base.BasePresenter;
import study.base.BaseView;

/**
 * Created by xiaofeng on 2017/1/10.
 */

public interface FruitContract {

    interface View extends BaseView {
    }


    interface Presenter extends BasePresenter<View> {
    }
}
