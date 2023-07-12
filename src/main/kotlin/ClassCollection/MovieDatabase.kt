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

    fun getMovie(id: Int): Movie? {
        return movieCollection.find { it.id == id}
    }

    fun showAllMovies() {
        movieCollection.forEach {
            println("""
             ID: '${it.id}'  Name: '${it.name}'  Rating: '${it.ratings.sum() / it.ratings.size}'  Price: '$%.2f'
            """.format(it.price).trimIndent())
        }
    }

    fun allMoviesCount(): Int {
        return movieCollection.size
    }

    fun showTop3CheapestMovie() {
        val sortedMovies = movieCollection.sortedBy { it.price }
        val top3Cheapest = sortedMovies.take(3)
        top3Cheapest.forEach {
            println("""
            ID: '${it.id}'  Name: '${it.name}'  Rating: '${it.ratings.sum() / it.ratings.size}'  Price: '%.2f'
        """.trimIndent().format(it.price))
        }
    }

    fun showTop3RatedMovies() {
        val sortedMovies = movieCollection.sortedByDescending { it.ratings.sum() / it.ratings.size }
        val top3Movies = sortedMovies.take(3)
        top3Movies.forEach {
            println("""
            ID: '${it.id}'  Name: '${it.name}'  Rating: '${it.ratings.sum() / it.ratings.size}'  Price: '%.2f'
        """.trimIndent().format(it.price))
        }
    }


}