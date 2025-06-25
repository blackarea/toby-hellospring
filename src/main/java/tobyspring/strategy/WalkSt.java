package tobyspring.strategy;

public class WalkSt implements MoveSt{
    @Override
    public void move() {
        System.out.println("걷기");
    }
}
