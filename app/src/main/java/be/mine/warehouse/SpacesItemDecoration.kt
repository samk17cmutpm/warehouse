package be.mine.warehouse

import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View

/**
 * Created by sam_nguyen on 1/4/18.
 */
class SpacesItemDecoration constructor(val mSpace: Int) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View?, parent: RecyclerView?, state: RecyclerView.State?) {
        outRect.left = mSpace
        outRect.right = mSpace
        outRect.top = mSpace
        outRect.bottom = mSpace
    }
}