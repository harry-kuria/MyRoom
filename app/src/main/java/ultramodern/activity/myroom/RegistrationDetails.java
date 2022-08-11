package ultramodern.activity.myroom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;

public class RegistrationDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_details);
    }

    public void ADD_DETAILS_TO_DATABASE(){
        SharedPreferences sharedPreferences = getSharedPreferences("My_Name",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        EditText username_input = findViewById(R.id.usernameInput);
        EditText PIN_input = findViewById(R.id.pinInput);
        String username = username_input.getText().toString();
        editor.putString("username",username);
        editor.commit();
        String PIN = PIN_input.getText().toString();
        DatabaseActivities databaseActivities = new DatabaseActivities();
        databaseActivities.AddClientRegistrationDetails(RegistrationDetails.this,username,PIN);
    }

    public void setLocation(View view){
        EditText usernameInput = findViewById(R.id.usernameInput);
        EditText pinInput = findViewById(R.id.pinInput);
        EditText confirmPinInput = findViewById(R.id.confirmPinInput);
        if (usernameInput.getText().length() == 0){
            usernameInput.setError("This area can't be blank!");
        }
        else if (pinInput.getText().length() == 0 && pinInput.getText().length() < 4){
           pinInput.setError("Your pin must be a 4 digit number");
        }
        else if (confirmPinInput.getText().length() == 0 && confirmPinInput.getText().length() < 4 ){
            confirmPinInput.setError("This area can't be blank");
        }
        else {
            ADD_DETAILS_TO_DATABASE();
            Intent intent = new Intent(RegistrationDetails.this, HostelLocation.class);
            startActivity(intent);
        }

    }
}