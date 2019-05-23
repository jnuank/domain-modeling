package com.handslab.domainmodeling.psyllium

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.CoreMatchers.instanceOf
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class PsylliumTest {

    @Test
    fun testNothingToRed() {
        val psylium = Psyllium()

        val red = psylium.lightOn()
        assertThat((red as Status.LightOn).color, equalTo(Color.RED))
    }

    @Test
    fun testRedToBlue() {
        val psylium = Psyllium()

        val red = psylium.lightOn()
        val blue = Psyllium(red).lightOn()

        assertThat((blue as Status.LightOn).color, equalTo(Color.BLUE))
    }

    @Test
    fun testBlueToRed() {
        val psylium = Psyllium()

        val red = psylium.lightOn()
        val blue = Psyllium(red).lightOn()
        val red2 = Psyllium(blue).lightOn()

        assertThat((red2 as Status.LightOn).color, equalTo(Color.RED))
    }

    @Test
    fun testRedToNothing() {
        val psylium = Psyllium()

        val red = psylium.lightOn()
        val off = Psyllium(red).lightOff()

        assertThat(off, instanceOf(Status.LightOff::class.java))
    }

    @Test
    fun testBlueToNothing() {
        val psylium = Psyllium()

        val red = psylium.lightOn()
        val blue = Psyllium(red).lightOn()
        val off = Psyllium(blue).lightOff()

        assertThat(off, instanceOf(Status.LightOff::class.java))
    }

    @Test
    fun testNothingToNothing() {
        val psylium = Psyllium()

        val off = psylium.lightOff()

        assertThat(off, instanceOf(Status.LightOff::class.java))
    }
}