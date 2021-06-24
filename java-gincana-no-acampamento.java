import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GinacanNoAcampamento {
	public static void main(String[] args) {
        
    String aluno, valorDaFicha;
		int numeroDeAlunos, valorAtualFicha, indiceAtual, indiceAlunoEliminado;
		
    Scanner scr = new Scanner(System.in);
		List<String> listaDeAlunos = new ArrayList<>(); 
		numeroDeAlunos = Integer.parseInt(scr.next());
		
		while (numeroDeAlunos > 0) {
      for (int i = 0; i < numeroDeAlunos; i++) {
				aluno = scr.next();
				valorDaFicha = scr.next();	
				listaDeAlunos.add(aluno.trim() + " " + valorDaFicha.trim());
      }
			
			indiceAtual = 0;
			indiceAlunoEliminado = 0;
			valorAtualFicha = Integer.parseInt(listaDeAlunos.get(indiceAtual).split(" ")[1]);
			
			for (int i = 0; i < numeroDeAlunos - 1; i++) {
				if (valorAtualFicha % 2 == 0) {
          indiceAlunoEliminado = (listaDeAlunos.size() - (valorAtualFicha % listaDeAlunos.size()) + indiceAtual) % listaDeAlunos.size();
					
				} else if (valorAtualFicha % 2 != 0) {
          indiceAlunoEliminado = (valorAtualFicha % listaDeAlunos.size() + indiceAtual) % listaDeAlunos.size();
        
        }
				
			  valorAtualFicha = Integer.parseInt(listaDeAlunos.get(indiceAlunoEliminado).split(" ")[1]);
			  listaDeAlunos.remove(indiceAlunoEliminado);

			  indiceAtual = (valorAtualFicha % 2 == 0) ? 
					((indiceAlunoEliminado <= listaDeAlunos.size() - 1) ? 
					  indiceAlunoEliminado : 0):
						  ((indiceAlunoEliminado == 0) ?
							  (listaDeAlunos.size() - 1):(indiceAlunoEliminado - 1));
			}

			System.out.println("Vencedor(a): " + listaDeAlunos.get(0).split(" ")[0]);
			
			listaDeAlunos.clear();
			numeroDeAlunos = Integer.parseInt(scr.next());
		}
		scr.close();
	}
}