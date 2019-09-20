package hu.ait.mf

import android.app.Dialog
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v7.app.AlertDialog


class AboutDialog : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireContext())

        builder.setTitle(getString(R.string.about_title))

        val rootView = requireActivity().layoutInflater.inflate(
            R.layout.about_dialog, null
        )

        builder.setView(rootView)
        builder.setPositiveButton("OK") {
                dialog, witch -> // empty
        }

        return builder.create()
    }
}