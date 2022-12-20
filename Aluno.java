import java.util.HashMap;
import java.util.Map;

public class Aluno extends Entidade{
    //TODO adicionar um HashMap para um aluno ver suas notas
    private int turma;
    private HashMap<Integer,Float[]> notas;

    public Aluno(String nome, int codigo){
        super(nome, codigo);
        notas = new HashMap<Integer,Float[]>();
    }
    
    public Aluno(String base){
        super(base);
        var tierOne = base.split(";");
        turma = Integer.parseInt(tierOne[2]);
        notas = new HashMap<Integer,Float[]>();
        for (String tTwo : tierOne[3].split("/")){
            var tierThree = tTwo.split("-");
            int key = Integer.parseInt(tierThree[0]);
            Float[] value = new Float[4];
            int i = 0;
            for (String tFour: tierThree[1].split(",")){
                value[i] = Float.parseFloat(tFour);
                i++;
            }
            notas.put(key, value);
        } 
    }
    @Override
    public String toCsv() {
        String toReturn = "";
        toReturn = toReturn + getCodigo() + ";"+ getNome() +";"+ turma+";";
        for (Map.Entry<Integer,Float[]> pair : notas.entrySet()) {
            toReturn = toReturn + pair.getKey() + "-";
            toReturn = toReturn + Float.toString(pair.getValue()[0])+",";
            toReturn = toReturn + Float.toString(pair.getValue()[1])+",";
            toReturn = toReturn + Float.toString(pair.getValue()[2])+",";
            toReturn = toReturn + Float.toString(pair.getValue()[3])+",";
            toReturn+= "/";
        }
        return toReturn;
    }
    
    public int getTurma(){
        return turma;
    }

    public void setTurma(int novo){
        turma = novo;
    }

    public HashMap<Integer, Float[]> getNotas() {
        return notas;
    }
}
