module dashbord.cardiosafe {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens dashbord to javafx.fxml;
    exports dashbord;
    exports dashbord.Controllers;
    opens dashbord.Controllers to javafx.fxml;

    exports dashbord.models to javafx.base;
    opens dashbord.models;

}