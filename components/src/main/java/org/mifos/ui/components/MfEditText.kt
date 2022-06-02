package org.mifos.ui.components

import android.content.Context
import android.util.AttributeSet
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MfEditText @JvmOverloads constructor(
    context: Context,
    AttributeSet: AttributeSet? = null
): TextInputEditText(context, AttributeSet)


class MfEditTextLayout @JvmOverloads constructor(
    context: Context,
    AttributeSet: AttributeSet? = null,
    defStyleAttr: Int = R.attr.mfStyleEditTextLayout
): TextInputLayout(context, AttributeSet, defStyleAttr)