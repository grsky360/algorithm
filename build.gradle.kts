plugins {
    id("org.springframework.boot") version "2.4.1"
    id("io.spring.dependency-management") version "1.0.10.RELEASE"
    java
    scala
}

group = "ilio"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11
java.targetCompatibility = JavaVersion.VERSION_11

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

sourceSets {
    main {
        java.srcDir(file("src/main/java"))
        withConvention(ScalaSourceSet::class) {
            scala.srcDir(file("src/main/scala"))
        }
    }
    test {
        java.srcDir(file("src/test/java"))
        withConvention(ScalaSourceSet::class) {
            scala.srcDir(file("src/test/scala"))
        }
    }
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web") {
        exclude(module = "spring-boot-starter-tomcat")
    }
    implementation("org.springframework.boot:spring-boot-starter-jetty")
    implementation("org.springframework.boot:spring-boot-starter-web")
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("junit:junit:4.13")

    runtimeOnly("mysql:mysql-connector-java")

    implementation("com.google.guava:guava:30.1-jre")
    implementation("com.google.code.gson:gson")

    implementation("org.apache.lucene:lucene-core:8.8.1")

    implementation("org.scala-lang:scala-library:2.11.12")
    testImplementation("org.scalatest:scalatest_2.11:3.0.0")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
