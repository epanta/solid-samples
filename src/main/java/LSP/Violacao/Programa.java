package LSP.Violacao;

public class Programa {

    private static void obterAreaRetangulo(Retangulo ret) {
        System.out.println("Calculo da área do retangulo");
        System.out.println(ret.altura.toString() + " * " + ret.largura.toString());
        System.out.println(ret.area());
    }

    public static void main(String[] args) {
        Quadrado quad = new Quadrado();
        quad.setAltura(10);
        quad.setLargura(5);

        obterAreaRetangulo(quad);
    }
}
