package ClassCollection

class UserDatabase {
    private val userCollection = mutableListOf<User>()

    private fun getUserByEmail(email: String): User? {
        return userCollection.find { it.email == email }
    }

    fun addUser(user: User): Boolean {
        if (getUserByEmail(user.email) != null) return false
        userCollection += user; return true
    }

    fun removeUser(user: User): Boolean {
        if (getUserByEmail(user.email) == null) return false
        userCollection -= user; return true
    }

    fun login(email: String, password: String): User? {
        var user: User? = getUserByEmail(email)
        return if (user != null && user.validatePassword(password))
            user
        else null
    }
}