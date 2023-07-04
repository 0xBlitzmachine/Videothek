package ClassCollection

class Database {
    private val userCollection = mutableListOf<User>()
    private val movieCollection = mutableListOf<Movie>()

    fun addUser(user: User) {
        this.userCollection += user
    }

    // Can be also Null! Do Null-Safety checks
    fun getUserByEmail(email: String): User {
        return userCollection.find { it.getEmail() == email }!!
    }

    fun getAllMovies(): List<Movie> {
        return movieCollection.toList()
    }

    // What if more names equal input - Return List?!?
    fun getMovieIdByName(name: String): List<Movie> {
        return listOf()
    }
}