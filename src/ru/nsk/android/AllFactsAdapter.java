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

  TextView factText;
  TextView nameText;
  TextView count;

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

    factText = (TextView) rowView.findViewById(R.id.factText);
    nameText = (TextView) rowView.findViewById(R.id.factName);
    count = (TextView) rowView.findViewById(R.id.factCount);

    factText.setText(fact[position]);
    nameText.setText(name[position]);
    count.setText(counter[position]);

    return rowView;
  }

}
