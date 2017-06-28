package com.itheima.android50.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.itheima.android50.R;

public class BaseFragment extends Fragment implements OnPressBack{

	protected View mRootView;
	protected View mDemoView;
	protected WebView mWebView;
	protected boolean isDemoShow = true;
	private ProgressBar mPb;
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		if (mRootView == null) {
			mRootView = initView();
			mDemoView = mRootView.findViewById(R.id.demo);
			mWebView = (WebView) mRootView.findViewById(R.id.web);
			mPb = (ProgressBar) mRootView.findViewById(R.id.pb);
			if(mWebView != null) {
				mWebView.getSettings().setDisplayZoomControls(false);
				WebSettings webSettings = mWebView.getSettings();
				webSettings.setJavaScriptEnabled(true);
				if(mPb != null) {
					mWebView.setWebChromeClient(new WebChromeClient() {
						@Override
						public void onProgressChanged(WebView view, int newProgress) {
							if (newProgress == 100) {
								mPb.setVisibility(View.INVISIBLE);
							} else {
								if (!isDemoShow && View.INVISIBLE == mPb.getVisibility()) {
									mPb.setVisibility(View.VISIBLE);
								}
								mPb.setProgress(newProgress);
							}
							super.onProgressChanged(view, newProgress);
						}

					});
				}
				mWebView.loadUrl(getUrl());
			}
		}
		if(mWebView != null) {
			refreshView();
		}
		//Toast.makeText(getActivity(), isDemoShow + "", Toast.LENGTH_SHORT).show();
		return mRootView;
	}

	protected View initView() {
		return null;
	}

	protected void refreshView() {
		mDemoView.setVisibility(isDemoShow ? View.VISIBLE : View.INVISIBLE);
		mWebView.setVisibility(isDemoShow ? View.INVISIBLE : View.VISIBLE);
		if(mPb != null) {
			mPb.setVisibility(isDemoShow ? View.INVISIBLE : View.VISIBLE);
		}
	}

	public boolean onOptionsItemSelected(MenuItem menu) {
		if (menu.getItemId() == R.id.action_example) {
			isDemoShow = !isDemoShow;
			refreshView();
			return true;
		}
		return false;
	}

	public boolean onCreateOptionsMenu(Menu menu) {
		return true;
	}

	public String getUrl() {
		return null;
	}

	@Override
	public void onBack() {

		if (mWebView != null && mWebView.canGoBack()) {
				mWebView.goBack();
			} else {
//				if ((System.currentTimeMillis() - exitTime) > 2000) {
//					Toast.makeText(getApplicationContext(), "再按一次退出程序",
//							Toast.LENGTH_SHORT).show();
//					exitTime = System.currentTimeMillis();
//				} else {
					getActivity().onBackPressed();
//				}

			}
		}

}
