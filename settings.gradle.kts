rootProject.name = "Canis"

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            version("minestom", "2026.06.20-26.1.2")
            version("junit", "6.1.0")

            library("minestom","net.minestom", "minestom").versionRef("minestom")
            library("minestom-test", "net.minestom", "testing").version("minestom")
            library("junit-jupiter", "org.junit.jupiter", "junit-jupiter").versionRef("junit")
            library("junit-jupiter-engine", "org.junit.jupiter", "junit-jupiter-engine").versionRef("junit")
        }
    }
}
