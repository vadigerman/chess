public interface Storage {
    void saveTime(long execTime, long combCnt);
    void savePath(String str, long number);
}
