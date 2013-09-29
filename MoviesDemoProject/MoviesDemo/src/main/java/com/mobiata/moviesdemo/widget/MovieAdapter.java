package com.mobiata.moviesdemo.widget;

import android.content.Context;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.mobiata.moviesdemo.R;
import com.mobiata.moviesdemo.data.Movie;
import com.mobiata.moviesdemo.view.SlidingPairView;

import java.util.List;

public class MovieAdapter extends BaseAdapter {

	private Context mContext;

	private List<Movie> mMovies;

	private float mSlide;

	public MovieAdapter(Context context, List<Movie> movies) {
		mContext = context;
		mMovies = movies;
	}

	public void setSlide(float slide) {
		mSlide = slide;
		notifyDataSetChanged();
	}

	@Override
	public int getCount() {
		return (int) Math.ceil(mMovies.size() / 2.0f);
	}

	@Override
	public Pair<Movie, Movie> getItem(int position) {
		int index = position * 2;
		return Pair.create(mMovies.get(index), mMovies.get(index + 1));
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder vh;
		if (convertView == null) {
			convertView = LayoutInflater.from(mContext).inflate(R.layout.row_movie_pair, parent, false);

			vh = new ViewHolder();
			vh.mSlidingPairView = (SlidingPairView) convertView.findViewById(R.id.sliding_pair);

			convertView.setTag(vh);
		}
		else {
			vh = (ViewHolder) convertView.getTag();
		}

		vh.mSlidingPairView.setSlide(mSlide);

		return convertView;
	}

	private static final class ViewHolder {
		SlidingPairView mSlidingPairView;
	}

}
