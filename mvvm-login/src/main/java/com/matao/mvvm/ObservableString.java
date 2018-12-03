package com.matao.mvvm;

/**
 * Created by matao on 2018/12/4
 */
public class ObservableString {

    public interface OnValueChangedListener {
        void onValueChanged(String newValue);
    }

    private String value;
    private OnValueChangedListener listener;

    public void setOnValueChangedListener(OnValueChangedListener listener) {
        this.listener = listener;
    }

    public void setValue(String value) {
        this.value = value;
        if (listener != null) {
            listener.onValueChanged(value);
        }
    }

    public String getValue() {
        return value;
    }
}
