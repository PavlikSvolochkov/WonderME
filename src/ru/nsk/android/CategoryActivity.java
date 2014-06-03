package ru.nsk.android;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import soap.CategoryParser;

public class CategoryActivity extends ListActivity {

  private ListView listView;
  private CategoryAdapter adapter;

  /**
   * Called when the activity is first created.
   */
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.categories);

    CategoryParser parser = new CategoryParser();
    parser.parse(getResources().getXml(R.xml.categories));

    listView = getListView();
    adapter = new CategoryAdapter(this, parser.getCategories(), parser.getValues());
    listView.setAdapter(adapter);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    menu.add(0, 1, 1, "Главная");
    menu.add(0, 2, 2, "Все факты");
    menu.add(0, 3, 3, "Топ 50");
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
        startActivity(new Intent(this, AllFactsActivity.class));
        break;
      case 3:
        startActivity(new Intent(this, TopFiftyActivity.class));
        break;
      case 4:
        startActivity(new Intent(this, FavoritesActivity.class));
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
