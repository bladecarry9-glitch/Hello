package com.example.helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends Activity {
    private TextView output;
    private EditText nameInput;
    private EditText countInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        buildScreen();
    }

    private void buildScreen() {
        int pad = dp(20);
        ScrollView scroll = new ScrollView(this);
        LinearLayout page = new LinearLayout(this);
        page.setOrientation(LinearLayout.VERTICAL);
        page.setPadding(pad, pad, pad, pad);
        page.setGravity(Gravity.CENTER_HORIZONTAL);
        page.setBackgroundColor(0xFFF5F7FB);

        TextView title = new TextView(this);
        title.setText("HELLO WORLD PLUS");
        title.setTextSize(25);
        title.setTextColor(0xFF172554);
        title.setGravity(Gravity.CENTER);
        title.setPadding(0, dp(18), 0, dp(8));
        title.setTypeface(null, 1);
        page.addView(title, matchWrap());

        TextView subtitle = new TextView(this);
        subtitle.setText("Your first Java Android app");
        subtitle.setTextSize(15);
        subtitle.setTextColor(0xFF64748B);
        subtitle.setGravity(Gravity.CENTER);
        page.addView(subtitle, matchWrap());

        output = new TextView(this);
        output.setText("Welcome! Tap a button to get started.");
        output.setTextSize(17);
        output.setTextColor(0xFF1E293B);
        output.setGravity(Gravity.CENTER);
        output.setPadding(dp(14), dp(22), dp(14), dp(22));
        output.setBackgroundColor(0xFFFFFFFF);
        LinearLayout.LayoutParams outputParams = matchWrap();
        outputParams.setMargins(0, dp(24), 0, dp(18));
        page.addView(output, outputParams);

        addButton(page, "Print Hello World", v ->
                output.setText("Hello, World!"));

        nameInput = new EditText(this);
        nameInput.setSingleLine(true);
        nameInput.setHint("Enter your name");
        nameInput.setTextSize(16);
        page.addView(nameInput, matchWrap());
        addButton(page, "Personal Greeting", v -> {
            String name = nameInput.getText().toString().trim();
            output.setText(name.isEmpty()
                    ? "Hello, friend!"
                    : "Hello, " + name + "! Welcome to Java Android.");
        });

        countInput = new EditText(this);
        countInput.setSingleLine(true);
        countInput.setInputType(android.text.InputType.TYPE_CLASS_NUMBER);
        countInput.setHint("Repeat count (1–100)");
        countInput.setTextSize(16);
        page.addView(countInput, matchWrap());
        addButton(page, "Repeat Hello World", v -> repeatGreeting());

        addButton(page, "Show Date and Time", v -> {
            String now = new SimpleDateFormat(
                    "dd MMM yyyy, hh:mm:ss a", Locale.getDefault()
            ).format(new Date());
            output.setText("Current date and time:\n" + now);
        });

        addButton(page, "Clear", v -> {
            nameInput.setText("");
            countInput.setText("");
            output.setText("Welcome! Tap a button to get started.");
        });

        TextView footer = new TextView(this);
        footer.setText("Built with Java • No internet permission • No external libraries");
        footer.setTextSize(12);
        footer.setTextColor(0xFF64748B);
        footer.setGravity(Gravity.CENTER);
        footer.setPadding(0, dp(22), 0, dp(12));
        page.addView(footer, matchWrap());

        scroll.addView(page);
        setContentView(scroll);
    }

    private void repeatGreeting() {
        String value = countInput.getText().toString().trim();
        if (value.isEmpty()) {
            countInput.setError("Enter a number from 1 to 100");
            return;
        }
        try {
            int count = Integer.parseInt(value);
            if (count < 1 || count > 100) {
                countInput.setError("Please enter 1 to 100");
                return;
            }
            StringBuilder result = new StringBuilder();
            for (int i = 1; i <= count; i++) {
                result.append(i).append(". Hello, World!");
                if (i < count) result.append('\n');
            }
            output.setText(result.toString());
        } catch (NumberFormatException ex) {
            Toast.makeText(this, "Enter a valid whole number", Toast.LENGTH_SHORT).show();
        }
    }

    private void addButton(LinearLayout parent, String label, View.OnClickListener listener) {
        Button button = new Button(this);
        button.setText(label);
        button.setAllCaps(false);
        button.setTextSize(15);
        button.setOnClickListener(listener);
        LinearLayout.LayoutParams params = matchWrap();
        params.setMargins(0, dp(5), 0, dp(5));
        parent.addView(button, params);
    }

    private LinearLayout.LayoutParams matchWrap() {
        return new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
    }

    private int dp(int value) {
        return (int) (value * getResources().getDisplayMetrics().density + 0.5f);
    }
}
