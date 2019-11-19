package com.akokom.irajayatiket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class TicketCheckoutAct extends AppCompatActivity {

    Button btn_buy_ticket, btnmines, btnpls;
    TextView textjumlahtiket, texttotalharga, textmybalance;
    Integer valueJumlahTiket = 1;
    Integer mybalance = 200;
    Integer valuetotalharga = 0;
    Integer valuehargatiket = 75;
    ImageView notice_money;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_checkout);
        btn_buy_ticket = findViewById(R.id.btn_buy_ticket);
        btnmines = findViewById(R.id.btnmines);
        btnpls = findViewById(R.id.btnpls);
        textjumlahtiket = findViewById(R.id.textjumlahtiket);
        texttotalharga = findViewById(R.id.texttotalharga);
        textmybalance = findViewById(R.id.textmybalance);
        notice_money = findViewById(R.id.notice_money);

        // setting value baru untuk beberapa komponen
        textjumlahtiket.setText(valueJumlahTiket.toString());
        textmybalance.setText("US$ "+mybalance);
        valuetotalharga = valuehargatiket * valueJumlahTiket;
        texttotalharga.setText("US$ "+valuetotalharga);

        // secara default/awal, kita hide btnmines
        btnmines.animate().alpha(0).setDuration(300).start();
        btnmines.setEnabled(false);
        notice_money.setVisibility(View.GONE);

        btnpls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valueJumlahTiket+=1;
                textjumlahtiket.setText(valueJumlahTiket.toString());
                if (valueJumlahTiket > 1){
                    btnmines.animate().alpha(1).setDuration(300).start();
                    btnmines.setEnabled(true);
                }
                valuetotalharga = valuehargatiket * valueJumlahTiket;
                texttotalharga.setText("US$ "+valuetotalharga);
                if (valuetotalharga > mybalance){
                     btn_buy_ticket.animate().translationY(250).alpha(0).setDuration(350).start();
                     btn_buy_ticket.setEnabled(false);
                     textmybalance.setTextColor(Color.parseColor("#D1206B"));
                     notice_money.setVisibility(View.VISIBLE);
                }
            }
        });
        btnmines.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valueJumlahTiket-=1;
                textjumlahtiket.setText(valueJumlahTiket.toString());
                if (valueJumlahTiket < 2){
                    btnmines.animate().alpha(0).setDuration(300).start();
                    btnmines.setEnabled(false);
                }
                valuetotalharga = valuehargatiket * valueJumlahTiket;
                texttotalharga.setText("US$ "+valuetotalharga);
                if (valuetotalharga < mybalance){
                    btn_buy_ticket.animate().translationY(0).alpha(1).setDuration(350).start();
                    btn_buy_ticket.setEnabled(true);
                    textmybalance.setTextColor(Color.parseColor("#203DD1"));
                    notice_money.setVisibility(View.GONE);
                }
            }
        });
        btn_buy_ticket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotosuccesstiket= new Intent(TicketCheckoutAct.this, SuccesBuyTicketAct.class);
                startActivity(gotosuccesstiket);
            }
        });
    }
}
