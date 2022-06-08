package io.github.rahul_gill.lint_check

import com.android.tools.lint.client.api.IssueRegistry
import com.android.tools.lint.client.api.Vendor
import com.android.tools.lint.detector.api.CURRENT_API
import com.android.tools.lint.detector.api.Issue


@Suppress("UnstableApiUsage")
class IssueRegistry : IssueRegistry() {

    override val api: Int = CURRENT_API

    override val issues: List<Issue>
        get() = listOf(StyleAttributeUsageIssue.ISSUE)
    override val vendor: Vendor
        get() = Vendor(vendorName = "Mifos", identifier = "mifos", feedbackUrl = "mifos.io", contact = "support@mifos.io")
}