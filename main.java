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
        String name;
        String strCopy = "fdklhfklfdsajk";
        int t = 10;
        String acvilLast = "hfkladh2456525442lkdfhl";
        String viltradLast = "hfkladh2456525442lkdfhl";
        String givLast = "hfkladh2456525442lkdfhl";
        try {
            UI.main(args);
            while (true) {
                TimeUnit.SECONDS.sleep(1);
                if (UI.getBool() == true) {
                    while (UI.getBool() == true) {
                            String str = UI.getTextVil();
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
                                UI.getArea().append("Bitte gib eine Zahl größer oder gleich 10 ein. Automatisch auf 10 gesetzt.\r\n");
                            }
                            if (!strCopy.equals(str)) {
                                strCopy = str;
                            }
                            try {
                                name = str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
                            } catch (StringIndexOutOfBoundsException e) {
                                UI.getArea().append("Gib einen gültigen Text ein.\r\n");
                                name = "Villagername";
                        }
                            String nameUp = name.toUpperCase();
                            String nameDo = name.toLowerCase();
                        acvilLast = acVil(acvilLast, name, nameUp, nameDo);
                        viltradLast = vilTrad(viltradLast, name, nameUp, nameDo);
                        givLast = giv(givLast, name, nameUp, nameDo);
                        TimeUnit.SECONDS.sleep(t);
                    }
                }
            }
        } catch (IOException e) {
            UI.getArea().append("Help, an IOException!\r\n");
        } catch (IllegalStateException e) {
            UI.getArea().append("Something went wrong. A random IllegalStateException appeared!\r\n");
        } catch (InterruptedException e) {
            UI.getArea().append("Brace yourself, an InterruptedException!\r\n");
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
                UI.getArea().append("Kein neuer Beitrag über " + name + " in r/ACVillager.\r\n");
                return last;
            }
            else if (element.text().contains(name) || element.text().contains(nameUp) || element.text().contains(nameDo)) {
                printDate();
                UI.getArea().append("Neuer Beitrag über " + name + " in r/ACVillager.\r\n");
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
                UI.getArea().append("Kein neuer Beitrag über " + name + " in r/ACVillager.\r\n");
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
                UI.getArea().append("Kein neuer Beitrag über " + name + " in r/ACNHvillagertrade.\r\n");
                return last;
            }
            else if (element.text().contains(name) || element.text().contains(nameUp) || element.text().contains(nameDo)) {
                printDate();
                UI.getArea().append("Neuer Beitrag über " + name + " in r/ACNHvillagertrade.\r\n");
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
                UI.getArea().append("Kein neuer Beitrag über " + name + " in r/ACNHvillagertrade.\r\n");
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
                UI.getArea().append("Kein neuer Beitrag über " + name + " in r/ACNHVillagerGiveaways.\r\n");
                return last;
            }
            else if (element.text().contains(name) || element.text().contains(nameUp) || element.text().contains(nameDo)) {
                printDate();
                UI.getArea().append("Neuer Beitrag über " + name + " in r/ACNHVillagerGiveaways.\r\n");
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
                UI.getArea().append("Kein neuer Beitrag über " + name + " in r/ACNHVillagerGiveaways.\r\n");
                return last;
            }
        }
        return last;
    }

    public static void printDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date date = new Date();
        UI.getArea().append(formatter.format(date) + ": ");
    }
}
