import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Disciplina extends Entidade{
    
    private ArrayList<Docente> docentes;

    private HashMap<Aluno,Float[]> notas;

    private int ano;

    
    public Disciplina(String nome, int codigo) {
        super(nome, codigo);
        docentes = new ArrayList<Docente>();
        notas = new HashMap<Aluno,Float[]>();
    }
//TODO #18 adicionar formas de o carregar do arquivo nao quebrar se o bgl n for inicializado todo antes de salvar
    public Disciplina(String base, Escola escola) {
        super(base);
        docentes = new ArrayList<Docente>();
        notas = new HashMap<Aluno,Float[]>();
        var tierOne = base.split(";");
        for (String tTwo : tierOne[2].split(",")){
            docentes.add(escola.docentes.get(Integer.parseInt(tTwo)));
        }
        for (String tTwo : tierOne[3].split("/")){
            var tierThree = tTwo.split("-");
            Aluno key = escola.alunos.get(Integer.parseInt(tierThree[0]));
            Float[] value = new Float[4];
            int i = 0;
            for (String tFour: tierThree[1].split(",")){
                value[i] = Float.parseFloat(tFour);
                i++;
            }
            notas.put(key, value);
        }
        for (Docente d: docentes){
            d.addDisciplina(this);
        }
    }

    public void editarNotas(Aluno aluno, Float[] nota){
        notas.put(aluno, nota);
    }
    public void adicionarAluno(Aluno aluno){
        notas.put(aluno, new Float[]{0f,0f,0f,0f});
        aluno.getNotas().put(getCodigo(), new Float[]{0f,0f,0f,0f});
    }

    public ArrayList<Docente> getDocentes() {
        return docentes;
    }

    public HashMap<Aluno, Float[]> getNotas() {
        return notas;
    }

    public boolean removerAluno(int aluno){
        ArrayList<Aluno> buffer = new ArrayList<Aluno>(notas.keySet());
        Aluno a = buffer.get(aluno);
        a.getNotas().remove(this.getCodigo());
        notas.remove(a);
        return true;
    }

    public boolean adicionarDocente(Docente docente){
        if (docentes.contains(docente))
            return false;
        docentes.add(docente);
        return true;
    }

    public boolean removerDocente(int docente){
        docentes.remove(docente);
        return true;
    }

    public String mapearDocentes(){
        String toReturn = "";
        for (Docente docente : docentes) {
            toReturn = toReturn + "Código: "+docente.getCodigo()+" Nome: " + docente.getNome();
        }

        return toReturn;
    }

    public String mapearAlunos(){
        String toReturn = "";
        for (Aluno aluno : notas.keySet()) {
            toReturn = toReturn + "Código: "+aluno.getCodigo()+" Nome: " + aluno.getNome();
        }

        return toReturn;
    }

    @Override
    public String toCsv() {
        String toReturn = "";
        toReturn = toReturn + getCodigo() + ";"+ getNome() +";";
        for (Docente d: docentes){
            toReturn+= d.getCodigo();
            toReturn+= ",";
        }
        toReturn+=";";
        for (Map.Entry<Aluno,Float[]> pair : notas.entrySet()) {
            toReturn = toReturn + pair.getKey().getCodigo() + "-";
            toReturn = toReturn + Float.toString(pair.getValue()[0])+",";
            toReturn = toReturn + Float.toString(pair.getValue()[1])+",";
            toReturn = toReturn + Float.toString(pair.getValue()[2])+",";
            toReturn = toReturn + Float.toString(pair.getValue()[3])+",";
            toReturn+= "/";
        }
        return toReturn;
    }

    public int getAno(){
        return ano;
    }

    public void setAno(int novo){
        ano = novo;
    }
    
    public int getDocentesSize(){
        return docentes.size();
    }
}
