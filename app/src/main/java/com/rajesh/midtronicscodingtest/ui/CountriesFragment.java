package com.rajesh.midtronicscodingtest.ui;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rajesh.midtronicscodingtest.CountryDetailsService;
import com.rajesh.midtronicscodingtest.MyDialogFragment;
import com.rajesh.midtronicscodingtest.R;
import com.rajesh.midtronicscodingtest.constants.CommonUtil;
import com.rajesh.midtronicscodingtest.model.CountryDetail;
import java.util.Arrays;
import java.util.List;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class CountriesFragment extends Fragment {

  private CountryClickListener countryClickListener;
  private final String TAG = this.getClass().getSimpleName();

  public CountriesFragment() {
    //default empty constructor
  }

  @SuppressWarnings("unused")
  public static CountriesFragment newInstance(int columnCount) {
    return new CountriesFragment();
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_counties_list, container, false);
    ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
    HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
    interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
    OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

    Gson gson = new GsonBuilder()
        .setLenient()
        .create();

    Retrofit retrofit = new Retrofit.Builder()
        .baseUrl(CommonUtil.BASE_URL)
        .client(client)
        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build();

    final CountryDetailsService countryDetailsService = retrofit.create(CountryDetailsService.class);
    countryClickListener = new CountryClickListener() {
      @Override
      public void onCountrySelected(final String country) {
        if (null != country) {
          Observable<List<CountryDetail>> countryDetailsObservable = countryDetailsService.getCountryDetails(country);
          countryDetailsObservable
              .subscribeOn(Schedulers.io())
              .observeOn(AndroidSchedulers.mainThread())
              .subscribe(new Subscriber<List<CountryDetail>>() {
                @Override
                public void onCompleted() {
                  Log.d(TAG, "onCompleted: ");
                }

                @Override
                public void onError(Throwable e) {
                  Log.e(TAG, "onError: ", e);
                }

                @Override
                public void onNext(List<CountryDetail> countryDetails) {
                  Log.d(TAG, "call: " + countryDetails.size());
                  for (CountryDetail item : countryDetails) {
                    MyDialogFragment dialogFragment = MyDialogFragment.newInstance(item.getName(), item.getCapital(), item.getPopulation(), item.getArea(), item.getRegion());
                    dialogFragment.setCancelable(true);
                    if (null != getFragmentManager()) {
                      dialogFragment.show(getFragmentManager(), null);
                    } else {
                      Log.e(TAG, "onNext: fragment manager was null");
                    }
                  }
                }
              });
        }
      }
    };
    // Set the adapter
    if (view instanceof RecyclerView) {
      Context context = view.getContext();
      List<String> countryList = Arrays.asList(getResources().getStringArray(R.array.countries));
      RecyclerView recyclerView = (RecyclerView) view;
      recyclerView.setLayoutManager(new LinearLayoutManager(context));
      recyclerView.setAdapter(new CountriesAdapter(countryList, countryClickListener));
    }
    return view;
  }

  @Override
  public void onDetach() {
    super.onDetach();
    countryClickListener = null;
  }

  public interface CountryClickListener {

    void onCountrySelected(String country);
  }
}
