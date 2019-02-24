package com.b5eg.stepgradient

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View


/**
 * @author Sergey
 * @since 20.02.2019
 */
class LineProgress : View {

    private var mWidth = 0
    private var mHeight = 0
    private val strokeWidth = 25F

    var colors = intArrayOf()
        set(value) {
            field = value
            positions = (1..value.size).map { it / (value.size).toFloat() }.toFloatArray()
            invalidate()
        }

    private var positions = floatArrayOf()

    private fun init(context: Context, attrs: AttributeSet?, defStyle: Int) {
    }

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas) {
        if (colors.isEmpty()) return
        gradient = LinearGradient(
            0F,
            0F,
            mWidth.toFloat(),
            0F,
            colors,
            positions,
            Shader.TileMode.MIRROR

        )

        mPaint.shader = gradient
        canvas.drawRoundRect(rectFProgress, strokeWidth / 2, strokeWidth / 2, mPaint)
        super.onDraw(canvas)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        mHeight = h
        mWidth = w

        rectF.set(
            0F, h / 2 - strokeWidth / 2,
            w.toFloat(), h / 2 + strokeWidth / 2
        )

        rectFProgress.set(
            0F, h / 2 - strokeWidth / 2,
            w.toFloat(), h / 2 + strokeWidth / 2
        )

        super.onSizeChanged(w, h, oldw, oldh)
    }

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs, 0) {
        init(context, attrs, 0)
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {
        init(context, attrs, defStyle)
    }

    private var rectF = RectF()
    private var rectFProgress = RectF()

    private var mPaint = Paint().apply {
        isAntiAlias = true
        style = Paint.Style.FILL
    }

    private var gradient: LinearGradient? = null

}