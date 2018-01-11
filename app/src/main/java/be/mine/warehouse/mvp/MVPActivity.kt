package be.mine.warehouse.mvp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import be.mine.warehouse.R
import be.mine.warehouse.di.DaggerRepositoryComponent
import be.mine.warehouse.model.Post
import javax.inject.Inject

class MVPActivity : AppCompatActivity(), MVPContract.View {

    @Inject
    lateinit var mPresenter: MVPContract.Presenter

    override fun initDagger() {
        val mRepositoryComponent = DaggerRepositoryComponent.builder().build()
        DaggerMVPComponent.builder().repositoryComponent(mRepositoryComponent).build().inject(this)
    }

    override fun initUI() {
        mPresenter.attachView(this)
    }

    override fun initData() {
        mPresenter.fetchPost()
    }

    override fun showPost(posts: List<Post>) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvp)
        initDagger()
        initUI()
        initData()
    }
}
