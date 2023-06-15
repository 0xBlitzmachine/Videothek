val movieCollection = mutableMapOf<String, Movie>()

fun addMovie(key: String, movieClass: Movie): String {
    if (movieCollection.containsKey(key))
        return Message().getMessageByKey("ADD_MOVIE_KEY_EXISTS").format(key)

        movieCollection[key] = movieClass
    return Message().getMessageByKey("ADD_MOVIE_SUCCESS").format(key, movieClass.genre, movieClass.price!!)
}

fun removeMovie(key: String): String {
    if (!movieCollection.containsKey(key))
        return Message().getMessageByKey("REMOVE_MOVIE_DOES_NOT_EXIST").format(key)

        movieCollection.remove(key)
        return Message().getMessageByKey("REMOVE_MOVIE_SUCCESS").format(key)
}

fun addDummies(listofmovies: List<String>): String {
    listofmovies.forEach {
        addMovie(it, Movie(it, null, randomPrice(), generateRatings()))
    }
    return "Dummy Collection of movies has been added!"
}