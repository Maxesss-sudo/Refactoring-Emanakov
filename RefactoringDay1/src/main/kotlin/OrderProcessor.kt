package org.example


private const val Phone = 500.0, Laptop = 1200.0
fun main() {
    fun process(ItemList: List<String>, amount: Double, delivery: Boolean) {
        for (item in ItemList) {
            if (item == "Phone") {
                total += 500.0
            } else if (item == "Laptop") {
                total += 1200.0
            } else {
                total += 10.0
            }
        }

        if (total > 1000) {
            total = total - (total * 0.1)
        }

        if (delivery) {
            total += 50.0
        }

        println("Items: " + p)
        println("Total sum: " + total)

        // Сохранение в "базу данных"
        println("Saving to DB...")
    }
}
data class Item(
    val name: String,
    val price: Double
)
data class Order(
    val items: List<Item>,
    val hasDelivery: Boolean
)
enum class Product(val price: Double) {
    Phone(500.0)
    Laptop(1200.0)
    Other(10.0)
}