import java.util.HashSet;
import java.util.Set;

public class TestCalculationListener implements CalculationListener {
    private long execTime;
    private long combCnt;

    Set<String> paths = new HashSet<>();

    @Override
    public void onCombinationOccurrence(String path, long cNum) {
        System.out.println(String.format("iteration %s, %d", path, cNum));
        paths.add(path);
    }

    @Override
    public void onCalculationCompletion(long execTime, long combCnt) {
        this.execTime = execTime;
        this.combCnt = combCnt;
    }

    public long getExecTime() {
        return execTime;
    }

    public long getCombCnt() {
        return combCnt;
    }

    public Set<String> getPaths() {
        return paths;
    }
}
