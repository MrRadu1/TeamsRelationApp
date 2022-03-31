import controller.Controller;
import model.Echipa;
import model.Manangement;
import view.MainView;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainView view= new MainView();
		Echipa model = new Echipa ();
		Manangement model2 = new Manangement();
		Controller ctr = new Controller (view,model2,model);
	}

}
