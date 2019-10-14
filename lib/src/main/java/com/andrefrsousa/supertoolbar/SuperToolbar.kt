/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2018 André Sousa
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.andrefrsousa.supertoolbar

import android.content.Context
import android.graphics.Typeface
import android.os.Build
import android.util.AttributeSet
import android.view.Gravity
import android.view.animation.DecelerateInterpolator
import androidx.appcompat.widget.AppCompatTextView
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat

private const val DURATION = 250

open class SuperToolbar : Toolbar {

    private lateinit var titleView: AppCompatTextView

    private var isElevationShown = false
    private var centerTitle = false
    private var useLightFont = false
    private var animationDuration = 0L
    private var toolbarElevation = 0f

    constructor(context: Context) : super(context) {
        initView(context, null, 0)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        initView(context, attrs, 0)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        initView(context, attrs, defStyleAttr)
    }

    private fun initView(context: Context, attrs: AttributeSet?, defStyleAttr: Int) {
        if (isInEditMode || attrs == null) {
            return
        }

        with(context.obtainStyledAttributes(attrs, R.styleable.SuperToolbar, defStyleAttr, 0)) {
            animationDuration =
                getInt(R.styleable.SuperToolbar_superToolbar_animationDuration, DURATION).toLong()
            isElevationShown =
                getBoolean(R.styleable.SuperToolbar_superToolbar_showElevationAtStart, false)
            centerTitle = getBoolean(R.styleable.SuperToolbar_superToolbar_centerTitle, false)
            useLightFont = getBoolean(R.styleable.SuperToolbar_superToolbar_useLightFont, false)
            recycle()
        }

        // If no elevation was defined we fallback to the default value
        with(ViewCompat.getElevation(this)) {
            toolbarElevation = if (this == 0f) {
                resources.getDimension(R.dimen.super_toolbar_default_elevation)
            } else {
                this
            }
        }

        // By default we remove the elevation when creating the toolbar
        if (!isElevationShown) {
            ViewCompat.setElevation(this, 0f)
        }

        // Add a custom title view
        if (centerTitle || useLightFont) {
            titleView = inflate(R.layout.super_toolbar_title) as AppCompatTextView

            if (useLightFont) {
                titleView.typeface = Typeface.SANS_SERIF
            }

            if (centerTitle) {
                val layoutParams = titleView.layoutParams as Toolbar.LayoutParams
                layoutParams.gravity = Gravity.CENTER
                addView(titleView, layoutParams)

            } else {
                addView(titleView)
            }
        }
    }

    override fun setTitle(resId: Int) {
        if (::titleView.isInitialized) {
            titleView.setText(resId)
            return
        }

        super.setTitle(resId)
    }

    override fun setTitle(title: CharSequence?) {
        if (::titleView.isInitialized) {
            titleView.text = title
            return
        }

        super.setTitle(title)
    }

    override fun setTitleTextAppearance(context: Context?, resId: Int) {
        if (::titleView.isInitialized) {
            if (hasMinimumSdk(Build.VERSION_CODES.M)) {
                titleView.setTextAppearance(resId)

            } else {
                titleView.setTextAppearance(context, resId)
            }

            return
        }

        super.setTitleTextAppearance(context, resId)
    }

    override fun setTitleTextColor(color: Int) {
        if (::titleView.isInitialized) {
            titleView.setTextColor(color)
            return
        }

        super.setTitleTextColor(color)
    }

    //region PUBLIC METHODS

    /**
     * Toggles the toolbar elevation visibility using an animation
     *
     * @param show true if you want to show the elevation; false otherwise
     */
    fun setElevationVisibility(show: Boolean) {
        if (isElevationShown == show) {
            return
        }

        isElevationShown = show

        ViewCompat.animate(this).run {
            translationZ(if (show) toolbarElevation else 0f)
            interpolator = DecelerateInterpolator()
            duration = animationDuration
            start()
        }
    }

    //endregion
}