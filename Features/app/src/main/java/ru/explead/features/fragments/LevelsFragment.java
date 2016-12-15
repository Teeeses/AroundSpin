package ru.explead.features.fragments;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import ru.explead.features.R;

/**
 * Created by develop on 15.12.2016.
 */
public class LevelsFragment extends Fragment {

    protected ButtonLevel[] buttons;
    private int numberLevelsInLine = 3;

    public void createButtons(LayoutInflater inflater, LinearLayout layoutVertical, int size) {
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
                    buttons[count] = new ButtonLevel(count + 1, tvLevel, levelLayout, viewLevel, ButtonLevel.STATUS_OPEN);
                } else if (i == 1) {
                    TextView tvLevel = (TextView) routesView.findViewById(R.id.tvLevelTwo);
                    RelativeLayout levelLayout = (RelativeLayout) routesView.findViewById(R.id.levelLayout2);
                    View viewLevel = routesView.findViewById(R.id.viewTwo);
                    tvLevel.setText(Integer.toString(count+1));
                    levelLayout.setVisibility(View.VISIBLE);
                    buttons[count] = new ButtonLevel(count + 1, tvLevel, levelLayout, viewLevel, ButtonLevel.STATUS_OPEN);
                } else if (i == 2) {
                    TextView tvLevel = (TextView) routesView.findViewById(R.id.tvLevelThree);
                    RelativeLayout levelLayout = (RelativeLayout) routesView.findViewById(R.id.levelLayout3);
                    View viewLevel = routesView.findViewById(R.id.viewThree);
                    tvLevel.setText(Integer.toString(count+1));
                    levelLayout.setVisibility(View.VISIBLE);
                    buttons[count] = new ButtonLevel(count + 1, tvLevel, levelLayout, viewLevel, ButtonLevel.STATUS_OPEN);
                }
                count++;
            }
            layoutVertical.addView(rootHorizontalLayout);
        }
    }

    class ButtonLevel {
        private int number;
        private TextView text;
        private View view;
        private RelativeLayout levelLayout;

        public static final int STATUS_OPEN = 1, STATUS_CURRENT = 2, STATUS_CLOSE = 3;
        private int status;

        public ButtonLevel(int number, TextView text, RelativeLayout levelLayout, View view, int status) {
            this.number = number;
            this.text = text;
            this.levelLayout = levelLayout;
            this.view = view;
            this.status = status;
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

        public TextView getText() {
            return text;
        }

        public int getNumber() {
            return number;
        }
    }
}
