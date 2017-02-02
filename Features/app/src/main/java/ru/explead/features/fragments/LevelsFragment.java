package ru.explead.features.fragments;

import android.support.v4.app.Fragment;
import android.widget.GridView;
import java.util.ArrayList;
import ru.explead.features.adapters.GridAdapter;
import ru.explead.features.beans.ButtonLevel;

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

    public void refreshStatus() {
        for(int i = 0; i < array.size(); i++) {
            array.get(i).findStatus();
        }
    }


    @Override
    public void onResume() {
        refreshStatus();
        if(adapter != null) {
            adapter.notifyDataSetChanged();
        }
        super.onResume();
    }
}
