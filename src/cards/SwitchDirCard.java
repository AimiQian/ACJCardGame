package cards;

/**
 * @author Aimi Qian
 */
public class SwitchDirCard extends FuncCard{
    public SwitchDirCard(Color color){
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
        if(o instanceof SwitchDirCard){
            SwitchDirCard sdc = (SwitchDirCard) o;
            return this.getColor() == this.getColor();
        }
        else{
            return false;
        }
    }

    @Override
    public boolean isValid(UnoCard prevCard){
        return this.getColor() ==  prevCard.getColor()|| prevCard instanceof SwitchDirCard;
    }

    @Override
    public String toString(){
        return "Function Card(Reverse/Color:" + this.getColor().getColorName() + ")";
    }

}
