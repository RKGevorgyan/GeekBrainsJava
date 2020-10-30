package lesson6;

public abstract class Animal {
    protected float runDistance;
    protected float swimDistance;
    protected float high;
    protected String name;

    private boolean canRun(float runDistance) {
        return this.runDistance >= runDistance;
    }
    private boolean canSwim(float swimDistance){
        return this.swimDistance >= swimDistance;
    }
    private boolean canJump(float high){
        return this.high >= high;
    }

    public void run(float runDistance) {
        System.out.println(name + " Left to run: " + this.runDistance);
        System.out.println(name + " run " + runDistance + ": " + canRun(runDistance));
        if (canRun(runDistance))
            this.runDistance-=runDistance;
        if (this.runDistance < 0)
            this.runDistance+=runDistance;
    }

    public void swim(float swimDistance) {
        System.out.println(name+ " Left to swim: " + this.swimDistance);
        System.out.println(name + " swim " + swimDistance + ": " + canSwim(swimDistance));
        if (canRun(swimDistance))
            this.swimDistance-=swimDistance;
        if (this.swimDistance < 0)
            this.swimDistance+=swimDistance;

    }

    public void jump(float high) {
        System.out.println(name + " Left to jump: " + this.high);
        System.out.println(name + " jump " + high + ": " + canJump(high));
        if (canJump(high))
            this.high-=high;
        if (this.high < 0)
            this.high+=high;
    }

}
