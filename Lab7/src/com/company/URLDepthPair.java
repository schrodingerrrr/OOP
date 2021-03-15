package com.company;

import java.util.LinkedList;
import java.net.MalformedURLException;
import java.net.URL;

public class URLDepthPair {
    public static final String URL_PREFIX = "http://";
    //строковая константа
    public String URL;
    //поле типа стринг. ключ дальше будет
    public int depth;
    //значение дальше будет
    public URLDepthPair (String URL, int depth)
    //конструктор
    {
        this.URL=URL;
        this.depth=depth;
    }
    public String getHost() throws MalformedURLException
    //исключение может быть
    {//исключение - часть java api (если адрес не так начинается)
        URL host = new URL(URL); //доменное имя
        return host.getHost();
    }
    public String getPath() throws MalformedURLException
    {
        URL path = new URL(URL);// путь
        return path.getPath();
    }
    public int getDepth()
    {
        return depth;
    }
    public String getURL()
    {
        return URL;
    }
    public static boolean check(LinkedList<URLDepthPair> resultLink, URLDepthPair pair)
    {
        boolean isAlready = true;
        for (URLDepthPair c : resultLink)
            if (c.getURL().equals(pair.getURL()))
                isAlready=false;
        return isAlready;
    }
}