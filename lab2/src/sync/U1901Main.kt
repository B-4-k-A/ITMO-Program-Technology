package sync

fun main(args: Array<String>) {
    val bankMain = U1901Bank()
    val U1901Thread = U1901Thread(bankMain, 100, 2000)
    U1901Thread.name = "U1901Thread"
    U1901Thread.priority = Thread.MAX_PRIORITY
    U1901Thread.start()
    val threadTwo = U1901Thread(bankMain, 50, 300)
    threadTwo.name = "threadTwo"
    threadTwo.priority = Thread.MAX_PRIORITY
    threadTwo.start()

}