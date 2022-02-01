import java.sql.Date;
import java.util.Scanner;

class Funcionario {
    String nome;
    int salario;
    String dataadmissao;

    public void CadastrarFuncionario(){
        Scanner myObj = new Scanner(System.in);
        System.out.println("Entre o nome do funcionário, depois a data de admissão, depois o salário:");
        String name = myObj.nextLine();
        String data = myObj.nextLine();
        int sal = myObj.nextInt();
        this.nome = name;
        this.dataadmissao = data;
        this.salario = sal;
    }
}

class Departamento {
    String nome;
    Funcionario funcionarios[] = new Funcionario[100];

    public void CadastrarDepartamento(){
        Scanner myObj = new Scanner(System.in);
        System.out.println("Entre o nome do departamento:");
        String name = myObj.nextLine();
        this.nome = name;
    }

    public void Aumento(){
        for (int i = 0; i < 100; i++) {
            funcionarios[i].salario += funcionarios[i].salario / 10;
        }
    }
}

class Empresa {
    String nome;
    String CNPJ;
    Departamento departamentos[] = new Departamento[10];

    public void CriaEmpresa(){
        Scanner myObj = new Scanner(System.in);
        System.out.println("Entre o nome e depois o CNPJ da empresa:");
        String name = myObj.nextLine();
        String cnpj = myObj.nextLine();
        this.nome = name;
        this.CNPJ = cnpj;
    }

    public void Show(){
        System.out.println(this.nome);
        System.out.println(this.CNPJ);
        for (int i = 0; i < 10; i++) {
            System.out.println(this.departamentos[i]);
        }
    }
}

public class Pessoa {
    public static void main(String[] args) {

        Empresa emp = new Empresa();
        emp.CriaEmpresa();
        emp.Show();

    }
}
