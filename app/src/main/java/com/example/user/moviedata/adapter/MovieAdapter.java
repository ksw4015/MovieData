package com.example.user.moviedata.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.user.moviedata.DetailsActivity;
import com.example.user.moviedata.R;
import com.example.user.moviedata.model.Movie;

import java.util.ArrayList;

/**
 * Created by USER on 2018-03-17.
 * 리사이클러 뷰 어댑터 클래스
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder>{

    ArrayList<Movie> movieList;
    Context mContext;

    public MovieAdapter(Context context, ArrayList<Movie> movieList) {
        this.mContext = context;
        this.movieList = movieList;
    }

    @Override
    public MovieAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieAdapter.ViewHolder holder, final int position) {

        String average = Double.toString(movieList.get(position).getRateAverage());

        // 포스터 이미지
        Glide.with(mContext)
                .load(movieList.get(position).getPosterPath())
                .into(holder.moviePoster);

        // 제목
        holder.movieTitle.setText(movieList.get(position).getMoiveTitle());
        // 평균 별점
        holder.movieAverage.setText(new StringBuilder()
                .append("평균 ")
                .append(average)
                .append("점")
                .toString());
        // 개봉날짜
        holder.movieRelease.setText(new StringBuilder()
                .append(movieList.get(position).getReleaseDate())
                .append(" 개봉")
                .toString());

        // 카드뷰 아이템에 클릭 리스너 등록
        holder.movieCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, DetailsActivity.class);
                intent.putExtra(mContext.getResources().getString(R.string.movie_id), movieList.get(position).getMovieId()); // DetailsActivity에서 영화 정보 Api를 요청하기위해 영화 ID값 전달
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        View movieCard;

        ImageView moviePoster;
        TextView movieTitle;
        TextView movieAverage;
        TextView movieRelease;

        public ViewHolder(View itemView) {
            super(itemView);

            movieCard = (View)itemView.findViewById(R.id.movie_card);
            moviePoster = (ImageView)itemView.findViewById(R.id.movie_poster);
            movieTitle = (TextView)itemView.findViewById(R.id.movie_title);
            movieAverage = (TextView)itemView.findViewById(R.id.movie_average);
            movieRelease = (TextView)itemView.findViewById(R.id.movie_release);

        }
    }
}
