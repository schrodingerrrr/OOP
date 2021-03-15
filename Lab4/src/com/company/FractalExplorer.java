package com.company;
import java.awt.BorderLayout;
import java.awt.geom.Rectangle2D;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.util.concurrent.TimeUnit;
import java.lang.InterruptedException;



public class FractalExplorer {
    private int displaySize;
    private JImageDisplay imgDisp;
    private FractalGenerator gen;
    private Rectangle2D.Double range;

    public FractalExplorer (int size)
    {
        displaySize = size;
        gen = new Mandelbrot(); // создаем объект класса Мандельброта через ссылку баз.класса
        range = new Rectangle2D.Double();
        gen.getInitialRange(range);
    }

    public void createAndShowGUI() {
        JFrame frame = new JFrame("Fractal Explorer"); // класс для создания окна графа приложения
        imgDisp = new JImageDisplay(displaySize, displaySize);
        JButton resetBut = new JButton("Reset Display");
        resetBut.setActionCommand("reset");
        FractalHandler handler = new FractalHandler();
        resetBut.addActionListener(handler);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// при закрытии окна закрывается и приложение
        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(imgDisp, BorderLayout.CENTER);
        frame.getContentPane().add(resetBut, BorderLayout.SOUTH);

        frame.getContentPane().addMouseListener(new MouseHandler());//регистрируем экземпляр обработчика Mouse Listener в фрейме, метод извлекает слои панели содержимого для добавления объекта

        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
    }

    private void drawFractal() // перерисовка фрактала
    {
        for (int x = 0; x < displaySize; x++)
        {
            double xCoord = FractalGenerator.getCoord(range.x, range.x + range.width, displaySize, x);
            for (int y = 0; y < displaySize; y++)
            {
                double yCoord = FractalGenerator.getCoord(range.y, range.y + range.height, displaySize, y);// синтаксис вывода статического метода (по имени класса)
                int numIters = gen.numIterations(xCoord, yCoord);
                if (numIters >= 0)
                {
                    float hue = 0.7f + (float) numIters / 200f;
                    int rgbColor = Color.HSBtoRGB(hue, 1f, 1f);
                    imgDisp.drawPixel(x, y, rgbColor);
                }
                else
                    imgDisp.drawPixel(x, y, 0);
                imgDisp.repaint(); // перерисовка изображения
            }
        }
    }

    private class FractalHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            String cmd = e.getActionCommand();
            if (cmd.equals("reset"))
            {
                imgDisp.clearImage();
                imgDisp.repaint();
               // sleep(3000);
                range = new Rectangle2D.Double();
                gen.getInitialRange(range);
                drawFractal();
                System.out.println("ok!");
            }
        }

    }

    public static void sleep(long mill)
    {
        try
        {
            Thread.sleep(mill);
            System.out.println("sleep");
        }
        catch(InterruptedException e)
        {
            System.out.println("Thread is interrupted!");
            Thread.currentThread().interrupt();
        }

    }

    private class MouseHandler extends MouseAdapter
    {

        public void mouseClicked(MouseEvent e)
        {

            double xCoord = FractalGenerator.getCoord(range.x, range.x + range.width,
                    displaySize, e.getX());

            double yCoord = FractalGenerator.getCoord(range.y, range.y + range.height,
                    displaySize, e.getY());

            gen.recenterAndZoomRange(range, xCoord, yCoord, 0.5);

            drawFractal();
        }
    }




    public static void main(String[] args)
    {
        FractalExplorer explorer = new FractalExplorer (800);
        explorer.createAndShowGUI();
        explorer.drawFractal();
    }

}