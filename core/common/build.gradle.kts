plugins {
    id(libs.plugins.android.library.get().pluginId)
    id(libs.plugins.kotlin.android.get().pluginId)
}

apply<CommonGradlePlugin>()

android {
    namespace = "gram.killergram.core.common"
}
