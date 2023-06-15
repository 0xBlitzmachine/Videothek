fun randomRating(): Int{
    return (1..5).random()
}

fun randomPrice(): Double {
    return (2..5).random().toDouble()
}

fun generateRatings(): MutableList<Int> {
    val ratings = mutableListOf<Int>()
    repeat((1..10).random()) {
        ratings.add(randomRating())
    }
    return ratings
}