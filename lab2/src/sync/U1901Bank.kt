package sync

class U1901Bank {
    var intTo: Int = 0
        private set(value) {
            if(value < 0) {
                throw Exception("Incorrect value for balance")
            }
            field = value
        }

    var intFrom: Int = 220
        private set(value) {
            if (value < 0)
                throw Exception("Incorrect value for balance")
            field = value
        }

    @Synchronized
    fun calc(intTransaction: Int, lngTime: Long) {
        println("before Thread=${Thread.currentThread().name}, From=$intFrom, To=$intTo")
        intFrom -= intTransaction
        Thread.currentThread()
        try {
            Thread.sleep(100)
        } catch (exp: Exception) {
            exp.printStackTrace()
        }
        intTo += intTransaction
        println("after Thread=${Thread.currentThread().name}, From=$intFrom, To=$intTo")
    }

}