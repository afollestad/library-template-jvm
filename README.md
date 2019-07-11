# Library Template (JVM)

This repository can be used as a template to create new GitHub repositories for Java/Kotlin libraries.

### Code Formatting

```gradle
./gradlew spotlessApply
```

*Make sure you update [spotless.license.kt](spotless.license.kt) and [LICENSE.md](LICENSE.md) to reflect your own license and author info!* Other settings for this plugin can be tweaked in [spotless.gradle](spotless.gradle).

### Check if Dependencies Are Up-to-Date

```gradle
./gradlew dependencyUpdates
```

Settings can be tweaked for this plugin within [versionsPlugin.gradle](versionsPlugin.gradle).

### Publishing the Library to Bintray -> jCenter

Just have to execute:

```gradle
./gradlew clean build bintrayUpload
```

But there are some pre-requisites:

1. Update [bintrayconfig.gradle](bintrayconfig.gradle) to contain your own Bintray username and 
the new library's matching details.
2. Add `bintray.user` and `bintray.apikey` entries to `local.properties` matching your own 
Bintray account.
3. With each release, update the version name and code in [dependencies.gradle](dependencies.gradle).
4. Once you've deployed to Bintray for the first time, you can link your Bintray repository to jCenter so people can depend on your library _without_ having to add any special repositories.