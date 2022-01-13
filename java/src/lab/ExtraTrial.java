package lab;

public class ExtraTrial extends Trial {
    private static final int PASS_MARK3 = 50;
    private int mark3;

    public ExtraTrial(){
    }
    public ExtraTrial(String name, int mark1, int mark2, int mark3){
        super(name, mark1, mark2);
        this.mark3 = mark3;
    }

    public int getMark3(){
        return mark3;
    }

    public void setMark3(){
        this.mark3 = mark3;
    }

    public boolean isPassed(){
        return super.isPassed() && mark3 >= PASS_MARK3;
    }

    @Override
    public String toString() {
        return String.format("%s;%d;%d;%d;%b",
                getName(), getMark1(), getMark2(), mark3, isPassed());
    }
}
