class Cinema {
    private var movieCollection: MutableMap<Int, Movie> = mutableMapOf()
    private var id = movieCollection.keys.max()

    fun addMovie(movie: Movie) {
        if (id == 0) {
            id = 1
            movieCollection[id] = movie
            return
        }

        movieCollection[]
    }
}