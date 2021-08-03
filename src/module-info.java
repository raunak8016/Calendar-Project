// needs to be renamed and functionality needs to be improved
module fxtemplate {
	requires javafx.controls;
	requires javafx.graphics;
	
	opens application to javafx.graphics, javafx.fxml;
}
