package com.helloword.util;

import android.app.Dialog;
import android.content.Context;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.helloword.R;

public class DialogFactory {
	
	public static Dialog creatRequestDialog(final Context context, String tip) {

		final Dialog dialog = new Dialog(context, R.style.dialog);
		dialog.setContentView(R.layout.dialog);
		Window window = dialog.getWindow();
		WindowManager.LayoutParams lp = window.getAttributes();
		int width = ScreenUtil.getScreenWidth(context);
		lp.width = (int) (0.6 * width);
		TextView titleTxtv = (TextView) dialog.findViewById(R.id.load);
		
		if (tip == null || tip.length() == 0) {
			titleTxtv.setText(R.string.sending_request);
		} else {
			titleTxtv.setText(tip);
		}

		return dialog;
	}
}
