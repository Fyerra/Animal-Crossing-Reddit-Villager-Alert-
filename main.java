import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.awt.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class main {

    public static void main(String[] args) {
        int x = 30;
        String vilName = "Skye";
        String vilName2 = "skye";
        String acvilLast = "hfkladhlkdfhl";
        String viltradLast = "dhfklhfggadh";
        String givLast = "dfhalhflkdfjl";
        try {
            while (true) {
                acvilLast = acVil(acvilLast, vilName, vilName2);
                viltradLast = vilTrad(viltradLast, vilName, vilName2);
                givLast = giv(givLast, vilName, vilName2);
                TimeUnit.SECONDS.sleep(x);
            }
        } catch (IOException e) {
            System.out.println("Help, an IOException!");
        } catch (IllegalStateException a) {
            System.out.println("Something went wrong. A random IllegalStateException appeared!");
        } catch (InterruptedException e) {
            System.out.println("Brace yourself, an InterruptedException!");
        }
    }


    public static String acVil(String x, String y, String z) throws IOException {
        Document acvil = Jsoup.connect("https://www.reddit.com/r/ACVillager/new/").get();
        Elements allElements =
                acvil.getAllElements();
        String speicher[];
        for (Element element : allElements) {
            if (element.text().contains(x)) {
                printDate();
                System.out.println("Kein neuer Beitrag in r/ACVillager.");
                return x;
            }
            else if (element.text().contains(y) || element.text().contains(z)) {
                printDate();
                System.out.println("Neuer Beitrag in r/ACVillager.");
                x = element.text();
                speicher = x.split("ago");
                x = speicher[1];
                speicher = x.split("comments");
                x = speicher[0];
                Toolkit.getDefaultToolkit().beep();
                return x;
            }
            else {
                printDate();
                System.out.println("Kein neuer Beitrag in r/ACVillager.");
                return x;
            }
        }
        return x;
    }

    public static String vilTrad(String x, String y, String z) throws IOException {
        Document viltrad = Jsoup.connect("https://www.reddit.com/r/ACNHvillagertrade/new/").get();
        Elements allElements =
                viltrad.getAllElements();
        String speicher[];
        for (Element element : allElements) {
             if (element.text().contains(x)) {
                printDate();
                System.out.println("Kein neuer Beitrag in r/ACNHvillagertrade.");
                return x;
            }
            else if (element.text().contains(y) || element.text().contains(z)) {
                printDate();
                System.out.println("Neuer Beitrag in r/ACNHvillagertrade.");
                 x = element.text();
                 speicher = x.split("ago");
                 x = speicher[1];
                 speicher = x.split("comments");
                 x = speicher[0];
                Toolkit.getDefaultToolkit().beep();
                return x;
            }
            else {
                printDate();
                System.out.println("Kein neuer Beitrag in r/ACNHvillagertrade.");
                return x;
            }
        }
        return x;
    }

    public static String giv(String x, String y, String z) throws IOException {
        Document giv = Jsoup.connect("https://www.reddit.com/r/ACNHVillagerGiveaways/new/").get();
        Elements allElements =
                giv.getAllElements();
        String speicher[];
        for (Element element : allElements) {
            if (element.text().contains(x)) {
                printDate();
                System.out.println("Kein neuer Beitrag in r/ACNHVillagerGiveaways.");
                return x;
            }
            else if (element.text().contains(y) || element.text().contains(z)) {
                printDate();
                System.out.println("Neuer Beitrag in r/ACNHVillagerGiveaways.");
                x = element.text();
                speicher = x.split("ago");
                x = speicher[1];
                speicher = x.split("comments");
                x = speicher[0];
                Toolkit.getDefaultToolkit().beep();
                return x;
            }
            else {
                printDate();
                System.out.println("Kein neuer Beitrag in r/ACNHVillagerGiveaways.");
                return x;
            }
        }
        return x;
    }

    public static void printDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date date = new Date();
        System.out.print(formatter.format(date) + ": ");
    }

}

