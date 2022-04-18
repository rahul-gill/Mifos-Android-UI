package org.mifos.ui.components

import android.content.Context
import android.content.res.TypedArray
import android.graphics.BlendMode
import android.graphics.BlendModeColorFilter
import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Build
import android.util.AttributeSet
import android.util.TypedValue
import android.view.LayoutInflater
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import com.google.android.material.card.MaterialCardView


class MfClickableCard @JvmOverloads  constructor(
    context: Context,
    AttributeSet: AttributeSet,
    defStyleAttr: Int = R.attr.mfStyleTextView
) : MaterialCardView(context, AttributeSet, defStyleAttr){

    private val title by lazy { findViewById<MfTextView>(R.id.title) }
    private val description by lazy { findViewById<MfTextView>(R.id.description) }
    private val icon by lazy { findViewById<ImageView>(R.id.icon) }

    init {
        LayoutInflater.from(getContext()).inflate(R.layout.component_clickable_card, this, true)
        val attributeArray: TypedArray = context.theme.obtainStyledAttributes(
            AttributeSet,
            R.styleable.MfClickableCard, 0, 0
        )
        val defaultTitleColor = TypedValue()
        val defaultDescColor = TypedValue()
        val theme = context.theme
        theme.resolveAttribute(org.mifos.ui.design.R.attr.mfColorText, defaultTitleColor, true)
        theme.resolveAttribute(org.mifos.ui.design.R.attr.mfColorBasic, defaultDescColor, true)



        setTitle(attributeArray.getString(R.styleable.MfClickableCard_title) ?: "")
        setDescription(attributeArray.getString(R.styleable.MfClickableCard_description) ?: "")
        setIcon(attributeArray.getResourceId(R.styleable.MfClickableCard_iconSrc, org.mifos.ui.design.R.color.mf_basic))
        setTitleTint(attributeArray.getColor(R.styleable.MfClickableCard_titleTint, defaultTitleColor.data))
        setDescriptionTint(attributeArray.getColor(R.styleable.MfClickableCard_descriptionTint, defaultDescColor.data))
        setIconTint(attributeArray.getColor(R.styleable.MfClickableCard_iconTint, Color.BLACK))
        attributeArray.recycle()

        isClickable = true
        background = ContextCompat.getDrawable(getContext(), R.drawable.ripple)
        elevation = 0f
    }

    fun setTitle(text: CharSequence){
        title.text = text
    }

    fun setDescription(text: CharSequence){
        description.text = text
    }

    fun setIcon(@DrawableRes resId: Int){
        icon.setImageResource(resId)
    }

    fun setTitleTint(color: Int){
        title.setTextColor(color)
    }

    fun setDescriptionTint(color: Int){
        description.setTextColor(color)
    }

    fun setIconTint(color: Int){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q)
                icon.drawable.mutate().colorFilter = BlendModeColorFilter(color, BlendMode.SRC_ATOP)
            else
                icon.drawable.setColorFilter(color, PorterDuff.Mode.SRC_ATOP)
    }

}