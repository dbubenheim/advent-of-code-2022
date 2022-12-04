import org.gradle.api.JavaVersion.VERSION_17

plugins {
    kotlin("jvm") version "1.7.21"
}

configure<JavaPluginExtension> {
    sourceCompatibility = VERSION_17
    targetCompatibility = VERSION_17
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
    implementation(kotlin("stdlib-jdk8"))

    testImplementation(kotlin("test"))
    testImplementation(platform("org.junit:junit-bom:5.8.2"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("com.willowtreeapps.assertk:assertk:0.25")
}

tasks {
    test {
        useJUnitPlatform()
        testLogging {
            events("passed", "skipped", "failed")
        }
    }

    compileKotlin {
        kotlinOptions.jvmTarget = "17"
    }
}
