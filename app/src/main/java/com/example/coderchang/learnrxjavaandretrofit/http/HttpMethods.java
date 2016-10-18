package com.example.coderchang.learnrxjavaandretrofit.http;

import com.example.coderchang.learnrxjavaandretrofit.entity.HttpResult;
import com.example.coderchang.learnrxjavaandretrofit.entity.Subject;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by coderchang on 16/10/17.
 */
public class HttpMethods {
  private static final String BASE_URL = "https://api.douban.com/v2/movie/";
  private Retrofit retrofit;
  private MovieService movieService;
  private HttpMethods() {
    OkHttpClient.Builder builder = new OkHttpClient.Builder();
    builder.connectTimeout(5, TimeUnit.SECONDS);
    retrofit = new Retrofit.Builder().client(builder.build())
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
        .build();
    movieService = retrofit.create(MovieService.class);

  }

  private static class SingletonHolder{
    private static final HttpMethods INSTANCE = new HttpMethods();
  }

  public static HttpMethods getInstance() {
    return SingletonHolder.INSTANCE;
  }

  public void getTopMovie(Subscriber<List<Subject>> subscriber, int start, int count) {
    movieService.getTopMovie(start, count)
        .map(new HttpResultFunc<List<Subject>>())
        .subscribeOn(Schedulers.io())
        .unsubscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(subscriber);
  }

  private class HttpResultFunc<T> implements Func1<HttpResult<T>, T> {
    @Override public T call(HttpResult<T> httpResult) {
      if (httpResult.getCount() == 0) {
        throw new ApiException(100);
      }
      return httpResult.getSubjects();
    }
  }

}
