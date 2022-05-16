package com.geektech.java3_hw2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FirstFragment extends Fragment {
    public static final String KEY = "key_1";
    private EditText editText;
    private Button button;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        editText = view.findViewById(R.id.edit_text);
        button = view.findViewById(R.id.btn_go_);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              if (!editText.getText().toString().isEmpty()){

                  
                  Bundle bundle = new Bundle();
                  String text = editText.getText().toString();
                  bundle.putString(KEY, text);
                  Fragment fragment = new SecondFragment();
                  fragment.setArguments(bundle);
                  requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container_main, fragment).commit();

              }else {
                  Toast.makeText(requireContext(),"строка не может быть пустым",Toast.LENGTH_SHORT).show();
              }


            }
        });
    }
}