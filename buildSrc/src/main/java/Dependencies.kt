import org.gradle.api.artifacts.dsl.DependencyHandler

object Dependencies{
    const val ANDROID_APP_COMPAT = "androidx.appcompat:appcompat:${Versions.APP_COMPAT}"
    const val ANDROID_CORE_KTX = "androidx.core:core-ktx:${Versions.CORE_KTX}"
    const val ANDROID_MATERIAL = "com.google.android.material:material:${Versions.MATERIAL}"
    const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:${Versions.CONSTRAINT_LAYOUT}"
    const val PIN_ENTRY_EDIT_TEXT = "com.alimuzaffar.lib:pinentryedittext:${Versions.PIN_TEXT_FIELD}"
}

fun DependencyHandler.appCompat() {
    add("implementation",Dependencies.ANDROID_APP_COMPAT)
    add("implementation",Dependencies.ANDROID_CORE_KTX)
}