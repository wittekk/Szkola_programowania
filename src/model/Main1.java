package model;

public class Main1 {

	public static void main(String[] args) {		
		
		User ob1 = new User();
		ob1.setUsername("Witold Krzemiński").setEmail("bigw@o2.pl").setPassword("coderslab").setPersonGroupId(1);
		UserDao.saveToDB(ob1);
	}
}
