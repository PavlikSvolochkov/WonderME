package ru.nsk.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    menu.add(0, 1, 1, "Главная");
    menu.add(0, 2, 2, "Все факты");
    menu.add(0, 3, 3, "Категории");
    menu.add(0, 4, 4, "Топ 50");
    return super.onCreateOptionsMenu(menu);
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      case 1:
        startActivity(new Intent(this, WonderMe.class));
        break;
      case 2:
        startActivity(new Intent(this, AllFacts.class));
        break;
      case 3:
        startActivity(new Intent(this, Category.class));
        break;
      case 4:
        startActivity(new Intent(this, TopFifty.class));
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
