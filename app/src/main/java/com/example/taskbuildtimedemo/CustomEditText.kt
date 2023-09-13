package com.example.taskbuildtimedemo

import android.content.Context
import android.util.AttributeSet
import android.widget.EditText
import java.util.ArrayList
import java.util.regex.Pattern

class CustomEditText @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defS: Int = 0
) : EditText(context, attrs, defS) {



    val comp = Pattern.compile("")

    val flag = true
    val list= ArrayList<String>()

    override fun onTextChanged(
        text: CharSequence?,
        start: Int,
        lengthBefore: Int,
        lengthAfter: Int
    ) {
        super.onTextChanged(text, start, lengthBefore, lengthAfter)
    }
}