package com.sitebooks.librovermo.controllers;

import com.alibaba.fastjson.JSONObject;
import com.sitebooks.librovermo.dao.DAOResponse;
import com.sitebooks.librovermo.dao.DBDAO;
import com.sitebooks.librovermo.dao.SendObject;
import com.sitebooks.librovermo.models.primary.Language;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Logger;

@RestController("/")
public class MainController {

    DBDAO db = new DBDAO();

    @GetMapping("/testGet")
    private SendObject sendObjectTest(){
        Map<String, String> map = new HashMap<>();
        map.put("name", "id = '22'");
        SendObject so = new SendObject(new Language(1,"lololo"),"Language", map);
        Logger.getAnonymousLogger().info(so.getSendClass());
        return so;
    }
    @GetMapping("/getFromDB")
    private List<Object> getAny(@RequestBody SendObject sendObj){
        List<Object> resultList = new ArrayList<>();
        try {
            Map<String,String> map = sendObj.getConditionMap() != null ? (Map<String, String>) sendObj.getConditionMap(): null;
            Logger.getLogger("MAPA").info((sendObj.getConditionMap() == null)+"");
            String className = DBDAO.rootClassPathName + sendObj.getSendClass();
                    ResultSet set = map == null?
                    db.selectFromTable(sendObj.getTableName(), Class.forName(className)) :
                    db.selectFromTable(sendObj.getTableName(), Class.forName(className),map);
            while (set.next()){
                resultList.add(ReorganizeClass(Class.forName(className), set));
            }
        } catch (ClassNotFoundException | IllegalAccessException | SQLException | InstantiationException e){
            Logger.getLogger("ERRORS").warning(e.getMessage());
        }
        return resultList;
    }
    @PostMapping("/addToDB")
    private DAOResponse addAny(@RequestBody SendObject sendObject){
        DAOResponse response = new DAOResponse();
        try {
            Class<?> reClass = Class.forName(DBDAO.rootClassPathName +sendObject.getSendClass());
            Logger.getLogger("AddMapping").info(sendObject.getSendObject().getClass().getName());
            db.addToTable(sendObject.getTableName(),ReorganizeClass(reClass,sendObject.getSendObject()));
        } catch (Exception e){ Logger.getLogger("Error").info(e.getMessage());}
        return response;
    }
    @PostMapping("/updateDB")
    private DAOResponse updateAny(@RequestBody SendObject sendObject){
        DAOResponse response = new DAOResponse();
        try {
            Class<?> reClass = Class.forName(DBDAO.rootClassPathName +sendObject.getSendClass());
            Logger.getLogger("AddMapping").info(sendObject.getSendObject().getClass().getName());
            db.updateTable(sendObject.getTableName(),ReorganizeClass(reClass,sendObject.getSendObject()));
        } catch (Exception e){ Logger.getLogger("Error").info(e.getMessage());}
        return response;
    }
    @PostMapping("/deleteDB")
    private DAOResponse deleteAny(@RequestBody SendObject sendObject){
        DAOResponse response = new DAOResponse();
        try {
            Class<?> reClass = Class.forName(DBDAO.rootClassPathName +sendObject.getSendClass());
            Logger.getLogger("AddMapping").info(sendObject.getSendObject().getClass().getName());
            db.deleteTable(sendObject.getTableName(),ReorganizeClass(reClass,sendObject.getSendObject()));
        } catch (Exception e){ Logger.getLogger("Error").info(e.getMessage());}
        return response;
    }
    public <T> T ReorganizeClass(Class<T> organizeClass, ResultSet set) throws InstantiationException, IllegalAccessException, SQLException {
        T newItem = organizeClass.newInstance();
        Field[] itemFields = organizeClass.getDeclaredFields();
        int i = 1;
        for (Field field : itemFields) {
            field.setAccessible(true);
            if(i == 1) {
                field.set(newItem, set.getLong(i));
            }
            else
                field.set(newItem, set.getString(i));
            i++;
        }
        return newItem;
    }
    public <T> T ReorganizeClass(Class<T> organizeClass, Object rootObject) {
        HashMap<String, Object> map = (HashMap<String, Object>) rootObject;
        return JSONObject.parseObject(JSONObject.toJSONString(map),organizeClass);
    }

}
