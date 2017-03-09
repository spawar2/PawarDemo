package com.example.gsu.pawardemo;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.gsu.pawardemo.bean.Book;
import com.example.gsu.pawardemo.dialog.quiz_class;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Quiz extends BaseActivity {


    private Button dialog_cancel;
    private Button dialog_okay;



    private quiz_class.ICustomDialogEventListener listener;  //making a interface

    //public interface ICustomDialogEventListener { public void onClickListener(); }
    //Custom Dialog method 

   // public Quiz(@NonNull Context context, quiz_class.ICustomDialogEventListener listener) {this.listener = listener; }

    private void customdialog() {
        final quiz_class dialog = new quiz_class(this, new quiz_class.ICustomDialogEventListener() {
            @Override
            public void onClickListener() {
                toastShort("Ok button was clicked");
            }
        });
        dialog.show();
    }



    private int checkedID;
    @BindView(R.id.rdg2) RadioGroup radioGroup;
    @OnClick(R.id.dialog_okay)
    public void onClickListener(){
        switch (checkedID){
            case R.id.rbb1:
                normalDialog1();
                break;
            case R.id.rbb2:
                normalDialog2();
                break;
            case R.id.dialog_okay:
                normalDialog3();
                break;
            default:
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_quiz);
        initialView();
        initialListener();
        onClickListener();
        ButterKnife.bind(this);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                toastShort("You checked "+checkedId);
                checkedID = checkedId;
            }
        });
    }


    private void initialView(){
        dialog_cancel = (Button) findViewById(R.id.dialog_cancel);
        dialog_okay = (Button) findViewById(R.id.dialog_okay);
    }

    private void initialListener() {
        dialog_cancel.setOnClickListener(new View.OnClickListener() {    //method to go to viewpager
            @Override
            public void onClick(View v){
                Toast.makeText(v.getContext(),"Button1 was clicked", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(v.getContext(), ViewPagerActivity.class);
                intent.putExtra("key","value");
                Bundle bundle = new Bundle();
                bundle.putInt("Integer", 12345);
                Book book = new Book();
                book.setName("Android");
                book.setAuthor("Pawar");
                bundle.putSerializable("book", book);
                intent.putExtras(bundle);
                startActivityForResult(intent, 1);
            }
        });

    }


    private void normalDialog1() {              //Custom dialog method 1
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.mipmap.ic_launcher);
        dialog_okay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), DialogActivity.class);
                startActivityForResult(intent,3);
            }
        });

        builder.show();
    }


    private void normalDialog2() {           //Custom dialog method 2
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.mipmap.ic_launcher);
        dialog_okay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ListViewActivity.class);
                startActivityForResult(intent,3);
            }
        });


        builder.show();
    }

    private void normalDialog3() {           //Custom dialog method 3
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.mipmap.ic_launcher);
        dialog_okay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Quiz.class);
                startActivityForResult(intent,3);
            }
        });
        builder.show();
    }


    }
