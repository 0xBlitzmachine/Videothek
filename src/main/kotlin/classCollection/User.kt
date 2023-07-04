package classCollection

import Movie

class User(
    private var email: String,
    private var password: String
) {
    private var isAdmin = false
    private var username: String? = null
    private var balance = 0.0
    private var age: Int? = null
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

    fun getEmail(): String {
        return this.email
    }

    fun changeEmail(newEmail: String) {
        this.email = newEmail
    }

    fun changePassword(oldPassword: String, newPassword: String): Boolean {
        return if (this.password != oldPassword) false
        else { this.password = newPassword; true }
    }

    fun getUsername(): String? {
        return this.username
    }

    fun changeUsername(newUsername: String) {
        this.username = newUsername
    }

    fun getBalance(): Double {
        return this.balance
    }

    fun increaseBalance(amount: Double) {
        this.balance += amount
    }

    fun decreaseBalance(amount: Double): Boolean {
        return if (amount > this.balance) false
        else { this.balance -= amount; true }
    }

    fun getAge(): Int? {
        return this.age
    }

    fun setAge(age: Int) {
        this.age = age
    }

    fun getLibrary(): List<Movie>? {
        return this.library
    }

    fun addMovie(movie: Movie) {
        this.library?.add(movie)
    }
}