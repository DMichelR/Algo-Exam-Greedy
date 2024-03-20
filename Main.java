import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int amountGuests = Integer.parseInt(br.readLine());
        int[] happinesLevels = new int[amountGuests];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < happinesLevels.length; i++) {
            happinesLevels[i] = Integer.parseInt(st.nextToken());
        }

        int[] souvenirs = new int[amountGuests];
        Arrays.fill(souvenirs, 0);
        for (int i = 0; i < amountGuests - 1; i++) {
            if (happinesLevels[i] > happinesLevels[i + 1]) {
                souvenirs[i + 1] = souvenirs[i] + 1;
            }
        }
        for (int i = amountGuests - 1; i > 0; i--) {

            if (happinesLevels[i] > happinesLevels[i - 1]) {
                souvenirs[i - 1] = souvenirs[i] + 1;
            }
        }
        int sum = amountGuests;
        for (int i = 0; i < souvenirs.length; i++) {
            sum = sum + souvenirs[i];
        }
        bw.write("" + sum);
        bw.flush();

    }
}

/*
 * a) entregar a la persona n 1 mas la cantidad de suvenirs de la persona n+1 si
 * esta es mas feliz que la anterior
 * y luego hacer lo mismo recorriendo la lista de personas al revez
 * 
 * b) la subestructura optima es un array primitivo de enteros
 * 
 * d) la complejidad es 0(3*n)
 */