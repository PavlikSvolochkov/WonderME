package ru.nsk.android;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class TopFifty extends Activity {

  String[] factArray;
  String[] nameArray;
  String[] countArray;

  ListView listView;
  TopFiftyAdapter adapter;

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

  public void reload(View view) {
    listView.setAdapter(adapter);
  }

  public void back(View view) {

  }
}
