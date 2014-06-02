package ru.nsk.android;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

public class AllFactsActivity extends ListActivity {

  private String[] factText;
  private String[] names;
  private String[] counts;

  TextView tvFactText;
  private ListView listView = null;

  private Intent intent;

  private AllFactsAdapter adapter;

  /**
   * Called when the activity is first created.
   */
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.all_facts);

    intent = new Intent(this, FactActivity.class);

    tvFactText = (TextView) findViewById(R.id.factText);

    listView = getListView();

    factText = getResources().getStringArray(R.array.facts_array);
    names = getResources().getStringArray(R.array.names);
    counts = getResources().getStringArray(R.array.counts);

    adapter = new AllFactsAdapter(this, factText, names, counts);

    listView.setAdapter(adapter);

    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        intent.putExtra("fact", factText[i]);
        intent.putExtra("name", names[i]);
        intent.putExtra("wonder", counts[i]);
        startActivity(intent);
      }
    });
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    menu.add(0, 1, 1, "Главная");
    menu.add(0, 2, 2, "Категории");
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
        startActivity(new Intent(this, CategoryActivity.class));
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
