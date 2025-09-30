rootProject.name = "Canis"

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            version("minestom", "2025.09.13-1.21.8")
            version("junit", "5.14.0")

            library("minestom","net.minestom", "minestom").versionRef("minestom")
            library("minestom-test", "net.minestom", "testing").version("minestom")
            library("junit-jupiter", "org.junit.jupiter", "junit-jupiter").versionRef("junit")
            library("junit-jupiter-engine", "org.junit.jupiter", "junit-jupiter-engine").versionRef("junit")
        }
    }
}
