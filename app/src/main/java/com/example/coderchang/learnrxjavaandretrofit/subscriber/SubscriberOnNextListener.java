package com.example.coderchang.learnrxjavaandretrofit.subscriber;

/**
 * Created by coderchang on 16/10/18.
 */
public interface SubscriberOnNextListener<T> {
  void onNext(T t);
}
