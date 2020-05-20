package omari.hamza.mvvm

import android.app.Application
import omari.hamza.mvvm.ui.home.HomeViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.bind
import org.kodein.di.generic.provider

class MyApplication : Application(), KodeinAware {

    override val kodein by Kodein.lazy {

        bind() from provider { HomeViewModelFactory() }


    }
}