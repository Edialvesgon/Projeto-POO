package projetodois;


public class DecimalParaRomano {
    
    public static String decimalParaRomano(int numero) {
        String resultado = " ";
        int resto = numero;
        int[] vetorNumeros = {1000, 500, 100, 50, 10};
        String[] vetorRomanos = {"M", "D", "C", "L", "X"};
        String[] vetorDezena = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        
        for (int i = 0; i < vetorNumeros.length; i++) {
            int divisao = resto / vetorNumeros[i];
            resto = resto % vetorNumeros[i];
            if (divisao > 0) {
                for (int x = 0; x < divisao; x++) {
                    resultado += vetorRomanos[i];
                }
            } else if (resto < 10) {
                if (resto > 0 && resto <= vetorDezena.length) {
                    resultado += vetorDezena[resto - 1];
                }
                break;
            }
        }
        return resultado;
    }

    public static void main(String[] args) {
        int numero = 150;
        System.out.println("Número romano para " + numero + " é " + decimalParaRomano(numero));
}
}
