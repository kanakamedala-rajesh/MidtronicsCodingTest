package com.rajesh.midtronicscodingtest.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemSelectedListener;
import com.rajesh.midtronicscodingtest.R;
import com.rajesh.midtronicscodingtest.constants.CommonUtil.FragmentTypes;

public class MainActivity extends AppCompatActivity {

  private final String TAG = this.getClass().getSimpleName();
  private Fragment activeFragment;


  private ProfileFragment profileFragment;
  private CountriesFragment countriesFragment;
  private FragmentManager fragmentManager;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    fragmentManager = getSupportFragmentManager();
    profileFragment = new ProfileFragment();
    countriesFragment = new CountriesFragment();

    fragmentManager.beginTransaction().add(R.id.fragment_container, countriesFragment, FragmentTypes.COUNTRIES_FRAGMENT.name()).hide(countriesFragment).commit();
    fragmentManager.beginTransaction().add(R.id.fragment_container, profileFragment, FragmentTypes.PROFILE_FRAGMENT.name()).commit();
    activeFragment = profileFragment;

    initializeViews();
  }

  private void initializeViews() {
    Log.d(TAG, "initializing the views");
    BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

    bottomNavigationView.setOnNavigationItemSelectedListener(new OnNavigationItemSelectedListener() {
      @Override
      public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.navigation_profile) {
          fragmentManager.beginTransaction().hide(activeFragment).show(profileFragment).commit();
          activeFragment = profileFragment;
          return true;
        } else if (menuItem.getItemId() == R.id.navigation_countries) {
          fragmentManager.beginTransaction().hide(activeFragment).show(countriesFragment).commit();
          activeFragment = countriesFragment;
          return true;
        } else {
          return false;
        }
      }
    });
  }
}
