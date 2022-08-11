package ultramodern.activity.myroom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ClientRegistrationScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_registration_screen);
    }
    public void ToClientDashboard(View view){
        Intent intent = new Intent(ClientRegistrationScreen.this,ClientDashboard.class);
        startActivity(intent);
    }
    public void ToClientReg(View view){
        Intent intent = new Intent(ClientRegistrationScreen.this, ClientRegDetails.class);
        startActivity(intent);
    }
}