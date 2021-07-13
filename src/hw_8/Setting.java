package hw_8;

import javax.swing.*;
import java.awt.*;

// для настроек
public class Setting extends JFrame {
    private final int MIN_FIELD_SIZE = 3;
    private final int MAX_FIELD_SIZE = 10;

    private GameWindow gameWindow; // связываем
    // слайдер отвечающий за размер окна
    private JSlider sliderFieldSize;
    //слайдер отвечающий
    private JSlider sliderDotsToWin;

    public Setting(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
        setBounds(500, 500, 450, 450);
        setTitle("TicTacToe setting");

        setLayout(new GridLayout(5, 1));
        sliderFieldSize = new JSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE, MIN_FIELD_SIZE);//(3,10, 3);// слайдер от  до  и по умолчанию (в константы)
        //настройки слайдера
        //JSlider sliderFieldSize = new JSlider(SwingConstants.HORIZONTAL, 0,100,50);
        sliderFieldSize.setMajorTickSpacing(1);
        //sliderFieldSize.setMinorTickSpacing(5);
        sliderFieldSize.setPaintLabels(true);
        sliderFieldSize.setPaintTicks(true);

        sliderDotsToWin = new JSlider(MIN_FIELD_SIZE, MIN_FIELD_SIZE, MIN_FIELD_SIZE);
        sliderDotsToWin.setMajorTickSpacing(1);
        sliderDotsToWin.setPaintLabels(true);
        sliderDotsToWin.setPaintTicks(true);

        // если меняем размер поля верхнего, то нижний слайдер тоже меняется
        sliderFieldSize.addChangeListener(e -> sliderDotsToWin.setMaximum(sliderFieldSize.getValue()));



        add(new Label("Field size:")); // надпись для выбора размера поля
        add(sliderFieldSize);
        add(new Label("Winning line:"));
        add(sliderDotsToWin);
        setVisible(false);

        // кнопка старта
        JButton button = new JButton("Start a game");
        add(button);
        button.addActionListener(e -> {
            //при нажатии данные нужно собрать
            int fieldSize = sliderFieldSize.getValue();
            int winLenght = sliderDotsToWin.getValue();
            //
            Logic.SIZE = fieldSize;
            Logic.DOTS_TO_WIN = winLenght;
            Logic.initMap();
            Logic.printMap();
           Logic.isGamaFinished = false;
            // и отправить
            gameWindow.startNewGame(fieldSize, winLenght);

            setVisible(false);
        });
    }
}
