package com.rajesh.midtronicscodingtest.constants;

import android.content.Context;
import com.rajesh.midtronicscodingtest.R;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CommonUtil {

  public static final String BASE_URL = "https://restcountries.eu/rest/v1/";

  public enum FragmentTypes {
    PROFILE_FRAGMENT,
    COUNTRIES_FRAGMENT
  }

  public static HashMap<String, List<String>> getProfileData(Context context) {
    HashMap<String, List<String>> details = new HashMap<>();

    details.put("Education", Arrays.asList(context.getResources().getStringArray(R.array.Education)));
    details.put("Experience", Arrays.asList(context.getResources().getStringArray(R.array.Experience)));
    details.put("Skills", Arrays.asList(context.getResources().getStringArray(R.array.Skills)));

    return details;
  }
}
