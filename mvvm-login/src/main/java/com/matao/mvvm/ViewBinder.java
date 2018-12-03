package com.matao.mvvm;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;

/**
 * Created by matao on 2018/12/4
 */
public class ViewBinder {

    public void bind(final TextView textView, final ObservableString observableString) {
        textView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!s.toString().equals(observableString.getValue())) {
                    observableString.setValue(s.toString());
                }
            }
        });

        observableString.setOnValueChangedListener(new ObservableString.OnValueChangedListener() {
            @Override
            public void onValueChanged(String newValue) {
                if (!newValue.equals(textView.getText().toString())) {
                    textView.setText(newValue);
                }
            }
        });
    }
}
