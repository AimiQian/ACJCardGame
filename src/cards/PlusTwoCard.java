package cards;

public class PlusTwoCard extends FuncCard{
    public PlusTwoCard (Color color){
        super(color);
    }

    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(o == null){
            return false;
        }
        if(o instanceof PlusTwoCard){
            PlusTwoCard ptc = (PlusTwoCard) o;
            return ptc.getColor() == this.getColor();
        }
        else{
            return false;
        }
    }

    @Override
    public boolean isValid(UnoCard prevCard){
        return this.getColor() == prevCard.getColor() || prevCard instanceof PlusTwoCard;
    }

    @Override
    public String toString(){
        return "Function Card(Plus 2/Color:" + this.getColor().getColorName() + ")";
    }
}
