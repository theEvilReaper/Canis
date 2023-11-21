rootProject.name = "Canis"

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            version("microtus", "1.1.1")
            version("junit", "5.10.0")
            library("minestom", "net.onelitefeather.microtus", "Minestom").versionRef("microtus")
            library("minestom-test", "net.onelitefeather.microtus.testing", "testing").versionRef("microtus")
            library("junit-jupiter", "org.junit.jupiter", "junit-jupiter").versionRef("junit")
            library("junit-jupiter-engine", "org.junit.jupiter", "junit-jupiter-engine").versionRef("junit")
        }
    }
}
