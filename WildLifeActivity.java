package com.example.mikey.loginvideo;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class WildLifeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wild_life);

        final TextView wildWel = (TextView) findViewById(R.id.wlw);
        final TextView acipenserBrevirostrum = (TextView) findViewById(R.id.textView1);
//        final String sv1 = acipenserBrevirostrum.getText().toString();

        String message = "Wildlife Data";
        wildWel.setText(message);

        acipenserBrevirostrum.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                final String sv1 = acipenserBrevirostrum.getText().toString();
//                Intent displayInformation = new Intent(WildLifeActivity.this, DetailActivity.class);
//                WildLifeActivity.this.startActivity(displayInformation);

                Response.Listener<String> responseListenerWild = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
//                            boolean success = true;

                            if (success) {
                                String scientific = jsonResponse.getString("scientific");
                                String common = jsonResponse.getString("common");
                                String info = jsonResponse.getString("info");

                                /**
                                 * Sends over the needed information to the DetailActivity function
                                 */
                                Intent sendInformation = new Intent(WildLifeActivity.this, DetailActivity.class);
                                sendInformation.putExtra("scientific", scientific);
                                sendInformation.putExtra("commonName", common);
                                sendInformation.putExtra("info", info);

                                WildLifeActivity.this.startActivity(sendInformation);
                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(WildLifeActivity.this);
                                builder.setMessage("Request Failed!")
                                        .setNegativeButton("Retry", null)
                                        .create()
                                        .show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                };

                DetailsRequest detailsRequest = new DetailsRequest(sv1, responseListenerWild);
                RequestQueue queue = Volley.newRequestQueue(WildLifeActivity.this);
                queue.add(detailsRequest);
            }

        });
    }
}
