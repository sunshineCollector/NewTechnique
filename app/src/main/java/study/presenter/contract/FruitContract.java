package study.presenter.contract;

import android.support.annotation.IdRes;

import study.base.BasePresenter;
import study.base.BaseView;

/**
 * Created by xiaofeng on 2017/1/10.
 */

public interface FruitContract {

    interface View extends BaseView {
        void setToolbarTitle(String title);
        void setFruitContent(String content);
        String getFruitTitleByIntentKey(String key);
        int getFruitImgIdByIntentKey(String key,int defValue);
        void setFruitViewById(@IdRes int id);
    }


    interface Presenter extends BasePresenter<View> {
        String generateFruitContent(String content);
    }
}
