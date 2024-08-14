rootProject.name = "Canis"

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            version("microtus", "1.4.2")
            version("junit", "5.11.0")
            library("minestom", "net.onelitefeather.microtus", "Microtus").versionRef("microtus")
            library("minestom-test", "net.onelitefeather.microtus.testing", "testing").version("microtus")
            library("junit-jupiter", "org.junit.jupiter", "junit-jupiter").versionRef("junit")
            library("junit-jupiter-engine", "org.junit.jupiter", "junit-jupiter-engine").versionRef("junit")
        }
    }
}
