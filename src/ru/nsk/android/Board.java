package ru.nsk.android;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

public class Board extends ListActivity {

  String[] names;
  String[] titles;
  String[] counter;
  String[] ratings;

  ListView lvBoard = null;
  BoardAdapter adapter;

  /**
   * Called when the activity is first created.
   */
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.board);

    lvBoard = getListView();

    names = getResources().getStringArray(R.array.names);
    titles = getResources().getStringArray(R.array.titles);
    counter = getResources().getStringArray(R.array.counts);
    ratings = getResources().getStringArray(R.array.counts);

    adapter = new BoardAdapter(this, names, titles, counter, ratings);

    lvBoard.setAdapter(adapter);
  }

  public void reload(View view) {
    Toast.makeText(this, "Эта кнопка ничего не далет! =)", Toast.LENGTH_LONG).show();
  }

  public void back(View view) {
    onBackPressed();
  }
}
