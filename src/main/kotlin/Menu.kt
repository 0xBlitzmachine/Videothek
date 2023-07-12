import ClassCollection.*

var MOVIE_DATABASE = MovieDatabase()
var USER_DATABASE = UserDatabase()
var LOGGED_USER: User? = null

fun main() {
    var userInputBalance = 0.0
    var userInputNavigation = 0
    var userInputEmail: String
    var userInputPassword: String

    // Generiere, beim Start des Programmes, einen festen Wert an Filmen, mit zufälligen Bewertungen und Preise
    generateMovies()

    // Programmfluss startet - Starte Login/Register Interface automatisch, da LOGGED_USER auf null gesetzt ist.
    do {
        while (LOGGED_USER == null) {
            println(MenuMessage.LOG_REG_INTERFACE.id)
            // Durch Try & Catch unterbinde ich falsche Eingaben! Sign Up or Sign In Only
            try {
                userInputNavigation = readln().toInt()
                if (userInputNavigation > 2 || userInputNavigation < 1)
                    throw Exception(ErrorMessage.SELECTION_OUT_OF_BOUND.id)

                // Logik für Sign In & Up
                when (userInputNavigation) {
                    // Sign In
                    1 -> {
                        println("--- LOGIN ---\n")
                        print("Email: "); userInputEmail = readln()
                        print("Password: "); userInputPassword = readln()

                        LOGGED_USER = USER_DATABASE.login(userInputEmail, userInputPassword)

                        when (LOGGED_USER) {
                            null -> throw Exception(ErrorMessage.LOGIN_FAILED.id)
                            else -> println(Message.LOGIN_SUCCESS.id)
                        }
                    }
                    // Sign Up
                    2 -> {
                        println("--- REGISTER ---\n")
                        print("Email: "); userInputEmail = readln()
                        print("Password: "); userInputPassword = readln()

                        // Versuche einen User zu erstellen mit dem eingegebenen Eingaben.
                        when (USER_DATABASE.addUser(User(userInputEmail, userInputPassword))) {
                            true -> println(Message.REGISTER_SUCCESS.id.format(userInputEmail))
                            false -> throw Exception(ErrorMessage.REGISTER_FAILED.id.format(userInputEmail))
                        }
                    }
                }
            } catch (e: Exception) {
                // Definiere die Fehler für falsches Menüverhalten
                when (e) {
                    is NumberFormatException -> println(ErrorMessage.WRONG_INPUT.id)
                    else -> println(e.message)
                }
            }
        }

        // User ist eingeloggt
        while (LOGGED_USER != null) {
            // Printe Informationen wie Namen und Kontoguthaben an
            println(
                MenuMessage.MAIN_INTERFACE.id.format(
                    LOGGED_USER!!.username ?: LOGGED_USER!!.email,
                    LOGGED_USER!!.balance
                )
            )

            // Usereingabe einfangen
            try {
                userInputNavigation = readln().toInt()
                if (userInputNavigation > 8 || userInputNavigation < 1)
                    throw Exception(ErrorMessage.SELECTION_OUT_OF_BOUND.id)

                // Interaktives Menü
                when (userInputNavigation) {
                    1 -> MOVIE_DATABASE.showAllMovies()
                    2 -> MOVIE_DATABASE.showTop3RatedMovies()
                    3 -> MOVIE_DATABASE.showTop3CheapestMovie()
                    4 -> {
                        print("How much you would like to deposit: ")
                        try {
                            userInputBalance = readln().toDouble()
                            if (userInputBalance < 1)
                                throw Exception("You need to deposit atleast $1")
                            else {
                                LOGGED_USER!!.balance += userInputBalance
                                println("Success")
                            }
                        } catch (e: Exception) {
                            println(e.message)
                        }
                    }
                    5 -> {
                        print("Enter the ID of the movie you would like to buy: ")
                        try {
                            userInputNavigation = readln().toInt()
                            LOGGED_USER!!.buyMovie(userInputNavigation)
                        } catch (e: Exception) {
                            when (e) {
                                is NumberFormatException -> println("Wrong ID input!")
                                else -> println(e.message)
                            }
                        }
                    }
                    6 -> LOGGED_USER!!.getAllMovies()
                    7 -> {
                        print("Enter your new username: ")
                        LOGGED_USER!!.username = readln()
                    }
                    8 -> LOGGED_USER = null
                }
            } catch (e: Exception) {
                // Definiere die Fehler für falsches Menüverhalten
                when (e) {
                    is NumberFormatException -> println(ErrorMessage.WRONG_INPUT.id)
                    else -> println(e.message)
                }
            }
        }
    } while (true)
}