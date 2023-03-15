package com.example.satriaadhipradana.utills

import android.content.Context
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.Color
import android.text.TextUtils
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.domain.models.CategoryModel
import com.example.satriaadhipradana.R
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso

fun String.isEmailValid(): Boolean {
    return !TextUtils.isEmpty(this) && android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches()
}

fun View.hideKeyBoard() {
    val imm: InputMethodManager =
        context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(windowToken, 0)
}

fun showSnackBarError(view: View, title: String, context: Context?) {
    val snack = Snackbar.make(view, title, Snackbar.LENGTH_SHORT)
        .setTextColor(Color.WHITE)
        .setBackgroundTint(Color.RED)
        .setActionTextColor(Color.WHITE)
    snack.setAction(context?.getString(R.string.cancel)) {
        snack.dismiss()
    }
    snack.show()
}

fun ImageView.downloadIcon(path: String) {
    Picasso.get().load(path)
        .error(R.drawable.ic_image)
        .into(this)
}

fun Int.dpToPx(): Int {
    return (this * Resources.getSystem().displayMetrics.density).toInt()
}

fun createListCategory(context: Context?): MutableList<CategoryModel> {
    val list = mutableListOf<CategoryModel>()
    for (i in 0..6) {
        when (i) {
            0 -> {
                list.add(
                    CategoryModel(
                        icon = R.drawable.ic_telephone,
                        label = context?.getString(R.string.phons) ?: "Category"
                    )
                )
            }
            1 -> {
                list.add(
                    CategoryModel(
                        icon = R.drawable.ic_headphones,
                        label = context?.getString(R.string.headphones) ?: "Category"
                    )
                )
            }
            2 -> {
                list.add(
                    CategoryModel(
                        icon = R.drawable.ic_games,
                        label = context?.getString(R.string.games) ?: "Category"
                    )
                )
            }
            3 -> {
                list.add(
                    CategoryModel(
                        icon = R.drawable.ic_cars,
                        label = context?.getString(R.string.cars) ?: "Category"
                    )
                )
            }
            4 -> {
                list.add(
                    CategoryModel(
                        icon = R.drawable.ic_furniture,
                        label = context?.getString(R.string.furniture) ?: "Category"
                    )
                )
            }
            5 -> {
                list.add(
                    CategoryModel(
                        icon = R.drawable.ic_kids,
                        label = context?.getString(R.string.kids) ?: "Category"
                    )
                )
            }
            6 -> {
                list.add(
                    CategoryModel(
                        icon = R.drawable.ic_computer,
                        label = context?.getString(R.string.computers) ?: "Category"
                    )
                )
            }
        }
    }
    return list
}