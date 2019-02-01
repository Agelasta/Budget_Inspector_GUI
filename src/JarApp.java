public class JarApp {

    public static void main(String[] args) {

        JarModel jarModel = new JarModel();
        JarView jarView = new JarView();
        JarController jarController = new JarController(jarModel, jarView);

        jarView.setVisible(true);

    }
}
