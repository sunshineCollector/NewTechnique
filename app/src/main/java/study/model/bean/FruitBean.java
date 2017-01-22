package study.model.bean;

import android.support.annotation.IdRes;

/**
 * Created by xiaofeng on 2016/12/29.
 */

public class FruitBean {
    public String name;

    @IdRes
    public int imageID;

    public FruitBean(String name, int imageID) {
        this.name = name;
        this.imageID = imageID;
    }
}
