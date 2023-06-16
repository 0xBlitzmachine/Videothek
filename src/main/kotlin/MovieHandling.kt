val movieCollection = mutableMapOf<String, Movie>()

fun addMovie(key: String, movieClass: Movie): String {
    if (movieCollection.containsKey(key))
        return Message.ADD_MOVIE_KEY_EXISTS.value.format(key)

        movieCollection[key] = movieClass
    return Message.ADD_MOVIE_SUCCESS.value.format(key, movieClass.genre, movieClass.price!!)
}

fun removeMovie(key: String): String {
    if (!movieCollection.containsKey(key))
        return Message.REMOVE_MOVIE_DOES_NOT_EXIST.value.format(key)

        movieCollection.remove(key)
        return Message.REMOVE_MOVIE_SUCCESS.value.format(key)
}

fun showAllMovies() {
    movieCollection.forEach {
        println("PLACEHOLDER")
    }
}

fun addDummies(listofmovies: List<String>): String {
    listofmovies.forEach {
        addMovie(it, Movie(it, null, randomPrice(), generateRatings()))
    }
    return "Dummy Collection of movies has been added!"
}