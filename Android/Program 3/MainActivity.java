package com.example.myappli1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText ed1;
    Button b1;
    TextView r;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ed1 = (EditText) findViewById(R.id.ed1);
        b1 = (Button) findViewById(R.id.b1);
        r = (TextView) findViewById(R.id.result);

        b1.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
         if(v.getId()==b1.getId())
         {
             int num=Integer.parseInt(ed1.getText().toString());
             int result = 1;
             if(num==0 || num==1){
                 result =1 ;
             }
             else {
                 for (int i = 2; i <= num; ++i)
                     result = result * i;
             }
             r.setText("Factorial : "+String.valueOf(result));
         }
    }
}