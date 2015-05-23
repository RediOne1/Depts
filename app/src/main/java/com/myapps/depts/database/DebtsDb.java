package com.myapps.depts.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.myapps.depts.Debt;

/**
 * Created by adrian
 * on 25.02.15.
 */
public class DebtsDb extends DataBase {

    public static final String KEY_ID = "id";
    public static final String ID_OPTIONS = "INTEGER PRIMARY KEY AUTOINCREMENT";
    public static final int ID_COLUMN = 0;
    public static final String KEY_NAME = "name";
    public static final String NAME_OPTIONS = "TEXT NOT NULL";
    public static final int NAME_COLUMN = 1;
    public static final String KEY_QUOTA_IDS = "quotaIds";
    public static final String QUOTA_IDS_OPTIONS = "TEXT NOT NULL";
    public static final int QUOTA_IDS_COLUMN = 2;

    private static final String DB_TABLE = "debts";
    public static final String DB_CREATE_TABLE =
            "CREATE TABLE " + DB_TABLE + "( " +
                    KEY_ID + " " + ID_OPTIONS + ", " +
                    KEY_NAME + " " + NAME_OPTIONS + ", " +
                    KEY_QUOTA_IDS + " " + QUOTA_IDS_OPTIONS +
                    ");";

    public static final String DROP_TABLE =
            "DROP TABLE IF EXISTS " + DB_TABLE;

    public DebtsDb(Context context) {
        super(context);
    }

    public long insertDebt(Debt debt) {
        ContentValues newDebtValues = new ContentValues();
        newDebtValues.put(KEY_NAME, debt.name);
        newDebtValues.put(KEY_QUOTA_IDS, debt.getQuotaListToString());
        return debt.id = db.insert(DB_TABLE, null, newDebtValues);
    }

    public boolean updateDebt(Debt debt) {
        String where = KEY_ID + "=" + debt.id;
        ContentValues updateDebtValues = new ContentValues();
        updateDebtValues.put(KEY_NAME, debt.name);
        updateDebtValues.put(KEY_QUOTA_IDS, debt.getQuotaListToString());
        return db.update(DB_TABLE, updateDebtValues, where, null) > 0;
    }

    public boolean deleteDebt(String id) {
        String where = KEY_ID + "=" + id;
        return db.delete(DB_TABLE, where, null) > 0;
    }

    public Cursor getAllDebts() {
        String[] columns = {KEY_ID, KEY_NAME, KEY_QUOTA_IDS};
        return db.query(DB_TABLE, columns, null, null, null, null, null);
    }
}
