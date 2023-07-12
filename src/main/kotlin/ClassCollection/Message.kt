package ClassCollection

enum class MenuMessage(var id: String) {
    LOG_REG_INTERFACE("""
        [1] - Sign In
        [2] - Sign Up
    """.trimIndent()),
    MAIN_INTERFACE("""
         ----------- USER INFORMATION --------------
        Name: %s
        Balance: $%.2f
         --------------------------------
        [1] - Show all available movies
        [2] - Show Top 3 rated movies
        [3] - Show Top 3 cheapest movies
         --------------------------------
        [4] - Add cash to wallet
        [5] - Buy a movie
        [6] - Show your library
         --------------------------------
        [7] - Change Username
        [8] - Logout
    """.trimIndent()
    )
}

enum class ErrorMessage(var id: String) {
    SELECTION_OUT_OF_BOUND("Your selection was higher than available options!"),
    WRONG_INPUT("You can only navigate using numbers!"),
    LOGIN_FAILED("Login failed. Wrong Email or password?"),
    REGISTER_FAILED("Email '%s' is already in use!")
}

enum class Message(var id: String) {
    LOGIN_SUCCESS("Successfully logged in!"),
    REGISTER_SUCCESS("Successfully created an account with Email: %s")
}
