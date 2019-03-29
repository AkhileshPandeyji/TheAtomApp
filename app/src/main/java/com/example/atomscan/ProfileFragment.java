package com.example.atomscan;


//import android.os.AsyncTask;
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

//import org.json.JSONObject;


public class ProfileFragment extends Fragment {

  //  private String enrol;
  // private Bundle bundle;
    private String[] PARAMS = {"Name:", "DOB:", "Enrollment No.:", "Father's Name:", "Email ID:", "Course:", "Branch:"};
    private String[] VALUES = {"Akhilesh Kumar Pandey", "08-02-1999", "00620802717", "Rajesh Kumar Pandey", "pandeyakhilesh5372@gmail.com", "B.Tech", "CSE"};


   /* public static ProfileFragment newInstance(String no) {
        ProfileFragment profileFragment = new ProfileFragment();
        Bundle bundle = new Bundle();
        bundle.putString("ENROL", no);
        profileFragment.setArguments(bundle);
        return profileFragment;
    }*/


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       // bundle = new Bundle();
        //bundle = this.getArguments();

       // JSONAsyncWork jsonAsyncWork = new JSONAsyncWork();
        //jsonAsyncWork.execute("http://urlgoeshere");
        View view_main = inflater.inflate(R.layout.activity_profile, container, false);
        ListView listView = view_main.findViewById(R.id.listView);

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

            View view = getLayoutInflater().inflate(R.layout.profile_list_view, null);

            TextView textView1 =  view.findViewById(R.id.profileText1);
            TextView textView2 =  view.findViewById(R.id.profileText2);
            textView1.setText(PARAMS[position]);
            textView2.setText(VALUES[position]);

            return view;
        }
    }

   /* class JSONAsyncWork extends AsyncTask<String, Void, Void> {


        @Override
        protected Void doInBackground(String... strings) {

            enrol = bundle.getString("ENROL");
            JSONParser.connect(strings[0] + enrol);
            VALUES[0] = JSONParser.getJSONString("Name");
            VALUES[1] = JSONParser.getJSONString("DOB");
            VALUES[2] = JSONParser.getJSONString("EnrolNo");
            VALUES[3] = JSONParser.getJSONString("Father");
            VALUES[4] = JSONParser.getJSONString("Email");
            VALUES[5] = JSONParser.getJSONString("Course");
            VALUES[6] = JSONParser.getJSONString("Branch");

            return null;
        }
    }*/
}
