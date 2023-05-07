package com.example.bai_2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MediaFileAdaptor  extends RecyclerView.Adapter<MediaFileAdaptor.MyViewHolder>{
    int mPosition;
    private Context context;
    private List<MediaFile> mMediaList;

    public MediaFileAdaptor(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public MediaFileAdaptor.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row, parent,false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MediaFileAdaptor.MyViewHolder holder, int position) {
        MediaFile df = mMediaList.get(position);
        holder.name.setText(df.getName());

    }

    @Override
    public int getItemCount() {
        if (mMediaList == null) {
            return 0;
        }
        return mMediaList.size();
    }
    public void setData(List<MediaFile> downloadedFileList) {
        mMediaList = downloadedFileList;
        notifyDataSetChanged();
    }

    public List<MediaFile> getEvents() {
        return mMediaList;
    }

    public void setPosition(int position) {
        mPosition = position;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name;

        MyViewHolder(@NonNull final View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tv_name);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent newActivity = new Intent(context, Play_Activity.class);
                    newActivity.putExtra("vMusicName", mMediaList.get(getAdapterPosition()).getName());
                    newActivity.putExtra("vMusicPath", mMediaList.get(getAdapterPosition()).getPath());
                    context.startActivity(newActivity);
                }
            });
        }
    }

}
