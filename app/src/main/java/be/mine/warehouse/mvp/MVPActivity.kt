package be.mine.warehouse.mvp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import be.mine.warehouse.R

class MVPActivity : AppCompatActivity(), MVPContract.View {

    private lateinit var mPresenter: MVPContract.Presenter

    override fun initPresenter() {
        mPresenter = MVPPresenter()
        mPresenter.attachView(this)
    }

    override fun initUI() {

    }

    override fun initData() {
        mPresenter.fetchData()
    }

    override fun showData() {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvp)
        initPresenter()
        initUI()
        initData()
    }
}
