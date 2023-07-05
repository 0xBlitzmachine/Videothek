package ClassCollection

class Movie(var name: String) {
    var id: Int = 0
    var price: Double? = null

    init {
        // Auto Increment of Identity Number
        // Auto Generate Price
        // Auto Generate Ratings
    }

    fun getName(): String {
        return this.name
    }
}


