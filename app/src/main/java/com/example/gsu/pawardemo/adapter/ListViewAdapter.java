package com.example.gsu.pawardemo.adapter;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.gsu.pawardemo.ListViewActivity;
import com.example.gsu.pawardemo.R;

import java.util.ArrayList;

/**
 * Created by mihiran on 1/25/2017.
 */

public class ListViewAdapter extends BaseAdapter {

    private final ArrayList<String> listResult;
    private Context mContext;
    private final LayoutInflater mInflator;

    public ListViewAdapter(Context context, ArrayList<String> listResult) {
        mContext = context;
        this.listResult = listResult;
        mInflator = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return listResult.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
//        TextView view = new TextView(mContext);
//        view.setText(String.valueOf(position));
//        return view;
        ViewHolder holder;
        if(convertView==null){
            convertView = mInflator.inflate(R.layout.list_item,parent,false);
            holder=new ViewHolder();
            holder.textView1 = (TextView) convertView.findViewById(R.id.list_view_tv1);
            holder.textView2 = (TextView) convertView.findViewById(R.id.list_view_tv2);
            holder.textView3 = (TextView) convertView.findViewById(R.id.list_view_tv3);
            convertView.setTag(holder);
        } else { holder = (ViewHolder) convertView.getTag();
        }
        holder.textView1.setText(String.valueOf(position));
        holder.textView3.setText(String.valueOf(position));
        holder.textView2.setText(listResult.get(position));

        if (position%2==0) {
            holder.textView1.setVisibility(View.VISIBLE);
            holder.textView3.setVisibility(View.INVISIBLE);

        } else {
            holder.textView1.setVisibility(View.INVISIBLE);
            holder.textView3.setVisibility(View.VISIBLE);
        }


//        View rowView = mInflator.inflate(R.layout.list_item,parent,false);
//        TextView textView = (TextView) rowView.findViewById(R.id.list_view_tv);
//        textView.setText((String.valueOf(position)));
        return convertView;
    }
}

class ViewHolder {
    TextView textView1;
    TextView textView2;
    TextView textView3;
}