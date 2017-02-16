package com.example.gsu.pawardemo.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import com.example.gsu.pawardemo.R;

import java.net.InterfaceAddress;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by GSU on 2/15/17.
 */

public class CustomDialog extends Dialog {

    @OnClick(R.id.dialog_ok)
    public void okClick(){
        dismiss();
        listener.onClickListener();

    }

    private ICustomDialogEventListener listener;

    public interface ICustomDialogEventListener{
        public void onClickListener();
    }

    public CustomDialog(@NonNull Context context, ICustomDialogEventListener listener) {
        super(context, R.style.dialog);
        this.listener = listener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int i = R.layout.custom_dialog;
        setContentView(R.layout.custom_dialog);
        ButterKnife.bind(this);
    }

}
