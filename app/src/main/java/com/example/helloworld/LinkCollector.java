package com.example.helloworld;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.URLSpan;
import android.text.util.Linkify;
import android.util.Patterns;
import android.util.TypedValue;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.text.Html;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class LinkCollector extends AppCompatActivity {
    ArrayList<String> linkCollector = new ArrayList<String>();
    LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_link_collector);
        //A4 Assignment Show the link Collector.
        Integer it = 0;
        Intent intent = getIntent();
        Bundle lc = intent.getExtras();
        if (intent.getExtras() != null) {
            while (lc.getString(String.valueOf(it)) instanceof String) {
                String temp = lc.getString(String.valueOf(it));
                linkCollector.add(temp);
                it += 1;
            }
        }
        linearLayout = (LinearLayout)findViewById(R.id.Linearlayout);
        for (int i = 0; i < linkCollector.size(); i++){
            String text = linkCollector.get(i);
            TextView textview = new TextView(this);
            textview.setText(text);
            textview.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
            Pattern pattern = Pattern.compile(text);
            Linkify.addLinks(textview, pattern, "http://");
            linearLayout.addView(textview);
        }
        //A4 Assignment Floating Action Button
        FloatingActionButton fab = findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.out.println("Floating Action Button");
                showInputDialog();
            }
        });
        if (lc!=null){
            if (lc.getString("-1") instanceof String){
                Snackbar snackbar = Snackbar.make(linearLayout, "Submit Successfully!", Snackbar.LENGTH_LONG);
                snackbar.show();
            }
        }

    }

    private void showInputDialog() {
        /*@setView 装入一个EditView
         */
        final EditText editText = new EditText(LinkCollector.this);
        AlertDialog.Builder inputDialog =
                new AlertDialog.Builder(LinkCollector.this);
        inputDialog.setTitle("Enter the link").setView(editText);
        inputDialog.setPositiveButton("Submit",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (isValidURL(editText.getText().toString())) {
                            linkCollector.add(editText.getText().toString());
                            Intent i = new Intent(LinkCollector.this, LinkCollector.class);
                            i.putExtra("-1", "");
                            for (int t = 0; t < linkCollector.size(); t++) {
                                i.putExtra(String.valueOf(t), linkCollector.get(t));
                            }

                            finish();
                            startActivity(i);
                        }
                        else{
                            showInputDialog();
                            Snackbar snackbar = Snackbar.make(linearLayout, "Doesn't fit URL format, reenter!", Snackbar.LENGTH_LONG);
                            snackbar.show();
                        }
                    }
                }).show();
    }

    public boolean isValidURL(String input) {
        if (TextUtils.isEmpty(input)) {
            return false;
        }
        Pattern URL_PATTERN = Patterns.WEB_URL;
        boolean isURL = URL_PATTERN.matcher(input).matches();
        if (!isURL) {
            String urlString = input + "";
            if (URLUtil.isNetworkUrl(urlString)) {
                try {
                    new URL(urlString);
                    isURL = true;
                } catch (Exception e) {
                }
            }
        }
        return isURL;
    }
}