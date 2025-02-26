package based_on_data_structure.array

fun main() {
    val arr = intArrayOf(1, 0, 1, 0, 1, 1, 0, 0, 1)
    sortOnesAndZeros(arr)
    println(arr.joinToString(", "))
}

fun sortOnesAndZeros(arr: IntArray) {
    var left = 0
    var right = arr.size - 1 // n - 1(n is size of the array)
    // 1, 0, 1, 0, 1, 1, 0, 0, 1
    // 0, 1, 2, 3, 4, 5, 6, 7, 8

    while (left < right) {
        while (left < right && arr[left] == 1) {
            left++
            println("left increment: $left")
        }

        while (left < right && arr[right] == 0) {
            right--
            println("right decrement: $right")
        }

        if (left < right) {
            arr[left] = 1
            arr[right] = 0
            left++
            right--
        }
    }
}