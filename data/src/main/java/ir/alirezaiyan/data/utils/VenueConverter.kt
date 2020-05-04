package ir.alirezaiyan.data.utils

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import ir.alirezaiyan.data.remote.response.*
import java.lang.reflect.Type


/**
 * @author Ali (alirezaiyann@gmail.com)
 * @since 5/2/2020 2:07 AM.
 */
class VenueConverter {
    private val gson = Gson()

    @TypeConverter
    fun locationToString(location: Location): String {
        return gson.toJson(location)
    }

    @TypeConverter
    fun stringToLocation(location: String): Location? {
        return gson.fromJson(location, Location::class.java)
    }

    @TypeConverter
    fun contactToString(contact: Contact): String {
        return gson.toJson(contact)
    }

    @TypeConverter
    fun stringToContact(contact: String): Contact? {
        return gson.fromJson(contact, Contact::class.java)
    }

    @TypeConverter
    fun statsToString(stats: Stats): String {
        return gson.toJson(stats)
    }

    @TypeConverter
    fun stringToStats(stats: String): Stats? {
        return gson.fromJson(stats, Stats::class.java)
    }

    @TypeConverter
    fun photoToString(photo: Response<PhotoResponse>): String {
        return gson.toJson(photo)
    }

    @TypeConverter
    fun stringToPhoto(photo: String): Response<PhotoResponse> {
        val type: Type = object : TypeToken<Response<PhotoResponse>>() {}.type
        return gson.fromJson(photo, type)
    }

    @TypeConverter
    fun categoriesToString(categories: List<Categories>): String {
        return gson.toJson(categories)
    }

    @TypeConverter
    fun stringToCategories(data: String): List<Categories>? {
        val type = object : TypeToken<List<Categories>>() {

        }.type
        return gson.fromJson<List<Categories>>(data, type)
    }

}