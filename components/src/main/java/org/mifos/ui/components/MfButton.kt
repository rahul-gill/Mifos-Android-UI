package org.mifos.ui.components

import android.content.Context
import android.util.AttributeSet
import com.google.android.material.button.MaterialButton

class MfButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = R.attr.mfStylePrimaryButton
) : MaterialButton(context, attrs, defStyleAttr)
