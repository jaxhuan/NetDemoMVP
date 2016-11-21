package com.skyzone.netdemomvp.demo;

import com.elvishew.xlog.XLog;
import com.skyzone.netdemomvp.DemoRetrofit;
import com.skyzone.netdemomvp.data.Result;
import com.skyzone.netdemomvp.data.bean.MeiZi;
import com.skyzone.netdemomvp.data.bean.Video;
import com.skyzone.netdemomvp.util.DateUtil;
import com.skyzone.netdemomvp.util.LogUtil;
import com.skyzone.netdemomvp.util.RxUtil;

import java.util.List;

import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Skyzone on 10/31/2016.
 */
public class DemoPresenter implements DemoContract.Presenter {

    public static final String TAG = DemoPresenter.class.getSimpleName();

    private final DemoContract.View mView;
    private CompositeSubscription mSubscriptions;

    public DemoPresenter(DemoContract.View view) {
        mView = view;

        mView.setPresenter(this);

        mSubscriptions = new CompositeSubscription();
    }

    public void loadData() {
        mView.showLoading(true);

//        DemoRetrofit.getDemoApiInstance().getData(1).enqueue(new Callback<Result<List<MeiZi>>>() {
//            @Override
//            public void onResponse(Call<Result<List<MeiZi>>> call, final Response<Result<List<MeiZi>>> response) {
//                if (response.isSuccessful()) {
//                    DemoRetrofit.getDemoApiInstance().getVideo(1).enqueue(new Callback<Result<List<Video>>>() {
//                        @Override
//                        public void onResponse(Call<Result<List<Video>>> call, Response<Result<List<Video>>> response_child) {
//                            if (response_child.isSuccessful()) {
//                                for (int i = 0; i < response.body().results.size(); i++) {
//                                    final MeiZi meizi = response.body().results.get(i);
//                                    response.body().results.get(i).setDesc(meizi.getDesc() + " " + response_child.body().results.get(i).getDesc());
//                                }
//                                mView.refresh(response.body().results);
//                                mView.showLoading(false);
//                            }
//                        }
//
//                        @Override
//                        public void onFailure(Call<Result<List<Video>>> call, Throwable t) {
//                            Toasts.showShort("get Video failed");
//                            mView.showLoading(false);
//                        }
//                    });
//                }
//            }
//
//            @Override
//            public void onFailure(Call<Result<List<MeiZi>>> call, Throwable t) {
//                mView.showLoading(false);
//                Toasts.showShort("get MeiZi failed");
//            }
//        });

//        DemoRetrofit.getDemoApiInstance().getData(1)
//                .compose(RxUtil.<Result<List<MeiZi>>>normalSchedulers())
//                .subscribe(
//                        new Action1<Result<List<MeiZi>>>() {
//                            @Override
//                            public void call(final Result<List<MeiZi>> listResult) {
//                                DemoRetrofit.getDemoApiInstance().getVideo(1)
//                                        .compose(RxUtil.<Result<List<Video>>>normalSchedulers())
//                                        .subscribe(
//                                                new Action1<Result<List<Video>>>() {
//                                                    @Override
//                                                    public void call(Result<List<Video>> listResult_v) {
//                                                        for (int i = 0; i < listResult_v.results.size(); i++) {
//                                                            final MeiZi meizi = listResult.results.get(i);
//                                                            listResult.results.get(i).setDesc(meizi.getDesc() + "  " + listResult_v.results.get(i).getDesc());
//                                                        }
//                                                        mView.refresh(listResult.results);
//                                                        mView.showLoading(false);
//                                                    }
//                                                },
//                                                new Action1<Throwable>() {
//                                                    @Override
//                                                    public void call(Throwable throwable) {
//                                                        Toasts.showShort("get video failed");
//                                                    }
//                                                }
//                                        );
//                            }
//
//                        },
//                        new Action1<Throwable>() {
//                            @Override
//                            public void call(Throwable throwable) {
//                                mView.showLoading(false);
//                                Toasts.showShort("get MeiZi failed");
//                            }
//                        }
//                );

        String[] names = {"jax", "ling", "irvine"};
        Observable.from(names)
                .compose(RxUtil.<String>normalSchedulers())
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        LogUtil.i(s);
                    }
                });
