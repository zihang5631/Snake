import java.awt.Point;
import java.util.LinkedList;

/**
 * 蛇的实体类，管理移动、生长、碰撞检测
 */
public class Snake {
    private final LinkedList<Point> body;
    private int direction; // 0=上, 1=右, 2=下, 3=左
    private boolean shouldGrow = false;
    
    public Snake(int startX, int startY) {
        body = new LinkedList<>();
        body.add(new Point(startX, startY));
        body.add(new Point(startX - 1, startY));
        body.add(new Point(startX - 2, startY));
        direction = 1; // 初始向右
    }
    
    public void move() {
        Point head = getHead();
        Point newHead = new Point(head);
        
        switch (direction) {
            case 0: newHead.y--; break; // 上
            case 1: newHead.x++; break; // 右
            case 2: newHead.y++; break; // 下
            case 3: newHead.x--; break; // 左
        }
        
        body.addFirst(newHead);
        
        if (!shouldGrow) {
            body.removeLast();
        } else {
            shouldGrow = false;
        }
    }
    
    public void grow() {
        shouldGrow = true;
    }
    
    public boolean isSelfCollision() {
        Point head = getHead();
        for (int i = 1; i < body.size(); i++) {
            if (head.equals(body.get(i))) {
                return true;
            }
        }
        return false;
    }
    
    public Point getHead() {
        return body.getFirst();
    }
    
    public LinkedList<Point> getBody() {
        return body;
    }

    public int getLength() {
        return body.size();
    }
    
    public int getDirection() {
        return direction;
    }
    
    public void setDirection(int direction) {
        this.direction = direction;
    }
}