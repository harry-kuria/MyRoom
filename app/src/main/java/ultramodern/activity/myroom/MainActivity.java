package ultramodern.activity.myroom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ToLandlordRegistrationScreen(View view){
        Intent intent = new Intent(MainActivity.this, LandlordRegistrationScreen.class);
        startActivity(intent);
    }
    public void ToClientRegistrationScreen(View view){
        Intent intent = new Intent(MainActivity.this, ClientRegistrationScreen.class);
        startActivity(intent);
    }
}