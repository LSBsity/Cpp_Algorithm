import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<String> channels = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            channels.add(br.readLine());
        }
        StringBuilder result = new StringBuilder();
        int cursor = 0;
        int idxKBS1 = channels.indexOf("KBS1");
        while (cursor < idxKBS1) {
            result.append("1");
            cursor++;
        }
        while (cursor > 0) {
            result.append("4");
            Collections.swap(channels, cursor, cursor - 1);
            cursor--;
        }

        int idxKBS2 = channels.indexOf("KBS2");
        while (cursor < idxKBS2) {
            result.append("1");
            cursor++;
        }
        while (cursor > 1) {
            result.append("4");
            Collections.swap(channels, cursor, cursor - 1);
            cursor--;
        }

        System.out.println(result);
    }
}