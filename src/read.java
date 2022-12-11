import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class read {
    static BufferedReader In;

    static {
        In = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void FlushInput() throws IOException {
        String var0 = In.readLine();
    }

    public static char GetChar() throws IOException {
        char var0 = (char)In.read();
        return var0;
    }

    public static String GetString() throws IOException {
        String var0 = In.readLine().trim();
        return var0;
    }
}
