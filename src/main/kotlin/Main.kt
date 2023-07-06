import ClassCollection.MovieDatabase
import ClassCollection.UserDatabase
import ClassCollection.User

val movieDatabase = MovieDatabase()
private val userDatabase = UserDatabase()
private var loggedUser: User? = null

fun main() {
    generateMovies()

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
                else {
                    do {
                        println("""
                            Welcome! Choose your options
                            Balance: ${loggedUser!!.balance}
                        [1] - Show all available movies
                        [2] - Show Top 3 rated movies
                        [3] - Show Top 3 cheapest movies
                        --------------------------------
                        [4] - Add cash to wallet
                        [5] - Buy a movie
                        [6] - Your library
                         """.trimIndent())
                        try {
                            userInputNavigation = readln().toInt()
                            if (userInputNavigation > 6)
                                throw Exception("Only six options available!")
                        } catch (ex: Exception) {
                            if (ex is NumberFormatException)
                                println("You can only use numbers to navigate!")
                            else println(ex.message)
                        }

                        when (userInputNavigation) {
                            1 -> movieDatabase.showAllMovies()
                        }
                    } while (true)
                }

            } while (loggedUser == null)
        } else {
            println("-- Register --") // Add check for a real email adresse. User class
            do {
                println("Email:"); userInputEmail = readln()
                println("Password:"); userInputPassword = readln()

                var registerResult = userDatabase.addUser(User(userInputEmail, userInputPassword))
                if (registerResult)
                    println("Registered! Welcome $userInputEmail")
                else println("Email already in use! Try again.")
            } while (!registerResult)
        }
    } while (true)
}
