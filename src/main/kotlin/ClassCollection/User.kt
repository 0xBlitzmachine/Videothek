package ClassCollection

import movieDatabase

class User(
    var email: String,
    private var password: String
) {
    var library: MutableList<Movie> = mutableListOf()
    var balance = 0.0
    var username: String? = null

    constructor(email: String, password: String, username: String) : this(email, password) {
        this.username = username
    }

    fun addMovie(id: Int): Movie {
        val movie = movieDatabase.getMovie(id)
        library += movie!!
        return movie!!
    }

    fun validatePassword(password: String): Boolean {
        return password == this.password
    }
}