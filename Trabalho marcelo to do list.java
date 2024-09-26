import java.util.ArrayList;
import java.util.Scanner;

class Tarefa {
    private String titulo;
    private String descricao;
    private boolean feita;

    public Tarefa(String titulo, String descricao) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.feita = false;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean isFeita() {
        return feita;
    }

    public void marcarComoFeita() {
        this.feita = true;
    }

    public void exibirTarefa() {
        System.out.println("Título: " + titulo);
        System.out.println("Descrição: " + descricao);
        System.out.println("Status: " + (feita ? "Feita" : "Pendente"));
        System.out.println("------------------------");
    }
}

class GerenciadorDeTarefas {
    private ArrayList<Tarefa> tarefas;

    public GerenciadorDeTarefas() {
        tarefas = new ArrayList<>();
    }

    public void adicionarTarefa(String titulo, String descricao) {
        Tarefa novaTarefa = new Tarefa(titulo, descricao);
        tarefas.add(novaTarefa);
        System.out.println("Tarefa adicionada com sucesso!");
    }

    public void listarTarefas() {
        System.out.println("\n--- Todas as Tarefas ---");
        for (int i = 0; i < tarefas.size(); i++) {
            System.out.println("Índice: " + i);
            tarefas.get(i).exibirTarefa();
        }
    }

    public void listarTarefasPendentes() {
        System.out.println("\n--- Tarefas Pendentes ---");
        for (int i = 0; i < tarefas.size(); i++) {
            if (!tarefas.get(i).isFeita()) {
                System.out.println("Índice: " + i);
                tarefas.get(i).exibirTarefa();
            }
        }
    }

    public void marcarTarefaComoFeita(int indice) {
        if (indice >= 0 && indice < tarefas.size()) {
            if (!tarefas.get(indice).isFeita()) {
                tarefas.get(indice).marcarComoFeita();
                System.out.println("Tarefa marcada como feita!");
            } else {
                System.out.println("Esta tarefa já está concluída.");
            }
        } else {
            System.out.println("Índice inválido.");
        }
    }

    public void exibirTarefasPorStatus(boolean feitas) {
        System.out.println(feitas ? "\n--- Tarefas Feitas ---" : "\n--- Tarefas Pendentes ---");
        for (Tarefa tarefa : tarefas) {
            if (tarefa.isFeita() == feitas) {
                tarefa.exibirTarefa();
            }
        }
    }
}

public class GerenciadorDeTarefasApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GerenciadorDeTarefas gerenciador = new GerenciadorDeTarefas();
        boolean rodando = true;

        while (rodando) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Adicionar Tarefa");
            System.out.println("2. Listar Todas as Tarefas");
            System.out.println("3. Listar Tarefas Pendentes");
            System.out.println("4. Sair");

            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();  // Limpa o buffer após ler o número

            switch (opcao) {
                case 1:
                    System.out.print("Digite o título da tarefa: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Digite a descrição da tarefa: ");
                    String descricao = scanner.nextLine();
                    gerenciador.adicionarTarefa(titulo, descricao);
                    break;
                case 2:
                    gerenciador.listarTarefas();
                    break;
                case 3:
                    gerenciador.listarTarefasPendentes();
                    break;
                
                case 4:
                    rodando = false;
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
                    break;

            }
        }

        scanner.close();
    }
}