import java.io.File;

public class saveTxtStrategy implements saveStrategy{
    public File file;
    public saveTxtStrategy(File file) {
        this.file = file;
    }

    @Override
    public String saveBoard(File file) {
        return "(TXT File)";
    }
}
