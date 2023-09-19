package com.vndevpro.android53_day4_btvn;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements IItemClickListener {

    private RecyclerView rvPost;
    private Button btnAdd;
    private ArrayList<PostModel> mListPostModels;
    private PostAdapter mPostAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        initView();
    }

    private void initData() {
        mListPostModels = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            PostModel postModel = new PostModel();
            postModel.setPostContent("Content Content Content Content Content " + i);
            postModel.setUserName("User " + i);
            postModel.setLike(false);
            postModel.setImgAvatar("https://imgv3.fotor.com/images/gallery/watercolor-female-avatar.jpg");
            postModel.setImgContent("https://images7.alphacoders.com/128/1280269.jpg");

            mListPostModels.add(postModel);
        }
    }

    private void initView() {
        btnAdd = findViewById(R.id.btnAdd);
        rvPost = findViewById(R.id.rvPost);
        mPostAdapter = new PostAdapter(mListPostModels);
        mPostAdapter.setItemClickListener(this);
        rvPost.setAdapter(mPostAdapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNewPost();
            }
        });
    }

    private void addNewPost() {
        int randomPos = new Random().nextInt(mListPostModels.size()-1);
        PostModel postModel = new PostModel();
        postModel.setPostContent("Content Content Content Content Content " + randomPos);
        postModel.setUserName("User " + randomPos);
        postModel.setLike(false);
        postModel.setImgAvatar("https://imgv3.fotor.com/images/gallery/watercolor-female-avatar.jpg");
        postModel.setImgContent("https://images7.alphacoders.com/128/1280269.jpg");

        mListPostModels.add(randomPos,postModel);
        mPostAdapter.notifyItemInserted(randomPos);
        rvPost.smoothScrollToPosition(randomPos);
    }

    @Override
    public void onChangeLikeState(int position) {
        PostModel postModel = mListPostModels.get(position);
        postModel.setLike(!postModel.isLike());

        mListPostModels.set(position, postModel);
        mPostAdapter.notifyItemChanged(position);
//        mPostAdapter.notifyDataSetChanged();
    }

    @Override
    public void onRemovePost(int position) {
        mListPostModels.remove(position);
        mPostAdapter.notifyItemRemoved(position);
    }
}