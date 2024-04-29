plugins {
    id(libs.plugins.android.library.get().pluginId)
    id(libs.plugins.kotlin.android.get().pluginId)
}

apply<CommonGradlePlugin>()
apply<ComposeGradlePlugin>()

android {
    namespace = "gram.killergram.feature.splash"
}

dependencies {
    api(project(":core:common"))
    api(project(":core:designsystem"))
}
