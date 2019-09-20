package hu.ait.mf.data

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "ingredient")
data class Ingredient(
    @PrimaryKey(autoGenerate = true) var ingredientId : Long?,
    @ColumnInfo(name = "ingredient name") var ingredientName: String
) : Serializable