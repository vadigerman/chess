import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

public class File implements Storage {
    @Override
    public void save(String str, long number) {
        str += Long.toString(number);
        try(FileWriter writer = new FileWriter("file.txt", true))
        {
            writer.write(str);
            writer.write('\n');
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void save(InputStream inputStream, String key) { }

    @Override
    public void delete(String key) { }

    @Override
    public InputStream get(String key) { return null; }

    public void writeToFile(long number) {

    }
}
