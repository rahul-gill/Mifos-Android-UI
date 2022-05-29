package org.mifos.ui.components.util

import android.content.Context
import android.util.TypedValue
import androidx.annotation.AttrRes


fun Context.dpToFloat(dpValue: Float) = TypedValue.applyDimension(
    TypedValue.COMPLEX_UNIT_DIP,
    dpValue,
    resources.displayMetrics
)
fun Context.getThemeColor(@AttrRes colorAttr: Int): Int?{
    val typedValue = TypedValue()
    if(theme.resolveAttribute(colorAttr, typedValue, true))
        return typedValue.data
    return null
}