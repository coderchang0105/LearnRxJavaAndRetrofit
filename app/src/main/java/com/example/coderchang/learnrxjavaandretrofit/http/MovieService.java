package com.example.coderchang.learnrxjavaandretrofit.http;

import com.example.coderchang.learnrxjavaandretrofit.entity.HttpResult;
import com.example.coderchang.learnrxjavaandretrofit.entity.Subject;
import java.util.List;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by coderchang on 16/10/17.
 */
public interface MovieService {
  @GET("top250") Observable<HttpResult<List<Subject>>> getTopMovie(@Query("start") int start,@Query("count") int count);
}
