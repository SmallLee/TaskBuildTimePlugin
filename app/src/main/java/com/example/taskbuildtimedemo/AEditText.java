package com.example.taskbuildtimedemo;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class AEditText extends androidx.appcompat.widget.AppCompatEditText {

    boolean flag = true;

    List arrraylist = new ArrayList();
    public AEditText(@NonNull Context context) {
        super(context);
    }

    public AEditText(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {
        super.onTextChanged(text, start, lengthBefore, lengthAfter);
    }
}
