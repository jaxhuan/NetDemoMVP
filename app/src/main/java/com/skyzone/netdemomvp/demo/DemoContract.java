package com.skyzone.netdemomvp.demo;

import com.skyzone.netdemomvp.BasePresenter;
import com.skyzone.netdemomvp.BaseView;
import com.skyzone.netdemomvp.data.bean.MeiZi;

import java.util.List;

/**
 * Created by Skyzone on 10/31/2016.
 */
public interface DemoContract {

    interface View extends BaseView<Presenter> {

        void refresh(List<MeiZi> meiZiList);
    }

    interface Presenter extends BasePresenter {

    }
}
