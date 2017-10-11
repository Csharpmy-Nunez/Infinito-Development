package com.example.samyappdev.studentprogresstracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import java.security.PublicKey;

/**
 * Created by Samy on 11/12/2016.
 */

public final class FeedReaderContract {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    public FeedReaderContract() {}

    /* Inner class that defines the Terms table contents */
    public static class FeedEntry implements BaseColumns{
        //Terms table
        public static final String TABLE_NAME = "terms";
        public static final String COLUMN_NAME_TERM_TITLE = "termTitle";
        public static final String COLUMN_NAME_START_DATE = "startDate";
        public static final String COLUMN_NAME_END_DATE = "endDate";

        private static final String TEXT_TYPE = " TEXT";
        private static final String COMMA_SEP = ",";
        private static final String SQL_CREATE_TERMS_ENTRIES =
                "CREATE TABLE " + FeedEntry.TABLE_NAME + " (" +
                        FeedEntry._ID + " INTEGER PRIMARY KEY," +
                        FeedEntry.COLUMN_NAME_TERM_TITLE + TEXT_TYPE + COMMA_SEP +
                        FeedEntry.COLUMN_NAME_START_DATE + TEXT_TYPE + COMMA_SEP + FeedEntry.COLUMN_NAME_END_DATE + TEXT_TYPE + " )";

        //Delete statement
        private static final String SQL_DELETE_TERMS_ENTRIES =
                "DROP TABLE IF EXISTS " + FeedEntry.TABLE_NAME;

    }//End of FeedEntry class



     /* Inner class that defines the Terms table contents */
    public static class CourseFeedEntry implements BaseColumns{
         //Courses table
         public static final String COURSE_TABLE_NAME = "courses";
         public static final String COURSE_TITLE = "courseTitle";
         public static final String COURSE_START_DATE = "courseStartDate";
         public static final String COURSE_COURSE_ANTICIPATED_END_DATE = "courseAnticipatedEndDate";
         public static final String COURSE_STATUS = "courseStatus";
         public static final String COURSE_COURSEMENTOR_FIRST_NAME = "courseMentorFname";
         public static final String COURSE_COURSEMENTOR_LAST_NAME = "courseMentorLname";
         public static final String COURSE_COURSEMENTOR_PHONE_NUMBER = "courseMentorPNumber";
         public static final String COURSE_COURSECOURSEMENTOR_EMAIL = "courseMentorEmail";
         public static final String COURSE_ASSOCIATED_TERM_ID = "assoTermId";


         //Create the course table
         private static final String TEXT_TYPE = " TEXT";
         private static final String COMMA_SEP = ",";
         private static final String SQL_CREATE_COURSE_ENTRIES =
                 "CREATE TABLE " + CourseFeedEntry.COURSE_TABLE_NAME + " (" +
                         CourseFeedEntry._ID + " INTEGER PRIMARY KEY," +
                         CourseFeedEntry.COURSE_TITLE + TEXT_TYPE + COMMA_SEP +
                         CourseFeedEntry.COURSE_START_DATE + TEXT_TYPE + COMMA_SEP + CourseFeedEntry.COURSE_COURSE_ANTICIPATED_END_DATE + TEXT_TYPE + COMMA_SEP + CourseFeedEntry.COURSE_STATUS
                         + TEXT_TYPE + COMMA_SEP + CourseFeedEntry.COURSE_COURSEMENTOR_FIRST_NAME + TEXT_TYPE + COMMA_SEP + CourseFeedEntry.COURSE_COURSEMENTOR_LAST_NAME
                         + TEXT_TYPE + COMMA_SEP + CourseFeedEntry.COURSE_COURSEMENTOR_PHONE_NUMBER + TEXT_TYPE + COMMA_SEP + CourseFeedEntry.COURSE_COURSECOURSEMENTOR_EMAIL
                         + TEXT_TYPE + COMMA_SEP + CourseFeedEntry.COURSE_ASSOCIATED_TERM_ID + TEXT_TYPE + " )";


