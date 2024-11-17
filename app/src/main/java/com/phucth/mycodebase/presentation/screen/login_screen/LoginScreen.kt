package com.phucth.mycodebase.presentation.screen.login_screen

import android.os.Bundle
import android.view.View
import com.phucth.base.fragment.FragmentBase
import com.phucth.mycodebase.R
import com.phucth.mycodebase.databinding.LoginFragmentBinding


class LoginScreen : FragmentBase<LoginFragmentBinding>(LoginFragmentBinding::inflate) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding?.btnLogin?.onButtonClick {
            moveToNewScreen(
                idNextScreen = R.id.action_move_to_home_graph,
                isUseAnimation = true,
                idPopScreen = R.id.loginScreen,
                isPopCurrentScreen = false
            )
        }
    }
}
