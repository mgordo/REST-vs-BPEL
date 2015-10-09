/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.dtu.utils;

/**
 *
 * @author miguel
 */
public interface Constants {
    public static final String DATE_FORMAT = "dd/MM/yyyy";
    public static final String MSG_ITINERARY_NOT_FOUND = "Itinerary not found";
    public static final String MSG_NULL_USER = "Not a valid username";
    public static final String MSG_FLIGHT_NOT_FOUND = "Flight not found";
    public static final String MSG_NO_FLIGHT_FOUND = "No flight was found";
    public static final String MSG_NO_HOTEL_FOUND = "No hotel was found";
    public static final String STATUS_UNCONFIRMED = "unconfirmed";
    public static final String STATUS_CONFIRMED = "confirmed";
    public static final String STATUS_CANCELLED = "cancelled";
    
    public static final String MEDIATYPE_XML = "application/travelgoodrest+xml";
    
    /**
     * URIs to access the resources
     */
    public static final String BASE_URI = "http://localhost:8070/TravelGoodREST/webresources/";
    public static final String BASE_ITINERARIES_URI = Constants.BASE_URI+"itineraries";
    public static final String BASE_FLIGHT_URI = "http://localhost:8070/TravelGoodREST/webresources/flights";
    public static final String BASE_HOTEL_URI = "http://localhost:8070/TravelGoodREST/webresources/hotels";
    public static final String BASE_LOGIN_URI = Constants.BASE_URI+"login";

    
    
    /**
     * Relations to access the itinerary resource
     */
    public static final String RELATION_ITINERARIES_BASE = "http://itineraries.ws/relations/";
    public static final String ITINERARY_RELATION = Constants.RELATION_ITINERARIES_BASE + "itinerary";    
    public static final String CANCEL_RELATION = Constants.RELATION_ITINERARIES_BASE + "cancel";
    public static final String FLIGHTADD_RELATION = Constants.RELATION_ITINERARIES_BASE + "flightadd";
    public static final String HOTELADD_RELATION = Constants.RELATION_ITINERARIES_BASE + "hoteladd";
    public static final String BOOKITINERARY_RELATION = Constants.RELATION_ITINERARIES_BASE + "book";
    
    
    
    /**
     * Relations to access the flights resource
     */
    public static final String RELATION_FLIGHTS_BASE = "http://flights.ws/relations/";
    public static final String GETFLIGHT_RELATION = Constants.RELATION_FLIGHTS_BASE + "getflight";
    
    /**
     * Relations to access the hotels resources
     */
    public static final String RELATION_HOTELS_BASE = "http://hotels.ws/relations/";
    public static final String GETHOTEL_RELATION = Constants.RELATION_HOTELS_BASE + "gethotel";

}
