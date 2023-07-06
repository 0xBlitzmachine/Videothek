package ClassCollection

class User(
    var email: String,
    private var password: String
) {
    private var library: MutableList<Movie> = mutableListOf()
    var balance = 0.0
    var username: String? = null

    constructor(email: String, password: String, username: String) : this(email, password) {
        this.username = username
    }

    fun validatePassword(password: String): Boolean {
        return password == this.password
    }
}