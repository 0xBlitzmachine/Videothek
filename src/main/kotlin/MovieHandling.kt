val movieCollection = mutableMapOf<String, Movie>()

fun addMovie(key: String, movieClass: Movie): String {
    if (!movieCollection.containsKey(key))
        movieCollection[key] = movieClass
    return Message().getMessageByKey("ADD_MOVIE_SUCCESS").format(key, movieClass.genre, movieClass.price)
}

fun removeMovie(key: String): String {
    if (!movieCollection.containsKey(key))
        return Message().getMessageByKey("REMOVE_MOVIE_DOES_NOT_EXIST").format(key)
    else {
        movieCollection.remove(key)
        return Message().getMessageByKey("REMOVE_MOVIE_SUCCESS").format(key)
    }
}