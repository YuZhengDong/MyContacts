package cn.edu.gdmec.a07150847.mycontacts;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by asus on 2016/10/19.
 */
public  class MyDB extends SQLiteOpenHelper {
    private  static  String DB_NAME="My_DB.db";
    private  static  int DB_VERSION =2;
    private SQLiteDatabase db;

   public MyDB(Context context){
        super(context,DB_NAME,null,DB_VERSION);
        db=getWritableDatabase();
    }



    public SQLiteDatabase openConnection(){
        if(!db.isOpen()) {
            db = getWritableDatabase();

        }
        return db;
    }



    public void closeConnection(){
        try {
            if(db!=null&&db.isOpen()) {
                db.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }



    public boolean createTable(String createTableSql){
        try {
            openConnection();
            db.execSQL(createTableSql);
        }catch (Exception ex){
            return false;
        }finally {
            closeConnection();
        }

        return true;
    }


   public boolean save(String tableName, ContentValues values){
    try {
        openConnection();
        db.insert(tableName,null,values);
    }catch (Exception ex){
        ex.printStackTrace();
        return false;
    }finally {
        closeConnection();
    }
        return true;

    }


    public boolean update(String table,ContentValues values,String whereClause,String []whereArgs){
       try {
           openConnection();
           db.update(table, values, whereClause, whereArgs);
       }catch (Exception ex){
           ex.printStackTrace();
           return false;
       }finally {
           closeConnection();
       }
        return true;
    }

    public boolean delete(String table,String deletesql,String obj[]){
        try {
            openConnection();
            db.delete(table,deletesql,obj);
        }catch (Exception ex){
            ex.printStackTrace();
            return false;
        }finally {
            closeConnection();
        }
        return true;

    }


    public Cursor find(String findSql,String []obj){
        try {
            openConnection();
            Cursor cursor = db.rawQuery(findSql,obj);
            return cursor;

        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            closeConnection();
            return null;
        }


    }

    public boolean isTableExits(String tablename){
        try {
            openConnection();
            String str ="select count(*)xcount from "+tablename;
            db.rawQuery(str,null).close();
        }catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
            return true;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }




}
