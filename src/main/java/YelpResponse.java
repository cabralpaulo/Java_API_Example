//Yelp API Responses classes to map JSON to JAVA objects.
public class YelpResponse {
    //Field for business
    //Array type.
    public Business[] businesses;
}

class Business{
    //represent one business object
    public String name;
    public double rating;
    //Location - Street Address
    public Location location;

}

class Location{
    public String city;
    public String address1; //Check the documentation write the right value.
}
