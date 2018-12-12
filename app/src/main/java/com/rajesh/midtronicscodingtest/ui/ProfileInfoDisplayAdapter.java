package com.rajesh.midtronicscodingtest.ui;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import com.rajesh.midtronicscodingtest.R;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class ProfileInfoDisplayAdapter extends BaseExpandableListAdapter {

  private String TAG = this.getClass().getSimpleName();
  private final Context context;
  private final List<String> headers;
  private final HashMap<String, List<String>> details;

  public ProfileInfoDisplayAdapter(Context context, List<String> headers, HashMap<String, List<String>> details) {
    this.context = context;
    this.headers = headers;
    this.details = details;
  }

  @Override
  public int getGroupCount() {
    return headers.size();
  }

  @Override
  public int getChildrenCount(int groupPosition) {
    return Objects.requireNonNull(details.get(headers.get(groupPosition))).size();
  }

  @Override
  public Object getGroup(int groupPosition) {
    return headers.get(groupPosition);
  }

  @Override
  public Object getChild(int groupPosition, int childPosition) {
    return Objects.requireNonNull(details.get(headers.get(groupPosition))).get(childPosition);
  }

  @Override
  public long getGroupId(int groupPosition) {
    return groupPosition;
  }

  @Override
  public long getChildId(int groupPosition, int childPosition) {
    return childPosition;
  }

  @Override
  public boolean hasStableIds() {
    return false;
  }

  @Override
  public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
    String header = (String) getGroup(groupPosition);
    if (convertView == null) {
      LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
      convertView = layoutInflater.inflate(R.layout.layout_profile_header, null);
    }
    TextView headerTextView = (TextView) convertView.findViewById(R.id.headerTitle);
    headerTextView.setTypeface(null, Typeface.BOLD);
    headerTextView.setText(header);
    return convertView;
  }

  @Override
  public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
    final String detail = (String) getChild(groupPosition, childPosition);
    if (convertView == null) {
      LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
      convertView = layoutInflater.inflate(R.layout.fragment_counties, null);
    }
    TextView numberTextView = (TextView) convertView.findViewById(R.id.item_number);
    TextView detailTextView = (TextView) convertView.findViewById(R.id.content);
    numberTextView.setText("" + (childPosition + 1));
    detailTextView.setText(detail);
    return convertView;
  }

  @Override
  public boolean isChildSelectable(int groupPosition, int childPosition) {
    return true;
  }
}
