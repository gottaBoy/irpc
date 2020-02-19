package com.gottaboy.irpc.serializer;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class XmlSerializer implements IchingSerializer {
    private static final XStream xStream = new XStream(new DomDriver());

    public <T> byte[] serialize(T obj) {
        return xStream.toXML(obj).getBytes();
    }

    public <T> T deserialize(byte[] data, Class<T> clazz) {
        String xml = new String(data);
        return (T) xStream.fromXML(xml);
    }
}
