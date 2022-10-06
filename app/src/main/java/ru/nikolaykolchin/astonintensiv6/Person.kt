package ru.nikolaykolchin.astonintensiv6

data class Person(
    val name: String,
    val familyName: String,
    val phoneNumber: String,
    val imagePath: String
) : java.io.Serializable {
    override fun toString(): String {
        return "$name $familyName, $phoneNumber"
    }
}