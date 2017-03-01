package ru.explead.features.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import ru.explead.features.LevelsActivity;
import ru.explead.features.R;
import ru.explead.features.Utils.Utils;
import ru.explead.features.app.App;
import ru.explead.features.beans.ButtonLevel;
import ru.explead.features.logic.Level;

/**
 * Created by develop on 30.01.2017.
 */

public class GridAdapter extends BaseAdapter {

    ArrayList<ButtonLevel> array =  new ArrayList<>();
    private LayoutInflater lInflater;
    private ViewHolder viewHolder;

    private int widthCell;

    private Drawable imageOpen;

    public GridAdapter(ArrayList<ButtonLevel> array){
        this.array.clear();
        this.array.addAll(array);
        lInflater = (LayoutInflater) LevelsActivity.getActivity()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        widthCell = (int)(App.getWidthScreen() - LevelsActivity.getActivity().getResources().getDimension(R.dimen.standard_margin)*8)/3;
        imageOpen = LevelsActivity.getRes().getDrawable(R.drawable.circle_level);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        if (convertView == null) {
            convertView = lInflater.inflate(R.layout.item_level, parent, false);
            viewHolder = new ViewHolder();

            viewHolder.levelLayout = (RelativeLayout) convertView.findViewById(R.id.levelLayout);
            viewHolder.levelLayout.setLayoutParams(new RelativeLayout.LayoutParams(widthCell, widthCell));
            viewHolder.ivLevel = (ImageView) convertView.findViewById(R.id.ivLevel);
            viewHolder.tvLevel = (TextView) convertView.findViewById(R.id.tvLevel);

            viewHolder.tvLevel.setTypeface(Utils.getTypeFaceLevel());
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        final ButtonLevel buttonLevel = (ButtonLevel) getItem(position);
        viewHolder.tvLevel.setText(Integer.toString(buttonLevel.getNumber()));
        if(buttonLevel.getStatus() == ButtonLevel.STATUS_CURRENT) {
            viewHolder.ivLevel.setBackgroundDrawable(imageOpen);
        }
        if(buttonLevel.getStatus() == ButtonLevel.STATUS_CLOSE) {
            viewHolder.ivLevel.setBackgroundDrawable(imageOpen);
        }
        if(buttonLevel.getStatus() == ButtonLevel.STATUS_OPEN) {
            viewHolder.ivLevel.setBackgroundDrawable(imageOpen);
        }


        viewHolder.levelLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(buttonLevel.getStatus() == ButtonLevel.STATUS_OPEN || buttonLevel.getStatus() == ButtonLevel.STATUS_CURRENT) {
                    App.setLevel(new Level(buttonLevel.getComplexity(), buttonLevel.getNumber()));
                    ((LevelsActivity) LevelsActivity.getActivity()).openNewActivity();
                } else {
                    Toast.makeText(LevelsActivity.getActivity(), "Уровень закрыт", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return convertView;
    }

    @Override
    public int getCount() {
        return array.size();
    }

    @Override
    public Object getItem(int position) {
        return array.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    class ViewHolder {
        TextView tvLevel;
        ImageView ivLevel;
        RelativeLayout levelLayout;
    }
}