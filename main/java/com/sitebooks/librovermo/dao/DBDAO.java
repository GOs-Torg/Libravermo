package com.sitebooks.librovermo.dao;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.Map;
import java.util.logging.Logger;

public class DBDAO {
    private static final String url = "jdbc:mysql://localhost:3306/libraDB";
    private static final String user = "root";
    private static final String password = "";
    public static Statement state;
    public static String rootClassPathName = "com.sitebooks.librovermo.models.";

    public Connection getConnections(){
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            return con;
        }
        catch (Exception e){}
        return null;
    }
    public <T> void addToTable(String tableName, T object){
        Long id = 1l;
        Class<?> newClass = object.getClass();
        Connection connection = getConnections();
        try {
            try {
                if (connection != null) {
                    String fieldName = "";
                    String fieldValue = "";
                    state = connection.createStatement();
                    Field[] field = newClass.getDeclaredFields();
                    field[0].setAccessible(true);
                    String querySel = "SELECT " + field[0].getName() + " FROM " + tableName + " ORDER BY " + field[0].getName() + " DESC";
                    Statement stateQuery = connection.createStatement();
                    ResultSet resState = stateQuery.executeQuery(querySel);
                    if (resState.next()){
                        id = resState.getLong(1) + 1l;
                    }
                    field[0].set(object, id);
                    for (Field fields : field) {
                        fields.setAccessible(true);
                        fieldName += fields.getName() + ",";
                        fieldValue += "'" + fields.get(object) + "'" + ",";
                    }
                    fieldName = fieldName.substring(0, fieldName.length() - 1);
                    fieldValue = fieldValue.substring(0, fieldValue.length() - 1);
                    Logger.getAnonymousLogger().info(field.length + "");
                    String query = "INSERT INTO " + tableName + " (" + fieldName + ")" + " VALUES (" + fieldValue + ")";
                    Logger.getAnonymousLogger().info(query);
                    state.executeUpdate(query);
                }
            }
            catch (SQLException e) {Logger.getAnonymousLogger().info(e.getMessage());}
        }
        catch (Exception e){Logger.getAnonymousLogger().info(e.getMessage());}
    }

    public <T> void updateTable(String tableName, T object){
        Class<?> newClass = object.getClass();
        Connection connection = getConnections();
        try {
            try {
                if (connection != null) {
                    String fieldName = "";
                    state = connection.createStatement();
                    Field[] field = newClass.getDeclaredFields();
                    for (Field fields : field) {
                        fields.setAccessible(true);
                        fieldName += fields.getName() + "='" + fields.get(object) + "',";
                    }
                    fieldName = fieldName.substring(0, fieldName.length() - 1);
                    Logger.getAnonymousLogger().info(field.length + "");
                    String query = "UPDATE " +  tableName + " SET " + fieldName + " WHERE " + field[0].getName() + " = " + field[0].get(object);
                    Logger.getAnonymousLogger().info(query);
                    state.executeUpdate(query);
                }
            }
            catch (SQLException e) {Logger.getAnonymousLogger().info(e.getMessage());}
        }
        catch (Exception e){Logger.getAnonymousLogger().info(e.getMessage());}
    }

    public <T> void deleteTable(String tableName, T object){
        Class<?> newClass = object.getClass();
        Connection connection = getConnections();
        try {
            try {
                if (connection != null) {
                    state = connection.createStatement();
                    Field[] field = newClass.getDeclaredFields();
                    Logger.getAnonymousLogger().info(field.length + "");
                    field[0].setAccessible(true);
                    String query = "DELETE FROM " + tableName + " WHERE " + field[0].getName() + " = " + field[0].get(object);
                    Logger.getAnonymousLogger().info(query);
                    state.executeUpdate(query);
                }
            }
            catch (SQLException e) {Logger.getAnonymousLogger().info(e.getMessage());}
        }
        catch (Exception e){Logger.getAnonymousLogger().info(e.getMessage());}
    }

    public ResultSet selectFromTable(String tableName, Class<?> returnClass){
        Class<?> newClass = returnClass;
        Connection connection = getConnections();
        try {
            try {
                if (connection != null) {
                    String fieldName = "";
                    state = connection.createStatement();
                    Field[] field = newClass.getDeclaredFields();
                    for (Field fields : field) {
                        fields.setAccessible(true);
                        fieldName += fields.getName() + ",";
                    }
                    fieldName = fieldName.substring(0, fieldName.length() - 1);
                    state = connection.createStatement();
                    String query = "SELECT "+ fieldName +" FROM " + tableName;
                    Logger.getAnonymousLogger().info(query);
                    ResultSet res = state.executeQuery(query);
                    return res;
                }
            }
            catch (SQLException e) {Logger.getAnonymousLogger().info(e.getMessage());}
        }
        catch (Exception e){Logger.getAnonymousLogger().info(e.getMessage());}
        return null;
    }
    public ResultSet selectFromTable(String tableName, Class<?> returnClass, Map<String,String> conditions){
        Class<?> newClass = returnClass;
        Connection connection = getConnections();
        try {
            try {
                if (connection != null) {
                    String fieldName = "";
                    state = connection.createStatement();
                    Field[] field = newClass.getDeclaredFields();
                    for (Field fields : field) {
                        fields.setAccessible(true);
                        fieldName += fields.getName() + ",";
                    }
                    fieldName = fieldName.substring(0, fieldName.length() - 1);
                    String conditionString = " Where ";
                    for (String key:
                            conditions.keySet()) {
                            conditionString += conditions.get(key) + " and ";
                    }
                    conditionString = conditionString.substring(0, conditionString.length()-4);
                    String query = "SELECT "+ fieldName +" FROM " + tableName + conditionString;
                    state = connection.createStatement();
                    Logger.getAnonymousLogger().info(query);
                    ResultSet res = state.executeQuery(query);
                    return res;
                }
            }
            catch (SQLException e) {Logger.getAnonymousLogger().info(e.getMessage());}
        }
        catch (Exception e){Logger.getAnonymousLogger().info(e.getMessage());}
        return null;
    }
}
