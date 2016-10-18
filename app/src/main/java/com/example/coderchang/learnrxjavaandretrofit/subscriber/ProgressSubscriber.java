package com.example.coderchang.learnrxjavaandretrofit.subscriber;

import android.content.Context;
import android.widget.Toast;
import com.example.coderchang.learnrxjavaandretrofit.progress.ProgressCancelListener;
import com.example.coderchang.learnrxjavaandretrofit.progress.ProgressDialogHandler;
import rx.Subscriber;

/**
 * Created by coderchang on 16/10/18.
 */
public class ProgressSubscriber<T> extends Subscriber<T> implements ProgressCancelListener{
  private SubscriberOnNextListener mOnNextListener;
  private ProgressDialogHandler mDialogHandler;
  private Context mContext;

  public ProgressSubscriber(Context mContext, SubscriberOnNextListener mOnNextListener) {
    this.mContext = mContext;
    this.mOnNextListener = mOnNextListener;
    mDialogHandler = new ProgressDialogHandler(true, mContext, this);
  }

  @Override public void onStart() {
    showProgressDialog();
  }

  @Override public void onCompleted() {
    dismissProgressDialog();
    Toast.makeText(mContext, "onCompleted", Toast.LENGTH_SHORT).show();
  }

  @Override public void onError(Throwable e) {
    dismissProgressDialog();
    Toast.makeText(mContext, "error:" + e.getMessage(), Toast.LENGTH_SHORT).show();
  }

  @Override public void onNext(T t) {
    mOnNextListener.onNext(t);
  }

  @Override public void onCancelProgress() {
    if (!this.isUnsubscribed()) {
      this.unsubscribe();
    }
  }

  private void showProgressDialog() {
    if (mDialogHandler != null) {
      mDialogHandler.obtainMessage(ProgressDialogHandler.SHOW_PROGRESS_DIALOG).sendToTarget();
    }
  }

  private void dismissProgressDialog() {
    if (mDialogHandler != null) {
      mDialogHandler.obtainMessage(ProgressDialogHandler.DISMISS_PROGRESS_DIALOG).sendToTarget();
      mDialogHandler = null;
    }
  }
}
