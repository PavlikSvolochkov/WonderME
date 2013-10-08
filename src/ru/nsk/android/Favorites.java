package ru.nsk.android;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Favorites extends Activity {

  /**
   * Called when the activity is first created.
   */
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.favorites);
  }

  public void reload(View view) {
    Toast.makeText(this, "Эта кнопка ничего не далет! =)", Toast.LENGTH_LONG).show();
  }

  public void back(View view) {
    onBackPressed();
  }
}
