package omuny;

import java.awt.*;

public class Score extends Rectangle {

    int GAME_WIDTH; // Ширина поля игры
    int GAME_HEIGHT; // Высота поля игры
    int player1; // Очки 1 игрока
    int player2; // Очки 2 игрока

    Score(int GAME_WIDTH, int GAME_HEIGHT) {
        this.GAME_WIDTH = GAME_WIDTH;
        this.GAME_HEIGHT = GAME_HEIGHT;
    }

    // Отрисовка результата
    public void draw(Graphics g) {
        g.setColor(Color.white);
        g.setFont(new Font("Consolas", Font.PLAIN, 60));

        g.drawLine(GAME_WIDTH / 2, 0, GAME_WIDTH / 2, GAME_HEIGHT); // Отрисовка разделительной линии

        // Отрисовка очков 1 и 2 игрока
        g.drawString(String.valueOf(player1 / 10) + String.valueOf(player1 % 10), (GAME_WIDTH / 2) - 85, 50);
        g.drawString(String.valueOf(player2 / 10) + String.valueOf(player2 % 10), (GAME_WIDTH / 2) + 20, 50);
    }
}