package com.rajesh.midtronicscodingtest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class MyDialogFragment extends DialogFragment {

  private TextView capitalTextView, populationTextView, areaTextView, regionTextView;

  public static MyDialogFragment newInstance(String name, String capital, int population, Double area, String region) {
    MyDialogFragment fragment = new MyDialogFragment();

    Bundle args = new Bundle();
    args.putString("name", name);
    args.putString("capital", capital);
    args.putInt("population", population);
    args.putDouble("area", area);
    args.putString("region", region);
    fragment.setArguments(args);

    return fragment;
  }

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setStyle(DialogFragment.STYLE_NORMAL, android.R.style.Theme_DeviceDefault_Light_Dialog_MinWidth);
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View v = inflater.inflate(R.layout.country_details_dialog, container, false);
    capitalTextView = (TextView) v.findViewById(R.id.tv_capital);
    populationTextView = (TextView) v.findViewById(R.id.tv_population);
    areaTextView = (TextView) v.findViewById(R.id.tv_area);
    regionTextView = (TextView) v.findViewById(R.id.tv_region);

    Bundle bundle = getArguments();
    if (bundle != null) {
      getDialog().setTitle(bundle.getString("name"));
      capitalTextView.setText(bundle.getString("capital"));
      populationTextView.setText("" + bundle.getInt("population"));
      areaTextView.setText("" + bundle.getDouble("area"));
      regionTextView.setText(bundle.getString("region"));
    }
    return v;
  }
}
