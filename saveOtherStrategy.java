import java.io.File;

public class saveOtherStrategy implements saveStrategy{
    public File file;
    public saveOtherStrategy(File file) {
        this.file = file;
    }
    @Override
    public String saveBoard(File file) {
        return "(Other File Type)";
    }
}
