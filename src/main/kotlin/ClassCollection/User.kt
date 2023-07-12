package ClassCollection

import MOVIE_DATABASE

class User(
    var email: String,
    private var password: String
) {
    var balance = 0.0
    var library: MutableList<Movie> = mutableListOf()
    var username: String? = null

    constructor(email: String, password: String, username: String) : this(email, password) {
        this.username = username
    }

    fun getAllMovies() {
        library.forEach { println("ID:  ${it.id}  Name:  ${it.name}") }
    }

    fun buyMovie(id: Int) {
        val movie = MOVIE_DATABASE.getMovie(id)
        if (movie != null) {
            if (this.library.contains(movie)) {
                println("You already own this movie")
                return
            }
            if (movie.price <= this.balance) {
                this.balance -= movie.price
                library += movie
                println("${movie.name} has been added to your list!")
            } else println("You do not own enough in the wallet to buy this movie!")
        } else println("This movie is not available")
    }


    fun validatePassword(password: String): Boolean {
        return password == this.password
    }
}