package com.akokom.irajayatiket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SuccesBuyTicketAct extends AppCompatActivity {

    Animation app_splash, bottomtotopalpha, toptobottomalpha;
    Button btn_my_dashboard, btn_view_ticket;
    TextView app_title, app_subitle;
    ImageView icon_success_ticket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_succes_buy_ticket);

        btn_my_dashboard = findViewById(R.id.btn_my_dashboard);
        btn_view_ticket = findViewById(R.id.btn_view_ticket);
        app_title = findViewById(R.id.app_title);
        app_subitle = findViewById(R.id.app_subtittle);
        icon_success_ticket = findViewById(R.id.icon_success_ticket);

        //load animation
        app_splash = AnimationUtils.loadAnimation(this, R.anim.app_splash);
        bottomtotopalpha = AnimationUtils.loadAnimation(this, R.anim.bottomtotopalpha);
        toptobottomalpha = AnimationUtils.loadAnimation(this, R.anim.toptobottomalpha);

        //run animation
        icon_success_ticket.startAnimation(app_splash);
        app_title.startAnimation(toptobottomalpha);
        app_subitle.startAnimation(toptobottomalpha);
        btn_my_dashboard.startAnimation(bottomtotopalpha);
        btn_view_ticket.startAnimation(bottomtotopalpha);

        btn_my_dashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotomyprofile = new Intent(SuccesBuyTicketAct.this, MyProfileAct.class);
                startActivity(gotomyprofile);
            }
        });
    }
}
