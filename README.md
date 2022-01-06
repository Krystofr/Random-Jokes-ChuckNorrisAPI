## ChuckNorrisAPI - Random Jokes

## Technologies Used:
- Kotlin
- KT Coroutines
- Retrofit, OkHttpLogger, GsonConverter
- Jetpack Navigation
- MVVM

## Description

- You can simply slone this repository into your Android Studio environment using git, and run on any android device operating on Android 5.0 (API 21) and higher, using USB debugging enabled on the android device.
- Uses Navigation Component for navigating through the 3 different Fragments.
- Fetches random jokes from the ChuckNorris API and displays in popup upon button click. Has a fragment to search random joke and displays in list view. Ability to view a grid view of joke categories.
  Random joke displays in a popup upon clicking a joke category in the grid.
  
## Reason for Choice of Design Pattern:
- I chose MVVM for this because it cleanly separates the user interface from the application business logic. 
- It guides how to distribute responsibility between the various classes and reduced complexity by having a fewer classes. 
- Also, the ViewModel projects the data from the Model into a format that fits the View.
- For more trivial or simpler projects, it will be an overkill to incorporate design pattern like MVP, MVC, MVI
