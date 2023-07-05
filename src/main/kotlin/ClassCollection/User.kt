package ClassCollection

class User(
    var email: String,
    private var password: String
) {
    private var library: MutableList<Movie> = mutableListOf()
    private var isAdmin = false
    private var balance = 0.0
    var username: String? = null
    var age: Int = 0

    constructor(email: String, password: String, username: String) : this(email, password) {
        this.username = username
    }

    // For Testing purpose later!
    constructor(email: String, password: String, isAdmin: Boolean) : this(email, password) {
        this.isAdmin = isAdmin
    }

    // For Testing purpose later!
    constructor(email: String, password: String, username: String, isAdmin: Boolean) : this(email, password) {
        this.username = username
        this.isAdmin = isAdmin
    }

    fun validatePassword(password: String): Boolean {
        return password == this.password
    }
}