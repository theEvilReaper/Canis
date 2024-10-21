# Canis

[![license](https://img.shields.io/github/license/theEvilReaper/Canis?style=for-the-badge&color=b22234c)](../LICENSE)

The fundamental objective of this project is to develop multiple implementations of `BlockHandler` for the Microtus
project, which is built on the Minestom framework. The specific functionalities provided by the pre-implemented handlers
are contingent upon the requirements of the application. For instance, one implementation may permit only read access to
block data, while another may allow for both reading and modifying this data. It is important to note that this project
does not aim to replicate the vanilla mechanics of Minecraft; rather, it serves as a utility to facilitate basic data
reading from blocks, particularly in the context of mini-games.

> [!IMPORTANT]
> Due to other projects taking priority, this project may look like it not being maintained.
> However every pull request is welcome to enhance the functionality of this project.

## Usage

The project is currently available over the **Jitpack** repository.
Currently, there is not really versioning, so the required version is `master-SNAPSHOT`.

If you are using `Gradle` as your preferred build system, you can add the following lines to your `build.gradle` file.

```gradle
repositories {
    maven("https://jitpack.io")
}

dependencies {
    implementation("com.github.theEvilReaper:Canis:master-SNAPSHOT")
}
```

> [!NOTE]
> In the future it's planned to release the project via the central maven repository.