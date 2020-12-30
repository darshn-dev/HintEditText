package dev.darshn.hintedittext

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView

class HintEditText : LinearLayout {
    lateinit var tvHint: TextView
    lateinit var etText: EditText

    constructor(context: Context) : this(context, null){
        //initUI()
    }
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0){
        //  initUI()
        getAttrValue(context, attrs)
    }
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        initUI()
        getAttrValue(context, attrs)

    }


    private fun initUI(){
        View.inflate(context, R.layout.layout_hint_text, this)
        tvHint = findViewById<TextView>(R.id.tv_hint)
        etText = findViewById<EditText>(R.id.et_text)
    }

    private fun getAttrValue(context: Context, attr : AttributeSet?){
        var typeedArray = context.obtainStyledAttributes(attr, R.styleable.HintEditText)
        var attrValue = typeedArray.getString(R.styleable.HintEditText_hint)
        if(attrValue!=null) {
            tvHint.text= attrValue
        }
    }


    public fun setError(error : String){
        etText?.setError(error)
    }

    public fun setText(text: String){
        etText?.setText(text)
    }
}


