plugins {
    kotlin("jvm") version "2.1.20"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
    implementation(kotlin("stdlib-jdk8"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.9.0")

    testImplementation(kotlin("test"))
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("com.willowtreeapps.assertk:assertk:0.26.1")
}

kotlin {
    jvmToolchain {
        languageVersion.set(JavaLanguageVersion.of("19"))
    }
}

tasks {
    test {
        useJUnitPlatform()
        testLogging {
            events("passed", "skipped", "failed")
        }
    }
}
