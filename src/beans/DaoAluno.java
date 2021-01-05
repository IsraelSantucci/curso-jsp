package beans;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class DaoAluno {

	FileWriter pr;
	
	
	
	public void Salvar(Aluno aluno) {
		try {
			pr = new FileWriter("Arquivo.txt");
			PrintWriter r = new PrintWriter(pr);
			r.println("Testando p printwriter");
			FileWriter fr2 = new FileWriter("mm.txt");
			pr.write(aluno.getNome() + " agora vai");
			fr2.write("mm ");
			FileWriter fr = new FileWriter("lorem.txt");
			fr.write("Estou testando esse merda ");
			fr.close();
			pr.close();
			System.out.println("gravando"); 
		} catch (IOException e) {
			System.out.println("erro abrir arquivo"); 
			e.printStackTrace();
		}
		
		System.out.println("salvo com sussesso: " + aluno.getNome());
	}
}
