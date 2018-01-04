package be.mine.warehouse


import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.Unbinder


/**
 * A simple [Fragment] subclass.
 * Use the [InventoryFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class InventoryFragment : Fragment() {

    lateinit var unbinder: Unbinder

    @BindView(R.id.sliding_tabs)
    lateinit var mTablayout: TabLayout

    @BindView(R.id.view_pager)
    lateinit var mViewPager: ViewPager

    lateinit var mInventoryContentPagerAdapter: InventoryContentPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater!!.inflate(R.layout.fragment_inventory, container, false)
        unbinder = ButterKnife.bind(this, view)

        mInventoryContentPagerAdapter = InventoryContentPagerAdapter(childFragmentManager)
        mViewPager.adapter = mInventoryContentPagerAdapter
        mTablayout.setupWithViewPager(mViewPager)
        mTablayout.tabMode = TabLayout.MODE_SCROLLABLE
        return view
    }

    companion object {
        // TODO: Rename parameter arguments, choose names that match
        // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment InventoryFragment.
         */
        // TODO: Rename and change types and number of parameters
        fun newInstance(): InventoryFragment {
            val fragment = InventoryFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        unbinder.unbind()
    }

    class InventoryContentPagerAdapter constructor(fragmentManager: FragmentManager) : SmartFragmentStatePagerAdapter(fragmentManager) {

        companion object {
            public val INVENTORY_CONTENT_TOTAL = 5
        }

        override fun getCount(): Int {
            return INVENTORY_CONTENT_TOTAL
        }

        override fun getItem(position: Int): Fragment {
            return InventoryContentFragment.newInstance()
        }

        override fun getPageTitle(position: Int): CharSequence {
            when (position) {
                InventoryContent.MAIN -> {
                    return "MAIN"
                }
                InventoryContent.PICTURES -> {
                    return "PICTURES"
                }
                InventoryContent.NEW_PRODUCTS -> {
                    return "NEW_PRODUCTS"
                }
                InventoryContent.NEW_ORDERS -> {
                    return "NEW_ORDERS"
                }
                InventoryContent.INVENTORIES -> {
                    return "INVENTORIES"
                }
                else -> {
                    return "MAIN"
                }
            }
        }
    }

    class InventoryContent {
        companion object {
            val MAIN = 0
            val PICTURES = 1
            val NEW_PRODUCTS = 2
            val NEW_ORDERS = 3
            val INVENTORIES = 4
        }
    }

}// Required empty public constructor
