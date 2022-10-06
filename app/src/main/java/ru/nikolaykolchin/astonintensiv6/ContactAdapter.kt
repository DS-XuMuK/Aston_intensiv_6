package ru.nikolaykolchin.astonintensiv6

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.squareup.picasso.Picasso
import ru.nikolaykolchin.astonintensiv6.databinding.ItemContactBinding

const val KEY_ITEM_INDEX = "item_index"
const val KEY_DETAILS_FRAGMENT_LIST = "details_fragment_list"

class ContactAdapter
    : ListAdapter<Person, ContactAdapter.ContactViewHolder>(ContactDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemContactBinding.inflate(inflater)
        return ContactViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val item = getItem(position)
        holder.binding.name.text = item.toString()
        Picasso.get()
            .load(item.imagePath)
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_foreground)
            .into(holder.binding.image)
        holder.binding.root.setOnClickListener {
            val fragmentDetails = DetailsFragment.newInstance(position)
            val activity = it.context as AppCompatActivity

            if (activity.findViewById<View?>(R.id.detailsFragment) == null) {
                activity.supportFragmentManager.beginTransaction().apply {
                    replace(
                        R.id.fragment_container, fragmentDetails,
                        DetailsFragment.DETAILS_FRAGMENT_TAG
                    )
                    addToBackStack(null)
                    setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out)
                    commit()
                }
            } else {
                activity.supportFragmentManager.beginTransaction().apply {
                    replace(
                        R.id.detailsFragment, fragmentDetails,
                        DetailsFragment.DETAILS_FRAGMENT_TAG
                    )
                    commit()
                }
            }
        }
    }

    class ContactViewHolder(val binding: ItemContactBinding) : ViewHolder(binding.root)
}