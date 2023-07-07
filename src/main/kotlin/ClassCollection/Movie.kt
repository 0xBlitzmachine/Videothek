package ClassCollection
import generatePrice
import generateRatings
import movieDatabase

class Movie(var name: String) {
    var id: Int = autoIncrementId()
    var price: Double = generatePrice()
    var ratings: List<Int> = generateRatings()

    private fun autoIncrementId(): Int {
        return movieDatabase.highestId() + 1
    }
}


