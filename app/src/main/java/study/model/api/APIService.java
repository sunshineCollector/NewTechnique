package study.model.api;

import io.reactivex.Observable;
import retrofit2.http.POST;
import retrofit2.http.Query;
import study.model.bean.BookBean;

/**
 * Created by xiaofeng on 2017/1/22.
 */


public interface APIService {

    @POST("LoginBean")
    Observable<BookBean> login(@Query("data") String jb);

}

