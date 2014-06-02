package ru.nsk.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class FactActivity extends Activity {

  private String factText;

  private TextView fullFact;
  private TextView name;
  private TextView wonders;

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

    name = (TextView) findViewById(R.id.name);
    name.setText(intent.getStringExtra("name"));

    wonders = (TextView) findViewById(R.id.wonders);
    wonders.setText(intent.getStringExtra("wonder"));

    fullFact.setText(factText);

  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    menu.add(0, 1, 1, "Поделиться");
    menu.add(0, 2, 2, "Ещё");
    menu.add(0, 3, 3, "В избранное");
    return super.onCreateOptionsMenu(menu);
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      case 1:
        Toast.makeText(this, "Отправляет на страничку вконтакте.", Toast.LENGTH_SHORT).show();
        break;
      case 2:
        Toast.makeText(this, "Показать следующий факт", Toast.LENGTH_SHORT).show();
        break;
      case 3:
        Toast.makeText(this, "Добавить в избранное", Toast.LENGTH_SHORT).show();
        break;
    }
    return super.onOptionsItemSelected(item);
  }

  public void reload(View view) {
    Toast.makeText(this, "Эта кнопка ничего не далет! =)", Toast.LENGTH_LONG).show();
  }

  public void back(View view) {
    onBackPressed();
  }
}
