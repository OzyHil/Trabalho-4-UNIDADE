import java.util.LinkedHashMap;
import java.util.Map;

public class Escola{
    public LinkedHashMap<Integer,Docente> docentes = new LinkedHashMap<Integer,Docente>();
    public LinkedHashMap<Integer,Disciplina> disciplinas = new LinkedHashMap<Integer,Disciplina>();
    public LinkedHashMap<Integer,Aluno> alunos = new LinkedHashMap<Integer,Aluno>();
    public LinkedHashMap<Integer,Turma> turmas = new LinkedHashMap<Integer,Turma>();
    private int maiorAluno,maiorDocente,maiorDisciplina,maiorTurma;
    private GerenteDeArquivo ga = new GerenteDeArquivo();

    //Metódos
    //TODO fazer os métodos de adição e adição darem throws qnd acessar um item q nao existem
    public Aluno adicionarAluno(String nome){
        Aluno aluno = new Aluno(nome,maiorAluno);
        alunos.put(maiorAluno, aluno);
        maiorAluno++;
        return aluno;
    }

    public void removerAluno(int codigo) throws NoSuchKeyException{
        if (!alunos.containsKey(codigo))
            throw new NoSuchKeyException();
        else
            alunos.remove(codigo);
    }

    public Docente adicionarDocente(String nome){
        Docente docente = new Docente(nome, maiorDocente);
        docentes.put(maiorDocente, docente);
        maiorDocente++;
        return docente;
    }

    public void removerDocente(int codigo) throws NoSuchKeyException{
        if (!docentes.containsKey(codigo))
            throw new NoSuchKeyException();
        else
            docentes.remove(codigo);
    }

    public Disciplina adicionarDisciplina(String nome){
        Disciplina disc =  new Disciplina(nome, maiorDisciplina);
        disciplinas.put(maiorDisciplina, disc);
        maiorDisciplina++;
        return disc;
    }

    public void removerDisciplina(int codigo) throws NoSuchKeyException{
        if (!disciplinas.containsKey(codigo))
            throw new NoSuchKeyException();
        else
            disciplinas.remove(codigo);
    }

    public Turma adicionarTurma(String nome){
        Turma turma = new Turma(nome,maiorTurma);
        turmas.put(maiorTurma, turma);
        maiorTurma++;
        return turma;
    }

    public void removerTurma(int codigo) throws NoSuchKeyException{
        if (!turmas.containsKey(codigo))
            throw new NoSuchKeyException();
        else
            turmas.remove(codigo);
    }

    public void editarAluno(){};
    public void editarTurma(){};
    public void editarDisciplina(){};
    public void editarDocente(){};

    //Os métodos abaixo estão retornando null enquanto não são devidamente implementados, pra não dar erro no java

    public String mapearDocentes(){
        String toReturn = "";
        for (Map.Entry<Integer, Docente> pair:docentes.entrySet()){
            toReturn = toReturn + pair.getKey() + " - " +pair.getValue().getNome() + "\n"; 
        } 
        return toReturn;
    } //Retorna o nome dos docentes e seus códigos.

    public String mapearDisciplinas(){        
        String toReturn = "";
        for (Map.Entry<Integer, Disciplina> pair:disciplinas.entrySet()){
            toReturn = toReturn + pair.getKey() + " - " +pair.getValue().getNome() + "\n"; 
        } 
        return toReturn;
    }//Retorna o nome das disciplinas e seus códigos.

    public String mapearAlunos(){
        String toReturn = "";
        for (Map.Entry<Integer, Aluno> pair:alunos.entrySet()){
            toReturn = toReturn + pair.getKey() + " - " +pair.getValue().getNome() + "\n"; 
        } 
        return toReturn;
    }//Retorna o nome dos alunos e seus códigos.

    public String mapearTurmas(){
        String toReturn = "";
        for (Map.Entry<Integer, Turma> pair:turmas.entrySet()){
            toReturn = toReturn + pair.getKey() + " - " +pair.getValue().getNome() + "\n"; 
        } 
        return toReturn;
    }//Retorna o nome das turmas e seus códigos.

    public void gerarRelatórios(int tipo){}//Gerar relatórios com o GeradorDeRelatorio e passar pro arquivo com o GerenteDeArquivos.

    public void carregar(){
        Aluno a;
        for (String base : ga.carregarAlunos()) {
            a = new Aluno(base);
            alunos.put(a.getCodigo(), a); 
        }
        Docente doc;
        for (String base : ga.carregarDocentes()) {
            doc = new Docente(base);
            docentes.put(doc.getCodigo(), doc); 
        }
        Turma t;
        for (String base : ga.carregarTurmas()) {
            t = new Turma(base,this);
            turmas.put(t.getCodigo(), t); 
        }
        Disciplina dic;
        for (String base : ga.carregarDisciplinas()) {
            dic = new Disciplina(base,this);
            disciplinas.put(dic.getCodigo(), dic); 
        }
    }

    public void salvar(){
        ga.escrever(this);
    }
    
}   
