class UserHandling {
    private var userDatabase = mutableMapOf<Int, User>()


    fun getAllUser(): Map<Int, User> {
        return userDatabase.toMap()
    }

    fun addUser(user: User) {
        return if (userDatabase.keys.max() == 0) userDatabase[1] = user
        else userDatabase[userDatabase.keys.max().plus(1)] = user
    }

    fun removeUserById(userId: Int): Boolean {
        if (!userDatabase.containsKey(userId)) return false
        userDatabase.remove(userId); return true
    }
}

