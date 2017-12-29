package admin;

import java.util.ArrayList;

import model.Exercise;
import model.ExerciseDao;

public class ExerciseAdmin {
	
	static void prompt(){
		while(true){
			System.out.println("Wybierz jedną z opcji list (lista ćwiczeń), add (dodanie ćwiczenia), edit (edycja ćwiczenia), delete (usunięcie ćwiczenia), quit (zakończenie programu):");
			String action = Application.scaner.nextLine();
			if(action.equals("add")){
				addExerciseAction();
			}else if(action.equals("list")){
				listExcercisesAction();
			}else if(action.equals("edit")){
				editExcerciseAction();
			}else if(action.equals("delete")){
				removeExcerciseAction();
			}else if(action.equals("quit")){
				System.out.println("Koniec");
				Application.closeApplication();
			}else{
				System.out.println("Podałeś nieprawidłową komendę spróbuj ponownie.");
			}
		}
	}
	static void listExcercisesAction(){
		ArrayList<Exercise> ex = ExerciseDao.loadAll();
		for(Exercise _ex: ex){
			System.out.println(_ex);
		}
	}
	static void addExerciseAction(){
		System.out.println("Dodanie ćwiczenia");

		String title = promptString(Type.TITLE);
		String description = promptString(Type.DESCRIPTION);
		Exercise ex = new Exercise();
		ExerciseDao.saveToDB(ex);

		System.out.println("Dodano zadanko");
	}
	static void editExcerciseAction(){
		System.out.println("Edycja");
		int id = promptInt(Type.ID);
		Application.scaner.nextLine();
		String title = promptString(Type.TITLE);
		String description = promptString(Type.DESCRIPTION);
		Exercise ex = ExerciseDao.loadExcerciseById(id);
		if(!title.isEmpty()) ex.setTitle(title);
		if(!description.isEmpty()) ex.setDescription(description);
		ExerciseDao.saveToDB(ex);
		System.out.println("Edycja zakończona");
	}
	static void removeExcerciseAction(){
		System.out.println("Usuń");
		int id = promptInt(Type.ID);
		Application.scaner.nextLine();
		if(id!=0 && Application.areYouSurePrompt()){
			Exercise ex = ExerciseDao.loadExcerciseById(id);
			ExerciseDao.delete(ex);
			System.out.println("Usunięto ćwiczenie");
		}
	}
	public static String promptString(Type type){
		switch (type) {
			case TITLE:
				System.out.println("Podaj nazwę ćwiczenia:");
				break;
			case DESCRIPTION:
				System.out.println("Podaj opis ćwiczenia:");
				break;
			 
			default:
				break; 
		}
		return Application.scaner.nextLine();
	} 
	public static int promptInt(Type type){
		switch (type) {
			case ID:
				System.out.println("Podaj id ćwiczenia:");
				break;
			default:
				break; 
		}
		while(!Application.scaner.hasNextInt()){
			Application.scaner.next();
			System.out.println("Podałeś nieprawidłowe dane. Spróbuj ponownie");
		} 
		return Application.scaner.nextInt();
	} 
	
	private enum Type{
		ID,
		TITLE,
		DESCRIPTION
	}
}
