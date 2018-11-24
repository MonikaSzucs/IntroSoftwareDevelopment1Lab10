/**
 * Class Canada contains the provinces and territories, and their population.
 *
 * @author  Joe Developer
 * @version 1.0
 */
public class Canada
{
    private ProvinceTerritory[] provinces;

    public final static int NUM_OF_PROVINCES    = 13;
    public final static int NO_SUCH_PROVINCE    = -1;

    public static final int AB = 0;
    public static final int BC = 1;
    public static final int MB = 2;
    public static final int NB = 3;
    public static final int NL = 4;
    public static final int NT = 5;
    public static final int NS = 6;
    public static final int NU = 7;
    public static final int ON = 8;
    public static final int PE = 9;
    public static final int QC = 10;
    public static final int SK = 11;
    public static final int YT = 12;

    /** 
     *  Create provinces and territories in Canada
     */
    public Canada()
    {
        provinces = new ProvinceTerritory[NUM_OF_PROVINCES] ;

        provinces[AB] = new ProvinceTerritory ("Alberta" , 3645257) ;
        provinces[BC] = new ProvinceTerritory ("British Columbia" , 4400057);
        provinces[MB] = new ProvinceTerritory ("Manitoba" , 1208268);
        provinces[NB] = new ProvinceTerritory ("New Brunswick" , 751171);
        provinces[NL] = new ProvinceTerritory ("Newfoundland and Labrador" , 514536);
        provinces[NT] = new ProvinceTerritory ("Northwest Territories" , 41462);
        provinces[NS] = new ProvinceTerritory ("Nova Scotia" , 921727);
        provinces[NU] = new ProvinceTerritory ("Nunavut" , 31906);
        provinces[ON] = new ProvinceTerritory ("Ontario" , 12851821);
        provinces[PE] = new ProvinceTerritory ("Prince Edward Island" , 140204);
        provinces[QC] = new ProvinceTerritory ("Quebec" , 7903001);
        provinces[SK] = new ProvinceTerritory ("Saskatchewan" , 1033381);
        provinces[YT] = new ProvinceTerritory ("Yukon", 33897 );
    }  

    /** 
     *  Gets the total population of Canada
     *  
     *  @return totalPopulation Total population of provinces and territories in Canada
     */
    public int getTotalPopulation()
    {
        int totalPopulation = 0;
        int index = 0; 

        while (index < provinces.length)
        {
            totalPopulation +=  provinces[index].getPopulation();
            index++;
        }

        return totalPopulation;
    }

    /**
     * Finds the province with the lowest population.
     * 
     * @return  Name of the province or territory with the lowest population
     */
    public String getLowestPopulation()
    {
        int     lowestPopulation = Integer.MAX_VALUE;
        String  smallestProvince = "";
        int     index = 0; 

        while (index < provinces.length)
        {
            if (provinces[index].getPopulation() < lowestPopulation)
            {
                lowestPopulation = provinces[index].getPopulation();
                smallestProvince = provinces[index].getName();
            }
            index++;
        }  

        return smallestProvince;
    }

    /**
     * Gets the population of a specific province.
     * 
     * @return  Population of the province or territory
     * @param   province    Name of the province or territory
     */
    public int getPopulation(String province)
    {
        int index = 0;
        
        if (province == null || province.equals(""))
            throw new IllegalArgumentException("Invalid Province");
            
        while (index < provinces.length)
        {
            if (provinces[index].getName().equalsIgnoreCase(province))
            {
                return provinces[index].getPopulation();
            }
            index++;
        }  
        
        return NO_SUCH_PROVINCE;
    }

    /** 
     * Determines if the province/territory is in Canada.
     * 
     * @return  Whether there is a province or territory with the given name
     * @name    Name of the province or territory
     */
    public boolean isProvinceInCanada(String name)
    {
        if (name == null || name.equals("")) {
            throw new IllegalArgumentException("Invalid name");
        }
        
        boolean isProvinceInCanada = false;
        int index = 0;

        while (index < provinces.length)
        {
            if (provinces[index].getName().equalsIgnoreCase(name))
            {
                isProvinceInCanada = true;
            }
            index++;
        }

        return isProvinceInCanada;
    }

    /**
     * Gets all province names that contain the given substring.
     * 
     * @param   substring   Substring to search for in the name of province or territory
     * @return  Array of provinces or territories names with the substring in their names
     */
    public String[] getProvincesWhoseNameContains(String substring)
    {
        if (substring == null || substring.equals("")) {
            throw new IllegalArgumentException("Invalid string");
        }
        
        int i = 0;
        int j = 0;
        int numOfProvContainingString = 0;
        String[] containingString;
        
        while (i < provinces.length)
        {
            if (provinces[i].getName().toLowerCase().contains(substring.toLowerCase()))
            {
                numOfProvContainingString++;
            }
            i++;
        }

        if (numOfProvContainingString > 0)
        {
            containingString = new String[numOfProvContainingString];
        }
        else {
            return null;
        }

        i = 0 ;  
        while (i < provinces.length)
        {
            if (provinces[i].getName().toLowerCase().contains(substring.toLowerCase()))
            {
                containingString[j] = provinces[i].getName();
                j++;
            }
            i++;
        }

        return containingString;
    }
    
    /**
     * Gets all provinces that contain the given substring.
     * 
     * @param   substring   Substring to search for in the name of province or territory
     * @return  Array of provinces or territories with the substring in their names
     */
    public ProvinceTerritory[] getMoreProvincesWhoseNameContains(String substring)
    {
        if (substring == null || substring.equals("")) {
            throw new IllegalArgumentException("Invalid string");
        }
        
        int i = 0;
        int j = 0;
        int numOfProvContainString = 0;
        ProvinceTerritory[] containString;

        while (i < provinces.length)
        {
            if (provinces[i].getName().toLowerCase().contains(substring.toLowerCase()))
            {
                numOfProvContainString++;
            }
            i++;
        }        

        if (numOfProvContainString > 0)
        {
            containString = new ProvinceTerritory[numOfProvContainString];
        }
        else {
            return null;
        }

        i = 0 ;  
        while (i < provinces.length)
        {
            if (provinces[i].getName().toLowerCase().contains(substring.toLowerCase()))
            {
                containString[j] = new ProvinceTerritory(provinces[i].getName() , provinces[i].getPopulation());
                j++;
            }
            i++;
        }            
        
        return containString;
    }
    
    /**
     * Gets all provinces that starts with the given letter.
     * 
     * @param   letter  Letter by which province or territory name starts with
     * @return  Array containing the provinces or territories whose name start with a specific letter
     */
    public String[] getProvincesWhoseNameStartsWith(char letter)
    {
        if (letter == ' ' || letter == '\0') {
            throw new IllegalArgumentException("Invalid letter");
        }
            
        int i = 0;
        int j = 0;
        int numOfProvStartingWith = 0;
        String[] startingWithChar;

        while (i < provinces.length)
        {
            if (provinces[i].getName().toLowerCase().charAt(0) == Character.toLowerCase(letter))
            {
                numOfProvStartingWith++;
            }
            i++;
        }

        if (numOfProvStartingWith > 0)
        {
            startingWithChar = new String[numOfProvStartingWith];
        }
        else
            return null;

        i = 0 ;  
        while (i < provinces.length)
        {
            if (provinces[i].getName().toLowerCase().charAt(0) == Character.toLowerCase(letter))
            {
                startingWithChar[j] = provinces[i].getName();
                j++;
            }
            i++;
        }

        return startingWithChar;
    }    

}

