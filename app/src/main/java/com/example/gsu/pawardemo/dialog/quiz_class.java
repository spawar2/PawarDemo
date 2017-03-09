package com.example.gsu.pawardemo.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.example.gsu.pawardemo.Dialog_new.custom_dialog;
import com.example.gsu.pawardemo.Quiz;
import com.example.gsu.pawardemo.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by GSU on 3/8/17.
 */

public class quiz_class extends Dialog {


    @OnClick(R.id.dialog_ok)
    public void okClick(){
        dismiss();
        listener.onClickListener();

    }

    private ICustomDialogEventListener listener;

    public interface ICustomDialogEventListener{
        public void onClickListener();
    }

    public quiz_class(@NonNull Context context, quiz_class.ICustomDialogEventListener listener) {
        super(context, R.style.dialog);
        this.listener = listener;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_dialog);
        ButterKnife.bind(this);
    }
}
