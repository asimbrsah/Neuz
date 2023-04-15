import org.gradle.api.artifacts.dsl.DependencyHandler

object AppDependencies {
    // Core
    val core = "androidx.core:core-ktx:${Versions.core}"

    // LifeCycle
    val lifecycle = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"

    // Compose
    val composeBom = "androidx.compose:compose-bom:${Versions.composeBom}"
    val composeWithMaterial = "androidx.compose.material3:material3"
    val composeWithLiveData = "androidx.compose.material3:material3"
    val composeWithActivity = "androidx.activity:activity-compose:${Versions.composeWithActivity}"
    val androidStudioPreview = "androidx.compose.ui:ui-tooling-preview"
    val androidStudioPreviewTool = "androidx.compose.ui:ui-tooling"

    // Hilt
    val hilt = "com.google.dagger:hilt-android:${Versions.hilt}"
    val hiltCompile = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"

    //test libs
    private val junit = "junit:junit:${Versions.junit}"
    private val extJUnit = "androidx.test.ext:junit:${Versions.extJunit}"
    private val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espresso}"

    val androidTestLibraries = arrayListOf<String>().apply {
        add(extJUnit)
        add(espressoCore)
    }

    val testLibraries = arrayListOf<String>().apply {
        add(junit)
    }
}

//util functions for adding the different type dependencies from build.gradle file
fun DependencyHandler.kapt(list: List<String>) {
    list.forEach { dependency ->
        add("kapt", dependency)
    }
}

fun DependencyHandler.implementation(list: List<String>) {
    list.forEach { dependency ->
        add("implementation", dependency)
    }
}

fun DependencyHandler.androidTestImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("androidTestImplementation", dependency)
    }
}

fun DependencyHandler.testImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("testImplementation", dependency)
    }
}