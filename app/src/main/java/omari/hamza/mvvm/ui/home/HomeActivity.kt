package omari.hamza.mvvm.ui.home

import omari.hamza.mvvm.R
import omari.hamza.mvvm.databinding.ActivityHomeBinding
import omari.hamza.mvvm.ui.base.BaseActivity
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class HomeActivity : BaseActivity<HomeViewModel, ActivityHomeBinding>(), KodeinAware {

    override val kodein by kodein()

    private val factory: HomeViewModelFactory by instance()

    override val layoutId = R.layout.activity_home

    override fun getViewModelClass() = HomeViewModel::class.java

    override fun getViewModelFactory() = factory

    override fun initializeUi() {
        binding.viewModel = viewModel
    }

    override fun readIntent() {

    }

    override fun getData() {

    }

}
