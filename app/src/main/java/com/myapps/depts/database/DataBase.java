package com.myapps.depts.database;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by adrian
 * on 25.02.15.
 */
public class DataBase {
	private static final String DEBUG_TAG = "SQL_DB";

	private static final int DB_VERSION = 6;
	private static final String DB_NAME = "database.db";

	protected SQLiteDatabase db;
	private Context context;

	public DataBase(Context context) {
		this.context = context;
	}

	public DataBase open() {
		DatabaseHelper dbHelper = new DatabaseHelper(context, DB_NAME, null, DB_VERSION);
		try {
			db = dbHelper.getWritableDatabase();
		} catch (SQLException e) {
			db = dbHelper.getReadableDatabase();
		}
		return this;
	}

	public void close() {
		db.close();
		context = null;
	}

	public void clearDb() {
		try {
			db.execSQL(DebtsDb.DROP_TABLE);

			db.execSQL(DebtsDb.DB_CREATE_TABLE);
		} catch (Exception e) {
			Log.e(getClass().getSimpleName(), "clearDb", e);
		}
	}

	private class DatabaseHelper extends SQLiteOpenHelper {
		public DatabaseHelper(Context context, String name,
		                      SQLiteDatabase.CursorFactory factory, int version) {
			super(context, name, factory, version);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			db.execSQL(DebtsDb.DB_CREATE_TABLE);

			Log.d(DEBUG_TAG, "Database creating...");
			Log.d(DEBUG_TAG, "Table ver." + DB_VERSION + " created");
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			db.execSQL(DebtsDb.DROP_TABLE);

			Log.d(DEBUG_TAG, "Database updating...");
			Log.d(DEBUG_TAG, "Table updated from ver." + oldVersion + " to ver." + newVersion);
			Log.d(DEBUG_TAG, "All data is lost.");

			onCreate(db);
		}
	}
}