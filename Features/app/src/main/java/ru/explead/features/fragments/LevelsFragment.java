package ru.explead.features.fragments;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;

import ru.explead.features.LevelsActivity;
import ru.explead.features.MainActivity;
import ru.explead.features.R;
import ru.explead.features.Utils.Utils;
import ru.explead.features.app.App;
import ru.explead.features.logic.Level;

/**
 * Created by develop on 15.12.2016.
 */
public class LevelsFragment extends Fragment {

    protected ArrayList<ButtonLevel> array = new ArrayList<>();
    protected GridView gvMain;
    protected GridAdapter adapter;

    public void createButtons(int size, int complexity) {
        this.array.clear();
        for(int i = 0; i < size; i++) {
            array.add(new ButtonLevel(complexity, i + 1));
        }
        adapter = new GridAdapter(array);
        gvMain.setAdapter(adapter);
        gvMain.setNumColumns(3);
    }

    class ButtonLevel {
        private int number;
        private int complexity;

        public static final int STATUS_OPEN = 1, STATUS_CURRENT = 2, STATUS_CLOSE = 3;
        private int status;

        public ButtonLevel(int complexity, int number) {
            this.complexity = complexity;
            this.number = number;
            findStatus();
        }

        public void findStatus() {
            if(complexity == Level.EASY) {
                int easy_current_level = LevelsActivity.getPref().getInt(Utils.EASY_CURRENT_LEVEL, 1);
                System.out.println(easy_current_level + " " + number);
                if(number == easy_current_level) {
                    status = STATUS_CURRENT;
                }
                if(number > easy_current_level) {
                    status = STATUS_CLOSE;
                }
                if(number < easy_current_level) {
                    status = STATUS_OPEN;
                }
            }
            if(complexity == Level.MEDIUM) {

            }
            if(complexity == Level.HARD) {

            }
            if(complexity == Level.VERY_HARD) {

            }
        }

        public int getStatus() {
            return status;
        }

        public int getNumber() {
            return number;
        }

        public int getComplexity() {
            return complexity;
        }
    }



    class GridAdapter extends BaseAdapter {

        ArrayList<ButtonLevel> array =  new ArrayList<>();
        private LayoutInflater lInflater;
        private ViewHolder viewHolder;

        public GridAdapter(ArrayList<ButtonLevel> array){
            this.array.clear();
            this.array.addAll(array);
            lInflater = (LayoutInflater) LevelsActivity.getActivity()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = lInflater.inflate(R.layout.item_level, parent, false);
                viewHolder = new ViewHolder();

                viewHolder.levelLayout = (RelativeLayout) convertView.findViewById(R.id.levelLayout);
                viewHolder.tvLevel = (TextView) convertView.findViewById(R.id.tvLevel);
                viewHolder.view = convertView.findViewById(R.id.view);

                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }

            final ButtonLevel buttonLevel = (ButtonLevel) getItem(position);
            viewHolder.tvLevel.setText(Integer.toString(buttonLevel.getNumber()));
            if(buttonLevel.getStatus() == ButtonLevel.STATUS_CURRENT) {
                viewHolder.view.setBackgroundColor(LevelsActivity.getActivity().getResources().getColor(R.color.green));
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

            System.out.println("return");
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
            View view;
            RelativeLayout levelLayout;
        }
    }
}
