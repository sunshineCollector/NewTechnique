package artframe.study.sunshine.artframe.ui.home.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import artframe.study.sunshine.artframe.R;
import artframe.study.sunshine.artframe.model.bean.FruitBean;
import artframe.study.sunshine.artframe.ui.fruit.FruitActivity;

/**
 * Created by xiaofeng on 2016/12/29.
 * HomepageAdapter
 */

public class HomepageAdapter extends RecyclerView.Adapter<HomepageAdapter.FruitViewHolder> {
    private ArrayList<FruitBean> fruitList;

    public HomepageAdapter(@NonNull ArrayList<FruitBean> list) {
        this.fruitList = list;
    }

    private Context mContext;

    @Override
    public HomepageAdapter.FruitViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (null == mContext) mContext = parent.getContext();
        View view = LayoutInflater.from(mContext).inflate(R.layout.cardview, parent, false);
        final FruitViewHolder fruitViewHolder = new FruitViewHolder(view);
        fruitViewHolder.cardView.setOnClickListener((v) -> {
            int position = fruitViewHolder.getAdapterPosition();
            FruitBean fruitBean = fruitList.get(position);
            Intent intent = new Intent(mContext, FruitActivity.class);
            intent.putExtra(FruitActivity.FRUIT_NAME, fruitBean.name).putExtra(FruitActivity.FRUIT_IMAEG_ID, fruitBean.imageID);
            mContext.startActivity(intent);
        });
        return fruitViewHolder;
    }

    @Override
    public void onBindViewHolder(HomepageAdapter.FruitViewHolder holder, int position) {
        FruitBean fruitBean = fruitList.get(position);
        Glide.with(mContext).fromResource().load(fruitBean.imageID).into(holder.imvIcon);
        holder.tvName.setText(fruitBean.name);
    }

    @Override
    public int getItemCount() {
        return fruitList.size();
    }

    class FruitViewHolder extends RecyclerView.ViewHolder {
        private final CardView cardView;
        private final ImageView imvIcon;
        private final TextView tvName;

        private FruitViewHolder(View rootView) {
            super(rootView);
            imvIcon = (ImageView) rootView.findViewById(R.id.imv_icon);
            tvName = (TextView) rootView.findViewById(R.id.tv_name);
            cardView = (CardView) rootView.findViewById(R.id.cardView);
        }
    }

}
