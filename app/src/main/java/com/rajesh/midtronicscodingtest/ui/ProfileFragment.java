package com.rajesh.midtronicscodingtest.ui;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import com.rajesh.midtronicscodingtest.R;
import com.rajesh.midtronicscodingtest.constants.CommonUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class ProfileFragment extends Fragment {

  private String TAG = this.getClass().getSimpleName();
  ExpandableListView expandableListView;
  ProfileInfoDisplayAdapter profileInfoDisplayAdapter;
  List<String> headers;
  HashMap<String, List<String>> details;

  public ProfileFragment() {
    // Required empty public constructor
  }

  public static ProfileFragment newInstance(String param1, String param2) {
    return new ProfileFragment();
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_profile, container, false);
    expandableListView = (ExpandableListView) view.findViewById(R.id.expandableListView);
    details = CommonUtil.getProfileData(view.getContext());
    headers = new ArrayList<>(details.keySet());
    profileInfoDisplayAdapter = new ProfileInfoDisplayAdapter(view.getContext(), headers, details);
    expandableListView.setAdapter(profileInfoDisplayAdapter);
    expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
      @Override
      public void onGroupExpand(int groupPosition) {
        Toast.makeText(getContext(), headers.get(groupPosition) + " List Expanded.", Toast.LENGTH_SHORT).show();
      }
    });

    expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
      @Override
      public void onGroupCollapse(int groupPosition) {
        Toast.makeText(getContext(), headers.get(groupPosition) + " List Collapsed.", Toast.LENGTH_SHORT).show();
      }
    });

    expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
      @Override
      public boolean onChildClick(ExpandableListView parent, View v,
          int groupPosition, int childPosition, long id) {
        Toast.makeText(getContext(), headers.get(groupPosition) + " -> " + Objects.requireNonNull(details.get(headers.get(groupPosition))).get(childPosition), Toast.LENGTH_SHORT).show();
        return false;
      }
    });
    return view;
  }

  @Override
  public void onAttach(Context context) {
    super.onAttach(context);
  }

  @Override
  public void onDetach() {
    super.onDetach();
    OnFragmentInteractionListener mListener = null;
  }

  public interface OnFragmentInteractionListener {

    void onFragmentInteraction(Uri uri);
  }
}
