package com.example.notes;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

public abstract class NotesDatabase extends RoomDatabase {

    private static NotesDatabase database;
    private static final String DB_NAME = "notes2.db";
    private static final Object LOCK = new Object();

    public static NotesDatabase getInstance(Context context) {
        synchronized (LOCK) {
            if (database == null) {
                database = Room.databaseBuilder(context, NotesDatabase.class, DB_NAME).build();
            }
            return database;
        }
    }
}
