package ru.nsk.android;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class CategoryAdapter extends ArrayAdapter<String> {

  private final Context context;
  private final String[] catValues;
  private final String[] countValues;

  TextView catTextView;
  TextView counterTextView;

  public CategoryAdapter(Context context, String[] catValues, String[] countValues) {
    super(context, R.layout.category_list_item, catValues);
    this.context = context;
    this.catValues = catValues;
    this.countValues = countValues;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    View rowView = inflater.inflate(R.layout.category_list_item, parent, false);

    catTextView = (TextView) rowView.findViewById(R.id.category);
    counterTextView = (TextView) rowView.findViewById(R.id.counter);

    catTextView.setText(catValues[position]);
    counterTextView.setText(countValues[position]);

    return rowView;
  }
}
