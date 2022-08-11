package ultramodern.activity.myroom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;
import android.widget.VideoView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

@SuppressWarnings("ALL")
public class Update_Form extends AppCompatActivity {

    static final int REQUEST_VIDEO_CAPTURE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update__form);
    }

    public void dispatchTakeVideoIntent(View view) {
        Intent takeVideoIntent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        if (takeVideoIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takeVideoIntent, REQUEST_VIDEO_CAPTURE);
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (requestCode == REQUEST_VIDEO_CAPTURE && resultCode == RESULT_OK) {
            Uri videoUri = intent.getData();
            final VideoView videoView = findViewById(R.id.vidView);
            videoView.setVisibility(View.VISIBLE);
            videoView.setVideoURI(videoUri);
            Button play = findViewById(R.id.playbtn);
            play.setVisibility(View.VISIBLE);
            play.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    videoView.start();
                }
            });
        }
    }
    public void DataSubmission(View view){
        getDataFromEntries();
    }

    private void getDataFromEntries() {
        CheckBox yes = findViewById(R.id.yes_radiobtn);
        CheckBox no = findViewById(R.id.no_radiobtn);
        CheckBox cctv = findViewById(R.id.CCTV);
        CheckBox security_guard = findViewById(R.id.security_guard);
        CheckBox other = findViewById(R.id.other);
        EditText rent_enquiry = findViewById(R.id.rentAmountInput);
        EditText otherSecurity = findViewById(R.id.otherSecurity);

        HashMap<String, String> hashMap = new HashMap<>();
        if (yes.isChecked()){
            yes.getText().toString();
            hashMap.put("Vacancy Available", "Available");
        }
        if (no.isChecked()){
            no.getText().toString();
            hashMap.put("Vacancy Available", "None");
        }
        if (cctv.isChecked()){
            hashMap.put("Security Method", cctv.getText().toString());
        }
        if (security_guard.isChecked()){
            hashMap.put("Security Method", security_guard.getText().toString());
        }
        if (other.isChecked()){
            otherSecurity.setVisibility(View.VISIBLE);
            otherSecurity.getText().toString();
            if (otherSecurity.getText().length()==0){
                otherSecurity.setError("A value on this space is needed!");
            }
            else {
                hashMap.put("Security Method", otherSecurity.getText().toString());
            }
        }
        if (!other.isChecked()){
            otherSecurity.setVisibility(View.GONE);
        }

        if (rent_enquiry.getText().length()==0){
            rent_enquiry.setError("This area can't be blank");
        }
        else {
            hashMap.put("Rent Amount",rent_enquiry.getText().toString());
        }

        SharedPreferences sharedPreferences = getSharedPreferences("My_Name",MODE_PRIVATE);
        String name = PreferenceManager.getDefaultSharedPreferences(this).getString("username","get");
        DatabaseReference firebaseDatabase = FirebaseDatabase.getInstance("https://myroom-2e840.firebaseio.com/").getReference("Users").child(name);
        //DatabaseReference reference = firebaseDatabase.getReference("Users").child(name);
        firebaseDatabase.push().setValue(hashMap);

    }
}