import org.gradle.api.Incubating


@Incubating
object Koin {

    const val core = "io.insert-koin:koin-core:_"
    const val ext = "io.insert-koin:koin-core-ext:_"

    @Incubating
    object Ktor {
        const val ktor = "io.insert-koin:koin-ktor:_"
    }

    @Incubating
    object Android {
        const val android = "io.insert-koin:koin-android:_"
        const val ext = "io.insert-koin:koin-android-ext:_"
        const val compose = "io.insert-koin:koin-androidx-compose:_"
    }


}

@Incubating
object Utils {

    const val firebaseAuth = "dev.gitlive:firebase-auth:_"

    const val firebaseFirestore = "dev.gitlive:firebase-firestore:_"

    const val sqldelightRuntime = "com.squareup.sqldelight:runtime:_"

    const val coliJetpackCompose = "dev.chrisbanes.accompanist:accompanist-coil:_"

    const val multiplatformSettings = "com.russhwolf:multiplatform-settings:_"

    const val activityCompose = "androidx.activity:activity-compose:_"

    const val kotlinxDateTime = "org.jetbrains.kotlinx:kotlinx-datetime:_"

    const val accompanist = "dev.chrisbanes.accompanist:accompanist-insets:_"

    const val constraintLayoutCompose = "androidx.constraintlayout:constraintlayout-compose:_"

    const val navCompose = "androidx.navigation:navigation-compose:_"

    const val pagingCompose = "androidx.paging:paging-compose:_"

    const val composeUiTooling = "androidx.compose.ui:ui-tooling:_"

    const val mokoParcel = "dev.icerock.moko:parcelize:_"

    const val mokoResource = "dev.icerock.moko:resources:_"

    const val mokoResourcePlugins = "dev.icerock.moko:resources-generator:_"

    const val imageCompressor = "id.zelory:compressor:_"

    const val analyticsKtx = "com.google.firebase:firebase-analytics-ktx"

    const val ktorSerialization = "io.ktor:ktor-serialization:_"

}