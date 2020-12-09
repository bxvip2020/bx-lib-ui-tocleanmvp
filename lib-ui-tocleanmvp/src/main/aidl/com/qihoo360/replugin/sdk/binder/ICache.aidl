// ICache.aidl
package com.qihoo360.replugin.sdk.binder;

// Declare any non-default types here with import statements

interface ICache {
    boolean setValue(String key ,String value);
    boolean setValues(in Map values);
    boolean setJsonModelValues(String model, String json);
    String getValue(String key ,String defaultValue);
    Map getValues(in List<String> keys);
    boolean removeKey(String key);
    boolean setModelValue(String model, String key ,String value);
    boolean setModelValues(String model, in Map values);
    String getModelValue(String model,String key ,String defaultValue);
    Map getModelValues(String model,in List<String> keys);
    Map getModelAllValues(String model);
    boolean removeModelKey(String model ,String key);
    boolean removeModelSpFile(String model);
    boolean cleanAll();
}