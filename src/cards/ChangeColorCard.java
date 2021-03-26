package cards;

/**
 * @author Aimi Qian
 */
public class ChangeColorCard extends FuncCard{
    public ChangeColorCard(){
        super(Color.RED);
    }

    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(o == null){
            return false;
        }
        if(o instanceof ChangeColorCard){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean isValid(UnoCard prevCard){
        return true;
    }

    @Override
    public String toString(){
        return "Function Card (Change color)";
    }

}
