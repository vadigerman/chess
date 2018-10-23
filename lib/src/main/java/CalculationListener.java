public interface CalculationListener {
    void onCombinationOccurrence(String path, long cNum);

    void onCalculationCompletion(long execTime, long combCnt);
}
