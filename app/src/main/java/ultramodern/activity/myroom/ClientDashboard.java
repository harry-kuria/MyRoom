package ultramodern.activity.myroom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class ClientDashboard extends AppCompatActivity {

    public RecyclerView list;
    public ArrayList<DataModelClass> dataModelClassArrayList;
    public ClientDashboardAdapter clientDashboardAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_dashboard);

        showDetails();
    }
    public void showDetails(){
        list=findViewById(R.id.list);
        list.setLayoutManager(new LinearLayoutManager(this));
        dataModelClassArrayList = new ArrayList<>();
        clientDashboardAdapter = new ClientDashboardAdapter(this,dataModelClassArrayList);
        list.setAdapter(clientDashboardAdapter);
    }
}