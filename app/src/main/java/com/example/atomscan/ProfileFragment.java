package com.example.atomscan;

import android.os.Bundle;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import android.support.v4.app.Fragment;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;


public class ProfileFragment extends Fragment {

    String[] PARAMS = {"Name:", "DOB:", "Enrollment No.:", "Father's Name:", "Email ID:", "Course:", "Branch:"};
    String[] VALUES = {"Akhilesh Kumar Pandey", "08-02-1999", "00620802717", "Rajesh Kumar Pandey", "pandeyakhilesh5372@gmail.com", "B.Tech", "CSE"};
    private  View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view_main = inflater.inflate(R.layout.activity_profile,container,false);
        ListView listView = (ListView) view_main.findViewById(R.id.listView);

        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);
        return view_main;
    }

    class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return PARAMS.length;
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

            view = getLayoutInflater().inflate(R.layout.profile_list_view,null);

            TextView textView1 = (TextView) view.findViewById(R.id.profileText1);
            TextView textView2 = (TextView) view.findViewById(R.id.profileText2);
            textView1.setText(PARAMS[position]);
            textView2.setText(VALUES[position]);

            return  view;
        }
    }
}
