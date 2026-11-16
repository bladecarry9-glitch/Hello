# Hello World Plus — Android Java project

This is a native Android application written in Java. It is structured as a Gradle Android project for import into Android Code Studio or another Android IDE that supports standard Gradle projects.

## Features
- Native Android screen (no WebView)
- Print Hello World
- Personalized greeting
- Repeat greeting 1–100 times
- Display date and time
- Clear inputs and output
- Input validation
- No Firebase, internet permission, or third-party libraries

## Open in Android Code Studio
1. Extract `HelloWorldAndroid.zip`.
2. In Android Code Studio, choose **Open Project** (or **Import Gradle Project**).
3. Select the extracted `HelloWorldAndroid` folder — the folder containing `settings.gradle`.
4. Allow Gradle sync to finish.
5. Build and run the `app` configuration on an emulator or Android device.

## Build configuration
- Android Gradle Plugin: 8.6.1
- Gradle distribution: 8.7
- Java compatibility: 17
- compileSdk: 35
- minSdk: 23 (Android 6.0)

Use a JDK 17 runtime for Gradle/Android Gradle Plugin 8.6.1. The IDE must have Android SDK Platform 35 installed (or be able to install it).

## Common Gradle sync fixes
- **Gradle requires JVM 17:** set the IDE's Gradle JDK to JDK 17.
- **SDK platform not found:** install Android SDK Platform 35 using the IDE's SDK Manager, or change `compileSdk` to an SDK platform already installed.
- **Could not resolve plugin / download failed:** check internet access and retry Gradle sync; the first sync downloads Gradle and Android Gradle Plugin.
- **Unsupported Gradle version:** keep Android Gradle Plugin 8.6.1 with Gradle 8.7; do not upgrade only one of them.
- **Project path issue:** extract the ZIP first, then open the project folder, not the ZIP file itself.

## Important
The Gradle wrapper properties are included. Some mobile IDEs provide their own Gradle launcher and do not use `gradlew`; use the IDE's Gradle Sync/Build action in that case. The wrapper JAR is not bundled in this ZIP, so use the IDE's Gradle integration or generate wrapper files from a Gradle installation if your IDE requires the wrapper script.
