package cards;

import java.util.HashMap;

/**
 * @author Aimi Qian
 * 
 * modified by: Christiana Kiervin & Joshua Miguel David
 * 
 * This enum class specifies the 4 colours a card is allowed to be in the Uno Game: Red, Yellow, Green and Blue
 * 
 * 
 */
public enum Color {
    RED("Red", 1),
    YELLOW("Yellow", 2),
    GREEN("Green", 3),
    BLUE("Blue", 4);

    private final String colorName;
    private final int index;
    private static HashMap<Integer , Color> lookupByIndex = null;

    /**
     * Default accessor
     * 
     * @return the colour of the current object
     */
    public String getColorName(){
        return this.colorName;
    }

    /**
     * Allows the user to find the index of the current object (associated with its color)
     * 
     * @return the index of the current object
     */
    public int getIndex() {
        return this.index;
    }

    /**
     * Given the index number, look up the associated color.
     * 
     * @param index specifying what the index of the color is.
     * 
     * @return the color associated with the given index.
     */
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

    /**
     * 
     * A method to intialize the hashmap to allow users to look up colors by index.
     * 
     */
    private static void initIndexLookup(){
        lookupByIndex = new HashMap<>();

        for(Color c : Color.values()){
            lookupByIndex.put(c.getIndex(),c);
        }
    }

    /**
     * A constructor for the enum.
     * 
     * @param colorName the name of the color
     * @param index the index associated with the color
     */
    Color(String colorName, int index){
        this.colorName = colorName;
        this.index = index;
    }
}
