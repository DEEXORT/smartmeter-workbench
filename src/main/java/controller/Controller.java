public class Controller {
    private Model model;
    private ViewProgram viewProgram;

    Controller(Model model) {
        this.model = model;
        this.viewProgram = new ViewProgram(this);
    }

    public void exit() {
        System.exit(0);
    }
}
