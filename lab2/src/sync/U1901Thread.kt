package sync

class U1901Thread(var bankWork: U1901Bank, var intTrans: Int, var lngSleep: Long) : Thread(){

    override fun run() {
        bankWork.calc(intTrans, lngSleep)
        println("End, ${Thread.currentThread().name}")
    }

}