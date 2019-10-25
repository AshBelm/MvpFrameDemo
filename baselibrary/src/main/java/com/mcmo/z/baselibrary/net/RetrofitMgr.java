package com.mcmo.z.baselibrary.net;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import retrofit2.Retrofit;

public class RetrofitMgr {
    private static volatile RetrofitMgr instance = null;
    private Retrofit DEFAULT = null;
    private Map<String, Retrofit> OTHERS;

    private RetrofitMgr() {
        OTHERS = new ConcurrentHashMap<>(2);
    }

    public static RetrofitMgr getInstance() {
        if(instance == null){
            synchronized (RetrofitMgr.class){
                if(instance == null){
                    instance = new RetrofitMgr();
                }
            }
        }
        return instance;
    }
    public void setDefaultRetrofit(Retrofit retrofit){
        DEFAULT = retrofit;
    }

    /**
     * 添加一个子Retrofit
     * @param name 名称key
     * @param retrofit retrofit 实例
     * @return 如果已经有同名的retrofit就返回之前的实例，如果没有返回null
     */
    public Retrofit addOtherRetrofit(String name,Retrofit retrofit){
        if(OTHERS.containsKey(name)){
            Retrofit oldRetrofit = OTHERS.remove(name);
            OTHERS.put(name,retrofit);
            return oldRetrofit;
        }else {
            OTHERS.put(name,retrofit);
            return null;
        }
    }

    public <T> T create(Class<T> service) {
        Retrofit retrofit = DEFAULT;
        if (DEFAULT == null) {
            throw new RuntimeException("default retrofit is no found,you need set a default value first");
        }
        return retrofit.create(service);
    }

    public <T> T create(String name,Class<T> service){
        Retrofit retrofit = OTHERS.get(name);
        if(retrofit == null){
            throw new RuntimeException("The name cannot be found to be the retrofit of "+name+" ,please check it is set");
        }
        return retrofit.create(service);
    }
}
