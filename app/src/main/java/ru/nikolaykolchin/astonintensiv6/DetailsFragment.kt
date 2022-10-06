package ru.nikolaykolchin.astonintensiv6

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.squareup.picasso.Picasso

class DetailsFragment : Fragment(R.layout.fragment_details) {
    private lateinit var imageContact: ImageView
    private lateinit var editName: EditText
    private lateinit var editFamilyName: EditText
    private lateinit var editPhone: EditText
    private lateinit var list: ArrayList<Person>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        imageContact = view.findViewById(R.id.imageContact)
        editName = view.findViewById(R.id.editTextName)
        editFamilyName = view.findViewById(R.id.editTextFamilyName)
        editPhone = view.findViewById(R.id.editTextPhone)

        arguments?.let {
            val itemIndex = it.getInt(KEY_ITEM_INDEX)
            list = it.getSerializable(KEY_DETAILS_FRAGMENT_LIST) as ArrayList<Person>
            onItemSelected(itemIndex)
        }
    }

    private fun onItemSelected(itemIndex: Int) {
        editName.setText(list[itemIndex].name)
        editFamilyName.setText(list[itemIndex].familyName)
        editPhone.setText(list[itemIndex].phoneNumber)

        Picasso.get()
            .load(list[itemIndex].imagePath)
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_foreground)
            .into(imageContact)
    }

    companion object {
        val DETAILS_FRAGMENT_TAG = "details_fragment_tag"

        fun newInstance(itemIndex: Int): DetailsFragment {
            val fragment = DetailsFragment()
            val args = Bundle()

            args.putInt(KEY_ITEM_INDEX, itemIndex)
            args.putSerializable(
                KEY_DETAILS_FRAGMENT_LIST,
                ContactsFragment.newInstance().arguments?.getSerializable(
                    KEY_CONTACT_FRAGMENT_LIST
                )
            )
            fragment.arguments = args
            return fragment
        }
    }
}