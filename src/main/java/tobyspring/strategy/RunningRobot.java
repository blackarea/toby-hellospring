package tobyspring.strategy;

class RunningRobot implements MoveSt, DisplaySt, TranslateSt {
    public void display() {
        System.out.println("달리는 로봇");
    }
    public void move() {
        System.out.println("뛰어서 배달합니다 삐-빅");
    }

    @Override
    public void translate() {
        System.out.println();
    }
}