         //Delete statement
         private static final String SQL_DELETE_COURSE_ENTRIES =
                 "DROP TABLE IF EXISTS " + CourseFeedEntry.COURSE_TABLE_NAME;


     }//End CourseFeedEntry class
    public static class AssessmentFeedEntry implements BaseColumns{

        //Assessments table
        public static final String ASSESSMENT_TABLE_NAME = "assessments";
        public static final String ASSESSMENT_TITLE = "assessmentTitle";
        public static final String ASSESSMENT_DUE_DATE= "dueDate";
        public static final String ASSESSMENT_TYPE = "assessmentType";
        public static final String ASSOCIATED_COURSE = "assocCourse";
        public static final String ASSOCIATED_NOTE = "assocNote";//Can have many notes <One to many relationship>
        public static final String ASSOCIATED_TERM = "assocTerm";//Can have many notes <One to many relationship>


        private static final String TEXT_TYPE = " TEXT";
        private static final String COMMA_SEP = ",";
        private static final String SQL_CREATE_ASSESSMENT_ENTRIES =
                "CREATE TABLE " + AssessmentFeedEntry.ASSESSMENT_TABLE_NAME + " (" +
                        AssessmentFeedEntry._ID + " INTEGER PRIMARY KEY," +
                        AssessmentFeedEntry.ASSESSMENT_TITLE + TEXT_TYPE + COMMA_SEP +
                        AssessmentFeedEntry.ASSESSMENT_DUE_DATE + TEXT_TYPE + COMMA_SEP + AssessmentFeedEntry.ASSESSMENT_TYPE + TEXT_TYPE + COMMA_SEP + AssessmentFeedEntry.ASSOCIATED_COURSE +
                        TEXT_TYPE + COMMA_SEP + ASSOCIATED_TERM + TEXT_TYPE + COMMA_SEP + AssessmentFeedEntry.ASSOCIATED_NOTE + TEXT_TYPE + " )";


        //Delete statement
        private static final String SQL_DELETE_ASSESSMENT_ENTRIES =
                "DROP TABLE IF EXISTS " + AssessmentFeedEntry.ASSESSMENT_TABLE_NAME;

     }// End of AssessmentFeedEntry
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------
     /*Just like files that you save on the device's internal storage, Android stores your database in private disk space that's associated application.
      Your data is secure, because by default this area is not accessible to other applications.

     A useful set of APIs is available in the SQLiteOpenHelper class. When you use this class to obtain references to your database,
     the system performs the potentially long-running operations of creating and updating the database only when needed and not during app startup.
     All you need to do is call getWritableDatabase() or getReadableDatabase().*/

         //----(((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((
         static public class FeedReaderDbHelper extends SQLiteOpenHelper {
         // If you change the database schema, you must increment the database version.
         public static final int DATABASE_VERSION = 11;
         public static final String DATABASE_NAME = "FeedReader.db";

         public FeedReaderDbHelper(Context context) {
             super(context, DATABASE_NAME, null, DATABASE_VERSION);
         }

         @Override
         public void onCreate(SQLiteDatabase sqLiteDatabase) {
             sqLiteDatabase.execSQL(FeedEntry.SQL_CREATE_TERMS_ENTRIES);
             sqLiteDatabase.execSQL(CourseFeedEntry.SQL_CREATE_COURSE_ENTRIES);
             sqLiteDatabase.execSQL(AssessmentFeedEntry.SQL_CREATE_ASSESSMENT_ENTRIES);
         }

