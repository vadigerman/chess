import java.io.File;
import java.io.InputStream;

public interface Storage {
    void save(InputStream inputStream, String key);
    void save(String str, long number);
    InputStream get(String key);
    void delete(String key);
}
