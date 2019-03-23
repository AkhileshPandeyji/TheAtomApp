package com.example.atomscan;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class FeedFragment extends Fragment {

    private RatingBar ratingBar;
    private TextView  ratingResponse;
    private Spinner devSpinner;
    private EditText comment;
    private Button submitBtn;
    private View view_main;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view_main = inflater.inflate(R.layout.feedback_form,container,false);
        ratingBar = view_main.findViewById(R.id.feedback_rating);
        ratingResponse = view_main.findViewById(R.id.rating_response);
        devSpinner = view_main.findViewById(R.id.feedback_spinner);
        comment = view_main.findViewById(R.id.feedback_comment);
        submitBtn = view_main.findViewById(R.id.feedback_submit_btn);

          ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                if(fromUser){
                    ratingResponse.setVisibility(View.VISIBLE);
                    String rating_string = String.valueOf(rating);
                    switch (rating_string){
                        case "0.5":
                            ratingResponse.setText("Wahiyad");
                            break;
                        case "1.0":
                            ratingResponse.setText("Kya h Yeh");
                            break;
                        case "1.5":
                            ratingResponse.setText("Poor");
                            break;
                        case "2.0":
                            ratingResponse.setText(" Below Average");
                            break;
                        case "2.5":
                            ratingResponse.setText(" Average");
                            break;
                        case "3.0":
                            ratingResponse.setText("Above Average");
                            break;
                        case "4.0":
                            ratingResponse.setText("Good");
                            break;
                        case "4.5":
                            ratingResponse.setText("Very Good");
                            break;
                        case "5.0":
                            ratingResponse.setText("Outstanding");
                            break;

                    }
                }
            }
        });

        final String devs [] ={"Akhilesh Pandey(Android Developer)","Prashant Varshney(Web BackEnd Developer)","Preeti Hinwal(Web FrontEnd Developer)","Tarun Chaudhary(Web FrontEnd Developer)"};
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this.getContext(),android.R.layout.simple_spinner_dropdown_item,devs);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        devSpinner.setAdapter(arrayAdapter);

        devSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String value = devs[position];
                comment.setHint("@"+value+" : \n"+"Any Suggestions?");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                 comment.setHint("@General : \n Any Suggestions?");
            }
        });
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"Feedback Submitted",Toast.LENGTH_LONG).show();
            }
        });

        return view_main;




    }
}
