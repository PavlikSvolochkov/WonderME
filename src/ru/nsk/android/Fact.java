package ru.nsk.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Fact extends Activity {

  String factText;

  TextView fullFact;
  TextView name;
  TextView wonderers;

  /**
   * Called when the activity is first created.
   */
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.fact);

    Intent intent = getIntent();

    fullFact = (TextView) findViewById(R.id.fullFact);
    factText = intent.getStringExtra("fact");

    wonderers = (TextView) findViewById(R.id.wonders);
    wonderers.setText(intent.getStringExtra("wonder"));

    fullFact.setText(factText);

  }

  public void reload(View view) {
    Toast.makeText(this, "Эта кнопка ничего не далет! =)", Toast.LENGTH_LONG).show();
  }

  public void back(View view) {
    Toast.makeText(this, "Эта кнопка ничего не далет! =)", Toast.LENGTH_LONG).show();
  }
}
