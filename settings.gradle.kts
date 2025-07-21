rootProject.name = "Canis"

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            version("minestom", "2025.07.20-1.21.8")
            version("junit", "5.13.4")

            library("minestom","net.minestom", "minestom").versionRef("minestom")
            library("minestom-test", "net.minestom", "testing").version("minestom")
            library("junit-jupiter", "org.junit.jupiter", "junit-jupiter").versionRef("junit")
            library("junit-jupiter-engine", "org.junit.jupiter", "junit-jupiter-engine").versionRef("junit")
        }
    }
}
