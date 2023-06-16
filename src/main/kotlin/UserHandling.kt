val userDatabase = mutableMapOf<Int, User>()

fun registerUser(user: User): String {
    if (userDatabase.isEmpty())
        userDatabase[0] = user
    else
        userDatabase[userDatabase.keys.max() + 1] = user
    return Message.ADD_USER_SUCCESS.value.format(user.username)
}