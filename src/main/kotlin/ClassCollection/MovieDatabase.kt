package ClassCollection

class MovieDatabase {
    private val movieCollection = mutableListOf<Movie>()

    fun highestId(): Int {
        return if (movieCollection.isEmpty()) 0
        else movieCollection.elementAt(movieCollection.lastIndex).id
    }

    fun addMovie(name: String) {
        movieCollection.add(Movie(name))
    }

    fun showAllMovies() {
        movieCollection.forEach {
            println("""
             ID: '${it.id}'  Name: '${it.name}'  Rating: '${it.ratings.sum() / it.ratings.size}'  Price: '%.2f'
            """.format(it.price).trimIndent())
        }
    }
}