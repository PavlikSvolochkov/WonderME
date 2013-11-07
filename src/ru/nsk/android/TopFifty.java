package ru.nsk.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

public class TopFifty extends Activity {

  private String[] factArray;
  private String[] nameArray;
  private String[] countArray;

  private ListView listView;
  private TopFiftyAdapter adapter;

  /**
   * Called when the activity is first created.
   */
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.top_fifty);

    listView = (ListView) findViewById(R.id.lvTop50);

    factArray = getResources().getStringArray(R.array.facts_array);
    nameArray = getResources().getStringArray(R.array.names);
    countArray = getResources().getStringArray(R.array.counts);

    adapter = new TopFiftyAdapter(this, factArray, nameArray, countArray);
    listView.setAdapter(adapter);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    menu.add(0, 1, 1, "Главная");
    menu.add(0, 2, 2, "Все факты");
    menu.add(0, 3, 3, "Категории");
    menu.add(0, 4, 4, "Избранное");
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
        startActivity(new Intent(this, Favorites.class));
        break;
    }
    return super.onOptionsItemSelected(item);
  }

  public void reload(View view) {
    listView.setAdapter(adapter);
  }

  public void back(View view) {
    onBackPressed();
  }
}
