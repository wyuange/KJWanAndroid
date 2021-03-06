package kylec.me.base.ui

import androidx.fragment.app.Fragment
import kylec.me.base.R

/**
 * Created by KYLE on 2019/5/10 - 20:10
 */
abstract class BaseContainerActivity(
    override val layoutId: Int = R.layout.activity_container
) : BaseActivity() {

    override fun initView() = getFragment().commit(R.id.container)

    abstract fun getFragment(): Fragment
}
