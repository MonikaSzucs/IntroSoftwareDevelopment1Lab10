/**
 * Class Canada contains the provinces and territories, and their population.
 *
 * @author  Joe Developer
 * @version 1.0
 */
import java.util.ArrayList;

public class Canada
{
    private ArrayList<ProvinceTerritory> provinces;

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
        provinces = new ArrayList<ProvinceTerritory>();

        provinces.add(new ProvinceTerritory("Alberta" , 3645257));
        provinces.add(new ProvinceTerritory("British Columbia" , 4400057));
        provinces.add(new ProvinceTerritory("Manitoba" , 1208268));
        provinces.add(new ProvinceTerritory("New Brunswick" , 751171));
        provinces.add(new ProvinceTerritory("Newfoundland and Labrador" , 514536));
        provinces.add(new ProvinceTerritory("Northwest Territories" , 41462));
        provinces.add(new ProvinceTerritory("Nova Scotia" , 921727));
        provinces.add(new ProvinceTerritory("Nunavut" , 31906));
        provinces.add(new ProvinceTerritory("Ontario" , 12851821));
        provinces.add(null);
        provinces.add(new ProvinceTerritory("Prince Edward Island" , 140204));
        provinces.add(new ProvinceTerritory("Quebec" , 7903001));
        provinces.add(new ProvinceTerritory("Saskatchewan" , 1033381));
        provinces.add(new ProvinceTerritory("Yukon", 33897));
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
        
        
        
        for(ProvinceTerritory province: provinces)
        {
            if(province !=null){
            totalPopulation +=  province.getPopulation();
            index++;
            }
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

        for(ProvinceTerritory province : provinces)
        {
            if(province != null && province.getPopulation() < lowestPopulation)
            {
                lowestPopulation = province.getPopulation();
                smallestProvince = province.getName();
            }
            index++;
        }  

        return smallestProvince;
    }

    /**
     * Finds the province with the lowest population.
     * 
     * @return  Name of the province or territory with the lowest population
     */
    public String getHighestPopulation()
    {
        int     highestPopulation = Integer.MIN_VALUE;
        String  largestProvince = "";
        int     index = 0; 

        for(ProvinceTerritory province : provinces)
        {
            if(province != null && province.getPopulation() > highestPopulation)
            {
                highestPopulation = province.getPopulation();
                largestProvince = province.getName();
            }
            index++;
        }  

        return largestProvince;
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
            
        for(ProvinceTerritory prov : provinces)
        {
            if ( province != null && prov.getName().equalsIgnoreCase(province))
            {
                return prov.getPopulation();
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

        for(ProvinceTerritory province : provinces)
        {
            if ( province != null && province.equals("") && province.getName().equalsIgnoreCase(name))
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
        
        for(ProvinceTerritory province : provinces)
        {
            if ( province != null && province.getName().toLowerCase().contains(substring.toLowerCase()))
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
        for(ProvinceTerritory province : provinces)
        {
            if (province != null && province.getName().toLowerCase().contains(substring.toLowerCase()))
            {
                containingString[j] = province.getName();
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
    public ArrayList<ProvinceTerritory> getMoreProvincesWhoseNameContains(String substring)
    {
        if (substring == null || substring.equals("")) {
            throw new IllegalArgumentException("Invalid string");
        }
        
        ArrayList<ProvinceTerritory> prov = new ArrayList<>();
        

        for(ProvinceTerritory province : provinces)
        {
            if (province != null && province.getName().toLowerCase().contains(substring.toLowerCase()))
            {
                prov.add(province.getName());
            }
            else{
                return null;
            }
            return prov;
        }        

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
            
        
        int j = 0;
        int numOfProvStartingWith = 0;
        String[] startingWithChar;

        for(ProvinceTerritory province : provinces)
        {
            if ( province != null && province.getName().toLowerCase().charAt(0) == Character.toLowerCase(letter))
            {
                numOfProvStartingWith++;
            }
            
        }

        if (numOfProvStartingWith > 0)
        {
            startingWithChar = new String[numOfProvStartingWith];
        }
        else
            return null;

        
        for(ProvinceTerritory province : provinces)
        {
            if (province != null && province.getName().toLowerCase().charAt(0) == Character.toLowerCase(letter))
            {
                startingWithChar[j] = province.getName();
                j++;
            }
            
        }

        return startingWithChar;
    }
   

}

