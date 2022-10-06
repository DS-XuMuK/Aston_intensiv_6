package ru.nikolaykolchin.astonintensiv6

import androidx.recyclerview.widget.DiffUtil

class ContactDiffUtil : DiffUtil.ItemCallback<Person>() {
    override fun areItemsTheSame(oldItem: Person, newItem: Person): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Person, newItem: Person): Boolean {
        return oldItem.name == newItem.name
    }
}