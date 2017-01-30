package ru.explead.features.fragments;

import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


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

    protected ButtonLevel[] buttons;
    private int numberLevelsInLine = 3;



    public void createButtons(LayoutInflater inflater, LinearLayout layoutVertical, int size, int complexity) {
        buttons = new ButtonLevel[size];
        int linesSize = size / numberLevelsInLine + 1;
        int count = 0;
        for (int j = 0; j < linesSize; j++) {
            View routesView = inflater.inflate(R.layout.horizontal_levels, null, false);
            LinearLayout rootHorizontalLayout = (LinearLayout) routesView.findViewById(R.id.rootHorizontalLayout);
            int k = (size - count);
            for (int i = 0; i < (k >= numberLevelsInLine ? numberLevelsInLine : k % numberLevelsInLine); i++) {
                if (i == 0) {
                    TextView tvLevel = (TextView) routesView.findViewById(R.id.tvLevelOne);
                    RelativeLayout levelLayout = (RelativeLayout) routesView.findViewById(R.id.levelLayout1);
                    View viewLevel = routesView.findViewById(R.id.viewOne);
                    tvLevel.setText(Integer.toString(count+1));
                    levelLayout.setVisibility(View.VISIBLE);
                    buttons[count] = new ButtonLevel(complexity, count + 1, tvLevel, levelLayout, viewLevel);
                } else if (i == 1) {
                    TextView tvLevel = (TextView) routesView.findViewById(R.id.tvLevelTwo);
                    RelativeLayout levelLayout = (RelativeLayout) routesView.findViewById(R.id.levelLayout2);
                    View viewLevel = routesView.findViewById(R.id.viewTwo);
                    tvLevel.setText(Integer.toString(count+1));
                    levelLayout.setVisibility(View.VISIBLE);
                    buttons[count] = new ButtonLevel(complexity, count + 1, tvLevel, levelLayout, viewLevel);
                } else if (i == 2) {
                    TextView tvLevel = (TextView) routesView.findViewById(R.id.tvLevelThree);
                    RelativeLayout levelLayout = (RelativeLayout) routesView.findViewById(R.id.levelLayout3);
                    View viewLevel = routesView.findViewById(R.id.viewThree);
                    tvLevel.setText(Integer.toString(count+1));
                    levelLayout.setVisibility(View.VISIBLE);
                    buttons[count] = new ButtonLevel(complexity, count + 1, tvLevel, levelLayout, viewLevel);
                }
                count++;
            }
            layoutVertical.addView(rootHorizontalLayout);
        }

        setClickListeners();
        setAnimation();
    }

    private void setAnimation() {}

    private void setClickListeners() {
        for(final ButtonLevel button: buttons) {
            button.getLevelLayout().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(button.getStatus() == ButtonLevel.STATUS_OPEN || button.getStatus() == ButtonLevel.STATUS_CURRENT) {
                        App.setLevel(new Level(button.getComplexity(), button.getNumber()));
                        ((LevelsActivity) LevelsActivity.getActivity()).openNewActivity();
                    } else {
                        Toast.makeText(LevelsActivity.getActivity(), "Уровень закрыт", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }


    class ButtonLevel {
        private int number;
        private int complexity;
        private TextView text;
        private View view;
        private RelativeLayout levelLayout;

        public static final int STATUS_OPEN = 1, STATUS_CURRENT = 2, STATUS_CLOSE = 3;
        private int status;

        public ButtonLevel(int complexity, int number, TextView text, RelativeLayout levelLayout, View view) {
            this.complexity = complexity;
            this.number = number;
            this.text = text;
            this.levelLayout = levelLayout;
            this.view = view;
            findStatus();
        }

        public void findStatus() {
            if(complexity == Level.EASY) {
                int easy_current_level = LevelsActivity.getPref().getInt(Utils.EASY_CURRENT_LEVEL, 1);
                System.out.println(easy_current_level + " " + number);
                if(number == easy_current_level) {
                    view.setBackgroundColor(LevelsActivity.getActivity().getResources().getColor(R.color.green));
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

        public RelativeLayout getLevelLayout() {
            return levelLayout;
        }

        public View getView() {
            return view;
        }

        public int getNumber() {
            return number;
        }

        public int getComplexity() {
            return complexity;
        }
    }
}
