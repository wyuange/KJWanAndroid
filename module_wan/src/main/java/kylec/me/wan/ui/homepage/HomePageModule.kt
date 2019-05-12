package kylec.me.wan.ui.homepage

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import kylec.me.wan.repo.HomeLocalDataSource
import kylec.me.wan.repo.HomePageRepository
import kylec.me.wan.repo.HomePageRepositoryImpl
import kylec.me.wan.repo.HomeRemoteDataSource
import org.kodein.di.Kodein
import org.kodein.di.android.x.AndroidLifecycleScope
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.scoped
import org.kodein.di.generic.singleton

/**
 * Created by KYLE on 2019/5/12 - 17:32
 */

private const val NAME_HOME_PAGE_MODULE = "HOME_PAGE_MODULE"

val homePageKodeinModule = Kodein.Module(NAME_HOME_PAGE_MODULE) {

    bind<HomePageViewModel>() with scoped<Fragment>(AndroidLifecycleScope).singleton {
        ViewModelProviders.of(
            context.activity!!,
            HomePageViewModelFactory.getInstance(instance())
        ).get(HomePageViewModel::class.java)
    }

    bind<HomeRemoteDataSource>() with scoped<Fragment>(AndroidLifecycleScope).singleton {
        HomeRemoteDataSource()
    }

    bind<HomeLocalDataSource>() with scoped<Fragment>(AndroidLifecycleScope).singleton {
        HomeLocalDataSource()
    }

    bind<HomePageRepository>() with singleton { HomePageRepositoryImpl(instance(), instance()) }

}
