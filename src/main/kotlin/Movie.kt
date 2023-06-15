data class Movie(
    var moviename: String,
    var genre: String?,
    var price: Double?,
    var ratings: List<Int>?
)

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