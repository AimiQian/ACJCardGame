package cards;

import java.util.HashMap;

public enum Color {
    RED("Red", 1),
    YELLOW("Yellow", 2),
    GREEN("Green", 3),
    BLUE("Blue", 3);

    private final String colorName;
    private final int index;
    private static HashMap<Integer , Color> lookupByIndex = null;

    public String getColorName(){
        return this.colorName;
    }

    public int getIndex() {
        return this.index;
    }

    public static Color getColor(int index){
        if(lookupByIndex == null) {
            initIndexLookup();
        }
        Color c = lookupByIndex.get(index);
        if(c == null){
            throw new IllegalArgumentException("Invalid Index.");
        }
        return c;
    }

    private static void initIndexLookup(){
        lookupByIndex = new HashMap<>();

        for(Color c : Color.values()){
            lookupByIndex.put(c.getIndex(),c);
        }
    }

    Color(String colorName, int index){
        this.colorName = colorName;
        this.index = index;
    }

}
