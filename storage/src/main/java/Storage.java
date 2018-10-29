import java.util.List;

public interface Storage {
    long registerExecution();
    void updateExecution(long execId, long execTime, long combCnt);
    void savePath(List<PiecePaths> paths);
}
