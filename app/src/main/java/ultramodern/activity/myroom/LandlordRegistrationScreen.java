package ultramodern.activity.myroom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LandlordRegistrationScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landlord_registration_screen);
    }

    public void ToUpdateFormScreen(View view){
        Intent intent = new Intent(LandlordRegistrationScreen.this,Update_Form.class);
        startActivity(intent);
    }

    public void ToRegistrationDetails(View view){
        Intent intent = new Intent(LandlordRegistrationScreen.this,RegistrationDetails.class);
        startActivity(intent);
    }
}