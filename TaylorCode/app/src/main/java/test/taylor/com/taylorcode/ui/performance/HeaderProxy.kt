package test.taylor.com.taylorcode.ui.performance

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import test.taylor.com.taylorcode.kotlin.ConstraintLayout
import test.taylor.com.taylorcode.kotlin.*
import test.taylor.com.taylorcode.ui.recyclerview.variety.VarietyAdapter2

class HeaderProxy : VarietyAdapter2.Proxy<Header, HeaderViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView = parent.context.run {
            LinearLayout {
                layout_width = match_parent
                layout_height = wrap_content
                orientation = vertical
                padding_top = 10
                padding_horizontal = 10
                shape = shape {
                    corner_radii = intArrayOf(20, 20, 20, 20, 0, 0, 0, 0)
                    solid_color = "#ffffff"
                }

                TextView {
                    layout_id = "tvTitle"
                    layout_width = wrap_content
                    layout_height = wrap_content
                    textSize = 16f
                    textColor = "#3F4658"
                    textStyle = bold
                    margin_bottom = 3
                }

                ConstraintLayout {
                    layout_width = match_parent
                    layout_height = wrap_content
                    margin_top = 16

                    TextView {
                        layout_id = "tvRank"
                        layout_width = wrap_content
                        layout_height = wrap_content
                        textSize = 11f
                        textColor = "#9DA4AD"
                        start_toStartOf = parent_id
                        center_vertical = true
                    }

                    TextView {
                        layout_id = "tvName"
                        layout_width = wrap_content
                        layout_height = wrap_content
                        textSize = 11f
                        textColor = "#9DA4AD"
                        align_vertical_to = "tvRank"
                        start_toEndOf = "tvRank"
                        margin_start = 19
                    }

                    TextView {
                        layout_id = "tvCount"
                        layout_width = wrap_content
                        layout_height = wrap_content
                        textSize = 11f
                        textColor = "#9DA4AD"
                        align_vertical_to = "tvRank"
                        end_toEndOf = parent_id
                    }
                }
            }
        }
        return HeaderViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: HeaderViewHolder, data: Header, index: Int, action: ((Any?) -> Unit)?) {
        holder.tvCount?.text = data.count
        holder.tvName?.text = data.name
        holder.tvRank?.text = data.rank
        holder.tvTitle?.text = data.title
    }
}

data class Header(
    val rank: String,
    val name: String,
    val count: String,
    val title:String
)

class HeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val tvRank = itemView.find<TextView>("tvRank")
    val tvName = itemView.find<TextView>("tvName")
    val tvCount = itemView.find<TextView>("tvCount")
    val tvTitle = itemView.find<TextView>("tvTitle")
}