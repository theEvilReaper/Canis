rootProject.name = "Canis"

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            library("minestom", "net.onelitefeather.microtus", "Minestom").version("1.1.0")
            library("minestom-test", "net.onelitefeather.microtus.testing", "testing").version("1.1.0")
            library("junit-jupiter", "org.junit.jupiter", "junit-jupiter").version("5.10.0")
            library("junit-jupiter-engine", "org.junit.jupiter", "junit-jupiter-engine").version("5.10.0")
        }
    }
}