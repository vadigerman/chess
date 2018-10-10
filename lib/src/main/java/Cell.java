public class Cell {
    private CellState state;
    private int x;
    private int y;

    public Cell(int x, int y, CellState state) {
        this.state = state;
        this.x = x;
        this.y = y;
    }

    public CellState getState() {
        return state;
    }

    public void setState(CellState state) {
        this.state = state;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return state == cell.state;
    }

    @Override
    public int hashCode() {
        return (this.getX() * 10 + this.getY());
//        return (((this.getX() & 0xFFFF) << 16) & (this.getY() & 0xFFFF));
    }
}
