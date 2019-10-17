package com.example.listviewpresiden;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.listviewpresiden.Model;
import com.example.listviewpresiden.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ListViewAdapter extends BaseAdapter {

    Context mContext;
    LayoutInflater inflater;
    List<Model> modellist;
    ArrayList<Model> arrayList;


    public ListViewAdapter(Context Context, List<Model> modelList) {
        mContext = Context;
        this.modellist = modelList;
        inflater = LayoutInflater.from(mContext);
        this.arrayList = new ArrayList<Model>();
        this.arrayList.addAll(modellist);
    }

    public class ViewHolder{
        TextView mTitleTv, mDescTv;
        ImageView mIconIv;

    }

    @Override
    public int getCount() {
        return modellist.size();
    }

    @Override
    public Object getItem(int i) {
        return modellist.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int position, View view, ViewGroup parent) {
        ViewHolder holder;
        if (view==null){
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.row, null);

            holder.mTitleTv = view.findViewById(R.id.mainTitle);
            holder.mDescTv = view.findViewById(R.id.mainDesc);
            holder.mIconIv = view.findViewById(R.id.mainIcon);

            view.setTag(holder);

        }
        else {
            holder = (ViewHolder)view.getTag();
        }
        holder.mTitleTv.setText(modellist.get(position).getTitle());
        holder.mDescTv.setText(modellist.get(position).getDesc());
        holder.mIconIv.setImageResource(modellist.get(position).getIcon());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (modellist.get(position).getTitle().equals("Soekarno")){
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Soekarno");
                    intent.putExtra("contentTv", "Lahir Pada 6 Juni 1901, Di Surabaya");
                    mContext.startActivity(intent);
                }
                if (modellist.get(position).getTitle().equals("Soeharto")){
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Soeharto");
                    intent.putExtra("contentTv", "Lahir Pada 8 Juni 1921, Di Yogyakarta");
                    mContext.startActivity(intent);
                }
                if (modellist.get(position).getTitle().equals("Bachruddin Jusuf Habibie")){
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Bachruddin Jusuf Habibie");
                    intent.putExtra("contentTv", "Lahir Pada 25 Juni 1936, Di Sulawesi Selatan");
                    mContext.startActivity(intent);
                }
                if (modellist.get(position).getTitle().equals("Abdurrahman Wahid")){
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Abdurrahman Wahid");
                    intent.putExtra("contentTv", "Lahir Pada 7 September 1940, Di Jombang");
                    mContext.startActivity(intent);
                }
                if (modellist.get(position).getTitle().equals("Megawati Soekarnoputri")){
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Megawati Soekarnoputri");
                    intent.putExtra("contentTv", "Lahir Pada 23 Januari 1947, Di Yogyakarta");
                    mContext.startActivity(intent);
                }
                if (modellist.get(position).getTitle().equals("Susilo Bambang Yudhoyono")){
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Susilo Bambang Yudhoyono");
                    intent.putExtra("contentTv", "Lahir Pada 9 September 1949, Di Pacitan");
                    mContext.startActivity(intent);
                }
                if (modellist.get(position).getTitle().equals("Joko Widodo")){
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Joko Widodo");
                    intent.putExtra("contentTv", "Lahir Pada 21 Juni 1961, Di Surakarta");
                    mContext.startActivity(intent);
                }
            }
        });
        return view;
    }

    public void filter(String charText){
        charText = charText.toLowerCase(Locale.getDefault());
        modellist.clear();
        if (charText.length()==0){
            modellist.addAll(arrayList);
        }
        else {
            for (Model model : arrayList){
                if (model.getTitle().toLowerCase(Locale.getDefault())
                        .contains(charText)){
                        modellist.add(model);
                }
            }
        }
        notifyDataSetChanged();
    }
}
