package ru.nsk.android;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class About extends Activity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.about);
  }

  public void back(View view) {
    Toast.makeText(this, "Эта кнопка ничего не далет! =)", Toast.LENGTH_LONG).show();
  }
}
