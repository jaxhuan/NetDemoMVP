package com.skyzone.netdemomvp.demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.skyzone.netdemomvp.R;
import com.skyzone.netdemomvp.data.bean.MeiZi;
import com.skyzone.netdemomvp.view.dialog_loading;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Skyzone on 10/31/2016.
 */
public class DemoFragment extends Fragment implements DemoContract.View {

    @BindView(R.id.fragment_demo_recycler_view)
    RecyclerView mFragmentDemoRecyclerView;

    private DemoContract.Presenter mPresenter;

    private dialog_loading mDialog_loading;

    private DemoGrilAdapter mAdapter;
    private List<MeiZi> mMeiZiList;

    public static DemoFragment newInstance() {
        DemoFragment demoFragment = new DemoFragment();
        return demoFragment;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_demo, container, false);
        ButterKnife.bind(this, root);
        setHasOptionsMenu(false);

        mDialog_loading = new dialog_loading(this.getActivity());

        mMeiZiList = new ArrayList<>();
        mAdapter = new DemoGrilAdapter(mMeiZiList);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        mFragmentDemoRecyclerView.setLayoutManager(layoutManager);
        mFragmentDemoRecyclerView.setAdapter(mAdapter);

        return root;
    }

    @Override
    public void onPause() {
        super.onPause();
        mPresenter.unSubscribe();
    }

    @Override
    public void setPresenter(DemoContract.Presenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public void showLoading(boolean loading) {
        if (null != mDialog_loading) {
            if (loading)
                mDialog_loading.show();
            else
                mDialog_loading.cancel();
        }
    }

    @Override
    public void refresh(List<MeiZi> meiZiList) {
        mMeiZiList.clear();
        mMeiZiList.addAll(meiZiList);
        mAdapter.notifyDataSetChanged();
    }
}
