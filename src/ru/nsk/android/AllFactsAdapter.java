package ru.nsk.android;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class AllFactsAdapter extends ArrayAdapter<String> {

  private final Context context;
  private final String[] fact;
  private final String[] name;
  private final String[] counter;

  public AllFactsAdapter(Context context,
                         String[] factText,
                         String[] nameText,
                         String[] countValues) {
    super(context, R.layout.all_facts_list_item, factText);
    this.context = context;
    this.fact = factText;
    this.name = nameText;
    this.counter = countValues;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    View rowView = inflater.inflate(R.layout.all_facts_list_item, parent, false);

    ((TextView) rowView.findViewById(R.id.factText)).setText(fact[position]);
    ((TextView) rowView.findViewById(R.id.factName)).setText(name[position]);
    ((TextView) rowView.findViewById(R.id.factCount)).setText(counter[position]);

    return rowView;
  }

}
