plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kapt)
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt)
    alias(libs.plugins.kotlin.parcelize)
}

apply(from = "${project.rootDir}/base.gradle")

android {
    namespace = "au.com.shiftyjelly.pocketcasts.sharedtest"
    buildFeatures {
        buildConfig = true
    }
}

dependencies {
    // These dependencies have to be redeclared here event though they are already in
    // base.gradle because here they need to not be test dependencies like they are in
    // the main app.
    implementation(libs.coroutines.test)
    implementation(libs.junit) {
        exclude(group = "org.hamcrest")
    }
}
