package com.geektech.java3_hw2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class FiveFragment extends Fragment {
    private EditText editText;
    private Button button;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_five, container, false);
    }   @Override
public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    editText  = view.findViewById(R.id.edit_text);
 button = view .findViewById(R.id.btn_go_);
    Bundle bundle =  getArguments();
   String text = bundle.getString(FirstFragment.KEY);
     editText.setText(text);
   button.setOnClickListener(new View.OnClickListener() {
       @Override
      public void onClick(View view) {
           Bundle bundle = new Bundle();
            String text = editText.getText().toString();
            bundle.putString(FirstFragment.KEY,text);
            Fragment fragment= new FiveFragment();
            fragment.setArguments(bundle);
            requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container_main,fragment).commit();
        }
     });
}
}
