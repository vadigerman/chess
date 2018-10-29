import java.util.List;

public class FileStorage implements Storage {
    @Override
    public long registerExecution() {
        return 0;
    }

    @Override
    public void updateExecution(long execId, long execTime, long combCnt) { }

    @Override
    public void savePath(List<PiecePaths> paths) {
//        str += Long.toString(number);
//        try (FileWriter writer = new FileWriter("file.csv", true))
//        {
//            writer.write(str);
//            writer.write('\n');
//            writer.flush();
//        }
//        catch (IOException ex){
//            System.out.println(ex.getMessage());
//        }
    }
}
