package v_builders

import util.TODO
import java.util.*
import kotlin.collections.HashMap

fun buildStringExample(): String {
    fun buildString(build: StringBuilder.() -> Unit): String {
        val stringBuilder = StringBuilder()
        stringBuilder.build()
        return stringBuilder.toString()
    }

    return buildString {
        this.append("Numbers: ")
        for (i in 1..10) {
            // 'this' can be omitted
            append(i)
        }
    }
}

fun todoTask37(): Nothing = TODO(
    """
        Task 37.
        Uncomment the commented code and make it compile.
        Add and implement function 'buildMap' with one parameter (of type extension function) creating a new HashMap,
        building it and returning it as a result.
    """
)

fun task37(): Map<Int, String> {
    fun buildMap(build: HashMap<Int, String>.() -> Unit) : Map<Int, String>{
        val mapBuilder = HashMap<Int, String>()
        mapBuilder.build()
        return mapBuilder
    }
    return buildMap {
        put(0, "0")
        for (i in 1..10) {
            put(i, "$i")
        }
    }
}
