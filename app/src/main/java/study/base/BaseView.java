package study.base;

/**
 * Created by xiaofeng on 2016/12/20.
 * base view
 */

public interface BaseView {
    void showError(String msg);

    void showNetWorkDisconnection();

    void setRefreshing(boolean refreshing);
}
