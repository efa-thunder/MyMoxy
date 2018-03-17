package com.google.mymoxy

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

/**
 * Created by iClub on 17.03.2018.
 * @author Egor Aref'ev
 */
@StateStrategyType(AddToEndSingleStrategy::class)
interface DialogView : MvpView {
    fun showDialog()
    fun hideDialog()
}