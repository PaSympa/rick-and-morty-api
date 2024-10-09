# Clean RmZpi + MVI 🤖

![Language](https://img.shields.io/github/languages/top/PaSympa/rick-and-morty-api?color=blue&logo=kotlin) ![Target API](https://img.shields.io/badge/target%20API-31-blue)

![GitHub issues](https://img.shields.io/github/issues/PaSympa/rick-and-morty-api)

Clean RmZpi + MVI is an Android application that uses the **Rick and Morty API** to demonstrate how to implement the **Model-View-Intent (MVI)** architecture in a Kotlin Android app. It showcases the usage of modern libraries and tools, including:
- **Jetpack Compose** for declarative UI
- **Ktor** for networking
- **Koin** for dependency injection
- **Clean Architecture** principles

This app serves as a practical guide for developers looking to adopt MVI architecture, clean code practices, and modern tools in their Android applications.

## How to Use 👣

To get started with this repository, follow these steps:

1. **Clone the repository**:
   ```bash
   git clone https://github.com/PaSympa/rick-and-morty-api.git
   ```
2. **Checkout the `evaluation` branch**:
   ```bash
   git checkout evaluation
   ```
3. **Open the project in Android Studio**:
    - Open the project in Android Studio
    - Select “Open an existing project” and navigate to the folder where you cloned the repository
4. **Sync Gradle**:
    - After opening the project, Android Studio will prompt you to sync Gradle. Let it complete.
5. **Run the App**: 
    - Connect an Android device or use an emulator
    - Click the “Run” button in Android Studio to build and launch the app

Alternatively, you can [download the repository as a ZIP file](https://github.com/PaSympa/rick-and-morty-api/archive/refs/heads/evaluation.zip) if you prefer not to use Git.

## Features 📱

This app includes the following features:

- **List All Characters**: View a complete list of characters from the **Rick and Morty** universe.
- **Character Details**: Get detailed information about each character, including:
   - Name
   - Gender
   - Species
   - Origin location
- **Location Details**: Explore the details of a character's origin location, including:
   - Location name
   - Dimension
   - List of residents

## Gradle Setup 🐘

This project is built using **Gradle**. All dependencies are centralized inside the Gradle Version Catalog in the `libs.versions.toml` file located in the `gradle` folder.

To sync the project, open it in **Android Studio**, and Gradle will automatically download and set up the required dependencies.

## Continuous Integration (CI) ⚙️

No Continuous Integration (CI) tools, such as automated testing or building workflows, have been set up for this project at the moment.

## Publishing 🚀

This project is intended to remain a local private project and is not set up for publishing to external repositories.

## Project Structure

The project is organized into the following main modules and directories:

- **`app/`**: Contains the main Android application code, including:
   - `manifests/`: The AndroidManifest file.
   - `kotlin+java/`: Source code for the Android app. (e.g., `MainActivity.kt`)

- **`core/`**: Core functionality shared across the app.
   - `data/`: Data-related concerns, including:
      - `di/`: Dependency injection setup (e.g., `DataModule.kt` ).
      - `local/`: Local data sources (e.g., databases).
      - `remote/`: Remote data sources (e.g., API calls).
      - `repositories/`: Data repositories implementing the domain interfaces.
   - `domain/`: Logic and domain models, including:
      - `models/`: Domain models 
      - `repositories/`: Domain repositories for accessing data.

- **`features/`**: Feature-specific modules for distinct app functionalities.
   - `characters/`: Contains code for managing characters (listing, details).
   - `location/`: Handles the location-related functionality (details).

- **`test/`**: Unit and instrumentation tests for the app. **(Not implemented yet)**

- **Gradle Scripts**: Build scripts for managing dependencies and project configuration.

## Credits 🙌

This README was inspired and built with the help of the [Kotlin Android Template](https://github.com/cortinico/kotlin-android-template). Special thanks to the authors of this template for providing a great starting point for the documentation!
