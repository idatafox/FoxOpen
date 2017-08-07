package com.idatafox.foxopen;
/**
 * show how to configure effect .
 */

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class EditTextDemoA extends AppCompatActivity {
    private EditText signInputName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_edit_text_demo);

        signInputName=(EditText)findViewById(R.id.editText2);
        //signInputName.setHintTextColor(getResources().getColor(R.color.colorFonta));
    }
}
