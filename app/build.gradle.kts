plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.devtools.ksp") version "1.9.0-1.0.13"
}

android {
    namespace = "com.sav.noteapp"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.sav.noteapp"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    packaging.resources.excludes.add("META-INF/atomicfu.kotlin_module")


    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    val activityVersion = "1.7.2"
    val appCompatVersion = "1.6.1"
    val constraintLayoutVersion = "2.1.4"
    val coreTestingVersion = "2.2.0"
    val coroutines = "1.7.3"
    val lifecycleVersion = "2.6.1"
    val materialVersion = "1.9.0"
    val roomVersion = "2.5.2"
    // testing
    val junitVersion = "4.13.2"
    val espressoVersion = "3.5.1"
    val androidxJunitVersion = "1.1.5"

    implementation ("androidx.appcompat:appcompat:$appCompatVersion")
    implementation ("androidx.activity:activity-ktx:$activityVersion")

    // Dependencies for working with Architecture components
    // You'll probably have to update the version numbers in build.gradle (Project)

    // Room components
    implementation ("androidx.room:room-ktx:$roomVersion")
    ksp ("androidx.room:room-compiler:$roomVersion")
    androidTestImplementation ("androidx.room:room-testing:$roomVersion")

    // Lifecycle components
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion")
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycleVersion")
    implementation ("androidx.lifecycle:lifecycle-common-java8:$lifecycleVersion")

    // Kotlin components
    implementation ("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.9.0")
    api ("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutines")
    api ("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutines")

    // UI
    implementation ("androidx.constraintlayout:constraintlayout:$constraintLayoutVersion")
    implementation ("com.google.android.material:material:$materialVersion")

    // Testing
    testImplementation ("junit:junit:$junitVersion")
    androidTestImplementation ("androidx.arch.core:core-testing:$coreTestingVersion")
    androidTestImplementation ("androidx.test.espresso:espresso-core:$espressoVersion") {
        exclude(group = "com.android.support", module = "support-annotations")
    }
    androidTestImplementation ("androidx.test.ext:junit:$androidxJunitVersion")
}



