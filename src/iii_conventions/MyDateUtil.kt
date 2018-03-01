package iii_conventions

import iii_conventions.TimeInterval.*
import java.util.*

fun MyDate.nextDay() = addTimeIntervals(DAY, 1)

fun MyDate.addTimeIntervals(timeInterval: TimeInterval, number: Int): MyDate {
  val c = Calendar.getInstance()
  c.set(year, month, dayOfMonth)
  when (timeInterval) {
    TimeInterval.DAY -> c.add(Calendar.DAY_OF_MONTH, number)
    TimeInterval.WEEK -> c.add(Calendar.WEEK_OF_MONTH, number)
    TimeInterval.YEAR -> c.add(Calendar.YEAR, number)
  }
  return MyDate(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DATE))
}


data class RepeatedTimeInterval(val timeInterval: TimeInterval, val times: Int)


operator fun MyDate.plus(timeInterval: TimeInterval): MyDate {
  return addTimeIntervals(timeInterval, 1)
}

operator fun MyDate.plus(timeIntervalTimes: RepeatedTimeInterval): MyDate{
  return addTimeIntervals(timeIntervalTimes.timeInterval, timeIntervalTimes.times)
}

operator fun TimeInterval.times(times: Int): RepeatedTimeInterval {
  return RepeatedTimeInterval(this, times)
}



