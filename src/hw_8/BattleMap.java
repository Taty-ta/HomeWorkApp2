package hw_8;

//import com.sun.deploy.panel.JavaPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BattleMap extends JPanel {
    private GameWindow gameWindow; // для связывания c окном GameWindow
    private int fieldSize;
    private int winLenght;
    private boolean isInit;
    private int cellWidth;
    private int cellHeigth;
    private String winner;

    public BattleMap(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
        setBackground(Color.ORANGE);

        // что бы узнать куда мы нажимаем MouseListener ((можно обработать кликЮ движение мышкой)) и MouseAdapter (выбрать конкретный...)
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                //super.mouseReleased(e); // выбрали из конструктора
                int cellx = e.getX() / cellWidth; // координаты ячейки ширина ячейки 100 ткнули на 150 = 1, если 50 - нулевая ячейка
                int celly = e.getY() / cellHeigth;

                if (isInit && !Logic.isGamaFinished) { //
                    Logic.humanTurn(celly, cellx);
                    // сюда вывести кто победил
                    if (Logic.w == 1) {
                        winner = "Победил человек";
                    } else if (Logic.w == 2) {
                        winner = "Ничья";
                    } else if (Logic.w == 3) {
                        winner = "Победил Искуственный Интеллект";
                    } else if (Logic.w == 0) {
                        winner = "Играем";
                    }

                }
                repaint();
            }
        });
    }


    void startNewGame(int fieldSize, int winLenght) {
// данные пришли и надо их отправить в BattleMap, в игровое поле
        this.fieldSize = fieldSize;
        this.winLenght = winLenght;//сохраним у себя поля
        isInit = true;// данные пришли
        repaint();// для запуска рисовалки
    }
// конструктором вызовем метод которым можно рисовать

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (!isInit) {
            return;
        }
        // рисуем

        // высота и ширина панели
        int panelWidth = getWidth();// высота и ширина панели
        int panelHeight = getHeight();
        cellWidth = panelWidth / fieldSize; // ширина поля / колич колонок
        cellHeigth = panelHeight / fieldSize;
        g.setColor(Color.BLACK);// цвет линий
        ((Graphics2D) g).setStroke(new BasicStroke(2f));// толщина линий

        for (int i = 1; i < fieldSize; i++) {
            int y = i * cellHeigth;// на высоту ячейки
            g.drawLine(0, y, panelWidth, y);// нарисовать горизонтальную линию
        }
        for (int i = 1; i < fieldSize; i++) {
            int x = i * cellWidth;// на высоту ячейки
            g.drawLine(x, 0, x, panelHeight);// нарисовать вертик линию
        }
        // вывод
        for (int i = 0; i < Logic.map.length; i++) {
            for (int j = 0; j < Logic.map.length; j++) {
                if (Logic.map[i][j] == Logic.DOT_X) {
                    drawX(g, i, j);
                    drawY(g, i, j);
                } else if (Logic.map[i][j] == Logic.DOT_O) {
                    drawO(g, i, j);
                }
            }

        }

    }

    // для рисования крестиков и ноликов
    private void drawX(Graphics g, int y, int x) {
        g.setColor(Color.BLUE);
        ((Graphics2D) g).setStroke(new BasicStroke(3f));
        g.drawLine(x * cellWidth, y * cellHeigth, (x + 1) * cellWidth, (y + 1) * cellHeigth);
        g.drawString(winner, 100, 100);
    }

    private void drawY(Graphics g, int y, int x) {
        g.setColor(Color.BLUE);
        ((Graphics2D) g).setStroke(new BasicStroke(3f));
        g.drawLine(x * cellWidth, (y + 1) * cellHeigth, (x + 1) * cellWidth, y * cellHeigth);
    }

    // для рисования  ноликов
    private void drawO(Graphics g, int y, int x) {
        g.setColor(Color.RED);
        ((Graphics2D) g).setStroke(new BasicStroke(3f));
        g.drawOval(x * cellWidth, y * cellHeigth, cellWidth, cellHeigth);
        g.drawString(winner, 100, 100);
    }
}
