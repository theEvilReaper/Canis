plugins {
    java
    `maven-publish`
}

group = "net.theevilreaper.canis"
version = "1.0.0-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
    maven("https://jitpack.io")
}

val minestomVersion = "master-SNAPSHOT"

dependencies {
    compileOnly(libs.minestom)

    testImplementation(libs.minestom)
    testImplementation(libs.junitApi)
    testRuntimeOnly(libs.junitEngine)
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = project.properties["group"] as String?
            artifactId = project.name
            version = project.properties["version"] as String?
            from(components["java"])
        }
    }
}

tasks {
    jar {
        archiveFileName.set("${rootProject.name}.${archiveExtension.getOrElse("jar")}")
    }

    compileJava {
        options.encoding = "UTF-8"
        options.release.set(17)
    }

    test {
        useJUnitPlatform()
        testLogging {
            events("passed", "skipped", "failed")
        }
    }
}