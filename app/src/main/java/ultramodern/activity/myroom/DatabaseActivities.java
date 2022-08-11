package ultramodern.activity.myroom;

import android.app.Activity;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import android.content.Context;

import androidx.annotation.NonNull;

import java.util.HashMap;

public class DatabaseActivities {

    public void AddClientRegistrationDetails(Context context, String username, String PIN){
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance("https://myroom-2e840.firebaseio.com/");
        DatabaseReference databaseReference = firebaseDatabase.getReference("Users").child(username);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("Username",username);
        hashMap.put("PIN",PIN);
        databaseReference.push().setValue(hashMap);
        Toast.makeText(context, "Registered Successfully", Toast.LENGTH_LONG).show();
    }
    public void AddLocationToDatabase(Context context, String username, String location){
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance("https://myroom-2e840.firebaseio.com/");
        DatabaseReference databaseReference = firebaseDatabase.getReference("Users").child(username);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("Location",location);
        databaseReference.setValue(hashMap);
        Toast.makeText(context, "Registered Successfully", Toast.LENGTH_LONG).show();
    }
}
