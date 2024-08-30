import model.InformationSystem;
import presenter.Presenter;
import view.View;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            InformationSystem model = new InformationSystem();
            View view = new View();
            new Presenter(model, view);
            view.setVisible(true);
        });
    }
}