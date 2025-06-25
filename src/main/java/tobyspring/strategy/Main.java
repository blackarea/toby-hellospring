package tobyspring.strategy;

public class Main {

    public static void main(String[] args) {
        Robot robot = new Robot(new WalkSt(), new KoreanTranslate());
        robot.move();
        robot.translate();
        Robot robot1 = new Robot(new RunningSt(), new JpTranslate());
        robot1.move();
        robot1.translate();
    }
}
