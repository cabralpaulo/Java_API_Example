import kong.unirest.Unirest;

import java.util.Map;

import static input.InputUtils.stringInput;

public class YelpSearch {
    public static void main(String[] args) {
        String yelpURL = "https://api.yelp.com/v3/businesses/search";
        String API_KEY = System.getenv("API_KEY"); //Environmental Variable

        // Lowest Price Category
        //Specify Type of Restaurants

        String restaurantType = stringInput("What type of restaurant would you like to search for?");

        Map <String, Object> yelpQuery = Map.of(
                "term",restaurantType, //Type of restaurant
                "location", "Minneapolis, MN",
                "categories", "Restaurants",
                "price", "1"); //lowest price

        //Making the Request
        YelpResponse response = Unirest
                .get(yelpURL)
                .header("Authorization","Bearer " + API_KEY)
                .queryString(yelpQuery)
                .asObject(YelpResponse.class)
                .getBody();

        System.out.println(response);
        for(Business b : response.businesses){
            System.out.println(b.name);
            System.out.println("Rating: " + b.rating);
            System.out.println(b.location.address1 + ", " + b.location.city);
        }
    }
}
