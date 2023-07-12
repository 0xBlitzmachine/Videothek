fun generatePrice(min: Int = 2, max: Int = 10): Double {
    return (min..max).random() + (0..99).random() / 100.0
}

fun generateRatings(): MutableList<Int> {
    val ratings = mutableListOf<Int>()
    repeat((5..30).random()) { ratings.add((1..5).random()) }
    return ratings
}

fun clearConsole() { repeat(15) { println("") } }

fun generateMovies() {
    movieList.forEach { MOVIE_DATABASE.addMovie(it) }
}
val movieList = listOf<String>(
    "The Dark Knight",
    "Indiana Jones",
    "Die Hard",
    "The Shawshank Redemption",
    "Schindler's List",
    "The Godfather",
    "Star Wars",
    "The Matrix",
    "The Lord of the Rings",
)