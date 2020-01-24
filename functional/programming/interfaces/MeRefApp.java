package functional.programming.interfaces;

import java.util.Arrays;
import java.util.Comparator;

public class MeRefApp {
	
	public static void referenciarMetodoStatico() {
		System.out.println("Metodo Referido estatico");
	}
	
	public void referenciarMetodoInstanciaObjetoArbitrario() {
		String[] nombres = {"Mito","Code","Jaime"};
		/* Arrays.sort(nombres, new Comparator<String>() {
			public int compare(String o1, String o2) {
				return o1.compareToIgnoreCase(o2);
			}
		}); */
		
		// Arrays.sort(nombres, (s1, s2) -> s1.compareToIgnoreCase(s2));
		
		Arrays.sort(nombres, String::compareToIgnoreCase);
		
		System.out.println(Arrays.deepToString(nombres));
		
	}
	public void referenciarMetodoInstanciaObjetoParticular() {
		System.out.println("Metodo Referido Instancia de Objeto en particular");
	}
	
	public void referenciarConstructor() {
		/* IPersona iper = new IPersona() {
			@Override
			public Persona crear(int id, String nombre) {
				return new Persona(id,nombre);
			}
		}; 
		iper.crear(1, "MitoCode"); */
		
		/* IPersona iper2 = (x,y) -> (new Persona(x,y));
		Persona per = iper2.crear(1, "MitoCode"); */
		
		IPersona iper3 = Persona::new;
		Persona per2 = iper3.crear(1, "MitoCode");
		
		
		System.out.println(per2.getId() + " " + per2.getNombre());
		
	}	
	public void operar() {
		//Operacion op = () -> MeRefApp.referenciarMetodoStatico();
		//op.saludar();
		
		Operacion op2 = MeRefApp::referenciarMetodoStatico;
		op2.saludar();
	}
	

	public static void main(String[] args) {
		
		MeRefApp app = new MeRefApp();
		// app.operar();
		
		//app.referenciarMetodoInstanciaObjetoArbitrario();
		
		/* Operacion op = app::referenciarMetodoInstanciaObjetoParticular;
		op.saludar(); */
		
		app.referenciarConstructor();

	}

}
