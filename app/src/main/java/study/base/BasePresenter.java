package study.base;

/**
 * Created by xiaofeng on 2016/12/20.
 * vase presenter
 */

public interface BasePresenter<T extends BaseView> {
    void attachView(T view);

    void detachView();

    void initServerData();

    void initCacheData();
}
