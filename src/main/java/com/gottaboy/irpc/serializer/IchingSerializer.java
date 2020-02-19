package com.gottaboy.irpc.serializer;

public interface IchingSerializer {
    /**
     * 序列化
     *
     * @param obj
     * @param <T>
     * @return
     */
    public <T> byte[] serialize(T obj);


    /**
     * 反序列化
     *
     * @param data
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T deserialize(byte[] data, Class<T> clazz);
}
