package ultramodern.activity.myroom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;

public class ClientRegDetails extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;

    public EditText usernameInput, PINInput, PINConfirmation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_reg_details);
    }

    @Override
    protected void onStart() {
        super.onStart();
        firebaseAuth.getCurrentUser();
    }

    public void DirectToLogin(View view){
        addToDatabase();
        Intent intent = new Intent(ClientRegDetails.this, LandlordRegistrationScreen.class);
        startActivity(intent);
    }

    public void addToDatabase(){
        usernameInput=findViewById(R.id.usernameInput);
        PINInput=findViewById(R.id.pinInput);
        PINConfirmation=findViewById(R.id.confirmPinInput);
        String username = usernameInput.getText().toString();
        String PIN = PINInput.getText().toString();
        FirebaseAuth auth = FirebaseAuth.getInstance();
        DatabaseActivities databaseActivities = new DatabaseActivities();
        databaseActivities.AddClientRegistrationDetails(ClientRegDetails.this,username,PIN);
    }
}
