package tobyspring.strategy;

public class Robot{
    private MoveSt moveStrategy;
    private TranslateSt translateStrategy;

    Robot(MoveSt moveStrategy, TranslateSt translateStrategy) {
        this.moveStrategy = moveStrategy;
        this.translateStrategy = translateStrategy;
    }

    public void move(){
        moveStrategy.move();
    }

    public void translate(){
        translateStrategy.translate();
    }
}
