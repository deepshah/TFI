package com.jpmc.tfi;

import java.util.List;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class InteractiveArrayAdapter extends ArrayAdapter<Attendance> {

  private final List<Attendance> list;
  private final Activity context;

  public InteractiveArrayAdapter(Activity context, List<Attendance> list) {
    super(context, R.layout.row_student, list);
    this.context = context;
    this.list = list;
  }

  static class ViewHolder {
    protected TextView text;
    protected CheckBox checkbox;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    View view = null;
    if (convertView == null) {
      LayoutInflater inflator = context.getLayoutInflater();
      view = inflator.inflate(R.layout.row_student, null);
      final ViewHolder viewHolder = new ViewHolder();
      viewHolder.text = (TextView) view.findViewById(R.id.sid);
      viewHolder.checkbox = (CheckBox) view.findViewById(R.id.check);
      viewHolder.checkbox
          .setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                boolean isChecked) {
            	Attendance element = (Attendance) viewHolder.checkbox
                  .getTag();
              element.setAttendance(buttonView.isChecked());

            }
          });
      view.setTag(viewHolder);
      viewHolder.checkbox.setTag(list.get(position));

    } else {
      view = convertView;
      ((ViewHolder) view.getTag()).checkbox.setTag(list.get(position));
    }
    ViewHolder holder = (ViewHolder) view.getTag();
    holder.text.setText(list.get(position).getSID());
    holder.checkbox.setChecked(list.get(position).getAttendance());
    return view;
  }
} 