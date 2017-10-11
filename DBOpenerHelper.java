package com.example.samyappdev.studentprogresstracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Samy on 11/4/2016. Samy comment _ Override methods in the SQLiteOpenHelper class
 */

public class DBOpenerHelper extends SQLiteOpenHelper {
    //Declare instance variables
    //Constants for db name and version
    private static final String DATABASE_NAME = "notes.db";
    private static final int DATABASE_VERSION = 8;

    //Constants for identifying table and columns
    public static final String TABLE_NOTES = "notes";
    public static final String NOTE_ID = "_id";
    public static final String NOTE_TEXT = "noteText";
    public static final String NOTE_CREATED = "noteCreated";
    public static final String ASSOCIATED_COURSE = "assocCourse";
    public static final String ASSOCIATED_TERM = "assocTerm";
    public static final String ASSOCIATED_ASSESSMENT = "assocAssessment";//Can have only one associated assessment <One to one relationship>
    public static final String IMAGE = "image";
    public static final String IMAGE_TAG = "image_tag";


    public static final String[] ALL_COLUMNS = {NOTE_ID, NOTE_TEXT, NOTE_CREATED};

    //SQL to create table
    private static final String TABLE_CREATE =
            "CREATE TABLE " + TABLE_NOTES + " (" +
                    NOTE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    NOTE_TEXT + " TEXT, " +
                    NOTE_CREATED + " TEXT default CURRENT_TIMESTAMP, " + ASSOCIATED_COURSE + " TEXT, " + ASSOCIATED_TERM + " TEXT, " +
                    ASSOCIATED_ASSESSMENT + " TEXT, " + IMAGE + "BLOB, " + IMAGE_TAG + " TEXT " + ")";

    //--------------------------CREATE THE IMAGE TABLE-----------------------------------------------------------------------------
    // Table Names
    public static final String IMAGE_TABLE = "table_image";
    public static final String KEY_ID = "_id";
    // column names
    public static final String KEY_NAME = "image_name";
    public static final String KEY_IMAGE = "image_data";
    public static final String IMAGE_ASSESSMENT_ID = "assessmentId";
    public static final String IMAGE_NOTE_ID = "assocnoteid";


    // Table create statement
    private static final String CREATE_TABLE_IMAGE = "CREATE TABLE " + IMAGE_TABLE + "("+ KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            KEY_NAME + " TEXT," + IMAGE_ASSESSMENT_ID + " TEXT," + IMAGE_NOTE_ID + " TEXT," + KEY_IMAGE + " BLOB );";


    //----------------------------------------------------------------------------------------------------------------------------

    public DBOpenerHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //Create database
        sqLiteDatabase.execSQL(TABLE_CREATE);
        sqLiteDatabase.execSQL(CREATE_TABLE_IMAGE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //Drop the table if exists
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NOTES);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + IMAGE_TABLE);
        //Recreate the table using current structure
        onCreate(sqLiteDatabase);
    }
    //========================================My Methods=================================================================
    public Cursor returnNotesAssociatedWithAssessment(String assessId, SQLiteDatabase db){

        String[] projection = {NOTE_ID, NOTE_TEXT,
                NOTE_CREATED, ASSOCIATED_COURSE, ASSOCIATED_ASSESSMENT };

        String selection = ASSOCIATED_ASSESSMENT + " LIKE ?";
        String[] selection_args = {assessId};

        Cursor cursor = db.query(TABLE_NOTES, projection, selection, selection_args, null, null, null);
        //cursor.moveToFirst();
        return cursor;
    }

    public Cursor returnNoteGivenNoteId(String noteId, SQLiteDatabase db){
        String[] projection = {NOTE_ID, NOTE_TEXT,
                NOTE_CREATED, ASSOCIATED_COURSE, ASSOCIATED_ASSESSMENT };

        String selection = NOTE_ID + " LIKE ?";
        String[] selection_args = {noteId};

        Cursor cursor = db.query(TABLE_NOTES, projection, selection, selection_args, null, null, null);
        return cursor;

    }
    public Cursor returnNotesAssociatedWithCourse(String courseid, String termid, SQLiteDatabase db){

        String[] projection = {NOTE_ID, NOTE_TEXT,
                NOTE_CREATED, ASSOCIATED_COURSE, ASSOCIATED_TERM };

        String selection = ASSOCIATED_COURSE + " LIKE ?" + " AND " + ASSOCIATED_TERM + " LIKE ?";
        String[] selection_args = {courseid, termid};

        Cursor cursor = db.query(TABLE_NOTES, projection, selection, selection_args, null, null, null);

        return cursor;
    }

    //--------------------------IMAGE SECTION------------------------------------------
    public void addEntry( String name, String noteId, String assessId, byte[] image) throws SQLiteException {
        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues cv = new ContentValues();

        cv.put(KEY_NAME,    name);

        cv.put(KEY_IMAGE,   image);

        cv.put(IMAGE_NOTE_ID, noteId);

        cv.put(IMAGE_ASSESSMENT_ID, assessId);

        database.insert( IMAGE_TABLE, null, cv );
    }
    public void addPhotoEntry(String name, String assessId, byte[] image) throws SQLiteException {
        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues cv = new ContentValues();

        cv.put(KEY_NAME,    name);

        cv.put(KEY_IMAGE,   image);

        cv.put(IMAGE_ASSESSMENT_ID, assessId);

        database.insert( IMAGE_TABLE, null, cv );
    }

    public Cursor returnImageWhereAssessmentAndNoteIdMatchGivenValues(String assessId, String noteId, SQLiteDatabase db){

        String[] projection = {KEY_ID, KEY_NAME, KEY_IMAGE, IMAGE_NOTE_ID, IMAGE_ASSESSMENT_ID};

        String selection = IMAGE_NOTE_ID + " LIKE ?" + " AND " + IMAGE_ASSESSMENT_ID + " LIKE ?";
        String[] selection_args = {noteId, assessId};

        Cursor cursor = db.query(IMAGE_TABLE, projection, selection, selection_args, null, null, null);

        return cursor;
    }
    public Cursor returnPhotoForAssessment(String assessId, SQLiteDatabase db){

        String[] projection = {KEY_ID, KEY_NAME, KEY_IMAGE, IMAGE_ASSESSMENT_ID};

        String selection = IMAGE_ASSESSMENT_ID + " LIKE ?";
        String[] selection_args = {assessId};

        Cursor cursor = db.query(IMAGE_TABLE, projection, selection, selection_args, null, null, null);

        return cursor;
    }
    //-------------------------------------------------------CRUD SECTION------------------------------------------------------------
    public boolean deleteNoteAssociatedWithGivenAssessment(SQLiteDatabase db, String assessmentid){

        // Define 'where' part of query.
        String selection = ASSOCIATED_ASSESSMENT + " LIKE ?";
        // Specify arguments in placeholder order.
        String[] selectionArgs = {assessmentid};
        // Issue SQL statement.
        db.delete(TABLE_NOTES, selection, selectionArgs);

        return true;
    }
    public boolean deleteImageAssociatedWithGivenAssessment(SQLiteDatabase db, String assessmentid){

        // Define 'where' part of query.
        String selection = IMAGE_ASSESSMENT_ID + " LIKE ?";
        // Specify arguments in placeholder order.
        String[] selectionArgs = {assessmentid};
        // Issue SQL statement.
        db.delete(IMAGE_TABLE, selection, selectionArgs);

        return true;
    }



}//End of class
