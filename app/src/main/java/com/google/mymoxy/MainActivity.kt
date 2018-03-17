package com.google.mymoxy

import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.widget.RelativeLayout
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.PresenterType
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.arellomobile.mvp.presenter.ProvidePresenterTag

class MainActivity : MvpAppCompatActivity(), DialogView {

    @InjectPresenter(type = PresenterType.GLOBAL)
    lateinit var dialogPresenter: DialogPresenter

    var alertDialog: AlertDialog? = null

    @ProvidePresenterTag(presenterClass = DialogPresenter::class, type = PresenterType.GLOBAL)
    fun provideDialogPresenterTag(): String = "MyMoxy"

    @ProvidePresenter(type = PresenterType.GLOBAL)
    fun ProvideDialogPresenter() = DialogPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<RelativeLayout>(R.id.activity_main)
                .setOnClickListener { dialogPresenter.onShowDialogClick() }
    }

    override fun showDialog() {
        alertDialog = AlertDialog.Builder(this)
                .setTitle("MyMoxy Alert Dialog")
                .setMessage("Hello from MyMoxy")
                .setOnDismissListener { dialogPresenter.onHideDialog() }
                .show()
    }

    override fun hideDialog() {
        alertDialog?.setOnDismissListener {}
        alertDialog?.cancel()
    }

    override fun onDestroy() {
        super.onDestroy()

        hideDialog()
    }
}
