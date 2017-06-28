package com.itheima.android50.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.itheima.android50.R;
import com.itheima.android50.activity.Behavior.activity.BottomSheetActivity;
import com.itheima.android50.activity.Behavior.activity.MyBehaviorActivity;
import com.itheima.android50.activity.nestedScroll.nested.NestedActivity;
import com.itheima.android50.activity.nestedScroll.nested1.Nested1Activity;

public class BeheivorFragment extends BaseFragment implements View.OnClickListener{

	@Override
	protected View initView() {
		View v = View.inflate(getActivity(),R.layout.fragment_nested_scrolling, null);
		Button nested = (Button) v.findViewById(R.id.nested);
		Button nested1 = (Button) v.findViewById(R.id.nested1);
		nested.setOnClickListener(this);
		nested1.setOnClickListener(this);
		return v;
	}

	@Override
	public String getUrl() {
		return "file:///android_asset/jqm.html";
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.nested:
				startActivity(new Intent(getActivity(), BottomSheetActivity.class));
				break;
			case R.id.nested1:
				startActivity(new Intent(getActivity(), MyBehaviorActivity.class));
				break;
		}
	}
}
