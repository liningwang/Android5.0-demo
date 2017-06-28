package com.itheima.android50.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.itheima.android50.R;
import com.itheima.android50.activity.nestedScroll.nested.NestedActivity;
import com.itheima.android50.activity.nestedScroll.nested1.Nested1Activity;

public class NestedScrollingFragment extends BaseFragment implements View.OnClickListener{

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
		return "http://www.jianshu.com/p/5f085a944650";
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.nested:
				startActivity(new Intent(getActivity(), NestedActivity.class));
				break;
			case R.id.nested1:
				startActivity(new Intent(getActivity(), Nested1Activity.class));
				break;
		}
	}
}
