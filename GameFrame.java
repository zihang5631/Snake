import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.awt.Dimension;

/**
 * 贪吃蛇游戏主窗口
 */
public class GameFrame extends JFrame {
    private static final long serialVersionUID = 1L;
    private static final int CELL_SIZE = 25;
    private static final int GRID_COLS = 30;
    private static final int GRID_ROWS = 20;
    private static final int SCORE_BAR = 40;

    public GameFrame() {
        setTitle("贪吃蛇 - JavaSE (方向键/WASD 控制，空格暂停)");
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        GamePanel panel = new GamePanel(CELL_SIZE, GRID_COLS, GRID_ROWS, SCORE_BAR);
        // 用 PreferredSize 让 pack() 自动算出包含边框/标题栏的窗口大小
        // 避免 setSize 把内容区硬编码到 750x540 导致右边/下边被切
        panel.setPreferredSize(new Dimension(
                GRID_COLS * CELL_SIZE, GRID_ROWS * CELL_SIZE + SCORE_BAR));
        add(panel);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        panel.requestFocusInWindow();
    }
}