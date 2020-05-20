package omari.hamza.mvvm.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import omari.hamza.mvvm.BR
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein

abstract class BaseActivity<V : ViewModel, B : ViewDataBinding> :
    AppCompatActivity(), KodeinAware {


    override val kodein by kodein()

    abstract val layoutId: Int

    lateinit var viewModel: V

    lateinit var binding: B

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutId)
        viewModel = ViewModelProvider(this, getViewModelFactory()).get(getViewModelClass())
        binding.lifecycleOwner = this
        initializeUi()
        readIntent()
        getData()
    }

    protected abstract fun getViewModelClass(): Class<V>

    protected abstract fun getViewModelFactory(): ViewModelProvider.Factory

    abstract fun initializeUi()

    abstract fun readIntent()

    abstract fun getData()

}