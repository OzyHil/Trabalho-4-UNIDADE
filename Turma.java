import java.util.ArrayList;

public class Turma extends Entidade{
    private ArrayList<Aluno> alunos;
    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    private int ano;

    

    public Turma(String nome, int codigo) {
        super(nome, codigo);
        alunos = new ArrayList<Aluno>();
    }
    public Turma(String base, Escola escola) {
        super(base);
        alunos = new ArrayList<Aluno>();
        var tierOne = base.split(";");
        for (String tTwo : tierOne[2].split(",")){
            alunos.add(escola.alunos.get(Integer.parseInt(tTwo)));
        }
    }
    public boolean adicionarAluno(Aluno aluno){
        if (alunos.contains(aluno))
            return false;
        alunos.add(aluno);
        return true;
    }
    public boolean removerAluno(Aluno aluno){
        if (!alunos.contains(aluno))
            return false;
        alunos.remove(aluno);
        return true;
    }
    public boolean removerAluno(int aluno){
        alunos.remove(aluno);
        return true;
    }

    public String mapearAlunos(){
        String toReturn = "";
        for (Aluno aluno : alunos) {
            toReturn = toReturn + "Código: "+aluno.getCodigo()+" Nome: " + aluno.getNome();
        }

        return toReturn;
    }

    @Override
    public String toCsv() {
        String toReturn = "";
        toReturn = toReturn + getCodigo() + ";"+ getNome() +";";
        for(Aluno a : alunos){
            toReturn+=a.getCodigo();
            toReturn+=",";
        }
        return toReturn;
    }
    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
}
