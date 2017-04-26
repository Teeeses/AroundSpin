package ru.explead.features.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import ru.explead.features.MainActivity;
import ru.explead.features.R;
import ru.explead.features.app.App;
import ru.explead.features.fragments.GameFragment;
import ru.explead.features.logic.Level;

/**
 * Created by develop on 16.01.2017.
 */

public class DialogMenu extends Dialog {

    private Activity activity;


    public DialogMenu(Activity activity) {
        super(activity);
        Log.d("TAG", "Initialization dialog");
        this.activity = activity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("TAG", "Create dialog");
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_menu);

        Button btnNext = (Button) findViewById(R.id.btnNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
                Level level = App.getLevel();
                App.setLevel(new Level(level.getComplexity(), level.getLevel() + 1));
                ((GameFragment)MainActivity.getFragment()).startGame();
            }
        });
    }

}