plugins {
    java
}

group = "ilio"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.google.guava", "guava", "29.0-jre")
    testImplementation("junit", "junit", "4.12")
}
