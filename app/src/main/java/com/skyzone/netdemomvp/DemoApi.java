package com.skyzone.netdemomvp;

import com.skyzone.netdemomvp.data.Result;
import com.skyzone.netdemomvp.data.bean.MeiZi;
import com.skyzone.netdemomvp.data.bean.Video;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by Skyzone on 11/3/2016.
 */
public interface DemoApi {

    @GET("data/福利/800/{page}")
    Observable<Result<List<MeiZi>>> getData(@Path("page") int page);

    @GET("data/休息视频/800/{page}")
    Observable<Result<List<Video>>> getVideo(@Path("page") int page);
}
