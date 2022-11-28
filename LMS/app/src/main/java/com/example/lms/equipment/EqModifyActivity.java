package com.example.lms.equipment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.example.lms.R;

public class EqModifyActivity extends AppCompatActivity {
    EditText modieqname,modieqquantity,modiinfo,modiprice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eq_modify);
    }
}