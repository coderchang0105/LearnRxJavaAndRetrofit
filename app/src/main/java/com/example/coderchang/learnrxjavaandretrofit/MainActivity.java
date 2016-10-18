package com.example.coderchang.learnrxjavaandretrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.example.coderchang.learnrxjavaandretrofit.entity.Subject;
import com.example.coderchang.learnrxjavaandretrofit.http.HttpMethods;
import com.example.coderchang.learnrxjavaandretrofit.subscriber.ProgressSubscriber;
import com.example.coderchang.learnrxjavaandretrofit.subscriber.SubscriberOnNextListener;
import java.util.List;

public class MainActivity extends AppCompatActivity {
  @Bind(R.id.textView) TextView tvResult;
  @Bind(R.id.button) Button btnClick;
  private SubscriberOnNextListener getTopMovieOnNext;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);
    getTopMovieOnNext = new SubscriberOnNextListener<List<Subject>>() {
      @Override public void onNext(List<Subject> subjects) {
        tvResult.setText(subjects.toString());
      }
    };
  }

  @OnClick(R.id.button) public void onClick() {
    HttpMethods.getInstance()
        .getTopMovie(new ProgressSubscriber<List<Subject>>(MainActivity.this, getTopMovieOnNext), 0,
            10);
  }
}
