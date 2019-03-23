package com.example.atomscan;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class AboutUsFragment extends Fragment {
    private ListView listView_aboutus ;
    private View view;
    int [] photos = {R.drawable.bpitlogo,R.drawable.bpitlogo,R.drawable.bpitlogo,R.drawable.bpitlogo};
    String [] Names = {"Akhilesh Kumar Pandey","Prashant Varshney","Preeti Hinwal","Tarun Chaudhary"};
    String [] Desc = {"Android App Designer","Website BackEnd Designer","Website FrontEnd Designer","Website FrontEnd Designer"};

        class AboutAdapter extends BaseAdapter{

        @Override
        public int getCount() {
         return   photos.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            view = getLayoutInflater().inflate(R.layout.activity_aboutus_view,null);
            ImageView view1 = (ImageView) view.findViewById(R.id.view1);
            view1.setImageResource(photos[position]);
            TextView view2 = (TextView) view.findViewById(R.id.view2);
            view2.setText(Names[position]);
            TextView view3 = (TextView) view.findViewById(R.id.view3);
            view3.setText(Desc[position]);
            return view;
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view_main = inflater.inflate(R.layout.activity_aboutus,container,false);
            listView_aboutus = (ListView) view_main.findViewById(R.id.listView_aboutus);
            listView_aboutus.setAdapter(new AboutAdapter());
        return view_main;
    }

}
