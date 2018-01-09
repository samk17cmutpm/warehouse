package be.mine.warehouse.mvp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import be.mine.warehouse.R
import be.mine.warehouse.data.repositories.PostDataRepository
import be.mine.warehouse.model.Post

class MVPActivity : AppCompatActivity(), MVPContract.View {

    private lateinit var mPresenter: MVPContract.Presenter

    override fun initPresenter() {
        mPresenter = MVPPresenter(PostDataRepository())
        mPresenter.attachView(this)
    }

    override fun initUI() {

    }

    override fun initData() {
        mPresenter.fetchPost()
    }

    override fun showPost(posts: List<Post>) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvp)
        initPresenter()
        initUI()
        initData()
    }
}
