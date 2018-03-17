package com.google.mymoxy

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter

/**
 * Created by iClub on 17.03.2018
 * @author Egor Aref'ev
 */
@InjectViewState
class DialogPresenter : MvpPresenter<DialogView>() {
    fun onShowDialogClick() {
        viewState.showDialog()
    }

    fun onHideDialog() {
        viewState.hideDialog()
    }

}