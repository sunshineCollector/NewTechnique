package study.presenter;


import study.presenter.contract.FruitContract;
import study.ui.fruit.FruitActivity;

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
        String title = mView.getFruitTitleByIntentKey(FruitActivity.FRUIT_NAME);
        mView.setToolbarTitle(title);
        mView.setFruitContent(generateFruitContent(title));
        mView.setFruitViewById(mView.getFruitImgIdByIntentKey(FruitActivity.FRUIT_IMAEG_ID, 0));


    }

    @Override
    public String generateFruitContent(String content) {
        StringBuilder fruitContent = new StringBuilder();
        for (int i = 0; i < 500; i++) {
            fruitContent.append(content);
        }
        return fruitContent.toString();
    }
}
