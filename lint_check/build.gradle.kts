plugins {
    id("java-library")
    id("kotlin")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies{

    val lintVersion = "30.2.1"

    compileOnly("com.android.tools.lint:lint-api:$lintVersion")
    compileOnly("com.android.tools.lint:lint-checks:$lintVersion")
    testImplementation("com.android.tools.lint:lint-tests:$lintVersion")

    testImplementation("junit:junit:4.13.2")
}


tasks.withType<Jar> {
    manifest {
        attributes["Lint-Registry-v2"] = "io.github.rahul_gill.lint_check.IssueRegistry"
    }
}
