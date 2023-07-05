import ClassCollection.UserDatabase
import ClassCollection.User

private val userDatabase = UserDatabase()
private var loggedUser: User? = null

fun main() {
    userDatabase.addUser(User("test@gmx.de", "1234"))

    do {
        println("""
        [1] - Sign In
        [2] - Sign Up
    """.trimIndent())

        var userInputNavigation = 0
        var userInputEmail: String
        var userInputPassword: String

        do {
            try {
                userInputNavigation = readln().toInt()
                if (userInputNavigation > 2)
                    throw Exception("Only two options available!")
            } catch (ex: Exception) {
                if (ex is NumberFormatException)
                    println("You can only use numbers to navigate!")
                else println(ex.message)
            }
        } while ((userInputNavigation != 1) && (userInputNavigation != 2))

        if (userInputNavigation == 1) {
            println("-- Login --")
            do {
                println("Email:"); userInputEmail = readln()
                println("Password:"); userInputPassword = readln()

                loggedUser = userDatabase.login(userInputEmail, userInputPassword)
                if (loggedUser == null)
                    println("Failed! - Wrong Email or password!")
            } while (loggedUser == null)
            println("Successfully logged in!")
            break
        }
    } while (true)
}
