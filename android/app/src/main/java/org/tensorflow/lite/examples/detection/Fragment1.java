package org.tensorflow.lite.examples.detection;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Fragment1 extends Fragment {

    private Button toServerBtn;

    public Fragment1() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_1,container,false);

    toServerBtn = view.findViewById(R.id.toServerBtn1);
    toServerBtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(view.getContext(), Test.class);
            startActivity(intent);
        }});


        // Inflate the layout for this fragment
        return view;
    }
}