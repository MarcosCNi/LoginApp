package com.example.loginapp.db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.loginapp.model.UserModel

class DataBaseHelper (context: Context, factory: SQLiteDatabase.CursorFactory?):
    SQLiteOpenHelper(context, DB_NAME, factory, DB_VERSION)
{
    override fun onCreate(db: SQLiteDatabase) {
        val query = (
            "CREATE TABLE " + TABLE_NAME +
                "("
                + CODE + " TEXT PRIMARY KEY, " +
                NAME + " TEXT," +
                CPF + " TEXT" +
                ADDRESS + "TEXT" +
                PHONE + "TEXT" +
                ")"
            )
        db.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun addUser(userModel: UserModel): Boolean{
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(NAME, userModel.name)
        values.put(CPF, userModel.cpf)
        values.put(ADDRESS, userModel.address)
        values.put(PHONE, userModel.phone)
        val _success = db.insert(TABLE_NAME,null,values)
        return (("$_success").toInt() != -1)
    }

    companion object{
        private val DB_VERSION = 1
        private val DB_NAME = "LoginDB"
        private val TABLE_NAME = "User"
        private val CODE = "Id"
        private val NAME = "Name"
        private val CPF = "CPF"
        private val ADDRESS = "Address"
        private val PHONE = "Phone"
    }

}