package ClassCollection

class Movie(private var name: String) {
    private var id: Int = 0
    private var price: Double? = null

    init {
        // Auto Increment of Identity Number
        // Auto Generate Price
        // Auto Generate Ratings
    }

    fun getName(): String {
        return this.name
    }
}


