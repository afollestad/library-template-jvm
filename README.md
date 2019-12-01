# Library Template (JVM)

This repository can be used as a template to create new GitHub repositories for Java/Kotlin libraries.

### Code Formatting

```gradle
./gradlew spotlessApply
```

*Make sure you update [spotless.license.kt](spotless.license.kt) and [LICENSE.md](LICENSE.md) to reflect your own license and author info!* Other settings for this plugin can be tweaked in [spotless.gradle](spotless_plugin_config.gradle).

### Check if Dependencies Are Up-to-Date

```gradle
./gradlew dependencyUpdates
```

Settings can be tweaked for this plugin within [versionsPlugin.gradle](versions_plugin_config.gradle).

### Publishing the Library to Bintray -> jCenter

Just have to execute:

```gradle
./gradlew clean build uploadArchives --no-parallel --no-daemon
```

But there are some pre-requisites:

1. Update the root [gradle.properties](gradle.properties) and the [gradle.properties](library/gradle.properties) for each 
publishable library module. 
2. Add `bintray.user` and `bintray.apikey` entries to `local.properties` matching the Bintray 
account that owns the repo being published to.
3. With each release, update the library version in the root [gradle.properties](gradle.properties). 
4. Once you've deployed to Bintray for the first time, you can link your Bintray repository to jCenter so people can 
depend on your library _without_ having to add any special repositories.