packages
- design: contains color, typography, sizing and spacing attributes and a base theme with default values of those attributes
- components: contains custom defined UI widgets and a theme which contains defauls styles for those components
- demoApp: component and design usage example

How this is incooperated in the app
- set the design system theme as application theme
```xml
<manifest>

    <application
        ...
        android:theme="@style/Mifos.DesignSystem.ThemeTheme.MifosUI">
        ...
    </application>

</manifest>

```
- or make application theme inherit from design system theme to override some values
```xml
<style name="AppTheme" parent="Mifos.DesignSystem.Theme">
    <item name="mfColorBackground">@color/gray</item>
    ...
</style>
```
- then use the components in your app
```xml
<org.mifos.ui.components.MfButton
    android:layout_height="wrap_content"
    android:layout_width="wrap_content"
    android:text="Hello World!" />
<org.mifos.ui.components.MfTextView
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="Hello world!"/>
<org.mifos.ui.components.MfClickableCard
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    app:title="Theme"
    app:description="Choose your theme"
    app:iconSrc="@drawable/ic_baseline_invert_colors_24" />
```

### Theme Attributes
Colors:
mfColorPrimary
mfColorBackground
mfColorBasic
mfColorDisabled
mfColorText
mfColorTextReverse
mfColorTextDisabled
mfColorSuccess
mfColorLink
mfColorWarning
mfColorError
<br>
Typography:
mfTypographyHeadline1
mfTypographyHeadline2
mfTypographyHeadline3
mfTypographyHeadline4
mfTypographyHeadline5
mfTypographyHeadline6
mfTypographySubtitle1
mfTypographySubtitle2
mfTypographyParagraph1
mfTypographyParagraph2
mfTypographyCaption1
mfTypographyCaption2
mfTypographyLabel
mfTypographyButton

### Clickable card attributes
title, description, iconSrc, titleTint, descriptionTint, iconTint