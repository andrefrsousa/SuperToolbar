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
import android.support.v4.view.ViewCompat
import android.support.v7.widget.Toolbar
import android.util.AttributeSet
import android.view.animation.DecelerateInterpolator

private const val DURATION = 250

open class SuperToolbar : Toolbar {

    private var isElevationShown = false
    private var animationDuration: Long = 0L
    private var toolbarElevation: Float = 0f

    constructor(context: Context) : super(context) {
        initView(context, null, 0)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        initView(context, attrs, 0)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        initView(context, attrs, defStyleAttr)
    }

    private fun initView(context: Context, attrs: AttributeSet?, defStyleAttr: Int) {
        if (isInEditMode || attrs == null) {
            return
        }

        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.SuperToolbar, defStyleAttr, 0)
        animationDuration = typedArray.getInt(R.styleable.SuperToolbar_superToolbar_animationDuration, DURATION).toLong()
        isElevationShown = typedArray.getBoolean(R.styleable.SuperToolbar_superToolbar_showElevationAtStart, false)
        typedArray.recycle()

        // Store the current toolbar elevation
        val elevation = ViewCompat.getElevation(this)

        // If no elevation was defined we fallback to the default value
        toolbarElevation = if (elevation == 0f) {
            context.resources.getDimension(R.dimen.super_toolbar_default_elevation)
        } else {
            elevation
        }

        // By default we remove the elevation when creating the toolbar
        if (!isElevationShown) {
            ViewCompat.setElevation(this, 0f)
        }
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

        if (show) {
            ViewCompat.animate(this).translationZ(toolbarElevation).run {
                interpolator = DecelerateInterpolator()
                duration = animationDuration
                start()
            }
        } else {
            ViewCompat.animate(this).translationZ(0f).run {
                interpolator = DecelerateInterpolator()
                duration = animationDuration
                start()
            }
        }
    }

    //endregion
}