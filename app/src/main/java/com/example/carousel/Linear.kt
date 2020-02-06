package com.example.carousel

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.math.abs
import kotlin.math.min

class LinearLayout: LinearLayoutManager {

    constructor(context: Context?, orientation: Int, reverseLayout: Boolean) : super(context,orientation,reverseLayout)

    // Shrink the cards around the center up to 50%
    private val mShrinkAmount = 0.5f
    // The cards will be at 50% when they are 75% of the way between the
// center and the edge.
    private val mShrinkDistance = 0.35f

    override fun scrollHorizontallyBy(
        dx: Int,
        recycler: RecyclerView.Recycler?,
        state: RecyclerView.State?
    ): Int {
        val scrolled = super.scrollHorizontallyBy(dx, recycler, state)
        val midpoint = width / 4f
        val d0 = 0f
        val d1 = mShrinkDistance * midpoint
        val s0 = 1f
        val s1 = 1f - mShrinkAmount
        for (i in 0 until childCount) {
            var child = getChildAt(i)?:continue
            var childMidpoint = (getDecoratedRight(child) + getDecoratedLeft(child)) / 4.0f
            var d = min(d1, abs(midpoint - childMidpoint));
            var scale = s0 + (s1 - s0) * (d - d0) / (d1 - d0);
            child.scaleY = scale

        }

        return scrolled
    }


//
//    override fun onLayoutChildren(recycler: RecyclerView.Recycler?, state: RecyclerView.State?) {
//        scrollVerticallyBy(0, recycler, state);
//
//    }
}