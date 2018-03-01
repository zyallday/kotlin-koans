package iii_conventions

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
  override fun compareTo(other: MyDate): Int {
    return when {
      this.year < other.year -> -1
      this.year == other.year -> when {
        this.month < other.month -> -1
        this.month == other.month -> when {
          this.dayOfMonth < other.dayOfMonth -> -1
          this.dayOfMonth == other.dayOfMonth -> 0
          else -> 1
        }
        else -> 1
      }
      else -> 1
    }
  }
}


operator fun MyDate.rangeTo(other: MyDate): DateRange = DateRange(this, other)

enum class TimeInterval {
  DAY,
  WEEK,
  YEAR
}

class DateRange(override val start: MyDate,
    override val endInclusive: MyDate) : ClosedRange<MyDate> {
  operator fun iterator(): Iterator<MyDate> = object : Iterator<MyDate> {

    private var currentDate: MyDate = start
    override fun hasNext(): Boolean {
      return currentDate < endInclusive.nextDay()
    }

    override fun next(): MyDate {
      val date = currentDate
      val nextDay = currentDate.nextDay()
      currentDate = nextDay
      return date
    }
  }
}
