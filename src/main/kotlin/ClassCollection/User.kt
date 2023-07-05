package ClassCollection

class User(
    var email: String,
    var password: String
) {
    var isAdmin = false
    var username: String? = null
    var balance = 0.0
    var age: Int? = null
    private var library: MutableList<Movie>? = null

    constructor(email: String, password: String, username: String) : this(email, password) {
        this.username = username
    }

    constructor(email: String, password: String, isAdmin: Boolean) : this(email, password) {
        this.isAdmin = isAdmin
    }

    constructor(email: String, password: String, username: String, isAdmin: Boolean) : this(email, password) {
        this.username = username
        this.isAdmin = isAdmin
    }

    fun increaseBalance(amount: Double) {
        this.balance += amount
    }

    fun decreaseBalance(amount: Double): Boolean {
        return if (amount > this.balance) false
        else { this.balance -= amount; true }
    }

    fun addMovie(movie: Movie) {
        this.library?.add(movie)
    }
}