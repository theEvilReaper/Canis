plugins {
    java
    signing
    `java-library`
    `maven-publish`
}

group = "net.theevilreaper.canis"
version = System.getenv("TAG_VERSION") ?: "1.0.0-SNAPSHOT"

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

repositories {
    mavenCentral()
}

dependencies {
    compileOnly(libs.minestom)
    testImplementation(libs.minestom)
    testImplementation(libs.minestom.test)
    testImplementation(libs.junit.jupiter)
    testRuntimeOnly(libs.junit.jupiter.engine)
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components.findByName("java"))
            groupId = "net.theevilreaper"
            artifactId = project.name
            version = project.version.toString()
            pom {
                name.set("Canis")
                description.set("A utility library from BlockHandlers for Microtus (Minestom)")
                url.set("https://github.com/theEvilReaper/Canis")
                licenses {
                    license {
                        name.set("AGPL-3.0")
                        url.set("https://github.com/theEvilReaper/Canis/blob/dev/LICENSE")
                    }
                }
                issueManagement {
                    system.set("Github")
                    url.set("https://github.com/theEvilReaper/Canis/issues")
                }
                developers {
                    developer {
                        id.set("theEvilReaper")
                        name.set("Steffen Wonning")
                        email.set("steffenwx@gmail.com")
                    }
                }
                scm {
                    connection.set("scm:git@github.com:theEvilReaper/Canis.git")
                    developerConnection.set("scm:git@github.com:theEvilReaper/Canis.git")
                    url.set("https://github.com/theEvilReaper/Canis")
                }
            }
        }
    }
    repositories {
        maven {
            val releasesRepoUrl = "https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/"
            val snapshotsRepoUrl = "https://s01.oss.sonatype.org/content/repositories/snapshots/"
            url = when (version.toString().endsWith("SNAPSHOT")) {
                true -> uri(snapshotsRepoUrl)
                else -> uri(releasesRepoUrl)
            }
            credentials {
                username = System.getenv("OSSRH_USERNAME")
                password = System.getenv("OSSRH_PASSWORD")
            }
        }
    }
}

tasks {
    jar {
        archiveFileName.set("${rootProject.name}.${archiveExtension.getOrElse("jar")}")
    }

    compileJava {
        options.encoding = "UTF-8"
        options.release.set(21)
    }

    test {
        useJUnitPlatform()
        testLogging {
            events("passed", "skipped", "failed")
        }
    }
}