         @Override
         public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
             sqLiteDatabase.execSQL(FeedEntry.SQL_DELETE_TERMS_ENTRIES);
             sqLiteDatabase.execSQL(CourseFeedEntry.SQL_DELETE_COURSE_ENTRIES);
             sqLiteDatabase.execSQL(AssessmentFeedEntry.SQL_DELETE_ASSESSMENT_ENTRIES);
             onCreate(sqLiteDatabase);
         }
         //---))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))
         ///-----------------------Methods to read data
         public Cursor returnOneTermRow(String termId, SQLiteDatabase db, FeedReaderDbHelper mDbHelper){
             db = mDbHelper.getReadableDatabase();

             String[] projection = {FeedEntry._ID, FeedEntry.COLUMN_NAME_TERM_TITLE,
                     FeedEntry.COLUMN_NAME_START_DATE, FeedEntry.COLUMN_NAME_END_DATE};

             String selection = FeedEntry._ID + " LIKE ?";

             String[] selection_args = {termId};

             Cursor cursor = db.query(FeedEntry.TABLE_NAME, projection, selection, selection_args, null, null, null);
             //db.close();
             return cursor;
         }

         public Cursor returnOneCursorRow(String courseId, SQLiteDatabase db, FeedReaderDbHelper mDbHelper){
             db = mDbHelper.getReadableDatabase();

             String[] projection = {CourseFeedEntry._ID, CourseFeedEntry.COURSE_TITLE,
                     CourseFeedEntry.COURSE_START_DATE, CourseFeedEntry.COURSE_COURSE_ANTICIPATED_END_DATE, CourseFeedEntry.COURSE_STATUS,
                     CourseFeedEntry.COURSE_COURSEMENTOR_FIRST_NAME, CourseFeedEntry.COURSE_COURSEMENTOR_LAST_NAME, CourseFeedEntry.COURSE_COURSEMENTOR_PHONE_NUMBER,
                     CourseFeedEntry.COURSE_COURSECOURSEMENTOR_EMAIL, CourseFeedEntry.COURSE_ASSOCIATED_TERM_ID};

             String selection = CourseFeedEntry._ID + " LIKE ?";
             String[] selection_args = {courseId};
             Cursor cursor = db.query(CourseFeedEntry.COURSE_TABLE_NAME, projection, selection, selection_args, null, null, null);
             return cursor;
         }

         public Cursor returnCoursesAssociatedWithTermGivenTermId(String termId, SQLiteDatabase db, FeedReaderDbHelper mDbHelper ){
             db = mDbHelper.getReadableDatabase();

             String[] projection = {CourseFeedEntry._ID, CourseFeedEntry.COURSE_TITLE,
                     CourseFeedEntry.COURSE_START_DATE, CourseFeedEntry.COURSE_COURSE_ANTICIPATED_END_DATE, CourseFeedEntry.COURSE_STATUS,
                     CourseFeedEntry.COURSE_COURSEMENTOR_FIRST_NAME, CourseFeedEntry.COURSE_COURSEMENTOR_LAST_NAME, CourseFeedEntry.COURSE_COURSEMENTOR_PHONE_NUMBER,
                     CourseFeedEntry.COURSE_COURSECOURSEMENTOR_EMAIL, CourseFeedEntry.COURSE_ASSOCIATED_TERM_ID};

             String selection = CourseFeedEntry.COURSE_ASSOCIATED_TERM_ID + " LIKE ?";
             String[] selection_args = {termId};

             Cursor cursor = db.query(CourseFeedEntry.COURSE_TABLE_NAME, projection, selection, selection_args, null, null, null);
             cursor.moveToFirst();
             return cursor;

         }
         public Cursor returnAssessmentAssociatedWithCourseGivenCourseIdAndAssessmentId(String courseId, String assessmentid, SQLiteDatabase db, FeedReaderDbHelper mDbHelper ){

             String[] projection = {AssessmentFeedEntry._ID, AssessmentFeedEntry.ASSESSMENT_TITLE,
                     AssessmentFeedEntry.ASSESSMENT_DUE_DATE, AssessmentFeedEntry.ASSESSMENT_TYPE, AssessmentFeedEntry.ASSOCIATED_COURSE,
                     AssessmentFeedEntry.ASSOCIATED_NOTE};

             String selection = AssessmentFeedEntry.ASSOCIATED_COURSE + " LIKE ?" + " AND " + AssessmentFeedEntry.ASSOCIATED_TERM + " LIKE ?";
             String[] selection_args = {courseId, assessmentid};

             Cursor cursor = db.query(AssessmentFeedEntry.ASSESSMENT_TABLE_NAME, projection, selection, selection_args, null, null, null);
             //cursor.moveToFirst();
             return cursor;
         }
             public Cursor returnAssessmentAssociatedWithCourseGivenCourseId(String courseId, SQLiteDatabase db, FeedReaderDbHelper mDbHelper){
                 String[] projection = {AssessmentFeedEntry._ID, AssessmentFeedEntry.ASSESSMENT_TITLE,
                         AssessmentFeedEntry.ASSESSMENT_DUE_DATE, AssessmentFeedEntry.ASSESSMENT_TYPE, AssessmentFeedEntry.ASSOCIATED_COURSE,
                         AssessmentFeedEntry.ASSOCIATED_NOTE};

                 String selection = AssessmentFeedEntry.ASSOCIATED_COURSE + " LIKE ?";
                 String[] selection_args = {courseId};

                 Cursor cursor = db.query(AssessmentFeedEntry.ASSESSMENT_TABLE_NAME, projection, selection, selection_args, null, null, null);
                 //cursor.moveToFirst();
                 return cursor;
             }

