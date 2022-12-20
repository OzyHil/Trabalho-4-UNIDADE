import java.util.ArrayList;

public class Docente extends Entidade{
    private ArrayList<Disciplina> disciplinas;
    
    public Docente(String nome, int codigo) {
        super(nome, codigo);
        disciplinas = new ArrayList<Disciplina>();
    }

    public Docente(String base) {
        super(base);
        disciplinas = new ArrayList<Disciplina>();
    }

    public ArrayList<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    @Override
    public String toCsv() {
        String toReturn = "";
        toReturn = toReturn + getCodigo() + ";"+ getNome();
        return toReturn;
    }

    public void addDisciplina(Disciplina toAdd){
        disciplinas.add(toAdd);
    }
    
    public void removeDisciplina(Disciplina toRemove){
        disciplinas.remove(toRemove);
    }
}
