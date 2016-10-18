package com.example.coderchang.learnrxjavaandretrofit.progress;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;

/**
 * Created by coderchang on 16/10/18.
 */
public class ProgressDialogHandler extends Handler{
  public static final int SHOW_PROGRESS_DIALOG = 1;
  public static final int DISMISS_PROGRESS_DIALOG = 2;
  private ProgressDialog progressDialog;
  private Context context;
  private boolean cancelable;
  private ProgressCancelListener progressCancelListener;

  public ProgressDialogHandler(boolean cancelable, Context context,
      ProgressCancelListener progressCancelListener) {
    super();
    this.cancelable = cancelable;
    this.context = context;
    this.progressCancelListener = progressCancelListener;
  }

  private void initProgressDialog() {
    if (progressDialog == null) {
      progressDialog = new ProgressDialog(context);
      progressDialog.setCancelable(cancelable);
      if (cancelable) {
        progressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
          @Override public void onCancel(DialogInterface dialog) {
            progressCancelListener.onCancelProgress();
          }
        });
      }
      if (!progressDialog.isShowing()) {
        progressDialog.show();
      }
    }
  }

  private void dismissProgressDialog() {
    if (progressDialog != null) {
      progressDialog.dismiss();
    }
  }

  @Override public void handleMessage(Message msg) {
    super.handleMessage(msg);
    switch (msg.what) {
      case SHOW_PROGRESS_DIALOG:
        initProgressDialog();
        break;
      case DISMISS_PROGRESS_DIALOG:
        dismissProgressDialog();
        break;
    }
  }
}
