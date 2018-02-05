# MoviesApp

### Description

This is my first Android application developed 100% in Kotlin. I used the idea of an Movies app to learn Kotlin.
The app shows movies and tv shows information (e.g.: title, rating, description, ...). 
The app uses [The Movie Database API](https://developers.themoviedb.org/3). I'm using MVP architecture.

### Technologies

- [Kotlin](https://kotlinlang.org/)
- [Retrofit](https://square.github.io/retrofit/) - for web requests
- [Picasso](https://square.github.io/picasso/) - for downloading pictures

### Resources

Movie API: https://developers.themoviedb.org/3

### Wireframe

TODO: missing some awesome pics

### Requirements

To run the application you need a Movies DB API key.
First you need to create a new file, which you can place at `\app\src\main\res\values\config.xml` with the following placeholder.
Then, you need to replace `MOVIES_DB_API_KEY` for your API key.
```
<?xml version="1.0" encoding="utf-8"?>
<resources>

    <string name="movies_db_api_key">MOVIES_DB_API_KEY</string>

</resources>
```

### Contributors

- Isabel Costa | [@github](https://github.com/isabelcosta) | [@twitter](https://twitter.com/isabelcmdcosta)
- André Alexandre | [@github](https://github.com/andrealexandre) | [@twitter](https://twitter.com/andrefvalex) - helped me understand Kotlin in my learning journey by reviewing my pull requests
