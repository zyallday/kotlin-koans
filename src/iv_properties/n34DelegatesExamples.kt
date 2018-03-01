package iv_properties

import util.TODO
import util.doc34
import kotlin.LazyThreadSafetyMode.SYNCHRONIZED
import kotlin.reflect.KProperty

class LazyPropertyUsingDelegates(val initializer: () -> Int) {
  val lazyValue: Int by lazy(initializer)
}

fun todoTask34(): Lazy<Int> = TODO(
    """
        Task 34.
        Read about delegated properties and make the property lazy by using delegates.
    """,
    documentation = doc34()
)


class Example {
  val lazyValue: String by lazy {
    println("computed!")
    "Hello"
  }
}


//class Delegate {
//  operator fun getValue(example: Example, property: KProperty<*>): String {
//    return "$example, thank you for delegating '${property.name}' to me!"
//  }
//
//  operator fun setValue(example: Example, property: KProperty<*>, s: String) {
//    println("$s has been assigned to '${property.name}' in $example.")
//  }
//
//}

fun main(args: Array<String>) {
}