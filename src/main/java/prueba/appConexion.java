package prueba;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class appConexion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		
		context.close();
	}

}
