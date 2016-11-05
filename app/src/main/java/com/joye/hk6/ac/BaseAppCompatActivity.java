package com.joye.hk6.ac;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.joye.hk6.Hk6AndroidApplication;
import com.joye.hk6.internal.di.component.Hk6ApplicationComponent;
import com.joye.hk6.internal.di.modules.StatusbarActivityModule;

/**
 * Base {@link Activity} class for every Activity in this application.
 */
public abstract class BaseAppCompatActivity extends AppCompatActivity {


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    this.getApplicationComponent().inject(this);
  }

  /**
   * Adds a {@link Fragment} to this activity's layout.
   *
   * @param containerViewId The container view to where add the fragment.
   * @param fragment The fragment to be added.
   */
  protected void addFragment(int containerViewId, Fragment fragment) {
    FragmentTransaction fragmentTransaction = getSupportFragmentManager()
            .beginTransaction();
    fragmentTransaction.add(containerViewId, fragment);
    fragmentTransaction.commit();
  }

  /**
   * Get the Main Application component for dependency injection.
   *
   */
  protected Hk6ApplicationComponent getApplicationComponent() {
    return ((Hk6AndroidApplication)getApplication()).getApplicationComponent();
  }

  /**
   * Get an Activity module for dependency injection.
   */
/*  protected StatusbarActivityModule getActivityModule() {
    return new StatusbarActivityModule(this);
  }*/
}
