package com.handslab.domainmodeling.psyllium

class Psyllium(
    val status: Status = Status.LightOff
) {
    fun lightOn() : Status {
        return when (status) {
            is Status.LightOff -> Status.LightOn(Color.RED)
            is Status.LightOn -> {
                // メモ：smart castしている
                when (status.color) {
                    Color.RED -> Status.LightOn(Color.BLUE)
                    Color.BLUE -> Status.LightOn(Color.RED)
                }
            }
        }
    }
    fun lightOff()  = Status.LightOff
}