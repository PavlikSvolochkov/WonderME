package ru.nsk.android;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class AllFacts extends ListActivity {

  String[] factText;
  String[] names;
  String[] counts;

  TextView tvFactText;

  Intent intent;

  AllFactsAdapter adapter;
  ListView listView = null;

  /**
   * Called when the activity is first created.
   */
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.all_facts);

    intent = new Intent(this, Fact.class);

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

  public void reload(View view) {
    listView.setAdapter(adapter);
  }

  public void back(View view) {
    Toast.makeText(this, "Эта кнопка ничего не далет! =)", Toast.LENGTH_LONG).show();
  }

}
