package com.example.coderchang.learnrxjavaandretrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.example.coderchang.learnrxjavaandretrofit.entity.MovieEntity;
import com.example.coderchang.learnrxjavaandretrofit.http.MovieService;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
  @Bind(R.id.textView) TextView tvResult;
  @Bind(R.id.button) Button btnClick;
  public static final String BASE_URL = "https://api.douban.com/v2/movie/";
  private Retrofit retrofit;
  private OkHttpClient.Builder builder;
  private MovieService movieService;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);
    builder = new OkHttpClient.Builder();
    builder.connectTimeout(5, TimeUnit.SECONDS);
  }

  @OnClick(R.id.button) public void onClick() {
    retrofit = new Retrofit.Builder().client(builder.build())
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
        .build();
    movieService = retrofit.create(MovieService.class);
    movieService.getTopMovies(0, 10)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Action1<MovieEntity>() {
          @Override public void call(MovieEntity movieEntity) {
            tvResult.setText(movieEntity.toString());
          }
        });
  }
}
