package com.example.donations;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.NumberPicker;

public class CyclicNumberPicker extends NumberPicker {
    private int minValue;
    private int maxValue;

    public CyclicNumberPicker(Context context) {
        super(context);
        initialize();
    }

    public CyclicNumberPicker(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize();
    }

    public CyclicNumberPicker(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize();
    }

    private void initialize() {
        minValue = 0;
        maxValue = 10000;
        setMinValue(minValue);
        setMaxValue(maxValue);
    }

    @Override
    public void setValue(int value) {
        if (value < minValue) {
            super.setValue(maxValue);
        } else if (value > maxValue) {
            super.setValue(minValue);
        } else {
            super.setValue(value);
        }
    }
}

