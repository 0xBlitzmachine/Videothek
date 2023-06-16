enum class Message(var value: String) {
    REMOVE_MOVIE_DOES_NOT_EXIST("This key '%s' does not exist in the library!"),
    REMOVE_MOVIE_SUCCESS("Key '%s' successfully removed from the library!"),
    ADD_MOVIE_KEY_EXISTS("Key '%s' is already in the library!"),
    ADD_MOVIE_SUCCESS("'%s' has been successfully added to the library!\n" +
            "---------------------------\n" +
            "Genre: %s\n" +
            "Price: %.2f @"),
    ADD_USER_SUCCESS("User '%s' has been successfully registered!")

}