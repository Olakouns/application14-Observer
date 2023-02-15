package runtime;
import com.model.*;
import com.controller.*;
import com.vue.*;

public class ApplicationDemo {

	public static void main(String[] args) {
		ConvertModel model = new ConvertModel();
		ConvertView view = new ConvertView(model);
		ConvertController controller = new ConvertController(model, view);
		    controller.run();
		
	}

}
