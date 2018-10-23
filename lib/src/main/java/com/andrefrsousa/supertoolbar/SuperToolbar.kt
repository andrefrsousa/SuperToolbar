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

private const val DURATION = 250L

class SuperToolbar : Toolbar {

    private var isElevationShown = false

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    fun toggleElevation(show: Boolean) {
        if (isElevationShown == show) {
            return
        }

        isElevationShown = show

        if (show) {
            ViewCompat.animate(this).translationZ(context.resources.getDimension(R.dimen.toolbar_elevation)).run {
                interpolator = DecelerateInterpolator()
                duration = DURATION
                start()
            }
        } else {
            ViewCompat.animate(this).translationZ(0f).run {
                interpolator = DecelerateInterpolator()
                duration = DURATION
                start()
            }
        }
    }
}