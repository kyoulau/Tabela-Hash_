import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static final String PATH_FAMALE_NAMES = "src/female_names.txt";
    public static void main(String[] args) {
        System.out.println("Inicianlizando programa");

        List<String> names = FileHander.readNamesFromFile(PATH_FAMALE_NAMES);


        if (names.isEmpty()) {
            System.err.println("Nenhum nome foi lido do arquivo. Verifique o caminho ou conteúdo do arquivo.");
            return;
        } else {
            System.out.println("Total de " + names.size() + " nomes lidos do arquivo.");
        }
    }
}