/*
import ClassCollection.MovieDatabase
import ClassCollection.UserDatabase
import ClassCollection.User

*/
/*val movieDatabase = MovieDatabase()
private val userDatabase = UserDatabase()
private var loggedUser: User? = null*//*

private var userLoggedOut = false

fun main() {
    // Generiere einen festen Bestandteil an Filme mit zufälligen Bewertungen & Preise
    generateMovies()

    // Starte die Menü-Schleife
    do {
        println(
            """
        [1] - Sign In
        [2] - Sign Up
    """.trimIndent()
        )

        var userInputBalance = 0.0
        var userInputNavigation = 0
        var userInputEmail: String
        var userInputPassword: String

        //Für den neustart der Schleife, falls ein eingeloggter User sich einloggt.
        do {
            if (userLoggedOut) {
                loggedUser = null
                userLoggedOut = false
            }

            // Input Handling für Menü-Navigation
            try {
                userInputNavigation = readln().toInt()
                if (userInputNavigation > 2)
                    throw Exception("Only 2 options available!")
            } catch (ex: Exception) {
                if (ex is NumberFormatException)
                    println("You can only use numbers to navigate!")
                else println(ex.message)
            }
        } while ((userInputNavigation != 1) && (userInputNavigation != 2))

        // Auswahl - Login
        if (userInputNavigation == 1) {
            println("-- Login --")
            do {
                println("Email:"); userInputEmail = readln()
                println("Password:"); userInputPassword = readln()

                loggedUser = userDatabase.login(userInputEmail, userInputPassword)

                if (loggedUser == null)
                    println("Failed! - Wrong Email or password!")

                // Zeige Hauptmenü falls Login erfolgreich verlief
                else {
                    println("Welcome ${loggedUser!!.username ?: loggedUser!!.email}! Choose your options")
                    do {
                        println(
                            """
                            Balance: %.2f
                        [1] - Show all available movies
                        [2] - Show Top 3 rated movies
                        [3] - Show Top 3 cheapest movies
                        --------------------------------
                        [4] - Add cash to wallet
                        [5] - Buy a movie
                        [6] - Your library
                        --------------------------------
                        [7] - Change Username
                        [8] - Logout
                         """.format(loggedUser!!.balance).trimIndent()
                        )
                        // Menü Input Navigation
                        try {
                            userInputNavigation = readln().toInt()
                            if (userInputNavigation > 8)
                                throw Exception("Only 8 options available!")
                        } catch (ex: Exception) {
                            if (ex is NumberFormatException)
                                println("You can only use numbers to navigate!")
                            else println(ex.message)
                        }
                        when (userInputNavigation) {
                            1 -> movieDatabase.showAllMovies()
                            2 -> movieDatabase.showTop3RatedMovies()
                            3 -> movieDatabase.showTop3CheapestMovie()
                            4 -> {
                                println("How much you want to add to your wallet?")
                                do {
                                    try {
                                        userInputBalance = readln().toDouble()
                                    } catch (ex: Exception) {
                                        println(ex.message)
                                    }
                                    if (userInputBalance <= 0)
                                        println("Not a valid input! Try again.")
                                } while (userInputBalance <= 0)
                                loggedUser!!.balance += userInputBalance
                            }

                            5 -> {
                                println("Enter the ID of the movie you want to buy:")
                                do {
                                    try {
                                        userInputNavigation = readln().toInt()
                                    } catch (ex: Exception) {
                                        println(ex.message)
                                    }
                                    if (userInputNavigation > movieDatabase.allMoviesCount())
                                        println("Such ID hasn't been found")
                                } while (userInputNavigation > movieDatabase.allMoviesCount())
                                if (movieDatabase.getMovie(userInputNavigation)!!.price > loggedUser!!.balance) {
                                    println("You do not own enough money to buy this movie!")
                                } else {
                                    val movie = loggedUser!!.addMovie(userInputNavigation)
                                    loggedUser!!.balance -= movie.price
                                    println("${movie.name} has been added to your library!")
                                }
                            }

                            6 -> loggedUser!!.library.forEach {
                                println("ID:  ${it.id} - Name:  ${it.name}")
                            }

                            7 -> {
                                println("Enter your new wanted username:")
                                val input = readln()
                                loggedUser!!.username = input
                            }

                            8 -> userLoggedOut = true
                        }
                    } while (!userLoggedOut)
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
*/