//
//        Observable.just(1, 2)
//                .lift(new Observable.Operator<String, Integer>() {
//                    @Override
//                    public Subscriber<? super Integer> call(final Subscriber<? super String> subscriber) {
//                        return new Subscriber<Integer>() {
//                            @Override
//                            public void onCompleted() {
//                                subscriber.onCompleted();
//                            }
//
//                            @Override
//                            public void onError(Throwable e) {
//                                subscriber.onError(e);
//                            }
//
//                            @Override
//                            public void onNext(Integer integer) {
//                                subscriber.onNext("" + integer);
//                            }
//                        };
//                    }
//                });


//        Subscription su = DemoRetrofit.getDemoApiInstance().getData(1)
//                .subscribeOn(Schedulers.io())
//                .observeOn(Schedulers.io())
//                .subscribe(new WebTrueAction<Result<List<MeiZi>>>() {
//                    @Override
//                    public void onSuccess(final Result<List<MeiZi>> listResult) {
//                        Subscription su_video = DemoRetrofit.getDemoApiInstance().getVideo(1)
//                                .compose(RxUtil.<Result<List<Video>>>normalSchedulers())
//                                .subscribe(new WebTrueAction<Result<List<Video>>>() {
//                                    @Override
//                                    public void onSuccess(Result<List<Video>> listResult_v) {
//                                        XLog.d("hahhahahhahahhahah");
//                                        for (int i = 0; i < listResult_v.results.size(); i++) {
//                                            final MeiZi meizi = listResult.results.get(i);
//                                            listResult.results.get(i).setDesc(meizi.getDesc() + "  " + listResult_v.results.get(i).getDesc());
//                                        }
//                                        mView.refresh(listResult.results);
//                                        mView.showLoading(false);
//                                    }
//                                }, new WebFalseAction());
//                        mSubscriptions.add(su_video);
//                    }
//                }, new WebFalseAction());

//        mSubscriptions.add(su);


        Subscription s = Observable.zip(DemoRetrofit.getDemoApiInstance().getData(1), DemoRetrofit.getDemoApiInstance().getVideo(1), new Func2<Result<List<MeiZi>>, Result<List<Video>>, List<MeiZi>>() {
            @Override
            public List<MeiZi> call(Result<List<MeiZi>> listResult, Result<List<Video>> listResult2) {
                XLog.d("listResult:" + listResult.results.size() + " listResult2:" + listResult2.results.size());
                for (MeiZi meizi : listResult.results) {
                    for (Video v : listResult2.results) {
                        if (DateUtil.isSameDay(meizi.getPublishedAt(), v.getPublishedAt())) {
                            meizi.setDesc(meizi.getDesc() + "  " + v.getDesc());
                            break;
                        }
                    }
                }
//                for (int i = 0; i < listResult2.results.size(); i++) {
//                    final MeiZi meizi = listResult.results.get(i);
//                    listResult.results.get(i).setDesc(meizi.getDesc() + "  " + listResult2.results.get(i).getDesc());
//                }
                return listResult.results;
            }
        })
                .flatMap(new Func1<List<MeiZi>, Observable<MeiZi>>() {
                    @Override
                    public Observable<MeiZi> call(List<MeiZi> meiZiList) {
                        return Observable.from(meiZiList);
                    }
                })
                .toSortedList(new Func2<MeiZi, MeiZi, Integer>() {
                    @Override
                    public Integer call(MeiZi meiZi, MeiZi meiZi2) {
                        return meiZi2.getPublishedAt().compareTo(meiZi.getPublishedAt());
                    }
                })
                .compose(RxUtil.<List<MeiZi>>normalSchedulers())
                .subscribe(new Action1<List<MeiZi>>() {
                    @Override
                    public void call(List<MeiZi> meiZiList) {
                        XLog.d("hahhahahhahahhaha");
                        mView.refresh(meiZiList);
                        mView.showLoading(false);
                    }
                });

        mSubscriptions.add(s);


        //map;flatmap都是用于将获取的数据A转换成数据B,区别在于flatmap用于做异步耗时处理

    }

    @Override
    public void subscribe() {
        loadData();
    }

    @Override
    public void unSubscribe() {
        mSubscriptions.unsubscribe();
    }
}
