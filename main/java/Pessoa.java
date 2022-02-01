import java.sql.Date;

class Pessoas {
    private String nome;
    private Date dataNascimento;
    private float altura;

    public Pessoas(String n, Date data, float alt) {

        this.nome = n;
        this.dataNascimento = data;
        this.altura = alt;

    }

    public void imprimir() {

        System.out.println("Nome: " + nome);
        System.out.println("data de nascimento: " + dataNascimento);
        System.out.println("Altura: " + altura);
    }

    class Agenda {
        private Pessoa pessoas[] = new Pessoa[10];

        public Agenda() {
            for (int i = 0; i <= 9; i++) {
                pessoas[i] = new Pessoa();
            }
        }

        public void armazenaPessoa(String nome, int idade, double altura) {
            for (int i = 0; i <= 9; i++) {
                if (pessoas[i].getNome() == "") {
                    pessoas[i].setNome(nome);
                    pessoas[i].setAltura(altura);
                    pessoas[i].setIdade(idade);
                    i = 10;
                }
            }
        }

        public void removePessoa(String nome) {
            for (int i = 0; i < 10; i++) {
                if (pessoas[i].getNome() == nome) {
                    pessoas[i].setNome("");
                    pessoas[i].setAltura(0);
                    pessoas[i].setIdade(0);
                    i = 10;
                }
            }
        }

        public int buscaPessoa(String nome) {
            for (int i = 0; i < 10; i++) {
                if (pessoas[i].getNome() == nome) {
                    return i;
                }
            }
            return -1;
        }

        public void imprimeAgenda() {
            for (int i = 0; i < 10; i++) {
                pessoas[i].imprimeTudo();
                System.out.println("");
            }
        }

        public void imprimePessoa(int index) {
            pessoas[index].imprimeTudo();
        }
    }
}

class Funcionario {
    String nome;
    int salario;
    String dataadmissao;
}

class Departamento {
    String nome;
    Funcionario funcionarios[] = new Funcionario[100];
}

class Empresa {
    String nome;
    String CNPJ;
    Departamento departamentos[] = new Departamento[10];

    public void CriaEmpresa(String name, String cnpj){
        this.nome = name;
        this.CNPJ = cnpj;
    }

    public void CadastrarDepartamento(String name){
        Departamento dep = new Departamento();
        dep.nome = name;
        for (int i = 0; i < 10; i++) {
            if (this.departamentos[i] == null){
                this.departamentos[i] = dep;
                i=10;
            }
        }
    }

    public void CadastrarFuncionario(Departamento dep, String name, String data, int sal){
        Funcionario func = new Funcionario();
        func.nome = name;
        func.dataadmissao = data;
        func.salario = sal;
        for (int i = 0; i < 100; i++) {
            if (dep.funcionarios[i] == null){
                dep.funcionarios[i] = func;
                i=100;
            }
        }
    }

    public void Aumento(Departamento dep){
        for (int i = 0; i < 100; i++) {
            if (dep.funcionarios[i] != null) {
                dep.funcionarios[i].salario += dep.funcionarios[i].salario / 10;
            }
        }
    }

    public void Transferir(Departamento depPosse, Departamento depPega) {
        depPega.funcionarios[0] = depPosse.funcionarios[0];
        depPosse.funcionarios[0] = null;
    }
}

public class Pessoa {
    public static void main(String[] args) {

        Empresa emp = new Empresa();
        emp.CriaEmpresa("Hoyal","123456");
        emp.CadastrarDepartamento("Técnico");
        emp.CadastrarDepartamento("Gerentes");
        emp.CadastrarFuncionario(emp.departamentos[0],"João","12/12/12",100);
        emp.Aumento(emp.departamentos[0]);
        emp.Transferir(emp.departamentos[0],emp.departamentos[1]);
    }
}
