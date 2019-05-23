package com.handslab.domainmodeling.psyllium

sealed class Status {
    data class LightOn(val color: Color): Status()
    object LightOff: Status()
}