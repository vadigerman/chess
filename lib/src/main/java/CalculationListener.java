public interface CalculationListener {
    void onCalculationCommencement();

    void onCombinationOccurrence(String path, long cNum);

    void onCalculationCompletion(long execTime, long combCnt);
}
