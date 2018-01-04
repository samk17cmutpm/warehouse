package be.mine.warehouse


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.Unbinder


/**
 * A simple [Fragment] subclass.
 * Use the [InventoryContentFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class InventoryContentFragment : Fragment() {

    lateinit var unbinder: Unbinder

    lateinit var mInventoryAdapter: InventoryAdapter

    val mInventoryItems = ArrayList<InventoryItem>()

    @BindView(R.id.recycler_view)
    lateinit var mRecyclerView: RecyclerView

    lateinit var mSpacesItemDecoration : SpacesItemDecoration

    lateinit var mLinearLayoutManager : LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater!!.inflate(R.layout.fragment_inventory_content, container, false)
        unbinder = ButterKnife.bind(this, view)
        for (item: Int in 1..100)
            mInventoryItems.add(InventoryItem())

        mSpacesItemDecoration = SpacesItemDecoration(10)
        mInventoryAdapter = InventoryAdapter(mInventoryItems)
        mLinearLayoutManager = LinearLayoutManager(activity)

        mRecyclerView.layoutManager = mLinearLayoutManager
        mRecyclerView.setHasFixedSize(true)
        mRecyclerView.addItemDecoration(mSpacesItemDecoration)
        mRecyclerView.adapter = mInventoryAdapter
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment InventoryContentFragment.
         */
        // TODO: Rename and change types and number of parameters
        fun newInstance(): InventoryContentFragment {
            val fragment = InventoryContentFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }

}// Required empty public constructor
