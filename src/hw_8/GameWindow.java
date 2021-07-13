package hw_8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame {
    private BattleMap battleMap; // для связыв
    private Setting setting; // для связыв

    public GameWindow() { //конструктор
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // что делаем когда нажимаем крестик
        setBounds(500, 500, 500, 500); // размеры окна
        setTitle("TicTacToe"); // надпись заголовка

        JButton button = new JButton("Start new game");
        add(button, BorderLayout.NORTH); // добавили кнопку, указали распложение вверху

        JButton buttonExit = new JButton("Exit");
        add(buttonExit, BorderLayout.NORTH); // добавили кнопку, указали распложение вверху

        JPanel panel = new JPanel(new GridLayout(1, 2)); //панель , GridLayout - в виде таблицы 1 строка, 2 столбика
        // метод добавит 10 кнопок
        //setLayout(new FlowLayout());
       /* setLayout(new BorderLayout());// GridLayout(3, 3)
        for (int i = 0; i< 10; i++){
            JButton button1 = new JButton("Start "+i);
            add(button1);
        }*/

        panel.add(button);// на панель добавили кнопку
        panel.add(buttonExit);// на панель добавили кнопку

        add(panel, BorderLayout.SOUTH);// расположении панели внизу
        panel.setBackground(Color.RED);// покрасить панель
        setVisible(true);// по умолчанию окно невидимое


        battleMap = new BattleMap(this); // в окне GameWindow проиницизировали  и отправили ссылку на себя (связали),а  в окне battleMap есть ссылка на GameWindow battleMap
        add(battleMap, BorderLayout.CENTER);
        setting = new Setting(this);

        // повесить событие на кнопку
        /*button.addActionListener(new ActionListener() { // лямбдавыражение Alt+ enter
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Hello");
            }
        });// повесить событие на кнопку*/
        // лямбдавыражение Alt+ enter
        // после связывания, при нажатии на кнопку вызывается setting
        button.addActionListener(e -> setting.setVisible(true));// повесить событие на кнопку
        buttonExit.addActionListener(e -> System.exit(0));// выход ноль
    }
        void startNewGame( int fieldSize, int winLenght){
// данные пришли и надо их отправить в BattleMap, в игровое поле
            battleMap.startNewGame(fieldSize, winLenght);
        }

    }
