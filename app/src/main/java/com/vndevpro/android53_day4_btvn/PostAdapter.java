package com.vndevpro.android53_day4_btvn;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {

    private ArrayList<PostModel> mListPostModels;
    private Context mContext;
    private IItemClickListener iItemClickListener;

    public PostAdapter(ArrayList<PostModel> listPostModels) {
        this.mListPostModels = listPostModels;
    }

    public void setItemClickListener(IItemClickListener itemClickListener) {
        this.iItemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public PostAdapter.PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        this.mContext = parent.getContext();
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_item_post_model, parent, false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostAdapter.PostViewHolder holder, int position) {
        Log.d("TAG", "onBindViewHolder: "+position);
        PostModel postModel = mListPostModels.get(position);

        Glide.with(mContext).load(postModel.getImgAvatar()).into(holder.imgAvt);
        holder.tvName.setText(postModel.getUserName());
        holder.tvContent.setText(postModel.getPostContent());
        Glide.with(mContext).load(postModel.getImgContent()).into(holder.imgPicture);

        if (postModel.isLike()) {
            holder.btnLike.setBackgroundResource(R.drawable.like_ed);
        } else {
            holder.btnLike.setBackgroundResource(R.drawable.like);
        }

//        holder.btnLike.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.d("TAG", "onClick: "+position);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return mListPostModels != null ? mListPostModels.size() : 0;
    }

    public class PostViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageButton btnClose, btnLike, btnComment, btnSent, btnShare;
        CircleImageView imgAvt;
        TextView tvName, tvContent, tvLike, tvSoLuongBinhLuan;
        ImageView imgPicture;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);

            btnClose = itemView.findViewById(R.id.btnClose);
            btnLike = itemView.findViewById(R.id.btnLike);
            btnComment = itemView.findViewById(R.id.btnComment);
            btnSent = itemView.findViewById(R.id.btnSent);
            btnShare = itemView.findViewById(R.id.btnShare);
            imgAvt = itemView.findViewById(R.id.imgAvt);
            tvName = itemView.findViewById(R.id.tvName);
            tvContent = itemView.findViewById(R.id.tvContent);
            tvLike = itemView.findViewById(R.id.tvLike);
            tvSoLuongBinhLuan = itemView.findViewById(R.id.tvSoLuongBinhLuan);
            imgPicture = itemView.findViewById(R.id.imgPicture);

            btnLike.setOnClickListener(this);
            btnClose.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            switch (v.getId()) {
                case R.id.btnLike:
                    if (iItemClickListener != null) {
                        iItemClickListener.onChangeLikeState(position);
                    }
                    break;
                case R.id.btnClose:
                    if (iItemClickListener != null){
                        iItemClickListener.onRemovePost(position);
                    }
                    break;
            }
        }
    }
}
