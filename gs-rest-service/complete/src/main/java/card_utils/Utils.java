package card_utils;

import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;
import hello.Card;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Utils
{
    private Utils()
    {
        //utility class
    }

    public static String[] stringCodeToArray(String code)
    {
        return code.split("-");
    }

    public static List<Card> parseCSV(InputStream dataStream)
    {
        List<Card> cardList = new ArrayList<>();
        CsvParserSettings settings = new CsvParserSettings();
        CsvParser parser = new CsvParser(settings);

        String[] row;
        parser.beginParsing(dataStream);

        while((row = parser.parseNext()) != null)
        {
            cardList.add(new Card(row[0], row[1], row[2]));
        }

        return cardList;
    }
}
