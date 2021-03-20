package cards;

public class PlusFourCard extends FuncCard{
    public PlusFourCard(){
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
        if(o instanceof PlusFourCard){
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
        return "Function Card(Plus 4)";
    }
}
