package hello;

import card_utils.Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Card
{
    private final String bank;
    private final String[] cardCode;
    private final String date;

    private final SimpleDateFormat formatter = new SimpleDateFormat("MMM-yyyy");

    public Card(String bank, String card, String date)
    {
        this.bank = bank;
        this.cardCode = Utils.stringCodeToArray(card);
        this.date = date;
    }

    public String getBank()
    {
        return bank;
    }

    public String getCardCode()
    {
        return cardCode[0] + "-xxxx-xxxx-xxxx";
    }

    public String getDate()
    {
        return date;
    }

    Date dateForComparator()
    {
        Date dateValue = new Date();
        try
        {
            dateValue = formatter.parse(date);
        } catch (ParseException e)
        {
            e.printStackTrace();
        }
        return dateValue;
    }
}
