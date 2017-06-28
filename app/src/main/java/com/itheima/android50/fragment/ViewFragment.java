package com.itheima.android50.fragment;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.itheima.android50.R;
import com.itheima.android50.activity.ScrollingActivity;
import com.itheima.android50.activity.ToolbarActivity;

public class ViewFragment extends BaseFragment implements View.OnClickListener{

	@Override
	protected View initView() {
		View v = View.inflate(getActivity(),R.layout.fragment_view,null);
		Button toolbar = (Button) v.findViewById(R.id.toolbar);
		toolbar.setOnClickListener(this);
		Button toolbar1 = (Button) v.findViewById(R.id.toolbar1);
		toolbar1.setOnClickListener(this);
		return v;
	}


	public boolean onOptionsItemSelected(MenuItem menu) {

		return false;
	}

	public boolean onCreateOptionsMenu(Menu menu) {
		return true;
	}

	@Override
	public String getUrl() {
		return null;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.toolbar:
				startActivity(new Intent(getActivity(), ToolbarActivity.class));
				break;
			case R.id.toolbar1:
				startActivity(new Intent(getActivity(), ScrollingActivity.class));
				break;
		}
	}
}
