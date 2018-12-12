package com.rajesh.midtronicscodingtest;

import com.rajesh.midtronicscodingtest.model.CountryDetail;
import java.util.List;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

public interface CountryDetailsService {
  @GET("name/{countryName}")
  Observable<List<CountryDetail>> getCountryDetails(@Path("countryName") String countryName);
}
