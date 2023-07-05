package ClassCollection

class UserDatabase {
    private val userCollection = mutableListOf<User>()

    private fun getUserByEmail(email: String): User? {
        return userCollection.find { it.email == email }
    }

    fun addUser(user: User): Boolean {
        return if (getUserByEmail(user.email) != null)
            false
        else {
            userCollection += user
            true
        }
    }

    fun removeUser(user: User): Boolean {
        return if (getUserByEmail(user.email) == null)
            false
        else {
            userCollection -= user
            true
        }
    }

    fun login(email: String, password: String): User? {
        val user: User? = getUserByEmail(email)
        return if (user != null && user.validatePassword(password))
            user
        else null
    }
}