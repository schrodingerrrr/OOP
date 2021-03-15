package com.company;

import java.net.*; // библиотека для сокетов
import java.io.*; // библиотека для потоков
import java.util.LinkedList;

public class Crawler {
    static LinkedList <URLDepthPair> findLink = new LinkedList <URLDepthPair>();//найденные
    static LinkedList <URLDepthPair> viewedLink = new LinkedList <URLDepthPair>();//просмотренные
    public static void showResult(LinkedList<URLDepthPair> viewedLink)
    {
        //выводит список всех пар, которые были посещены
        for (URLDepthPair c : viewedLink) System.out.println("Depth : "+c.getDepth() + "\tLink : "+c.getURL());
    }
    public static  void request(PrintWriter out,URLDepthPair pair) throws MalformedURLException //http запрос
    {
        //исключение - часть java api (если адрес не так начинается)
        out.println("GET " + pair.getPath() + " HTTP/1.1");
        out.println("Host: " + pair.getHost());
        out.println("Connection: close");
        out.println();
        out.flush();
        // с помощью println помещаем значения в буфер PrintWriter, а уже с flush() отдаем в system.out то есть выводим
    }
    public static void Process(String pair, int maxDepth) throws IOException
    {
        findLink.add(new URLDepthPair(pair, 0));
        while (!findLink.isEmpty())
        {
            URLDepthPair currentPair = findLink.removeFirst();
            // текущая ссылка, которую мы просматриваем. Убираем ее из списка найденных
            if (currentPair.depth < maxDepth)
            // просматриваем только те ссылки, у которых глубина меньше максимальной заданной
            {
                Socket my_socket = new Socket(currentPair.getHost(), 80);
                //создает сокет и уст. соединение с портом
                my_socket.setSoTimeout(1000);
                //уст. время ожидания в миллисекундах
                // чтобы избежать бесконечное время ожидания
                try
                {
                    BufferedReader in = new BufferedReader(new InputStreamReader(my_socket.getInputStream()));
                    //возращает сроку связ с сокет (данные с другой стороны соединения)
                    //Теперь in имеет тип InputStreamReader, который может читать символы из
                    //сокета (Socket)
                    PrintWriter out = new PrintWriter(my_socket.getOutputStream(), true);
                    //отправлять данные на другую стороную соединения
                    request(out, currentPair);
                    String line;
                    while ((line = in.readLine()) != null)
                    // возвращает null когда подходим к концу потока, однако сервер не закрывает соединение, а ожидает
                    {
                        if (line.indexOf(currentPair.URL_PREFIX) != -1 && line.indexOf('"') != -1)
                        {
                            StringBuilder currentLink = new StringBuilder();
                            int i = line.indexOf(currentPair.URL_PREFIX);
                            while (line.charAt(i) != '"' && line.charAt(i) != ' ') //он выстаскиевает ссылку из урл адреса (ищем скобку и ковычки)
                            {
                                if (line.charAt(i) == '<')
                                {
                                    currentLink.deleteCharAt(currentLink.length() - 1);
                                    break;
                                }
                                else
                                {
                                    currentLink.append(line.charAt(i));
                                    i++;
                                }
                            }
                            URLDepthPair newPair = new URLDepthPair(currentLink.toString(),
                                    currentPair.depth + 1);
                            if (currentPair.check(findLink, newPair) && currentPair.check(viewedLink, newPair)
                                    && !currentPair.URL.equals(newPair.URL))
                                findLink.add(newPair);
                        }
                    }
                    my_socket.close();
                    //закрывает сокет
                }
                catch (SocketTimeoutException e)
                {
                    my_socket.close();
                }
            }
            viewedLink.add(currentPair);
        }
        showResult(viewedLink);
        //передаем список просмотренных ссылок в функцию вывода
    }

    public static void main(String[] args) throws IOException { // реализуем ввод соответсвенно
        // и через трай кетч пытаемся вызвать функцию которую просматриваем урл ссылки и если у нас не тот формат то программа
        // выдает сообщение об используемых аргументах
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите URL: ");
        String s = reader.readLine();
        System.out.println("Введите глубину: ");
        String Depth = reader.readLine();
        String[] arg = new String[]{s, Depth};
        try
        {
            Process(arg[0], Integer.parseInt(arg[1]));
        }
        catch (NumberFormatException | IOException e)
        {
            System.out.println("usage: java crawler " + arg[0] + " " + arg[1]);
        }
    }
}
