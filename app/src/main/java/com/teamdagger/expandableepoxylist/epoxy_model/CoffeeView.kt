package com.teamdagger.expandableepoxylist.epoxy_model

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.teamdagger.expandableepoxylist.R
import com.teamdagger.expandableepoxylist.entity.Coffee

@EpoxyModelClass(layout = R.layout.item_coffee)
abstract class CoffeeView: EpoxyModelWithHolder<CoffeeView.Holder>() {

    @EpoxyAttribute
    lateinit var item: Coffee

    override fun bind(holder: Holder) {
        super.bind(holder)

        holder.title.text = item.title
        holder.description.text = item.decsription
    }

    inner class Holder : EpoxyHolder() {

        lateinit var title: TextView
        lateinit var description: TextView
        lateinit var avatar: ImageView

        override fun bindView(itemView: View) {
            title = itemView.findViewById(R.id.titleChildTextView)
            description = itemView.findViewById(R.id.descChildTextView)
            avatar = itemView.findViewById(R.id.avatarChildImageView)
        }

    }

}