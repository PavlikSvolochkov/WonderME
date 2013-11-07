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

  public CategoryAdapter(Context context, String[] catValues, String[] countValues) {
    super(context, R.layout.category_list_item, catValues);
    this.context = context;
    this.catValues = catValues;
    this.countValues = countValues;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) throws NullPointerException {
    LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    View rowView = inflater.inflate(R.layout.category_list_item, parent, false);

    ((TextView) rowView.findViewById(R.id.category)).setText(catValues[position]);
    ((TextView) rowView.findViewById(R.id.counter)).setText(countValues[position]);

    return rowView;
  }
}
