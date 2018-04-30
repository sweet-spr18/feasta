package com.esoxjem.movieguide.listing;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.esoxjem.movieguide.Building;
import com.esoxjem.movieguide.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author tta
 */
public class BuildingsListingAdapter extends RecyclerView.Adapter<BuildingsListingAdapter.ViewHolder> {
    private List<Building> buildings;
    private Context context;
    private BuildingsListingView view;

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.building_poster) //TO CHANGE!
        ImageView poster;
        /*@BindView(R.id.title_background)
        View titleBackground;*/
        @BindView(R.id.building_name)
        TextView name;

        public Building building;

        public ViewHolder(View root) {
            super(root);
            ButterKnife.bind(this, root);
        }

        @Override
        public void onClick(View view) {
            BuildingsListingAdapter.this.view.onBuildingClicked(building);
        }
    }

    public BuildingsListingAdapter(BuildingsListingView buildingsView) {
        this.buildings = new ArrayList<Building>();
        buildings.add(new Building("DAC", R.drawable.dac));
        buildings.add(new Building("LIB", R.drawable.lib));
        buildings.add(new Building("SJH", R.drawable.sjh));


        view = buildingsView;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View rootView = LayoutInflater.from(context).inflate(R.layout.building_grid_item, parent, false);

        return new ViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.itemView.setOnClickListener(holder);
        holder.building = buildings.get(position);
        holder.building.getName();
        holder.poster.setImageResource(holder.building.getPhotoID());

        /*RequestOptions options = new RequestOptions()
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                .priority(Priority.HIGH);

        Glide.with(context)
                .asBitmap()
                .load(Api.getPosterPath(holder.movie.getPosterPath()))
                .apply(options)
                .into(new BitmapImageViewTarget(holder.poster) {
                    @Override
                    public void onResourceReady(Bitmap bitmap, @Nullable Transition<? super Bitmap> transition) {
                        super.onResourceReady(bitmap, transition);
                        Palette.from(bitmap).generate(palette -> setBackgroundColor(palette, holder));
                    }
                });*/
    }

    /*private void setBackgroundColor(Palette palette, ViewHolder holder) {
        holder.titleBackground.setBackgroundColor(0x0);
    }*/

    @Override
    public int getItemCount() {
        return buildings.size();
    }
}
