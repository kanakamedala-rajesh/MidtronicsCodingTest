package com.rajesh.midtronicscodingtest.ui;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.rajesh.midtronicscodingtest.R;
import com.rajesh.midtronicscodingtest.ui.CountriesAdapter.CountriesViewHolder;
import com.rajesh.midtronicscodingtest.ui.CountriesFragment.CountryClickListener;
import java.util.List;

public class CountriesAdapter extends RecyclerView.Adapter<CountriesViewHolder> {

  private String TAG = this.getClass().getSimpleName();
  private List<String> countries;
  private CountryClickListener mListener;

  public CountriesAdapter(List<String> items, CountryClickListener listener) {
    countries = items;
    mListener = listener;
  }

  @Override
  public CountriesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_counties, parent, false);
    return new CountriesViewHolder(view);
  }

  @Override
  public void onBindViewHolder(final CountriesViewHolder holder, int position) {
    if (null != holder) {
      holder.country = countries.get(position);
      holder.mIdView.setText("" + (position + 1));
      holder.mContentView.setText(countries.get(position));

      holder.mView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          if (null != mListener) {
            mListener.onCountrySelected(holder.country);
          }
        }
      });
    } else {
      Log.e(TAG, "onBindViewHolder: view holder can't be null");
    }
  }

  @Override
  public int getItemCount() {
    if (countries != null) {
      return countries.size();
    } else {
      return 0;
    }
  }

  public class CountriesViewHolder extends RecyclerView.ViewHolder {

    public final View mView;
    public final TextView mIdView;
    public final TextView mContentView;
    private String country;

    public CountriesViewHolder(View view) {
      super(view);
      mView = view;
      mIdView = (TextView) view.findViewById(R.id.item_number);
      mContentView = (TextView) view.findViewById(R.id.content);
    }

    @Override
    public String toString() {
      return super.toString() + " '" + mContentView.getText() + "'";
    }
  }
}
