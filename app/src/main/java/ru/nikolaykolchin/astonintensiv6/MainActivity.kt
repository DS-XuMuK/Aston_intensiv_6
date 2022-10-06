package ru.nikolaykolchin.astonintensiv6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.nikolaykolchin.astonintensiv6.ContactsFragment.Companion.CONTACTS_FRAGMENT_TAG
import ru.nikolaykolchin.astonintensiv6.DetailsFragment.Companion.DETAILS_FRAGMENT_TAG

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val detailsFragment = supportFragmentManager.findFragmentByTag(DETAILS_FRAGMENT_TAG)
        if ((detailsFragment == null) || !detailsFragment.isInLayout) {
            supportFragmentManager.beginTransaction().apply {
                val fragmentContact = ContactsFragment.newInstance()
                replace(R.id.fragment_container, fragmentContact, CONTACTS_FRAGMENT_TAG)
                commit()
            }
        }
    }
}