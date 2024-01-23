pluginManagement {
    includeBuild("build-logic")
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

rootProject.name = "cvforge"

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
include(":app")
include(":core:designsystem")
include(":feature:resume")
include(":feature:profile")
include(":feature:settings")
include(":feature:premium")
include(":core:model")
include(":core:data")
include(":core:datastore")
include(":feature:home")
include(":feature:coverletter")
include(":feature:preview")
include(":core:pdf")
