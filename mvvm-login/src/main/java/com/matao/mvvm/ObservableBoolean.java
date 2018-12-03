package com.matao.mvvm;

/**
 * Created by matao on 2018/12/4
 */
public class ObservableBoolean {

    public interface OnValueChangedListener {
        void onValueChanged(boolean newValue);
    }

    private boolean value;
    private OnValueChangedListener listener;

    public void setOnValueChangedListener(OnValueChangedListener listener) {
        this.listener = listener;
    }

    public void setValue(boolean value) {
        this.value = value;
        if (listener != null) {
            listener.onValueChanged(value);
        }
    }

    public boolean getValue() {
        return value;
    }
}
