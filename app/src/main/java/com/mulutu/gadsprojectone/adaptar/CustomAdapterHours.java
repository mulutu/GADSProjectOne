package com.mulutu.gadsprojectone.adaptar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.jakewharton.picasso.OkHttp3Downloader;
import com.mulutu.gadsprojectone.R;
import com.mulutu.gadsprojectone.model.LearnerHours;
import com.mulutu.gadsprojectone.model.LearnerIQ;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CustomAdapterHours extends RecyclerView.Adapter<CustomAdapterHours.CustomViewHolder> {
    private List<LearnerHours> learnersListHours;
    private Context context;

    public CustomAdapterHours(Context context, List<LearnerHours> dataList) {
        this.context = context;
        this.learnersListHours = dataList;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.custom_row, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {

        holder.txtLearnerName.setText(learnersListHours.get(position).getName());
        holder.txtLeanerDetails.setText(learnersListHours.get(position).getHours() + " learning hours, " + learnersListHours.get(position).getCountry());

        Picasso.Builder builder = new Picasso.Builder(context);
        builder.downloader(new OkHttp3Downloader(context));
        builder.build().load(learnersListHours.get(position).getBadgeUrl())
                .placeholder((R.drawable.ic_launcher_background))
                .error(R.drawable.ic_launcher_background)
                .into(holder.badgeID);

    }

    @Override
    public int getItemCount() {
        return learnersListHours.size();
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

        public final View mView;

        TextView txtLearnerName;
        TextView txtLeanerDetails;
        private ImageView badgeID;

        CustomViewHolder(View itemView) {
            super(itemView);
            mView = itemView;

            txtLearnerName = mView.findViewById(R.id.learnerName);
            txtLeanerDetails = mView.findViewById(R.id.learnerDetails);
            badgeID = mView.findViewById(R.id.badgeID);
        }
    }
}
