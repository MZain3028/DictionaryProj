import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class read {
    static BufferedReader In;

    static {
        In = new BufferedReader(new InputStreamReader(System.in));
    }

    public read() {
    }

    public static void FlushInput() throws IOException {
        String var0 = In.readLine();
    }

    public static char GetChar() throws IOException {
        char var0 = (char)In.read();
        return var0;
    }

    public static double GetDouble() throws IOException {
        while(true) {
            try {
                String var0 = In.readLine().trim();
                double var1 = new Double(var0);
                return var1;
            } catch (NumberFormatException var3) {
            }
        }
    }

    public static float GetFloat() throws IOException {
        while(true) {
            try {
                String var0 = In.readLine().trim();
                float var1 = new Float(var0);
                return var1;
            } catch (NumberFormatException var2) {
            }
        }
    }

    public static int GetInt() throws IOException {
        while(true) {
            try {
                String var0 = In.readLine().trim();
                int var1 = new Integer(var0);
                return var1;
            } catch (NumberFormatException var2) {
            }
        }
    }

    public static long GetLong() throws IOException {
        while(true) {
            try {
                String var0 = In.readLine().trim();
                long var1 = new Long(var0);
                return var1;
            } catch (NumberFormatException var3) {
            }
        }
    }

    public static String GetString() throws IOException {
        String var0 = In.readLine().trim();
        return var0;
    }
}
