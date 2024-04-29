gradle.startParameter.excludedTaskNames.addAll(listOf(":buildSrc:testClasses"))
pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "killergram"
include(":app")
include(":core:designsystem")
include(":core:network")
include(":core:domain")
include(":core:data")
include(":core:common")
include(":core:local")
include(":feature")
include(":feature:splash")
