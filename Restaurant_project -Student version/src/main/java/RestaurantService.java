import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RestaurantService {
    private static List<Restaurant> restaurants = new ArrayList<>();

    public Restaurant findRestaurantByName(String restaurantName) throws restaurantNotFoundException {
        for (Restaurant restaurant: restaurants) {
            if (restaurant.getName().equals(restaurantName))
                return restaurant;
        }
        throw new restaurantNotFoundException(restaurantName);
    }

    public Restaurant addRestaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        Restaurant newRestaurant = new Restaurant(name, location, openingTime, closingTime);
        restaurants.add(newRestaurant);
        return newRestaurant;
    }

    public Restaurant removeRestaurant(String restaurantName) throws restaurantNotFoundException {
        Restaurant restaurantToBeRemoved = findRestaurantByName(restaurantName);
        if (!Objects.isNull(restaurantToBeRemoved)) {
            restaurants.remove(restaurantToBeRemoved);
            return restaurantToBeRemoved;
        }
        throw new restaurantNotFoundException(restaurantName);
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public int calculateOrder(List<Item> items) {
        int result = 0;
        for (Item item: items) {
            result += item.getPrice();
        }
        return result;
    }
}
