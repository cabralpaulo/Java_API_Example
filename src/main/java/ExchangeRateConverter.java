import kong.unirest.Unirest;

import java.util.Map;

import static input.InputUtils.doubleInput;

public class ExchangeRateConverter {
    public static void main(String[] args) {
        String url = "https://1150-exchange-rates.azurewebsites.net/latest";
        Map<String , Object> queryParameters = Map.of("base", "USD", "symbols", "EUR");
        //todo Make a Request:
        RateResponse  response = Unirest.get(url)
                .queryString(queryParameters)
                .asObject(RateResponse.class).
                getBody();

        String dateRequested = response.date;

        double rate = response.rates.EUR;
        double ammount = doubleInput("How many US dollars to convert? ");
        double equivalentEuro = ammount * rate;
        //double rate1 = response.rates.BRL;
        System.out.println("On the " + dateRequested + "the exchange rate from USD to EUR  is " + rate);
        System.out.println("$"+ ammount + " is equivalent to "  + equivalentEuro + " Euros");

    }

}

    class RateResponse { //Constructor Rate Response
        public String base;
        public String date;
        public Rates rates;
    }

    class Rates { //Constructor Rate Class
        //public double BRL;
        public double EUR;
    }

