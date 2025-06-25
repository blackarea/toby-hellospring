package tobyspring.strategy;

class WalkingRobot implements MoveSt, DisplaySt, TranslateSt {
    public void display() {
        System.out.println("걷기 로봇");
    }
    public void move() {
        System.out.println("걸어서 배달합니다 삐-빅");
    }

    @Override
    public void translate() {

    }
}