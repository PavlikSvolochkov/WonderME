package ru.nsk.android;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class Category extends ListActivity {

  String[] categories;
  String[] values;

  ListView listView;
  CategoryAdapter adapter;

  /**
   * Called when the activity is first created.
   */
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.categories);

    listView = getListView();

    categories = getResources().getStringArray(R.array.categories);
    values = getResources().getStringArray(R.array.counts);

    adapter = new CategoryAdapter(this, categories, values);
    listView.setAdapter(adapter);
  }

  public void reload(View view) {
    listView.setAdapter(adapter);
  }

  public void back(View view) {
    onBackPressed();
  }
}
