package com.b5eg.stepgradient

import android.graphics.Color

/**
 * @author Sergey
 * @since 21.02.2019
 */
class StepGradientUtil(private var colar1: Colar?, private var colar2: Colar?) {

    private var mSteps: Int = 0

    infix fun StepGradientUtil.gradient0(f: () -> IntRange): IntArray {
        val result = f.invoke().map {
            it.colorStep()
        }.toIntArray()
        recycler()
        return result
    }

    infix fun Int.upTo(steps: Int): IntRange {
        mSteps = steps
        return (this until steps)
    }

    private fun recycler() {
        mSteps = 0
        colar1 = null
        colar2 = null
    }

    private fun Int.colorStep() = Color.rgb(
        (colar1!!.r * (mSteps - this) + colar2!!.r * this) / mSteps,
        (colar1!!.g * (mSteps - this) + colar2!!.g * this) / mSteps,
        (colar1!!.b * (mSteps - this) + colar2!!.b * this) / mSteps
    )
}

data class Colar(
    val r: Int,
    val g: Int,
    val b: Int
)

infix fun Colar.toColor(colar: Colar) = StepGradientUtil(colar1 = this, colar2 = colar)

fun Int.gradientBySteps() = (Colar(35, 164, 237) toColor Colar(6, 65, 191)).run {
    gradient0 { 0 upTo this@gradientBySteps }
}








