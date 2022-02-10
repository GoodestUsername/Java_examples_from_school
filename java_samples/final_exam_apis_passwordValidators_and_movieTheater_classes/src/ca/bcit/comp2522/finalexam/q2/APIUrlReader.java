package ca.bcit.comp2522.finalexam.q2;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class APIUrlReader {
    private ArrayList<APIEntry> arrayOfAPIs;

    public String jsonString;

    public APIUrlReader() {
        Path currentPath = Paths.get("res/APIList.txt");
        jsonString = getJSONFromFile(currentPath.toAbsolutePath().toString());

        Gson gson = new Gson();
        arrayOfAPIs =  new ArrayList<>(
                gson.fromJson(jsonString, new TypeToken<List<APIEntry>>() {}.getType())
        );
    }

    public static void main(String[] args) {
        APIUrlReader reader = new APIUrlReader();
        reader.arrayOfAPIs.stream()
                .filter(apiEntry -> apiEntry.getCategory().equals("Animals"))
                .filter(apiEntry -> apiEntry.getAuth().equals(""))
                .filter(apiEntry -> apiEntry.getHTTPS().equals("true"))
                .sorted(Comparator.comparing(APIEntry :: getDescription))
                .forEach(System.out :: println);

        List<String> categories = reader.arrayOfAPIs.stream()
                .map(APIEntry :: getCategory)
                .distinct()
                .collect(Collectors.toList());
        categories.forEach(System.out :: println);
    }

    public long getCountAPIs() {
        return arrayOfAPIs.size();
    }

    public long getCountNoAuth() {
        Stream<APIEntry> noAuthAPIs = arrayOfAPIs.stream().filter(apiEntry -> apiEntry.getAuth().equals(""));
        return noAuthAPIs.count();
    }

    public long getCountHTTPS() {
        Stream<APIEntry> noAuthAPIs = arrayOfAPIs.stream().filter(apiEntry -> apiEntry.getHTTPS().equals("true"));
        return noAuthAPIs.count();
    }

    public long getCountAnimalAPIs() {
        Stream<APIEntry> noAuthAPIs = arrayOfAPIs.stream().filter(apiEntry -> apiEntry.getCategory().equals("Animals"));
        return noAuthAPIs.count();
    }

    public static String getJSONFromFile(String aFile) {
        String inline = "";
        try {

            Scanner scanner = new Scanner(new File(aFile));

            while (scanner.hasNext()) {
                inline += scanner.nextLine();
            }
            scanner.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return inline;
    }
}
