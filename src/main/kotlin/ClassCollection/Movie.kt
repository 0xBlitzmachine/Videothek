package ClassCollection

import generatePrice
import generateRatings
import MOVIE_DATABASE

class Movie(var name: String) {
    var id: Int = autoIncrementId()
    var price: Double = generatePrice()
    var ratings: List<Int> = generateRatings()

    private fun autoIncrementId(): Int {
        return MOVIE_DATABASE.highestId() + 1
    }
}


