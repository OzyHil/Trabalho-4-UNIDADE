import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class GerenteDeArquivo{
    //TODO remover essa merda se n precisa pra UI
    public ArrayList<String> metaDados;// Proveniente do metadados.txt
    public ArrayList<String> alunos;// Proveniente do alunos.txt
    public ArrayList<String> docentes;// Proveniente do docentes.txt
    public ArrayList<String> disciplinas;// Proveniente do disciplinas.txt
    public ArrayList<String> turmas;// Proveniente do turmas.txt
    public ArrayList<String> relatorios;

    public void carregarMeta(){} // Carrega o arquivo metadados.txt e bota na lista metaDados;

    public List<String> carregarAlunos(){
        Path path = FileSystems.getDefault().getPath("src/Dados/Alunos.txt");
        List<String> toReturn = null;
        try {
            toReturn = Files.readAllLines(path);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try{
        toReturn.remove(toReturn.size()-1);
        } catch (IndexOutOfBoundsException ex){
            return toReturn;
        }
        return toReturn;
    }

    public List<String> carregarDocentes(){
        Path path = FileSystems.getDefault().getPath("src/Dados/Docentes.txt");
        List<String> toReturn = null;
        try {
            toReturn = Files.readAllLines(path);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try{
            toReturn.remove(toReturn.size()-1);
            } catch (IndexOutOfBoundsException ex){
                return toReturn;
            }
        return toReturn;
    }

    public List<String> carregarTurmas(){
        Path path = FileSystems.getDefault().getPath("src/Dados/Turmas.txt");
        List<String> toReturn = null;
        try {
            toReturn = Files.readAllLines(path);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try{
            toReturn.remove(toReturn.size()-1);
            } catch (IndexOutOfBoundsException ex){
                return toReturn;
            }
        return toReturn;
    }

    public List<String> carregarDisciplinas(){
        Path path = FileSystems.getDefault().getPath("src/Dados/Disciplinas.txt");
        List<String> toReturn = null;
        try {
            toReturn = Files.readAllLines(path);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try{
            toReturn.remove(toReturn.size()-1);
            } catch (IndexOutOfBoundsException ex){
                return toReturn;
            }
        return toReturn;
    }
    public void adicionarLinha(int list, String add){}// Bota a string add na lista list (códigos definidos na classe Util).

    public void removerLinha(int linha, int list){}
    
    public void adicionarRelatorio(String relatorio){}//

    public void escrever(Escola escola){
        String toWrite = "";
        FileWriter writer = null;
        for (Aluno aluno : escola.alunos.values()) {
            toWrite = toWrite + aluno.toCsv() + "\n";
        }
        
        try {
            writer = new FileWriter("src/Dados/Alunos.txt",true);
            writer.write(toWrite);
            writer.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        toWrite = "";
        for ( Docente doc : escola.docentes.values()) {
            toWrite = toWrite + doc.toCsv() + "\n";
        }
        
        try {
            writer = new FileWriter("src/Dados/Docentes.txt",true);
            writer.write(toWrite);
            writer.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        toWrite = "";
        for (Turma t : escola.turmas.values()) {
            toWrite = toWrite + t.toCsv() + "\n";
        }
        
        try {
            writer = new FileWriter("src/Dados/Turmas.txt",true);
            writer.write(toWrite);
            writer.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        toWrite = "";
        for (Disciplina d : escola.disciplinas.values()) {
            toWrite = toWrite + d.toCsv() + "\n";
        }
        
        try {
            writer = new FileWriter("src/Dados/Disciplinas.txt",true);
            writer.write(toWrite);
            writer.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    } 
}
