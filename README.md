Here’s a comprehensive README for your project on GitHub:

---

# Trending Movies App

This Android application fetches trending movies from The Movie Database (TMDB) API and displays them using Jetpack Compose. The app supports searching for movies, viewing movie details, and handles loading, empty, and error states gracefully.

## Features

- **Search for Movies**: Users can search for specific movies by title.
- **Display a List of Movies**: A list of trending movies is fetched and displayed.
- **View Movie Details**: Tap on any movie to view its details.
- **Error Handling**: Displays error messages for network issues.
- **Loading Indicators**: Shows loading indicators while fetching data.

## Tech Stack

- Kotlin
- Jetpack Compose
- Hilt
- Coil
- ViewModel

## API Integration

- **TMDB API**: The app fetches a list of trending movies from the TMDB API.
   - API endpoint:
     ``` 
     https://api.themoviedb.org/3/trending/movie/week
     ```
   - Fetch movie images from the following base URL:
     ```
     https://image.tmdb.org/t/p/w500/
     ```

## Project Structure

Below is the architecture and data flow of the app, from data fetching to UI rendering:

## Getting Started

### Prerequisites

1. [Register on TMDB](https://www.themoviedb.org/) and generate an API key.
2. Clone this repository to your local machine.

```bash
git clone https://github.com/shivamkumard107/tmdb-compose.git
```

3. Open the project in Android Studio.
4. Put your API_KEY in the **local.properties** like API_KEY=<YOUR_API_KEY>

### Running the App

To run the app, simply press **Run** in Android Studio after syncing the project dependencies. The app should now fetch the trending movies and display them.

### Screenshots and Recordins

https://github.com/user-attachments/assets/70d8d7d9-b0e5-48fd-89d8-509ecc96acc4

## Features Walkthrough

### Movie List Screen

The main screen displays a list of trending movies fetched from the TMDB API. The user can scroll through the list and click on any movie to view more details.

<img src="https://github.com/user-attachments/assets/1766b6f9-4edb-47ea-bf36-1f5c310bdd0f" width="200" height="auto" />

### Search Functionality
A search bar is provided at the top of the movie list screen. Users can type the name of a movie, and the app will filter the displayed movies accordingly.

### Movie Details Screen
When a user clicks on a movie, a detail screen is shown, displaying more information about the movie, such as the description, release date, and an image.

### Loading and Error States

- **Loading Indicators**: While the data is being fetched from the API, a loading spinner is displayed.
- **Error Handling**: If there is a network error or other issues, an error message is shown to the user.

<img src="https://github.com/user-attachments/assets/bd0eed45-a862-4c4e-a925-282d7d58144e" width="200" height="auto" />

<img src="https://github.com/user-attachments/assets/004b0958-2eec-49bb-973e-39cb101bed9a" width="200" height="auto" />

<img src="https://github.com/user-attachments/assets/79e37866-3108-4f02-816e-375b47b02756" width="200" height="auto" />







## Code Quality & Best Practices

- **Clean Architecture**: The app follows clean architecture principles, separating concerns into distinct layers (data, domain, UI).
- **MVVM Pattern**: Uses the Model-View-ViewModel pattern to separate business logic from UI logic.
- **Kotlin Coroutines**: The app makes use of Kotlin coroutines for asynchronous data fetching.
