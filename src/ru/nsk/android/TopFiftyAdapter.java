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

  TextView factField;
  TextView nameField;
  TextView countField;

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
  public View getView(int position, View convertView, ViewGroup parent) {
    LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    View rowView = inflater.inflate(R.layout.all_facts_list_item, parent, false);

    factField = (TextView) rowView.findViewById(R.id.factText);
    nameField = (TextView) rowView.findViewById(R.id.factName);
    countField = (TextView) rowView.findViewById(R.id.factCount);

    factField.setText(factText[position]);
    nameField.setText(nameText[position]);
    countField.setText(counter[position]);

    return rowView;
  }
}
