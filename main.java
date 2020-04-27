import org.jsoup.Jsoup;
import org.jsoup.internal.StringUtil;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.awt.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class main {


    static UserInterface UI = new UserInterface();
    public static void main(String[] args) {
    String strCopy = "fdklhfklfdsajk";
    int t = 10;
    String str = UI.getTextVil();
    String name = str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    String nameUp = UI.getTextVil().toUpperCase();
    String nameDo = UI.getTextVil().toLowerCase();;
    String acvilLast = "hfkladh2456525442lkdfhl";
    String viltradLast = "hfkladh2456525442lkdfhl";
    String givLast = "hfkladh2456525442lkdfhl";
    try {
        UI.main(args);
        while (true) {
            TimeUnit.SECONDS.sleep(1);
            if (UI.getBool() == true) {
                while (UI.getBool() == true) {
                    str = UI.getTextVil();
                    if (!strCopy.equals(str)) {
                        acvilLast = "hfkladh2456525442lkdfhl";
                        viltradLast = "hfkladh2456525442lkdfhl";
                        givLast = "hfkladh2456525442lkdfhl";
                    }
                    try {
                            if (UI.getTextS() < 10) {
                                throw new NumberFormatException();
                            }
                            t = UI.getTextS();
                        } catch (NumberFormatException e) {
                            System.out.println("Bitte gib eine Zahl größer oder gleich 10 ein. Automatisch auf 10 gesetzt.");
                        }
                        if (!strCopy.equals(str)) {
                            strCopy = str;
                        }
                        name = str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
                        nameUp = UI.getTextVil().toUpperCase();
                        nameDo = UI.getTextVil().toLowerCase();
                    acvilLast = acVil(acvilLast, name, nameUp, nameDo);
                    viltradLast = vilTrad(viltradLast, name, nameUp, nameDo);
                    givLast = giv(givLast, name, nameUp, nameDo);
                    TimeUnit.SECONDS.sleep(t);
                }
            }
        }
        } catch (IOException e) {
            System.out.println("Help, an IOException!");
        } catch (IllegalStateException e) {
            System.out.println("Something went wrong. A random IllegalStateException appeared!");
        } catch (InterruptedException e) {
            System.out.println("Brace yourself, an InterruptedException!");
        } //catch (NumberFormatException e) {
          //  System.out.println("Bitte gib eine Zahl größer oder gleich 10 ein.");
        //}
    }


    public static String acVil(String last, String name, String nameUp, String nameDo) throws IOException {
        Document acvil = Jsoup.connect("https://www.reddit.com/r/ACVillager/new/").get();
        Elements allElements =
                acvil.getAllElements();
        String speicher[];
        for (Element element : allElements) {
            if (element.text().contains(last)) {
                printDate();
                System.out.println("Kein neuer Beitrag über " + name + " in r/ACVillager.");
                return last;
            }
            else if (element.text().contains(name) || element.text().contains(nameUp) || element.text().contains(nameDo)) {
                printDate();
                System.out.println("Neuer Beitrag über " + name + " in r/ACVillager.");
                last = element.text();
                speicher = last.split("ago");
                last = speicher[1];
                speicher = last.split("•");
                last = speicher[0];
                Toolkit.getDefaultToolkit().beep();
                return last;
            }
            else {
                printDate();
                System.out.println("Kein neuer Beitrag über " + name + " in r/ACVillager.");
                return last;
            }
        }
        return last;
    }

    public static String vilTrad(String last, String name, String nameUp, String nameDo) throws IOException {
        Document viltrad = Jsoup.connect("https://www.reddit.com/r/ACNHvillagertrade/new/").get();
        Elements allElements =
                viltrad.getAllElements();
        String speicher[];
        for (Element element : allElements) {
             if (element.text().contains(last)) {
                printDate();
                System.out.println("Kein neuer Beitrag über " + name + " in r/ACNHvillagertrade.");
                return last;
            }
            else if (element.text().contains(name) || element.text().contains(nameUp) || element.text().contains(nameDo)) {
                printDate();
                System.out.println("Neuer Beitrag über " + name + " in r/ACNHvillagertrade.");
                 last = element.text();
                 speicher = last.split("ago");
                 last = speicher[1];
                 speicher = last.split("•");
                 last = speicher[0];
                Toolkit.getDefaultToolkit().beep();
                return last;
            }
            else {
                printDate();
                System.out.println("Kein neuer Beitrag über " + name + " in r/ACNHvillagertrade.");
                return last;
            }
        }
        return last;
    }

    public static String giv(String last, String name, String nameUp, String nameDo) throws IOException {
        Document giv = Jsoup.connect("https://www.reddit.com/r/ACNHVillagerGiveaways/new/").get();
        Elements allElements =
                giv.getAllElements();
        String speicher[];
        for (Element element : allElements) {
            if (element.text().contains(last)) {
                printDate();
                System.out.println("Kein neuer Beitrag über " + name + " in r/ACNHVillagerGiveaways.");
                return last;
            }
            else if (element.text().contains(name) || element.text().contains(nameUp) || element.text().contains(nameDo)) {
                printDate();
                System.out.println("Neuer Beitrag über " + name + " in r/ACNHVillagerGiveaways.");
                last = element.text();
                speicher = last.split("ago");
                last = speicher[1];
                speicher = last.split("•");
                last = speicher[0];
                Toolkit.getDefaultToolkit().beep();
                return last;
            }
            else {
                printDate();
                System.out.println("Kein neuer Beitrag über " + name + " in r/ACNHVillagerGiveaways.");
                return last;
            }
        }
        return last;
    }

    public static void printDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date date = new Date();
        System.out.print(formatter.format(date) + ": ");
    }

}