         public Cursor returnAssessmentGivenAssessmentId(String assessId, SQLiteDatabase db, FeedReaderDbHelper mDbHelper ){

             db = mDbHelper.getReadableDatabase();
             String[] projection = {AssessmentFeedEntry._ID, AssessmentFeedEntry.ASSESSMENT_TITLE,
                     AssessmentFeedEntry.ASSESSMENT_DUE_DATE, AssessmentFeedEntry.ASSESSMENT_TYPE, AssessmentFeedEntry.ASSOCIATED_COURSE,
                     AssessmentFeedEntry.ASSOCIATED_NOTE};

             String selection = AssessmentFeedEntry._ID + " LIKE ?";
             String[] selection_args = {assessId};

             Cursor cursor = db.query(AssessmentFeedEntry.ASSESSMENT_TABLE_NAME, projection, selection, selection_args, null, null, null);
             //cursor.moveToFirst();
             return cursor;
         }
         //--------------------------------------------------CRUD SECTION------------------------------------------------------------------------------------------------------
         public boolean deleteEmptyTerm(SQLiteDatabase db, String termid){
             // Define 'where' part of query.
             String selection = FeedEntry._ID + " LIKE ?";
             // Specify arguments in placeholder order.
             String[] selectionArgs = {termid};
             // Issue SQL statement.
             db.delete(FeedEntry.TABLE_NAME, selection, selectionArgs);

             return true;
         }
         public boolean deleteEmptyCourse(SQLiteDatabase db, String courseid){
             // Define 'where' part of query.
             String selection = CourseFeedEntry._ID + " LIKE ?";
             // Specify arguments in placeholder order.
             String[] selectionArgs = {courseid};
             // Issue SQL statement.
             db.delete(CourseFeedEntry.COURSE_TABLE_NAME, selection, selectionArgs);

             return true;
         }
         public boolean deleteAssessmentsAssociatedWithGivenCourse(SQLiteDatabase db, String courseid){

             // Define 'where' part of query.
             String selection = AssessmentFeedEntry.ASSOCIATED_COURSE + " LIKE ?";
             // Specify arguments in placeholder order.
             String[] selectionArgs = {courseid};
             // Issue SQL statement.
             db.delete(AssessmentFeedEntry.ASSESSMENT_TABLE_NAME, selection, selectionArgs);

             return true;
         }
             public boolean deleteAssessment(SQLiteDatabase db, String assessmentid){
                 // Define 'where' part of query.
                 String selection = AssessmentFeedEntry._ID + " LIKE ?";
                 // Specify arguments in placeholder order.
                 String[] selectionArgs = {assessmentid};
                 // Issue SQL statement.
                 db.delete(AssessmentFeedEntry.ASSESSMENT_TABLE_NAME, selection, selectionArgs);

                 return true;
             }
         public int updateCourseStatus(SQLiteDatabase db, String courseid, String newValue, FeedReaderDbHelper mDbHelper){
             // New value for one column
             db = mDbHelper.getReadableDatabase();
             ContentValues values = new ContentValues();
             values.put(CourseFeedEntry.COURSE_STATUS, newValue);

             // Which row to update, based on the title
             String selection = CourseFeedEntry._ID + " LIKE ?";
             String[] selectionArgs = {courseid};


             int count = db.update(
                     CourseFeedEntry.COURSE_TABLE_NAME,
                     values,
                     selection,
                     selectionArgs);


             return count;
         }
             public int updateCourseStartDate(SQLiteDatabase db, String courseid, String newValue, FeedReaderDbHelper mDbHelper){
                 // New value for one column
                 db = mDbHelper.getReadableDatabase();
                 ContentValues values = new ContentValues();
                 values.put(CourseFeedEntry.COURSE_START_DATE, newValue);

                 // Which row to update, based on the title
                 String selection = CourseFeedEntry._ID + " LIKE ?";
                 String[] selectionArgs = {courseid};


                 int count = db.update(
                         CourseFeedEntry.COURSE_TABLE_NAME,
                         values,
                         selection,
                         selectionArgs);


                 return count;
             }
             public int updateCourseEndDate(SQLiteDatabase db, String courseid, String newValue, FeedReaderDbHelper mDbHelper){
                 // New value for one column
                 db = mDbHelper.getReadableDatabase();
                 ContentValues values = new ContentValues();
                 values.put(CourseFeedEntry.COURSE_COURSE_ANTICIPATED_END_DATE, newValue);

                 // Which row to update, based on the title
                 String selection = CourseFeedEntry._ID + " LIKE ?";
                 String[] selectionArgs = {courseid};


                 int count = db.update(
                         CourseFeedEntry.COURSE_TABLE_NAME,
                         values,
                         selection,
                         selectionArgs);


                 return count;
             }
             public int updateCourseTitle(SQLiteDatabase db, String courseid, String newValue, FeedReaderDbHelper mDbHelper){
                 // New value for one column
                 db = mDbHelper.getReadableDatabase();
                 ContentValues values = new ContentValues();
                 values.put(CourseFeedEntry.COURSE_TITLE, newValue);

                 // Which row to update, based on the title
                 String selection = CourseFeedEntry._ID + " LIKE ?";
                 String[] selectionArgs = {courseid};


                 int count = db.update(
                         CourseFeedEntry.COURSE_TABLE_NAME,
                         values,
                         selection,
                         selectionArgs);


                 return count;
             }
             public int updateCourseMentorFirstName(SQLiteDatabase db, String courseid, String newValue, FeedReaderDbHelper mDbHelper){
                 // New value for one column
                 db = mDbHelper.getReadableDatabase();
                 ContentValues values = new ContentValues();
                 values.put(CourseFeedEntry.COURSE_COURSEMENTOR_FIRST_NAME, newValue);

                 // Which row to update, based on the title
                 String selection = CourseFeedEntry._ID + " LIKE ?";
                 String[] selectionArgs = {courseid};


                 int count = db.update(
                         CourseFeedEntry.COURSE_TABLE_NAME,
                         values,
                         selection,
                         selectionArgs);


                 return count;
             }
             public int updateCourseMentorLastName(SQLiteDatabase db, String courseid, String newValue, FeedReaderDbHelper mDbHelper){
                 // New value for one column
                 db = mDbHelper.getReadableDatabase();
                 ContentValues values = new ContentValues();
                 values.put(CourseFeedEntry.COURSE_COURSEMENTOR_LAST_NAME, newValue);

                 // Which row to update, based on the title
                 String selection = CourseFeedEntry._ID + " LIKE ?";
                 String[] selectionArgs = {courseid};


                 int count = db.update(
                         CourseFeedEntry.COURSE_TABLE_NAME,
                         values,
                         selection,
                         selectionArgs);


                 return count;
             }
             public int updateCourseMentorPhoneNumber(SQLiteDatabase db, String courseid, String newValue, FeedReaderDbHelper mDbHelper){
                 // New value for one column
                 db = mDbHelper.getReadableDatabase();
                 ContentValues values = new ContentValues();
                 values.put(CourseFeedEntry.COURSE_COURSEMENTOR_PHONE_NUMBER, newValue);

                 // Which row to update, based on the title
                 String selection = CourseFeedEntry._ID + " LIKE ?";
                 String[] selectionArgs = {courseid};


                 int count = db.update(
                         CourseFeedEntry.COURSE_TABLE_NAME,
                         values,
                         selection,
                         selectionArgs);


                 return count;
             }
             public int updateCourseEmail(SQLiteDatabase db, String courseid, String newValue, FeedReaderDbHelper mDbHelper){
                 // New value for one column
                 db = mDbHelper.getReadableDatabase();
                 ContentValues values = new ContentValues();
                 values.put(CourseFeedEntry.COURSE_COURSECOURSEMENTOR_EMAIL, newValue);

                 // Which row to update, based on the title
                 String selection = CourseFeedEntry._ID + " LIKE ?";
                 String[] selectionArgs = {courseid};


                 int count = db.update(
                         CourseFeedEntry.COURSE_TABLE_NAME,
                         values,
                         selection,
                         selectionArgs);


                 return count;
             }
             //-----------------------------------------------------
         public int updateAssessmentType(SQLiteDatabase db, String assessid, String newValue, FeedReaderDbHelper mDbHelper){
             db = mDbHelper.getReadableDatabase();
             // New value for one column
             ContentValues values = new ContentValues();
             values.put(AssessmentFeedEntry.ASSESSMENT_TYPE, newValue);

             // Which row to update, based on the title
             String selection = AssessmentFeedEntry._ID + " LIKE ?";
             String[] selectionArgs = {assessid};


             int count = db.update(
                     AssessmentFeedEntry.ASSESSMENT_TABLE_NAME,
                     values,
                     selection,
                     selectionArgs);


             return count;
         }
             public int updateAssessmentDueDate(SQLiteDatabase db, String assessid, String newValue, FeedReaderDbHelper mDbHelper){
                 db = mDbHelper.getReadableDatabase();
                 // New value for one column
                 ContentValues values = new ContentValues();
                 values.put(AssessmentFeedEntry.ASSESSMENT_DUE_DATE, newValue);

                 // Which row to update, based on the title
                 String selection = AssessmentFeedEntry._ID + " LIKE ?";
                 String[] selectionArgs = {assessid};


                 int count = db.update(
                         AssessmentFeedEntry.ASSESSMENT_TABLE_NAME,
                         values,
                         selection,
                         selectionArgs);


                 return count;
             }

             public int updateAssessmentTitle(SQLiteDatabase db, String assessid, String newValue, FeedReaderDbHelper mDbHelper){
                 db = mDbHelper.getReadableDatabase();
                 // New value for one column
                 ContentValues values = new ContentValues();
                 values.put(AssessmentFeedEntry.ASSESSMENT_TITLE, newValue);

                 // Which row to update, based on the title
                 String selection = AssessmentFeedEntry._ID + " LIKE ?";
                 String[] selectionArgs = {assessid};


                 int count = db.update(
                         AssessmentFeedEntry.ASSESSMENT_TABLE_NAME,
                         values,
                         selection,
                         selectionArgs);


                 return count;
             }




     }//Enf of FeedReaderDbHelper class

}//End of FeedReaderContract class ----------------------------------------------------------------------------------------------------------------
