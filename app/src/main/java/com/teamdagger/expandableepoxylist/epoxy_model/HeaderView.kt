package com.teamdagger.expandableepoxylist.epoxy_model

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.teamdagger.expandableepoxylist.R
import com.teamdagger.expandableepoxylist.entity.Header

@EpoxyModelClass(layout = R.layout.item_header)
abstract class HeaderView: EpoxyModelWithHolder<HeaderView.Holder>() {

    @EpoxyAttribute
    lateinit var item: Header

    @EpoxyAttribute
    lateinit var onExpandClicked: () -> Unit

    override fun bind(holder: Holder) {
        super.bind(holder)

        holder.setItem(item)
    }

    inner class Holder : EpoxyHolder() {

        private lateinit var title: TextView
        private lateinit var expandButton: ImageView

        override fun bindView(itemView: View) {
            title = itemView.findViewById(R.id.titleHeaderTextView)
            expandButton = itemView.findViewById(R.id.expandHeaderButton)
            itemView.context
        }

        fun setItem(header: Header) {
            title.text = item.title
            expandButton.setImageDrawable(
                if (header.isExpanded) {
                    AppCompatResources.getDrawable(title.context, R.drawable.ic_baseline_keyboard_arrow_up_24)
                } else {
                    AppCompatResources.getDrawable(title.context, R.drawable.ic_baseline_keyboard_arrow_down_24)
                }
            )
            expandButton.setOnClickListener {
                onExpandClicked.invoke()
            }
        }

    }

}