package ru.nsk.android;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class Board extends Activity {

  /**
   * Called when the activity is first created.
   */
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.board);
  }

  public void reload(View view) {

  }
}
