rootProject.name = "oop-23-prof-vs-students"
plugins {
    id("com.gradle.enterprise") version "3.17.4"
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}

gradleEnterprise {
    buildScan {
        termsOfServiceUrl = "https://gradle.com/terms-of-service"
        termsOfServiceAgree = "yes"
        publishAlways()
        buildScanPublished {
            file("scan-journal.log").writeText("$buildScanId - $buildScanUri\n")
        }
    }
}
