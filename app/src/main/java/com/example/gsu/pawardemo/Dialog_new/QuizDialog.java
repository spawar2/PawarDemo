/*
package com.example.gsu.pawardemo.Dialog_new;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.gsu.pawardemo.MainActivity;
import com.example.gsu.pawardemo.R;
import com.example.gsu.pawardemo.Dialog_new.QuizDialog;
import butterknife.ButterKnife;
import butterknife.OnClick;

*/
/**
 * Created by GSU on 3/1/17.
 *//*


public class QuizDialog extends Dialog {

    @OnClick(R.id.dialog_okay)
    public void okClick(){
        dismiss();
        listener.onClickListener();
    }

    private ICustomDialogEventListener listener;

    public interface ICustomDialogEventListener{
        public void onClickListener();
    }

    public QuizDialog(@NonNull Context context, ICustomDialogEventListener listener) {
        super(context, R.style.dialog);
        this.listener = listener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        int i = R.layout.custom_dialog;
        setContentView(R.layout.content_quiz);
        ButterKnife.bind(this);
        initialListener();
        initialView();
    }

    private Button rbb1;
    private Button rbb2;


    private void initialView(){
        rbb1 = (Button) findViewById(R.id.rbb1);
        rbb2 = (Button) findViewById(R.id.rbb2);
    }

    private void initialListener() {

        rbb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final QuizDialog dialog = new QuizDialog(this, new QuizDialog.ICustomDialogEventListener() {
                    @Override
                    public void onClickListener() {
                        Util("Click");

                    }
                });
                dialog.show();
            }

        });

        rbb2.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                final QuizDialog dialog = new QuizDialog(this, new QuizDialog.ICustomDialogEventListener() {
                    @Override
                    public void onClickListener() {
                        toastShort("Click");
                    }

                });
                dialog.show();

            }

        });

    }



}
*/
