package ru.nsk.android;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class BoardAdapter extends ArrayAdapter<String> {

  private final Context context;
  private final String[] name;
  private final String[] title;
  private final String[] count;
  private final String[] ratingSum;

  int pos = 1;

  TextView tvName;
  TextView tvTitle;
  TextView tvCount;
  TextView tvRating;
  TextView topNum;

  public BoardAdapter(Context context, String[] name, String[] title, String[] count, String[] ratingSum) {
    super(context, R.layout.board_list_item, name);
    this.context = context;
    this.name = name;
    this.title = title;
    this.count = count;
    this.ratingSum = ratingSum;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    View rowView = inflater.inflate(R.layout.board_list_item, parent, false);

    tvName = (TextView) rowView.findViewById(R.id.name);
    tvTitle = (TextView) rowView.findViewById(R.id.title);
    tvCount = (TextView) rowView.findViewById(R.id.addFacts);
    tvRating = (TextView) rowView.findViewById(R.id.ratingSum);
    topNum = (TextView) rowView.findViewById(R.id.topNum);

    tvName.setText(name[position]);
    tvTitle.setText("Титул: " + title[position]);
    tvCount.setText("Добавлено фактов: " + count[position]);
    tvRating.setText("Сумма рейтингов: " + ratingSum[position]);
    topNum.setText(String.valueOf(position + 1));

    return rowView;
  }
}
