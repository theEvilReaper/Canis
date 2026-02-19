rootProject.name = "Canis"

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            version("minestom", "2026.02.19-1.21.11")
            version("junit", "6.0.3")

            library("minestom","net.minestom", "minestom").versionRef("minestom")
            library("minestom-test", "net.minestom", "testing").version("minestom")
            library("junit-jupiter", "org.junit.jupiter", "junit-jupiter").versionRef("junit")
            library("junit-jupiter-engine", "org.junit.jupiter", "junit-jupiter-engine").versionRef("junit")
        }
    }
}
