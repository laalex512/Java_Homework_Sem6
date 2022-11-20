import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Logger;

public class Program {
    public static void main(String[] args) {
        Logger logger = Logger.getAnonymousLogger();
        Set<Notebook> notebooksSet = new HashSet<>();
        notebooksSet.add(new Notebook("HP", "4", "250", "Windows", "15", "Black"));
        notebooksSet.add(new Notebook("HP", "8", "500", "Windows", "15", "Black"));
        notebooksSet.add(new Notebook("HP", "16", "1000", "Windows", "17", "White"));
        notebooksSet.add(new Notebook("HP", "32", "2000", "Windows", "17", "White"));
        notebooksSet.add(new Notebook("MacBook", "4", "250", "MacOS", "15", "White"));
        notebooksSet.add(new Notebook("MacBook", "8", "500", "MacOS", "15", "White"));
        notebooksSet.add(new Notebook("MacBook", "16", "1000", "MacOS", "15", "White"));
        notebooksSet.add(new Notebook("MacBook", "32", "2000", "MacOS", "17", "White"));
        notebooksSet.add(new Notebook("Lenovo", "4", "250", "Windows", "15", "Black"));
        notebooksSet.add(new Notebook("Lenovo", "8", "500", "Windows", "15", "Black"));
        notebooksSet.add(new Notebook("Lenovo", "16", "1000", "Windows", "17", "Black"));
        notebooksSet.add(new Notebook("Lenovo", "32", "2000", "Windows", "17", "Black"));

        String message = "All notebooks: \n";
        for (Notebook i : notebooksSet) {
            message += i;
        }
        logger.info(message);
        while (true) {
            Map<String, String> filterMap = new HashMap<>();
            Scanner iScan = new Scanner(System.in);
            System.out.println("New filter:");
            System.out.printf("Insert name: ");
            String currentMessage = iScan.nextLine();
            if (currentMessage.equals("q")) {
                break;
            } else {
                filterMap.put("name", currentMessage);
                System.out.printf("Insert ram: ");
                filterMap.put("ram", iScan.nextLine());
                System.out.printf("Insert hdd: ");
                filterMap.put("hdd", iScan.nextLine());
                System.out.printf("Insert os (Windows or MacOS): ");
                filterMap.put("os", iScan.nextLine());
                System.out.printf("Insert display (15 or 17): ");
                filterMap.put("display", iScan.nextLine());
                System.out.printf("Insert color (Black or White): ");
                filterMap.put("color", iScan.nextLine());
                filter(notebooksSet, filterMap);
            }
        }
    }

    public static void filter(Set<Notebook> set, Map<String, String> filterParametres) {
        Logger logger = Logger.getAnonymousLogger();
        Set<Notebook> resultSet = new HashSet<>();
        for (Notebook i : set) {
            if ((filterParametres.get("name").equals("") ||
                    filterParametres.get("name").equals(i.getParameter("name")))
                    &&
                    (filterParametres.get("ram").equals("") ||
                            Integer.parseInt(filterParametres.get("ram")) <= Integer.parseInt(i.getParameter("ram")))
                    &&
                    (filterParametres.get("hdd").equals("") ||
                            Integer.parseInt(filterParametres.get("hdd")) <= Integer.parseInt(i.getParameter("hdd")))
                    &&
                    (filterParametres.get("display").equals("") ||
                            Integer.parseInt(filterParametres.get("display")) <= Integer
                                    .parseInt(i.getParameter("display")))
                    &&
                    (filterParametres.get("os").equals("") ||
                            filterParametres.get("os").equals(i.getParameter("os")))
                    &&
                    (filterParametres.get("color").equals("") ||
                            filterParametres.get("color").equals(i.getParameter("color")))) {
                resultSet.add(i);
            }
        }
        String output = "Notebooks filtred:\n";
        for (Notebook i : resultSet) {
            output += i;
        }
        logger.info(output);
    }

}
