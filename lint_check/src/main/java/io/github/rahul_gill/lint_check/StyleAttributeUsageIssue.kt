package io.github.rahul_gill.lint_check

import com.android.SdkConstants
import com.android.resources.ResourceFolderType
import com.android.tools.lint.detector.api.*
import org.w3c.dom.Attr

@Suppress("UnstableApiUsage")
object StyleAttributeUsageIssue {

    private const val ID = "StyleAttributeUsageIssue"

    private const val PRIORITY = 7

    private const val DESCRIPTION = "Usage of style attribute. Use theme styles instead"

    private const val EXPLANATION = """
        For consistency of UI, changing Views' style attributes in layout files is discouraged.
        Click here to learn more: https://sample.doc.link.com
    """

    private val CATEGORY = Category.CUSTOM_LINT_CHECKS

    private val SEVERITY = Severity.FATAL

    val ISSUE = Issue.create(
        ID,
        DESCRIPTION,
        EXPLANATION,
        CATEGORY,
        PRIORITY,
        SEVERITY,
        Implementation(MyDetector::class.java, Scope.ALL_RESOURCES_SCOPE)
    )

    class MyDetector : ResourceXmlDetector() {


        override fun appliesTo(folderType: ResourceFolderType) = ResourceFolderType.LAYOUT == folderType

        override fun getApplicableElements(): MutableList<String> = XmlScannerConstants.ALL

        override fun getApplicableAttributes() = listOf(
            SdkConstants.ATTR_TEXT_COLOR,
            SdkConstants.ATTR_TINT,
            SdkConstants.ATTR_TEXT_SIZE,
            SdkConstants.ATTR_BACKGROUND_TINT
        )

        override fun visitAttribute(context: XmlContext, attribute: Attr) {
            val incident = Incident(context, ISSUE)
                .message( "Style attribute usage in layout detected")
                .at(attribute)
            context.report(incident)
        }
    }
}