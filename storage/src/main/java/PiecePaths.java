public class PiecePaths {
    private long executionId;
    private String path;
    private long cNum;

    public PiecePaths(long executionId, String path, long cNum) {
        this.executionId = executionId;
        this.path = path;
        this.cNum = cNum;
    }

    public long getExecutionId() {
        return executionId;
    }

    public String getPath() {
        return path;
    }

    public long getcNum() {
        return cNum;
    }
}
