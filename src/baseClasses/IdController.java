package baseClasses;

public abstract class IdController {

    protected int id;
    protected static int idAtual;

    public IdController() {
        incrementaIdAtual();
        id = idAtual;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final IdController other = (IdController) obj;
        return this.id == other.id;
    }

    public abstract void incrementaIdAtual();
}
