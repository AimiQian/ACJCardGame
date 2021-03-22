package cards;

public class NormalCard extends UnoCard{
    private int num;

    public NormalCard (Color color, int num){
        super(color);
        this.setNum(num);
    }

    public int getNum() {
        return this.num;
    }

    public void setNum(int num) {
        if(num >= 0 && num <= 9) {
            this.num = num;
        }
        else{
            throw new IllegalArgumentException("Number should be between 0 - 9.");
        }
    }

    @Override
    public boolean equals(Object o){
        if(this == o ){
            return true;
        }
        if (o == null){
            return false;
        }
        if(o instanceof NormalCard){
            NormalCard nc = (NormalCard) o;
            return this.getColor() == nc.getColor() && this.getNum() == nc.getNum();
        }
        else{
            return false;
        }
    }

    @Override
    public boolean isValid(UnoCard prevCard){
        if(prevCard instanceof NormalCard){
            NormalCard nc = (NormalCard) prevCard;
            return this.getColor() == nc.getColor() || this.getNum() == nc.getNum();
        }
        else if(prevCard instanceof FuncCard){
            FuncCard fc = (FuncCard) prevCard;
            return this.getColor() == fc.getColor();
        }
        else{
            return false;
        }
    }

    @Override
    public String toString(){
        return "Normal Card (Color:" + this.getColor().getColorName() + "/Num:" + this.getNum() + ")";
    }

}
