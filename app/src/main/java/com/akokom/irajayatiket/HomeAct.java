package com.akokom.irajayatiket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class HomeAct extends AppCompatActivity {

    LinearLayout btn_ticket_rinjani;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btn_ticket_rinjani = findViewById(R.id.btn_ticket_rinjani);
        btn_ticket_rinjani.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotorinjani = new Intent(HomeAct.this, TicketDetailAct.class);
                startActivity(gotorinjani);
            }
        });
    }
}
