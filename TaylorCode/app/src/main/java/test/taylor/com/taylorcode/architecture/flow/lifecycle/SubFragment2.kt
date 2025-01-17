package test.taylor.com.taylorcode.architecture.flow.lifecycle

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import test.taylor.com.taylorcode.R
import test.taylor.com.taylorcode.kotlin.*
import test.taylor.com.taylorcode.ui.fragment.visibility.IPvTracker

class SubFragment2:BaseFragment(),IPvTracker {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return context?.run {
            ConstraintLayout {
                layout_id = "subFragment2"
                layout_width = match_parent
                layout_height = match_parent
                background_color = "#897654"

                TextView {
                    layout_id = "tvChange"
                    layout_width = wrap_content
                    layout_height = wrap_content
                    textSize = 50f
                    textColor = "#ffffff"
                    text = "sub Fragment 2"
                    fontFamily = R.font.pingfang
                    gravity = gravity_center
                    center_vertical = true
                    center_horizontal = true
                }
            }.also { it.setTag("subFragment2") }
        }
    }
    override fun getPvEventId(): String {
        return "SubFragment2"
    }

    override fun getPvExtra(): Bundle {
        return bundleOf()
    }
}