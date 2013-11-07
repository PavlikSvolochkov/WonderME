package ru.nsk.android;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class TopFiftyAdapter extends ArrayAdapter<String> {

  private final Context context;
  private final String[] factText;
  private final String[] nameText;
  private final String[] counter;

  public TopFiftyAdapter(Context context,
                         String[] factText,
                         String[] nameText,
                         String[] countValues) {
    super(context, R.layout.all_facts_list_item, factText);
    this.context = context;
    this.factText = factText;
    this.nameText = nameText;
    this.counter = countValues;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) throws NullPointerException {
    LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    View rowView = inflater.inflate(R.layout.all_facts_list_item, parent, false);

    ((TextView) rowView.findViewById(R.id.factText)).setText(factText[position]);
    ((TextView) rowView.findViewById(R.id.factName)).setText(nameText[position]);
    ((TextView) rowView.findViewById(R.id.factCount)).setText(counter[position]);

    return rowView;
  }
}
