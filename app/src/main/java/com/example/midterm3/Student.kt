package layout

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Student (val name : String, val pass : String , val gender : String, val email : String , val birthday : String, val time : String , val major : String, val fruit : String) : Parcelable {
}