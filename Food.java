import java.awt.Point;
import java.util.LinkedList;
import java.util.Random;

/**
 * 食物类，负责生成随机位置的食物
 */
public class Food {
    private Point position;
    private final int gridCols;
    private final int gridRows;
    private final Random random;
    
    public Food(int gridCols, int gridRows) {
        this.gridCols = gridCols;
        this.gridRows = gridRows;
        this.random = new Random();
        this.position = new Point();
    }
    
    public void generateNewPosition(LinkedList<Point> snakeBody) {
        Point newPos;
        boolean collision;
        
        do {
            newPos = new Point(random.nextInt(gridCols), random.nextInt(gridRows));
            collision = false;
            
            for (Point p : snakeBody) {
                if (p.equals(newPos)) {
                    collision = true;
                    break;
                }
            }
        } while (collision);
        
        position = newPos;
    }
    
    public Point getPosition() {
        return new Point(position);
    }
}