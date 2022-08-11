package ultramodern.activity.myroom;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Context;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ClientDashboardAdapter extends RecyclerView.Adapter<ClientDashboardAdapter.ClientDashboardAdapterHolder> {
    private Context context;
    private ArrayList<DataModelClass> dataModelClassArrayList;

    public ClientDashboardAdapter(Context context, ArrayList<DataModelClass> dataModelClassArrayList) {
        this.context = context;
        this.dataModelClassArrayList = dataModelClassArrayList;
    }

    @NonNull
    @Override
    public ClientDashboardAdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_row,parent,false);
        return new ClientDashboardAdapterHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClientDashboardAdapterHolder holder, int position) {

        holder.setDetails(dataModelClassArrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return dataModelClassArrayList.size();
    }
    static class ClientDashboardAdapterHolder extends RecyclerView.ViewHolder {
        private TextView hostel_name;
        private TextView hostel_location;
        private TextView hostel_price;
        private TextView hostel_vacancy;
        public ClientDashboardAdapterHolder(@NonNull View itemView) {
            super(itemView);
            hostel_name=itemView.findViewById(R.id.hostel_name);
            hostel_location=itemView.findViewById(R.id.location_name);
            hostel_price=itemView.findViewById(R.id.price);
            hostel_vacancy=itemView.findViewById(R.id.vavancy_name);
        }
        public void setDetails(DataModelClass dataModelClass){
            hostel_name.setText(dataModelClass.getName());
            hostel_location.setText(dataModelClass.getLocation());
            hostel_price.setText(dataModelClass.getPrice());
            hostel_vacancy.setText(dataModelClass.getVacancy());
        }
    }
}
