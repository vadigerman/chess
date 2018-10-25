import java.io.FileWriter;
import java.io.IOException;

public class FileStorage implements Storage {
    @Override
    public void savePath(String str, long number) {
        str += Long.toString(number);
        try (FileWriter writer = new FileWriter("file.csv", true))
        {
            writer.write(str);
            writer.write('\n');
            writer.flush();
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void saveTime(long execTime, long combCnt) { }
}
