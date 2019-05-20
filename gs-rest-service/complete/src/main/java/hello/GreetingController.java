package hello;

import card_utils.Utils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@CrossOrigin
@RestController
public class GreetingController
{
    private final List<Card> cardList = new ArrayList<>();

    @RequestMapping("/addCard")
    public String addData(
            @RequestParam(value="bank") String bank,
            @RequestParam(value="card") String card,
            @RequestParam(value="date") String date)
    {
        cardList.add(new Card(bank, card, date));
        return "200";
    }

    @RequestMapping("/addCSV")
    public String addCSV(InputStream dataStream)
    {
        cardList.addAll(Utils.parseCSV(dataStream));
        return "200";
    }

    @RequestMapping("/getTable")
    public List<Card> getData()
    {
        cardList.sort(Comparator.comparing(Card::dateForComparator).reversed());

        return cardList;
    }
}
