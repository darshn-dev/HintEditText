package dev.darshn.hintedittext

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView


class HintEditText : LinearLayout {
    private lateinit var tvHint: TextView
    private lateinit var etText: EditText


    constructor(context: Context) : this(context, null) {
        //initUI()
    }

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0) {
        //  initUI()
        getAttrValue(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        initUI()
        getAttrValue(context, attrs)

    }


    private fun initUI() {
        View.inflate(context, R.layout.layout_hint_text, this)
        tvHint = findViewById(R.id.tv_hint)
        etText = findViewById(R.id.et_text)
    }

    private fun getAttrValue(context: Context, attr: AttributeSet?) {
        val typeedArray = context.obtainStyledAttributes(attr, R.styleable.HintEditText)
        val attrValue = typeedArray.getString(R.styleable.HintEditText_hint)
        val hintColor = typeedArray.getColor(
            R.styleable.HintEditText_hintColor,
            resources.getColor(R.color.design_default_color_on_primary)
        )
        val tvColor = typeedArray.getColor(
            R.styleable.HintEditText_textColor,
            resources.getColor(R.color.design_default_color_on_primary)
        )
        if (attrValue != null) {
            tvHint.text = attrValue
            etText.setTextColor(tvColor)
            tvHint.setTextColor(hintColor)
        }
    }


    fun setError(error: String) {
        etText.error = error
    }

    fun setText(text: String) {
        etText.setText(text)
    }
}


