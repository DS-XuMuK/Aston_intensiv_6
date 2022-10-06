package ru.nikolaykolchin.astonintensiv6

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

const val KEY_CONTACT_FRAGMENT_LIST = "contact_fragment_list"

class ContactsFragment : Fragment(R.layout.fragment_contacts) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
        val adapter = ContactAdapter()

        recyclerView.adapter = adapter
        arguments?.let {
            adapter.submitList(it.getSerializable(KEY_CONTACT_FRAGMENT_LIST) as ArrayList<Person>)
        }
    }

    companion object {
        val CONTACTS_FRAGMENT_TAG = "contacts_fragment_tag"

        fun newInstance(): ContactsFragment {
            val fragment = ContactsFragment()
            val args = Bundle()
            val list = arrayListOf<Person>()
            for (i in 1..110) {
                list.add(
                    Person(
                        "Name$i",
                        "FamilyName$i",
                        "8800555$i",
                        "https://source.unsplash.com/random/200x200?sig=$i"
                    )
                )
            }
            args.putSerializable(KEY_CONTACT_FRAGMENT_LIST, list)
            fragment.arguments = args
            return fragment
        }
    }
}