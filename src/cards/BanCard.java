package cards;

/**
 * @author Aimi Qian
 */
public class BanCard extends FuncCard{
    public BanCard (Color color){
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
        if(o instanceof BanCard){
            BanCard bc = (BanCard) o;
            return this.getColor() == bc.getColor();
        }
        else{
            return false;
        }
    }

    @Override
    public boolean isValid(UnoCard prevCard){
        return this.getColor() == prevCard.getColor()||prevCard instanceof BanCard;
    }

    @Override
    public String toString(){
        return "Function Card(Ban/Color:" + this.getColor().getColorName() + ")";
    }
}
