package com.gottaboy.irpc.serializer;

import org.apache.thrift.TBase;
import org.apache.thrift.TDeserializer;
import org.apache.thrift.TException;
import org.apache.thrift.TSerializer;
import org.apache.thrift.protocol.TBinaryProtocol;

public class ThriftSerializer implements IchingSerializer {

    public <T> byte[] serialize(T obj) {
        try {
            TSerializer serializer = new TSerializer(new TBinaryProtocol.Factory());
            return serializer.serialize((TBase) obj);
        } catch (TException e) {
            throw new RuntimeException(e);
        }
    }

    public <T> T deserialize(byte[] data, Class<T> clazz) {
        try {
            TBase o = (TBase) clazz.newInstance();
            TDeserializer tDeserializer = new TDeserializer();
            tDeserializer.deserialize(o, data);
            return (T) o;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
