package kr.co.landvibe.handicraft.schedule;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import kr.co.landvibe.handicraft.R;
import kr.co.landvibe.handicraft.utils.LogUtil;

public class ScheduleFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtil.d("onCreate()");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_schedule, container, false);
        ButterKnife.bind(this, view);
        LogUtil.d("onCreateView()");
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        LogUtil.d("onActivityCreated()");

    }
}
