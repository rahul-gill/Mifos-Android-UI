package org.mifos.ui.components

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.text.method.DigitsKeyListener
import android.util.AttributeSet
import android.view.inputmethod.EditorInfo
import org.mifos.ui.components.util.dpToFloat
import org.mifos.ui.components.util.getThemeColor

class MfPinEntryEditText @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
): com.alimuzaffar.lib.pin.PinEntryEditText(context, attrs, defStyleAttr){
    init {
        isCursorVisible = false
        keyListener = DigitsKeyListener.getInstance("0123456789")
        isFocusable = true
        isFocusableInTouchMode = true
        inputType = EditorInfo.TYPE_CLASS_NUMBER
        setTextIsSelectable(false)
        mLineStroke = context.dpToFloat(2F)
        mLineStrokeSelected = context.dpToFloat(4F)
        val colors = intArrayOf(
            context.getThemeColor(org.mifos.ui.design.R.attr.mfColorPrimary) ?: Color.GREEN,
            Color.RED,
            Color.BLACK,
            Color.GRAY
        )
        mColorStates = ColorStateList(mStates, colors)


    }
}